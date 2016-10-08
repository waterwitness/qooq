package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class DiskLruCache
  implements Closeable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final Pattern LEGAL_KEY_PATTERN;
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final Sink NULL_SINK;
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Runnable cleanupRunnable = new Runnable()
  {
    public void run()
    {
      int i = 0;
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.this.initialized)
        {
          if ((i | DiskLruCache.this.closed) == 0) {}
        }
        else {
          i = 1;
        }
      }
    }
  };
  private boolean closed;
  private final File directory;
  private final Executor executor;
  private final FileSystem fileSystem;
  private boolean hasJournalErrors;
  private boolean initialized;
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  private BufferedSink journalWriter;
  private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
  private long nextSequenceNumber = 0L;
  private int redundantOpCount;
  private long size = 0L;
  private final int valueCount;
  
  static
  {
    if (!DiskLruCache.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
      NULL_SINK = new Sink()
      {
        public void close()
          throws IOException
        {}
        
        public void flush()
          throws IOException
        {}
        
        public Timeout timeout()
        {
          return Timeout.NONE;
        }
        
        public void write(Buffer paramAnonymousBuffer, long paramAnonymousLong)
          throws IOException
        {
          paramAnonymousBuffer.skip(paramAnonymousLong);
        }
      };
      return;
    }
  }
  
  DiskLruCache(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor)
  {
    this.fileSystem = paramFileSystem;
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
    this.executor = paramExecutor;
  }
  
  private void checkNotClosed()
  {
    try
    {
      if (isClosed()) {
        throw new IllegalStateException("cache is closed");
      }
    }
    finally {}
  }
  
  private void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    Entry localEntry;
    try
    {
      localEntry = paramEditor.entry;
      if (localEntry.currentEditor != paramEditor) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i;
    if ((paramBoolean) && (!localEntry.readable))
    {
      i = 0;
      if (i >= this.valueCount) {
        break label446;
      }
    }
    for (;;)
    {
      long l1;
      if (i >= this.valueCount)
      {
        this.redundantOpCount += 1;
        localEntry.currentEditor = null;
        if (!(localEntry.readable | paramBoolean)) {
          break label386;
        }
        localEntry.readable = true;
        this.journalWriter.writeUtf8("CLEAN").writeByte(32);
        this.journalWriter.writeUtf8(localEntry.key);
        localEntry.writeLengths(this.journalWriter);
        this.journalWriter.writeByte(10);
        if (paramBoolean)
        {
          l1 = this.nextSequenceNumber;
          this.nextSequenceNumber = (1L + l1);
          localEntry.sequenceNumber = l1;
        }
      }
      for (;;)
      {
        this.journalWriter.flush();
        if ((this.size > this.maxSize) || (journalRebuildRequired())) {
          this.executor.execute(this.cleanupRunnable);
        }
        for (;;)
        {
          return;
          if (paramEditor.written[i] == 0)
          {
            paramEditor.abort();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i);
          }
          if (this.fileSystem.exists(localEntry.dirtyFiles[i])) {
            break;
          }
          paramEditor.abort();
        }
        paramEditor = localEntry.dirtyFiles[i];
        if (paramBoolean)
        {
          if (!this.fileSystem.exists(paramEditor)) {
            break label461;
          }
          File localFile = localEntry.cleanFiles[i];
          this.fileSystem.rename(paramEditor, localFile);
          l1 = localEntry.lengths[i];
          long l2 = this.fileSystem.size(localFile);
          localEntry.lengths[i] = l2;
          this.size = (this.size - l1 + l2);
          break label461;
        }
        this.fileSystem.delete(paramEditor);
        break label461;
        label386:
        this.lruEntries.remove(localEntry.key);
        this.journalWriter.writeUtf8("REMOVE").writeByte(32);
        this.journalWriter.writeUtf8(localEntry.key);
        this.journalWriter.writeByte(10);
      }
      label446:
      i = 0;
      continue;
      i += 1;
      break;
      label461:
      i += 1;
    }
  }
  
  public static DiskLruCache create(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    return new DiskLruCache(paramFileSystem, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
  }
  
  /* Error */
  private Editor edit(String paramString, long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 354	com/squareup/okhttp/internal/DiskLruCache:initialize	()V
    //   9: aload_0
    //   10: invokespecial 356	com/squareup/okhttp/internal/DiskLruCache:checkNotClosed	()V
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 359	com/squareup/okhttp/internal/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 123	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   22: aload_1
    //   23: invokevirtual 362	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 21	com/squareup/okhttp/internal/DiskLruCache$Entry
    //   29: astore 5
    //   31: lload_2
    //   32: ldc2_w 30
    //   35: lcmp
    //   36: ifeq +35 -> 71
    //   39: aload 6
    //   41: astore 4
    //   43: aload 5
    //   45: ifnull +21 -> 66
    //   48: aload 5
    //   50: invokestatic 365	com/squareup/okhttp/internal/DiskLruCache$Entry:access$10	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)J
    //   53: lstore 7
    //   55: lload 7
    //   57: lload_2
    //   58: lcmp
    //   59: ifeq +12 -> 71
    //   62: aload 6
    //   64: astore 4
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 4
    //   70: areturn
    //   71: aload 5
    //   73: ifnull +15 -> 88
    //   76: aload 6
    //   78: astore 4
    //   80: aload 5
    //   82: invokestatic 228	com/squareup/okhttp/internal/DiskLruCache$Entry:access$1	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   85: ifnonnull -19 -> 66
    //   88: aload_0
    //   89: getfield 239	com/squareup/okhttp/internal/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   92: ldc 36
    //   94: invokeinterface 245 2 0
    //   99: bipush 32
    //   101: invokeinterface 249 2 0
    //   106: aload_1
    //   107: invokeinterface 245 2 0
    //   112: bipush 10
    //   114: invokeinterface 249 2 0
    //   119: pop
    //   120: aload_0
    //   121: getfield 239	com/squareup/okhttp/internal/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   124: invokeinterface 262 1 0
    //   129: aload 6
    //   131: astore 4
    //   133: aload_0
    //   134: getfield 181	com/squareup/okhttp/internal/DiskLruCache:hasJournalErrors	Z
    //   137: ifne -71 -> 66
    //   140: aload 5
    //   142: astore 4
    //   144: aload 5
    //   146: ifnonnull +26 -> 172
    //   149: new 21	com/squareup/okhttp/internal/DiskLruCache$Entry
    //   152: dup
    //   153: aload_0
    //   154: aload_1
    //   155: aconst_null
    //   156: invokespecial 368	com/squareup/okhttp/internal/DiskLruCache$Entry:<init>	(Lcom/squareup/okhttp/internal/DiskLruCache;Ljava/lang/String;Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)V
    //   159: astore 4
    //   161: aload_0
    //   162: getfield 123	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   165: aload_1
    //   166: aload 4
    //   168: invokevirtual 372	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: pop
    //   172: new 16	com/squareup/okhttp/internal/DiskLruCache$Editor
    //   175: dup
    //   176: aload_0
    //   177: aload 4
    //   179: aconst_null
    //   180: invokespecial 375	com/squareup/okhttp/internal/DiskLruCache$Editor:<init>	(Lcom/squareup/okhttp/internal/DiskLruCache;Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V
    //   183: astore_1
    //   184: aload 4
    //   186: aload_1
    //   187: invokestatic 234	com/squareup/okhttp/internal/DiskLruCache$Entry:access$6	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V
    //   190: aload_1
    //   191: astore 4
    //   193: goto -127 -> 66
    //   196: astore_1
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	DiskLruCache
    //   0	201	1	paramString	String
    //   0	201	2	paramLong	long
    //   41	151	4	localObject1	Object
    //   29	116	5	localEntry	Entry
    //   1	129	6	localObject2	Object
    //   53	3	7	l	long
    // Exception table:
    //   from	to	target	type
    //   5	31	196	finally
    //   48	55	196	finally
    //   80	88	196	finally
    //   88	129	196	finally
    //   133	140	196	finally
    //   149	172	196	finally
    //   172	190	196	finally
  }
  
  private boolean journalRebuildRequired()
  {
    return (this.redundantOpCount >= 2000) && (this.redundantOpCount >= this.lruEntries.size());
  }
  
  private BufferedSink newJournalWriter()
    throws FileNotFoundException
  {
    Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile))
    {
      protected void onException(IOException paramAnonymousIOException)
      {
        if ((!DiskLruCache.$assertionsDisabled) && (!Thread.holdsLock(DiskLruCache.this))) {
          throw new AssertionError();
        }
        DiskLruCache.this.hasJournalErrors = true;
      }
    });
  }
  
  private void processJournal()
    throws IOException
  {
    this.fileSystem.delete(this.journalFileTmp);
    Iterator localIterator = this.lruEntries.values().iterator();
    Entry localEntry;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      localEntry = (Entry)localIterator.next();
      if (localEntry.currentEditor != null) {
        break;
      }
      i = 0;
      while (i < this.valueCount)
      {
        this.size += localEntry.lengths[i];
        i += 1;
      }
    }
    localEntry.currentEditor = null;
    int i = 0;
    for (;;)
    {
      if (i >= this.valueCount)
      {
        localIterator.remove();
        break;
      }
      this.fileSystem.delete(localEntry.cleanFiles[i]);
      this.fileSystem.delete(localEntry.dirtyFiles[i]);
      i += 1;
    }
  }
  
  private void readJournal()
    throws IOException
  {
    BufferedSource localBufferedSource = Okio.buffer(this.fileSystem.source(this.journalFile));
    label239:
    try
    {
      String str1 = localBufferedSource.readUtf8LineStrict();
      String str2 = localBufferedSource.readUtf8LineStrict();
      String str3 = localBufferedSource.readUtf8LineStrict();
      String str4 = localBufferedSource.readUtf8LineStrict();
      String str5 = localBufferedSource.readUtf8LineStrict();
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(this.appVersion).equals(str3)) || (!Integer.toString(this.valueCount).equals(str4)) || (!"".equals(str5))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
      }
    }
    finally
    {
      Util.closeQuietly(localBufferedSource);
      throw ((Throwable)localObject);
      int i = 0;
      try
      {
        for (;;)
        {
          readJournalLine(localBufferedSource.readUtf8LineStrict());
          i += 1;
        }
        rebuildJournal();
      }
      catch (EOFException localEOFException)
      {
        this.redundantOpCount = (i - this.lruEntries.size());
        if (localBufferedSource.exhausted()) {
          break label239;
        }
      }
      Util.closeQuietly(localBufferedSource);
      return;
    }
  }
  
  private void readJournalLine(String paramString)
    throws IOException
  {
    int i = paramString.indexOf(' ');
    if (i == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int j = i + 1;
    int k = paramString.indexOf(' ', j);
    Object localObject2;
    Object localObject1;
    if (k == -1)
    {
      localObject2 = paramString.substring(j);
      localObject1 = localObject2;
      if (i != "REMOVE".length()) {
        break label110;
      }
      localObject1 = localObject2;
      if (!paramString.startsWith("REMOVE")) {
        break label110;
      }
      this.lruEntries.remove(localObject2);
    }
    label110:
    do
    {
      return;
      localObject1 = paramString.substring(j, k);
      Entry localEntry = (Entry)this.lruEntries.get(localObject1);
      localObject2 = localEntry;
      if (localEntry == null)
      {
        localObject2 = new Entry((String)localObject1, null);
        this.lruEntries.put(localObject1, localObject2);
      }
      if ((k != -1) && (i == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        ((Entry)localObject2).readable = true;
        ((Entry)localObject2).currentEditor = null;
        ((Entry)localObject2).setLengths(paramString);
        return;
      }
      if ((k == -1) && (i == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        ((Entry)localObject2).currentEditor = new Editor((Entry)localObject2, null);
        return;
      }
    } while ((k == -1) && (i == "READ".length()) && (paramString.startsWith("READ")));
    throw new IOException("unexpected journal line: " + paramString);
  }
  
  private void rebuildJournal()
    throws IOException
  {
    for (;;)
    {
      Entry localEntry;
      try
      {
        if (this.journalWriter != null) {
          this.journalWriter.close();
        }
        BufferedSink localBufferedSink1 = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
        try
        {
          localBufferedSink1.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
          localBufferedSink1.writeUtf8("1").writeByte(10);
          localBufferedSink1.writeDecimalLong(this.appVersion).writeByte(10);
          localBufferedSink1.writeDecimalLong(this.valueCount).writeByte(10);
          localBufferedSink1.writeByte(10);
          Iterator localIterator = this.lruEntries.values().iterator();
          boolean bool = localIterator.hasNext();
          if (!bool)
          {
            localBufferedSink1.close();
            if (this.fileSystem.exists(this.journalFile)) {
              this.fileSystem.rename(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.rename(this.journalFileTmp, this.journalFile);
            this.fileSystem.delete(this.journalFileBackup);
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            return;
          }
          localEntry = (Entry)localIterator.next();
          if (localEntry.currentEditor != null)
          {
            localBufferedSink1.writeUtf8("DIRTY").writeByte(32);
            localBufferedSink1.writeUtf8(localEntry.key);
            localBufferedSink1.writeByte(10);
            continue;
            localBufferedSink2 = finally;
          }
        }
        finally
        {
          localBufferedSink1.close();
        }
        localBufferedSink2.writeUtf8("CLEAN").writeByte(32);
      }
      finally {}
      localBufferedSink2.writeUtf8(localEntry.key);
      localEntry.writeLengths(localBufferedSink2);
      localBufferedSink2.writeByte(10);
    }
  }
  
  private boolean removeEntry(Entry paramEntry)
    throws IOException
  {
    if (paramEntry.currentEditor != null) {
      paramEntry.currentEditor.hasErrors = true;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.valueCount)
      {
        this.redundantOpCount += 1;
        this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(paramEntry.key).writeByte(10);
        this.lruEntries.remove(paramEntry.key);
        if (journalRebuildRequired()) {
          this.executor.execute(this.cleanupRunnable);
        }
        return true;
      }
      this.fileSystem.delete(paramEntry.cleanFiles[i]);
      this.size -= paramEntry.lengths[i];
      paramEntry.lengths[i] = 0L;
      i += 1;
    }
  }
  
  private void trimToSize()
    throws IOException
  {
    for (;;)
    {
      if (this.size <= this.maxSize) {
        return;
      }
      removeEntry((Entry)this.lruEntries.values().iterator().next());
    }
  }
  
  private void validateKey(String paramString)
  {
    if (!LEGAL_KEY_PATTERN.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\"");
    }
  }
  
  public void close()
    throws IOException
  {
    for (;;)
    {
      int i;
      try
      {
        if ((!this.initialized) || (this.closed))
        {
          this.closed = true;
          return;
        }
        Entry[] arrayOfEntry = (Entry[])this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);
        int j = arrayOfEntry.length;
        i = 0;
        if (i >= j)
        {
          trimToSize();
          this.journalWriter.close();
          this.journalWriter = null;
          this.closed = true;
          continue;
        }
        localEntry = localObject[i];
      }
      finally {}
      Entry localEntry;
      if (localEntry.currentEditor != null) {
        localEntry.currentEditor.abort();
      }
      i += 1;
    }
  }
  
  public void delete()
    throws IOException
  {
    close();
    this.fileSystem.deleteContents(this.directory);
  }
  
  public Editor edit(String paramString)
    throws IOException
  {
    return edit(paramString, -1L);
  }
  
  /* Error */
  public void evictAll()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 354	com/squareup/okhttp/internal/DiskLruCache:initialize	()V
    //   6: aload_0
    //   7: getfield 123	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   10: invokevirtual 400	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   13: aload_0
    //   14: getfield 123	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   17: invokevirtual 378	java/util/LinkedHashMap:size	()I
    //   20: anewarray 21	com/squareup/okhttp/internal/DiskLruCache$Entry
    //   23: invokeinterface 527 2 0
    //   28: checkcast 529	[Lcom/squareup/okhttp/internal/DiskLruCache$Entry;
    //   31: astore_1
    //   32: aload_1
    //   33: arraylength
    //   34: istore_3
    //   35: iconst_0
    //   36: istore_2
    //   37: iload_2
    //   38: iload_3
    //   39: if_icmplt +6 -> 45
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: aload_1
    //   47: iload_2
    //   48: aaload
    //   49: invokespecial 175	com/squareup/okhttp/internal/DiskLruCache:removeEntry	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   52: pop
    //   53: iload_2
    //   54: iconst_1
    //   55: iadd
    //   56: istore_2
    //   57: goto -20 -> 37
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	DiskLruCache
    //   31	16	1	arrayOfEntry	Entry[]
    //   60	4	1	localObject	Object
    //   36	21	2	i	int
    //   34	6	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	35	60	finally
    //   45	53	60	finally
  }
  
  /* Error */
  public void flush()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 157	com/squareup/okhttp/internal/DiskLruCache:initialized	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 356	com/squareup/okhttp/internal/DiskLruCache:checkNotClosed	()V
    //   18: aload_0
    //   19: invokespecial 187	com/squareup/okhttp/internal/DiskLruCache:trimToSize	()V
    //   22: aload_0
    //   23: getfield 239	com/squareup/okhttp/internal/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   26: invokeinterface 262 1 0
    //   31: goto -20 -> 11
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	DiskLruCache
    //   34	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  /* Error */
  public Snapshot get(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 354	com/squareup/okhttp/internal/DiskLruCache:initialize	()V
    //   6: aload_0
    //   7: invokespecial 356	com/squareup/okhttp/internal/DiskLruCache:checkNotClosed	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 359	com/squareup/okhttp/internal/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 123	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual 362	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 21	com/squareup/okhttp/internal/DiskLruCache$Entry
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +12 -> 40
    //   31: aload_2
    //   32: invokestatic 231	com/squareup/okhttp/internal/DiskLruCache$Entry:access$0	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   35: istore_3
    //   36: iload_3
    //   37: ifne +9 -> 46
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_2
    //   47: invokevirtual 540	com/squareup/okhttp/internal/DiskLruCache$Entry:snapshot	()Lcom/squareup/okhttp/internal/DiskLruCache$Snapshot;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnonnull +8 -> 60
    //   55: aconst_null
    //   56: astore_1
    //   57: goto -15 -> 42
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 199	com/squareup/okhttp/internal/DiskLruCache:redundantOpCount	I
    //   65: iconst_1
    //   66: iadd
    //   67: putfield 199	com/squareup/okhttp/internal/DiskLruCache:redundantOpCount	I
    //   70: aload_0
    //   71: getfield 239	com/squareup/okhttp/internal/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   74: ldc 54
    //   76: invokeinterface 245 2 0
    //   81: bipush 32
    //   83: invokeinterface 249 2 0
    //   88: aload_1
    //   89: invokeinterface 245 2 0
    //   94: bipush 10
    //   96: invokeinterface 249 2 0
    //   101: pop
    //   102: aload_2
    //   103: astore_1
    //   104: aload_0
    //   105: invokespecial 191	com/squareup/okhttp/internal/DiskLruCache:journalRebuildRequired	()Z
    //   108: ifeq -66 -> 42
    //   111: aload_0
    //   112: getfield 153	com/squareup/okhttp/internal/DiskLruCache:executor	Ljava/util/concurrent/Executor;
    //   115: aload_0
    //   116: getfield 130	com/squareup/okhttp/internal/DiskLruCache:cleanupRunnable	Ljava/lang/Runnable;
    //   119: invokeinterface 268 2 0
    //   124: aload_2
    //   125: astore_1
    //   126: goto -84 -> 42
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	DiskLruCache
    //   0	134	1	paramString	String
    //   26	99	2	localObject	Object
    //   35	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	27	129	finally
    //   31	36	129	finally
    //   46	51	129	finally
    //   60	102	129	finally
    //   104	124	129	finally
  }
  
  public File getDirectory()
  {
    return this.directory;
  }
  
  public long getMaxSize()
  {
    try
    {
      long l = this.maxSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void initialize()
    throws IOException
  {
    try
    {
      if ((!$assertionsDisabled) && (!Thread.holdsLock(this))) {
        throw new AssertionError();
      }
    }
    finally {}
    boolean bool = this.initialized;
    if (bool) {
      return;
    }
    if (this.fileSystem.exists(this.journalFileBackup))
    {
      if (!this.fileSystem.exists(this.journalFile)) {
        break label186;
      }
      this.fileSystem.delete(this.journalFileBackup);
    }
    for (;;)
    {
      bool = this.fileSystem.exists(this.journalFile);
      if (bool) {
        try
        {
          readJournal();
          processJournal();
          this.initialized = true;
        }
        catch (IOException localIOException)
        {
          Platform.get().logW("DiskLruCache " + this.directory + " is corrupt: " + localIOException.getMessage() + ", removing");
          delete();
          this.closed = false;
        }
      }
      rebuildJournal();
      this.initialized = true;
      break;
      label186:
      this.fileSystem.rename(this.journalFileBackup, this.journalFile);
    }
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = this.closed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean remove(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 354	com/squareup/okhttp/internal/DiskLruCache:initialize	()V
    //   6: aload_0
    //   7: invokespecial 356	com/squareup/okhttp/internal/DiskLruCache:checkNotClosed	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 359	com/squareup/okhttp/internal/DiskLruCache:validateKey	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 123	com/squareup/okhttp/internal/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual 362	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 21	com/squareup/okhttp/internal/DiskLruCache$Entry
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +9 -> 37
    //   31: iconst_0
    //   32: istore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: invokespecial 175	com/squareup/okhttp/internal/DiskLruCache:removeEntry	(Lcom/squareup/okhttp/internal/DiskLruCache$Entry;)Z
    //   42: istore_2
    //   43: goto -10 -> 33
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	DiskLruCache
    //   0	51	1	paramString	String
    //   32	11	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	27	46	finally
    //   37	43	46	finally
  }
  
  public void setMaxSize(long paramLong)
  {
    try
    {
      this.maxSize = paramLong;
      if (this.initialized) {
        this.executor.execute(this.cleanupRunnable);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long size()
    throws IOException
  {
    try
    {
      initialize();
      long l = this.size;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Iterator<Snapshot> snapshots()
    throws IOException
  {
    try
    {
      initialize();
      Iterator local4 = new Iterator()
      {
        final Iterator<DiskLruCache.Entry> delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
        DiskLruCache.Snapshot nextSnapshot;
        DiskLruCache.Snapshot removeSnapshot;
        
        public boolean hasNext()
        {
          if (this.nextSnapshot != null) {
            return true;
          }
          synchronized (DiskLruCache.this)
          {
            if (DiskLruCache.this.closed) {
              return false;
            }
            DiskLruCache.Snapshot localSnapshot;
            while (this.delegate.hasNext())
            {
              localSnapshot = ((DiskLruCache.Entry)this.delegate.next()).snapshot();
              if (localSnapshot != null) {
                break;
              }
            }
            return false;
            this.nextSnapshot = localSnapshot;
            return true;
          }
        }
        
        public DiskLruCache.Snapshot next()
        {
          if (!hasNext()) {
            throw new NoSuchElementException();
          }
          this.removeSnapshot = this.nextSnapshot;
          this.nextSnapshot = null;
          return this.removeSnapshot;
        }
        
        public void remove()
        {
          if (this.removeSnapshot == null) {
            throw new IllegalStateException("remove() before next()");
          }
          try
          {
            DiskLruCache.this.remove(DiskLruCache.Snapshot.access$1(this.removeSnapshot));
            this.removeSnapshot = null;
            return;
          }
          catch (IOException localIOException)
          {
            localIOException = localIOException;
            this.removeSnapshot = null;
            return;
          }
          finally
          {
            localObject = finally;
            this.removeSnapshot = null;
            throw ((Throwable)localObject);
          }
        }
      };
      return local4;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final class Editor
  {
    private boolean committed;
    private final DiskLruCache.Entry entry;
    private boolean hasErrors;
    private final boolean[] written;
    
    private Editor(DiskLruCache.Entry paramEntry)
    {
      this.entry = paramEntry;
      if (DiskLruCache.Entry.access$0(paramEntry)) {}
      for (this$1 = null;; this$1 = new boolean[DiskLruCache.this.valueCount])
      {
        this.written = DiskLruCache.this;
        return;
      }
    }
    
    public void abort()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        DiskLruCache.this.completeEdit(this, false);
        return;
      }
    }
    
    public void abortUnlessCommitted()
    {
      synchronized (DiskLruCache.this)
      {
        boolean bool = this.committed;
        if (bool) {}
      }
      try
      {
        DiskLruCache.this.completeEdit(this, false);
        return;
        localObject = finally;
        throw ((Throwable)localObject);
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    
    public void commit()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (this.hasErrors)
        {
          DiskLruCache.this.completeEdit(this, false);
          DiskLruCache.this.removeEntry(this.entry);
          this.committed = true;
          return;
        }
        DiskLruCache.this.completeEdit(this, true);
      }
    }
    
    public Sink newSink(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.Entry.access$1(this.entry) != this) {
          throw new IllegalStateException();
        }
      }
      if (!DiskLruCache.Entry.access$0(this.entry)) {
        this.written[paramInt] = true;
      }
      Object localObject2 = DiskLruCache.Entry.access$3(this.entry)[paramInt];
      try
      {
        localObject2 = DiskLruCache.this.fileSystem.sink((File)localObject2);
        localObject2 = new FaultHidingSink((Sink)localObject2)
        {
          protected void onException(IOException arg1)
          {
            synchronized (DiskLruCache.this)
            {
              DiskLruCache.Editor.this.hasErrors = true;
              return;
            }
          }
        };
        return (Sink)localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Sink localSink = DiskLruCache.NULL_SINK;
        return localSink;
      }
    }
    
    public Source newSource(int paramInt)
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (DiskLruCache.Entry.access$1(this.entry) != this) {
          throw new IllegalStateException();
        }
      }
      if (!DiskLruCache.Entry.access$0(this.entry)) {
        return null;
      }
      try
      {
        Source localSource = DiskLruCache.this.fileSystem.source(DiskLruCache.Entry.access$2(this.entry)[paramInt]);
        return localSource;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
  }
  
  private final class Entry
  {
    private final File[] cleanFiles;
    private DiskLruCache.Editor currentEditor;
    private final File[] dirtyFiles;
    private final String key;
    private final long[] lengths;
    private boolean readable;
    private long sequenceNumber;
    
    private Entry(String paramString)
    {
      this.key = paramString;
      this.lengths = new long[DiskLruCache.this.valueCount];
      this.cleanFiles = new File[DiskLruCache.this.valueCount];
      this.dirtyFiles = new File[DiskLruCache.this.valueCount];
      paramString = new StringBuilder(paramString).append('.');
      int j = paramString.length();
      int i = 0;
      for (;;)
      {
        if (i >= DiskLruCache.this.valueCount) {
          return;
        }
        paramString.append(i);
        this.cleanFiles[i] = new File(DiskLruCache.this.directory, paramString.toString());
        paramString.append(".tmp");
        this.dirtyFiles[i] = new File(DiskLruCache.this.directory, paramString.toString());
        paramString.setLength(j);
        i += 1;
      }
    }
    
    private IOException invalidLengths(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }
    
    /* Error */
    private void setLengths(String[] paramArrayOfString)
      throws IOException
    {
      // Byte code:
      //   0: aload_1
      //   1: arraylength
      //   2: aload_0
      //   3: getfield 26	com/squareup/okhttp/internal/DiskLruCache$Entry:this$0	Lcom/squareup/okhttp/internal/DiskLruCache;
      //   6: invokestatic 35	com/squareup/okhttp/internal/DiskLruCache:access$7	(Lcom/squareup/okhttp/internal/DiskLruCache;)I
      //   9: if_icmpeq +9 -> 18
      //   12: aload_0
      //   13: aload_1
      //   14: invokespecial 130	com/squareup/okhttp/internal/DiskLruCache$Entry:invalidLengths	([Ljava/lang/String;)Ljava/io/IOException;
      //   17: athrow
      //   18: iconst_0
      //   19: istore_3
      //   20: iload_3
      //   21: aload_1
      //   22: arraylength
      //   23: if_icmplt +4 -> 27
      //   26: return
      //   27: aload_0
      //   28: getfield 37	com/squareup/okhttp/internal/DiskLruCache$Entry:lengths	[J
      //   31: iload_3
      //   32: aload_1
      //   33: iload_3
      //   34: aaload
      //   35: invokestatic 136	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   38: lastore
      //   39: iload_3
      //   40: iconst_1
      //   41: iadd
      //   42: istore_3
      //   43: goto -23 -> 20
      //   46: astore_2
      //   47: aload_0
      //   48: aload_1
      //   49: invokespecial 130	com/squareup/okhttp/internal/DiskLruCache$Entry:invalidLengths	([Ljava/lang/String;)Ljava/io/IOException;
      //   52: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	53	0	this	Entry
      //   0	53	1	paramArrayOfString	String[]
      //   46	1	2	localNumberFormatException	NumberFormatException
      //   19	24	3	i	int
      // Exception table:
      //   from	to	target	type
      //   20	26	46	java/lang/NumberFormatException
      //   27	39	46	java/lang/NumberFormatException
    }
    
    DiskLruCache.Snapshot snapshot()
    {
      if (!Thread.holdsLock(DiskLruCache.this)) {
        throw new AssertionError();
      }
      Source[] arrayOfSource = new Source[DiskLruCache.this.valueCount];
      long[] arrayOfLong = (long[])this.lengths.clone();
      int i = 0;
      try
      {
        for (;;)
        {
          if (i >= DiskLruCache.this.valueCount) {
            return new DiskLruCache.Snapshot(DiskLruCache.this, this.key, this.sequenceNumber, arrayOfSource, arrayOfLong, null);
          }
          arrayOfSource[i] = DiskLruCache.this.fileSystem.source(this.cleanFiles[i]);
          i += 1;
        }
        if (i < DiskLruCache.this.valueCount) {}
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        i = 0;
      }
      for (;;)
      {
        return null;
        if (arrayOfSource[i] != null)
        {
          Util.closeQuietly(arrayOfSource[i]);
          i += 1;
        }
      }
    }
    
    void writeLengths(BufferedSink paramBufferedSink)
      throws IOException
    {
      long[] arrayOfLong = this.lengths;
      int j = arrayOfLong.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return;
        }
        long l = arrayOfLong[i];
        paramBufferedSink.writeByte(32).writeDecimalLong(l);
        i += 1;
      }
    }
  }
  
  public final class Snapshot
    implements Closeable
  {
    private final String key;
    private final long[] lengths;
    private final long sequenceNumber;
    private final Source[] sources;
    
    private Snapshot(String paramString, long paramLong, Source[] paramArrayOfSource, long[] paramArrayOfLong)
    {
      this.key = paramString;
      this.sequenceNumber = paramLong;
      this.sources = paramArrayOfSource;
      this.lengths = paramArrayOfLong;
    }
    
    public void close()
    {
      Source[] arrayOfSource = this.sources;
      int j = arrayOfSource.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return;
        }
        Util.closeQuietly(arrayOfSource[i]);
        i += 1;
      }
    }
    
    public DiskLruCache.Editor edit()
      throws IOException
    {
      return DiskLruCache.this.edit(this.key, this.sequenceNumber);
    }
    
    public long getLength(int paramInt)
    {
      return this.lengths[paramInt];
    }
    
    public Source getSource(int paramInt)
    {
      return this.sources[paramInt];
    }
    
    public String key()
    {
      return this.key;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\internal\DiskLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */