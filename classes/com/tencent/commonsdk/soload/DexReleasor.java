package com.tencent.commonsdk.soload;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.zip.ZipException;

public class DexReleasor
  implements MyZipConstants
{
  private static final String DEX_NAME = "classes.dex";
  static byte[] buffer = new byte[81920];
  private static DexReleasor dexOperator;
  public static final String[] sExtraDexes = { "classes2.dex", "classes3.dex", "classes5.dex", "classes6.dex" };
  public static final String[] sExtraJarDexes = { "classes2.jar", "classes3.jar", "classes5.jar", "classes6.jar" };
  byte[] commentOfEOCD = null;
  private String mDstPath;
  private final LinkedHashMap<String, MyZipEntry> mEntries = new LinkedHashMap();
  RandomAccessFile mRaf = null;
  private String mSrcFile;
  
  static
  {
    dexOperator = null;
  }
  
  private DexReleasor(String paramString1, String paramString2)
  {
    this.mSrcFile = paramString1;
    this.mDstPath = paramString2;
    try
    {
      read();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static DexReleasor getInstance(String paramString1, String paramString2)
  {
    try
    {
      if (dexOperator == null) {
        dexOperator = new DexReleasor(paramString1, paramString2);
      }
      paramString1 = dexOperator;
      return paramString1;
    }
    finally {}
  }
  
  private boolean read()
    throws IOException
  {
    boolean bool;
    long l2;
    try
    {
      File localFile = new File(this.mSrcFile);
      bool = localFile.exists();
      if (!bool)
      {
        bool = false;
        return bool;
      }
      this.mRaf = new RandomAccessFile(localFile, "r");
      l2 = this.mRaf.length() - 22L;
      if (l2 < 0L) {
        throw new ZipException("too short to be Zip");
      }
    }
    finally {}
    long l3 = l2 - 65536L;
    long l1 = l3;
    if (l3 < 0L) {
      l1 = 0L;
    }
    int i5;
    int n;
    label228:
    do
    {
      this.mRaf.seek(l2);
      if (Integer.reverseBytes(this.mRaf.readInt()) == 101010256)
      {
        localObject2 = new byte[18];
        this.mRaf.readFully((byte[])localObject2);
        localObject2 = HeapBufferIterator.iterator((byte[])localObject2, 0, localObject2.length, ByteOrder.LITTLE_ENDIAN);
        i = ((BufferIterator)localObject2).readShort();
        j = ((BufferIterator)localObject2).readShort();
        i5 = ((BufferIterator)localObject2).readShort();
        k = ((BufferIterator)localObject2).readShort();
        l1 = ((BufferIterator)localObject2).readInt();
        m = ((BufferIterator)localObject2).readInt();
        n = ((BufferIterator)localObject2).readShort();
        if (n <= 0) {
          break;
        }
        localObject2 = new byte[n];
        if (this.mRaf.read((byte[])localObject2, 0, localObject2.length) == -1) {
          break;
        }
        this.commentOfEOCD = ((byte[])localObject2);
        break;
        throw new ZipException("spanned archives not supported");
      }
      l3 = l2 - 1L;
      l2 = l3;
    } while (l3 >= l1);
    throw new ZipException("EOCD not found; not a Zip archive?");
    label266:
    Object localObject2 = new BufferedInputStream(new MyZipFile.RAFStream(this.mRaf, m), 4096);
    byte[] arrayOfByte = new byte[46];
    int m = 0;
    int i1 = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    label337:
    label617:
    label640:
    for (;;)
    {
      int i2;
      int i3;
      int i4;
      if ((m != 0) && (i1 != 0))
      {
        bool = readLocalHeader(this.mRaf);
        break;
        MyZipEntry localMyZipEntry = new MyZipEntry(arrayOfByte, (InputStream)localObject2);
        String str = localMyZipEntry.getName();
        n = j;
        i2 = k;
        i3 = m;
        i4 = i1;
        if (TextUtils.isEmpty(str)) {
          break label617;
        }
        if (str.equals(sExtraDexes[0]))
        {
          this.mEntries.put(str, localMyZipEntry);
          i3 = 1;
          n = j;
          i2 = k;
          i4 = i1;
          break label617;
        }
        if (str.equals(sExtraDexes[1]))
        {
          this.mEntries.put(str, localMyZipEntry);
          i4 = 1;
          n = j;
          i2 = k;
          i3 = m;
          break label617;
        }
        if (str.equals(sExtraDexes[2]))
        {
          this.mEntries.put(str, localMyZipEntry);
          i2 = 1;
          n = j;
          i3 = m;
          i4 = i1;
          break label617;
        }
        n = j;
        i2 = k;
        i3 = m;
        i4 = i1;
        if (!str.equals(sExtraDexes[3])) {
          break label617;
        }
        this.mEntries.put(str, localMyZipEntry);
        n = 1;
        i2 = k;
        i3 = m;
        i4 = i1;
        break label617;
      }
      bool = false;
      break;
      if ((i5 != k) || (i != 0)) {
        break label228;
      }
      if (j == 0) {
        break label266;
      }
      break label228;
      for (;;)
      {
        if (i >= i5) {
          break label640;
        }
        if ((m == 0) || (i1 == 0) || (k == 0) || (j == 0)) {
          break label337;
        }
        break;
        i += 1;
        j = n;
        k = i2;
        m = i3;
        i1 = i4;
      }
    }
  }
  
  private boolean readLocalHeader(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = new byte[30];
        Iterator localIterator = this.mEntries.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label230;
        }
        Object localObject = (String)localIterator.next();
        localObject = (MyZipEntry)this.mEntries.get(localObject);
        Streams.readFully(new BufferedInputStream(new MyZipFile.RAFStream(paramRandomAccessFile, ((MyZipEntry)localObject).mLocalHeaderRelOffset), 4096), arrayOfByte, 0, arrayOfByte.length);
        HeapBufferIterator localHeapBufferIterator = HeapBufferIterator.iterator(arrayOfByte, 0, arrayOfByte.length, ByteOrder.LITTLE_ENDIAN);
        i = localHeapBufferIterator.readInt();
        if (i != 67324752L)
        {
          bool = false;
          return bool;
        }
        localHeapBufferIterator.skip(2);
        if ((localHeapBufferIterator.readShort() & 0x8) != 0)
        {
          bool = true;
          localHeapBufferIterator.skip(18);
          i = localHeapBufferIterator.readShort();
          int j = localHeapBufferIterator.readShort();
          ((MyZipEntry)localObject).hasDD = bool;
          long l1 = i + 30 + j;
          long l2 = ((MyZipEntry)localObject).compressedSize;
          if (!bool) {
            break label224;
          }
          i = 16;
          ((MyZipEntry)localObject).mLocContentSize = (l1 + l2 + i);
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label224:
      int i = 0;
      continue;
      label230:
      boolean bool = true;
    }
  }
  
  private long writeLong(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((int)(0xFF & paramLong));
    paramOutputStream.write((int)(paramLong >> 8) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 16) & 0xFF);
    paramOutputStream.write((int)(paramLong >> 24) & 0xFF);
    return paramLong;
  }
  
  private int writeShort(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    return paramInt;
  }
  
  /* Error */
  private File writeToJar(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 70	com/tencent/commonsdk/soload/DexReleasor:mEntries	Ljava/util/LinkedHashMap;
    //   6: aload_2
    //   7: invokevirtual 218	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 174	com/tencent/commonsdk/soload/MyZipEntry
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +9 -> 24
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: areturn
    //   24: new 87	java/io/File
    //   27: dup
    //   28: new 258	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   35: aload_0
    //   36: getfield 74	com/tencent/commonsdk/soload/DexReleasor:mDstPath	Ljava/lang/String;
    //   39: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 93	java/io/File:exists	()Z
    //   57: ifne +8 -> 65
    //   60: aload_1
    //   61: invokevirtual 269	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: new 271	java/io/FileOutputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: astore_3
    //   74: new 276	java/io/BufferedOutputStream
    //   77: dup
    //   78: aload_3
    //   79: invokespecial 279	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 63	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   88: aload_2
    //   89: getfield 222	com/tencent/commonsdk/soload/MyZipEntry:mLocalHeaderRelOffset	J
    //   92: invokevirtual 117	java/io/RandomAccessFile:seek	(J)V
    //   95: aload_0
    //   96: getfield 63	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   99: getstatic 54	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   102: iconst_0
    //   103: bipush 26
    //   105: invokevirtual 154	java/io/RandomAccessFile:read	([BII)I
    //   108: istore 7
    //   110: iload 7
    //   112: iconst_m1
    //   113: if_icmpeq +10 -> 123
    //   116: iload 7
    //   118: bipush 26
    //   120: if_icmpeq +17 -> 137
    //   123: aload 4
    //   125: invokevirtual 282	java/io/BufferedOutputStream:close	()V
    //   128: aload_3
    //   129: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   132: aconst_null
    //   133: astore_1
    //   134: goto -114 -> 20
    //   137: aload 4
    //   139: getstatic 54	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   142: iconst_0
    //   143: bipush 26
    //   145: invokevirtual 286	java/io/BufferedOutputStream:write	([BII)V
    //   148: ldc 10
    //   150: ldc_w 288
    //   153: invokevirtual 292	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   156: astore 5
    //   158: aload 5
    //   160: arraylength
    //   161: istore 8
    //   163: aload_0
    //   164: aload 4
    //   166: iload 8
    //   168: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   171: pop
    //   172: aload_0
    //   173: aload 4
    //   175: aload_2
    //   176: getfield 298	com/tencent/commonsdk/soload/MyZipEntry:extraLength	I
    //   179: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   182: pop
    //   183: aload 4
    //   185: aload 5
    //   187: invokevirtual 300	java/io/BufferedOutputStream:write	([B)V
    //   190: aload_0
    //   191: getfield 63	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   194: aload_2
    //   195: getfield 222	com/tencent/commonsdk/soload/MyZipEntry:mLocalHeaderRelOffset	J
    //   198: ldc2_w 301
    //   201: ladd
    //   202: aload_2
    //   203: getfield 305	com/tencent/commonsdk/soload/MyZipEntry:nameLength	I
    //   206: i2l
    //   207: ladd
    //   208: invokevirtual 117	java/io/RandomAccessFile:seek	(J)V
    //   211: aload_2
    //   212: getfield 243	com/tencent/commonsdk/soload/MyZipEntry:mLocContentSize	J
    //   215: ldc2_w 301
    //   218: lsub
    //   219: aload_2
    //   220: getfield 305	com/tencent/commonsdk/soload/MyZipEntry:nameLength	I
    //   223: i2l
    //   224: lsub
    //   225: lstore 12
    //   227: lconst_0
    //   228: lstore 10
    //   230: ldc2_w 306
    //   233: lload 10
    //   235: ladd
    //   236: lload 12
    //   238: lcmp
    //   239: ifgt +21 -> 260
    //   242: aload_0
    //   243: getfield 63	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   246: getstatic 54	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   249: invokevirtual 310	java/io/RandomAccessFile:read	([B)I
    //   252: istore 7
    //   254: iload 7
    //   256: iconst_m1
    //   257: if_icmpne +451 -> 708
    //   260: lload 12
    //   262: lload 10
    //   264: lsub
    //   265: l2i
    //   266: istore 7
    //   268: aload_0
    //   269: getfield 63	com/tencent/commonsdk/soload/DexReleasor:mRaf	Ljava/io/RandomAccessFile;
    //   272: getstatic 54	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   275: iconst_0
    //   276: iload 7
    //   278: invokevirtual 154	java/io/RandomAccessFile:read	([BII)I
    //   281: istore 9
    //   283: iload 9
    //   285: iconst_m1
    //   286: if_icmpeq +472 -> 758
    //   289: iload 9
    //   291: iload 7
    //   293: if_icmpne +465 -> 758
    //   296: aload 4
    //   298: getstatic 54	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   301: iconst_0
    //   302: iload 7
    //   304: invokevirtual 286	java/io/BufferedOutputStream:write	([BII)V
    //   307: new 312	java/io/ByteArrayOutputStream
    //   310: dup
    //   311: invokespecial 313	java/io/ByteArrayOutputStream:<init>	()V
    //   314: astore 6
    //   316: aload_0
    //   317: aload 6
    //   319: ldc2_w 314
    //   322: invokespecial 317	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   325: pop2
    //   326: aload_0
    //   327: aload 6
    //   329: aload_2
    //   330: getfield 320	com/tencent/commonsdk/soload/MyZipEntry:version	I
    //   333: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   336: pop
    //   337: aload_0
    //   338: aload 6
    //   340: aload_2
    //   341: getfield 323	com/tencent/commonsdk/soload/MyZipEntry:versionMinimum	I
    //   344: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   347: pop
    //   348: aload_0
    //   349: aload 6
    //   351: aload_2
    //   352: getfield 326	com/tencent/commonsdk/soload/MyZipEntry:flags	I
    //   355: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   358: pop
    //   359: aload_0
    //   360: aload 6
    //   362: aload_2
    //   363: getfield 329	com/tencent/commonsdk/soload/MyZipEntry:compressionMethod	I
    //   366: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   369: pop
    //   370: aload_0
    //   371: aload 6
    //   373: aload_2
    //   374: getfield 332	com/tencent/commonsdk/soload/MyZipEntry:time	I
    //   377: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   380: pop
    //   381: aload_0
    //   382: aload 6
    //   384: aload_2
    //   385: getfield 335	com/tencent/commonsdk/soload/MyZipEntry:modDate	I
    //   388: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   391: pop
    //   392: aload_0
    //   393: aload 6
    //   395: aload_2
    //   396: getfield 338	com/tencent/commonsdk/soload/MyZipEntry:crc	J
    //   399: invokespecial 317	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   402: pop2
    //   403: aload_0
    //   404: aload 6
    //   406: aload_2
    //   407: getfield 240	com/tencent/commonsdk/soload/MyZipEntry:compressedSize	J
    //   410: invokespecial 317	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   413: pop2
    //   414: aload_0
    //   415: aload 6
    //   417: aload_2
    //   418: getfield 341	com/tencent/commonsdk/soload/MyZipEntry:size	J
    //   421: invokespecial 317	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   424: pop2
    //   425: aload_0
    //   426: aload 6
    //   428: iload 8
    //   430: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   433: pop
    //   434: aload_0
    //   435: aload 6
    //   437: aload_2
    //   438: getfield 298	com/tencent/commonsdk/soload/MyZipEntry:extraLength	I
    //   441: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   444: pop
    //   445: aload_0
    //   446: aload 6
    //   448: aload_2
    //   449: getfield 344	com/tencent/commonsdk/soload/MyZipEntry:commentLength	I
    //   452: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   455: pop
    //   456: aload_0
    //   457: aload 6
    //   459: aload_2
    //   460: getfield 347	com/tencent/commonsdk/soload/MyZipEntry:diskNumbers	I
    //   463: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   466: pop
    //   467: aload_0
    //   468: aload 6
    //   470: aload_2
    //   471: getfield 350	com/tencent/commonsdk/soload/MyZipEntry:internalFileAttri	I
    //   474: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   477: pop
    //   478: aload_0
    //   479: aload 6
    //   481: aload_2
    //   482: getfield 353	com/tencent/commonsdk/soload/MyZipEntry:externalFileAttri	J
    //   485: invokespecial 317	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   488: pop2
    //   489: aload_0
    //   490: aload 6
    //   492: lconst_0
    //   493: invokespecial 317	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   496: pop2
    //   497: aload 6
    //   499: aload 5
    //   501: invokevirtual 354	java/io/ByteArrayOutputStream:write	([B)V
    //   504: aload_2
    //   505: getfield 298	com/tencent/commonsdk/soload/MyZipEntry:extraLength	I
    //   508: ifle +12 -> 520
    //   511: aload 6
    //   513: aload_2
    //   514: getfield 357	com/tencent/commonsdk/soload/MyZipEntry:extra	[B
    //   517: invokevirtual 354	java/io/ByteArrayOutputStream:write	([B)V
    //   520: aload_2
    //   521: getfield 344	com/tencent/commonsdk/soload/MyZipEntry:commentLength	I
    //   524: ifle +15 -> 539
    //   527: aload 6
    //   529: aload_2
    //   530: getfield 360	com/tencent/commonsdk/soload/MyZipEntry:comment	Ljava/lang/String;
    //   533: invokevirtual 363	java/lang/String:getBytes	()[B
    //   536: invokevirtual 354	java/io/ByteArrayOutputStream:write	([B)V
    //   539: aload_2
    //   540: getfield 237	com/tencent/commonsdk/soload/MyZipEntry:hasDD	Z
    //   543: ifeq +220 -> 763
    //   546: bipush 16
    //   548: istore 7
    //   550: iload 7
    //   552: bipush 30
    //   554: iadd
    //   555: iload 8
    //   557: iadd
    //   558: aload_2
    //   559: getfield 298	com/tencent/commonsdk/soload/MyZipEntry:extraLength	I
    //   562: iadd
    //   563: i2l
    //   564: lstore 10
    //   566: aload_2
    //   567: getfield 240	com/tencent/commonsdk/soload/MyZipEntry:compressedSize	J
    //   570: lstore 12
    //   572: aload 6
    //   574: invokevirtual 365	java/io/ByteArrayOutputStream:size	()I
    //   577: istore 7
    //   579: aload_0
    //   580: aload 6
    //   582: ldc2_w 366
    //   585: invokespecial 317	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   588: pop2
    //   589: aload_0
    //   590: aload 6
    //   592: iconst_0
    //   593: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   596: pop
    //   597: aload_0
    //   598: aload 6
    //   600: iconst_0
    //   601: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   604: pop
    //   605: aload_0
    //   606: aload 6
    //   608: iconst_1
    //   609: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   612: pop
    //   613: aload_0
    //   614: aload 6
    //   616: iconst_1
    //   617: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   620: pop
    //   621: aload_0
    //   622: aload 6
    //   624: iload 7
    //   626: i2l
    //   627: invokespecial 317	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   630: pop2
    //   631: aload_0
    //   632: aload 6
    //   634: lload 10
    //   636: lload 12
    //   638: ladd
    //   639: invokespecial 317	com/tencent/commonsdk/soload/DexReleasor:writeLong	(Ljava/io/OutputStream;J)J
    //   642: pop2
    //   643: aload_0
    //   644: getfield 65	com/tencent/commonsdk/soload/DexReleasor:commentOfEOCD	[B
    //   647: ifnull +80 -> 727
    //   650: aload_0
    //   651: aload 6
    //   653: aload_0
    //   654: getfield 65	com/tencent/commonsdk/soload/DexReleasor:commentOfEOCD	[B
    //   657: arraylength
    //   658: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   661: pop
    //   662: aload 6
    //   664: aload_0
    //   665: getfield 65	com/tencent/commonsdk/soload/DexReleasor:commentOfEOCD	[B
    //   668: invokevirtual 354	java/io/ByteArrayOutputStream:write	([B)V
    //   671: aload 6
    //   673: aload 4
    //   675: invokevirtual 370	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   678: aload 4
    //   680: ifnull +13 -> 693
    //   683: aload 4
    //   685: invokevirtual 373	java/io/BufferedOutputStream:flush	()V
    //   688: aload 4
    //   690: invokevirtual 282	java/io/BufferedOutputStream:close	()V
    //   693: aload_3
    //   694: ifnull +61 -> 755
    //   697: aload_3
    //   698: invokevirtual 374	java/io/FileOutputStream:flush	()V
    //   701: aload_3
    //   702: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   705: goto +50 -> 755
    //   708: aload 4
    //   710: getstatic 54	com/tencent/commonsdk/soload/DexReleasor:buffer	[B
    //   713: invokevirtual 300	java/io/BufferedOutputStream:write	([B)V
    //   716: lload 10
    //   718: iload 7
    //   720: i2l
    //   721: ladd
    //   722: lstore 10
    //   724: goto -494 -> 230
    //   727: aload_0
    //   728: aload 6
    //   730: iconst_0
    //   731: invokespecial 294	com/tencent/commonsdk/soload/DexReleasor:writeShort	(Ljava/io/OutputStream;I)I
    //   734: pop
    //   735: goto -64 -> 671
    //   738: astore_1
    //   739: aload_0
    //   740: monitorexit
    //   741: aload_1
    //   742: athrow
    //   743: astore_1
    //   744: goto -5 -> 739
    //   747: astore_1
    //   748: goto -9 -> 739
    //   751: astore_1
    //   752: goto -13 -> 739
    //   755: goto -735 -> 20
    //   758: aconst_null
    //   759: astore_1
    //   760: goto -740 -> 20
    //   763: iconst_0
    //   764: istore 7
    //   766: goto -216 -> 550
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	769	0	this	DexReleasor
    //   0	769	1	paramString1	String
    //   0	769	2	paramString2	String
    //   73	629	3	localFileOutputStream	java.io.FileOutputStream
    //   82	627	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   156	344	5	arrayOfByte	byte[]
    //   314	415	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   108	657	7	i	int
    //   161	397	8	j	int
    //   281	13	9	k	int
    //   228	495	10	l1	long
    //   225	412	12	l2	long
    // Exception table:
    //   from	to	target	type
    //   84	110	738	finally
    //   123	132	738	finally
    //   137	227	738	finally
    //   242	254	738	finally
    //   268	283	738	finally
    //   296	520	738	finally
    //   520	539	738	finally
    //   539	546	738	finally
    //   550	671	738	finally
    //   671	678	738	finally
    //   683	693	738	finally
    //   697	705	738	finally
    //   708	716	738	finally
    //   727	735	738	finally
    //   2	14	743	finally
    //   24	53	743	finally
    //   53	65	747	finally
    //   65	74	747	finally
    //   74	84	751	finally
  }
  
  public void destroy()
  {
    if (this.mRaf != null) {}
    try
    {
      this.mRaf.close();
      this.mRaf = null;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException = localIOException;
        this.mRaf = null;
      }
    }
    finally
    {
      localObject = finally;
      this.mRaf = null;
      throw ((Throwable)localObject);
    }
    buffer = null;
    dexOperator = null;
  }
  
  /* Error */
  public File releaseDex(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_2
    //   5: invokespecial 379	com/tencent/commonsdk/soload/DexReleasor:writeToJar	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   8: astore_3
    //   9: aload_3
    //   10: astore_1
    //   11: getstatic 39	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   14: iconst_3
    //   15: aaload
    //   16: aload_2
    //   17: invokevirtual 191	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +9 -> 29
    //   23: aload_0
    //   24: invokevirtual 381	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   27: aload_3
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   38: aconst_null
    //   39: astore_3
    //   40: aload_3
    //   41: astore_1
    //   42: getstatic 39	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   45: iconst_3
    //   46: aaload
    //   47: aload_2
    //   48: invokevirtual 191	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   51: ifeq -22 -> 29
    //   54: aload_0
    //   55: invokevirtual 381	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   58: aload_3
    //   59: astore_1
    //   60: goto -31 -> 29
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: getstatic 39	com/tencent/commonsdk/soload/DexReleasor:sExtraDexes	[Ljava/lang/String;
    //   72: iconst_3
    //   73: aaload
    //   74: aload_2
    //   75: invokevirtual 191	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 381	com/tencent/commonsdk/soload/DexReleasor:destroy	()V
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	DexReleasor
    //   0	87	1	paramString1	String
    //   0	87	2	paramString2	String
    //   8	51	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   2	9	33	java/io/IOException
    //   11	27	63	finally
    //   42	58	63	finally
    //   69	85	63	finally
    //   85	87	63	finally
    //   2	9	68	finally
    //   34	38	68	finally
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\soload\DexReleasor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */