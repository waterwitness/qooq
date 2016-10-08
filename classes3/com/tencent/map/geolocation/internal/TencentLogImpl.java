package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import java.io.File;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class TencentLogImpl
  implements TencentLog
{
  private static boolean DEBUG = false;
  private static final String TAG = "TencentLogImpl";
  private final File mBackupDir;
  private Handler mHandler;
  private final Runnable mKiller;
  private boolean mPrepared;
  private HandlerThread mWorker;
  
  public TencentLogImpl(Context paramContext, @Nullable File paramFile)
  {
    this.mBackupDir = paramFile;
    if ((paramFile != null) && ((paramFile.exists()) || (paramFile.mkdirs()))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mPrepared = bool;
      if (this.mPrepared)
      {
        this.mWorker = new HandlerThread("log_worker", 10);
        this.mWorker.start();
        this.mHandler = new LogHandler(this.mWorker.getLooper(), null);
      }
      this.mKiller = new Runnable()
      {
        public void run()
        {
          if (TencentLogImpl.this._isPrepared())
          {
            TencentLogImpl.access$202(TencentLogImpl.this, false);
            TencentLogImpl.this.mHandler.removeCallbacksAndMessages(null);
            TencentLogImpl.this.mWorker.quit();
          }
        }
      };
      if (DEBUG)
      {
        new StringBuilder("log dir=").append(this.mBackupDir);
        if (!this.mPrepared) {
          new StringBuilder("init failed: mPrepared=").append(this.mPrepared);
        }
      }
      return;
    }
  }
  
  private boolean _isPrepared()
  {
    return (this.mPrepared) && (this.mHandler != null);
  }
  
  public static boolean isDebugEnabled()
  {
    return DEBUG;
  }
  
  public static void setDebugEnabled(boolean paramBoolean)
  {
    DEBUG = paramBoolean;
  }
  
  final boolean isPrepared()
  {
    return this.mPrepared;
  }
  
  public final void println(String paramString1, int paramInt, @NonNull String paramString2)
  {
    if (_isPrepared())
    {
      paramString1 = new StringBuilder();
      paramString1.append(DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()));
      paramString1.append(":").append(paramString2).append("\n");
      this.mHandler.obtainMessage(1, paramString1.toString()).sendToTarget();
    }
  }
  
  public final void shutdown(long paramLong)
  {
    if (_isPrepared())
    {
      this.mHandler.removeCallbacks(this.mKiller);
      this.mHandler.postDelayed(this.mKiller, paramLong);
    }
  }
  
  public final boolean tryRestart()
  {
    boolean bool = false;
    if (_isPrepared())
    {
      this.mHandler.removeCallbacks(this.mKiller);
      bool = true;
    }
    return bool;
  }
  
  final class LogHandler
    extends Handler
  {
    private static final String TXWATCHDOG = "txwatchdog";
    private File mDest = makeSureDest();
    
    private LogHandler(Looper paramLooper)
    {
      super();
    }
    
    private File makeSureDest()
    {
      File localFile = TencentLogImpl.this.mBackupDir;
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return new File(localFile, "txwatchdog");
    }
    
    /* Error */
    public final void handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 6
      //   3: aload_0
      //   4: aload_1
      //   5: invokespecial 54	android/os/Handler:handleMessage	(Landroid/os/Message;)V
      //   8: aload_0
      //   9: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   12: ifnull +18 -> 30
      //   15: ldc 11
      //   17: aload_0
      //   18: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   21: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
      //   24: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   27: ifne +11 -> 38
      //   30: aload_0
      //   31: aload_0
      //   32: invokespecial 26	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:makeSureDest	()Ljava/io/File;
      //   35: putfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   38: aload_1
      //   39: getfield 70	android/os/Message:obj	Ljava/lang/Object;
      //   42: invokevirtual 75	java/lang/Object:toString	()Ljava/lang/String;
      //   45: ldc 77
      //   47: invokevirtual 81	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   50: invokestatic 87	ct/b:a	([B)[B
      //   53: astore_2
      //   54: aload_2
      //   55: arraylength
      //   56: istore 7
      //   58: iload 7
      //   60: newarray <illegal type>
      //   62: astore_1
      //   63: aload_2
      //   64: iconst_0
      //   65: aload_1
      //   66: iconst_0
      //   67: iload 7
      //   69: invokestatic 93	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   72: iload 7
      //   74: iconst_5
      //   75: irem
      //   76: bipush 7
      //   78: iadd
      //   79: istore 8
      //   81: iconst_0
      //   82: istore 4
      //   84: iload 8
      //   86: iconst_1
      //   87: ishl
      //   88: iload 4
      //   90: iadd
      //   91: iload 7
      //   93: if_icmpge +19 -> 112
      //   96: iload 4
      //   98: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   101: invokevirtual 103	java/lang/Integer:byteValue	()B
      //   104: istore 9
      //   106: iconst_0
      //   107: istore 5
      //   109: goto +313 -> 422
      //   112: iload 7
      //   114: iconst_4
      //   115: iadd
      //   116: newarray <illegal type>
      //   118: astore_3
      //   119: aload_1
      //   120: arraylength
      //   121: istore 4
      //   123: aload_3
      //   124: iconst_0
      //   125: iload 4
      //   127: bipush 8
      //   129: ishr
      //   130: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   133: invokevirtual 103	java/lang/Integer:byteValue	()B
      //   136: bastore
      //   137: aload_3
      //   138: iconst_1
      //   139: iload 4
      //   141: bipush 24
      //   143: ishr
      //   144: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   147: invokevirtual 103	java/lang/Integer:byteValue	()B
      //   150: bastore
      //   151: aload_3
      //   152: iconst_2
      //   153: iload 4
      //   155: bipush 16
      //   157: ishr
      //   158: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   161: invokevirtual 103	java/lang/Integer:byteValue	()B
      //   164: bastore
      //   165: aload_3
      //   166: iconst_3
      //   167: iload 4
      //   169: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   172: invokevirtual 103	java/lang/Integer:byteValue	()B
      //   175: bastore
      //   176: aload_1
      //   177: iconst_0
      //   178: aload_3
      //   179: iconst_4
      //   180: iload 4
      //   182: invokestatic 93	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   185: aload_0
      //   186: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   189: astore_1
      //   190: new 105	java/io/BufferedOutputStream
      //   193: dup
      //   194: new 107	java/io/FileOutputStream
      //   197: dup
      //   198: aload_1
      //   199: iconst_1
      //   200: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   203: invokespecial 113	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   206: astore_2
      //   207: aload_2
      //   208: astore_1
      //   209: aload_2
      //   210: aload_3
      //   211: invokevirtual 117	java/io/BufferedOutputStream:write	([B)V
      //   214: aload_2
      //   215: astore_1
      //   216: aload_2
      //   217: invokevirtual 121	java/io/BufferedOutputStream:flush	()V
      //   220: aload_2
      //   221: invokestatic 124	ct/b:a	(Ljava/io/Closeable;)V
      //   224: aload_0
      //   225: getfield 19	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:this$0	Lcom/tencent/map/geolocation/internal/TencentLogImpl;
      //   228: invokestatic 36	com/tencent/map/geolocation/internal/TencentLogImpl:access$500	(Lcom/tencent/map/geolocation/internal/TencentLogImpl;)Ljava/io/File;
      //   231: astore_1
      //   232: aload_0
      //   233: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   236: astore_2
      //   237: aload_1
      //   238: ifnull +7 -> 245
      //   241: aload_2
      //   242: ifnonnull +27 -> 269
      //   245: return
      //   246: astore_3
      //   247: aconst_null
      //   248: astore_1
      //   249: aload_3
      //   250: athrow
      //   251: astore_3
      //   252: aload_1
      //   253: astore_2
      //   254: aload_3
      //   255: astore_1
      //   256: aload_2
      //   257: invokestatic 124	ct/b:a	(Ljava/io/Closeable;)V
      //   260: aload_1
      //   261: athrow
      //   262: astore_1
      //   263: aload_0
      //   264: aconst_null
      //   265: putfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
      //   268: return
      //   269: invokestatic 128	java/lang/System:currentTimeMillis	()J
      //   272: lstore 11
      //   274: aload_2
      //   275: invokevirtual 131	java/io/File:length	()J
      //   278: ldc2_w 132
      //   281: lcmp
      //   282: ifle +33 -> 315
      //   285: aload_2
      //   286: new 38	java/io/File
      //   289: dup
      //   290: aload_1
      //   291: new 135	java/lang/StringBuilder
      //   294: dup
      //   295: ldc -119
      //   297: invokespecial 140	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   300: lload 11
      //   302: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   305: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   308: invokespecial 48	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   311: invokevirtual 149	java/io/File:renameTo	(Ljava/io/File;)Z
      //   314: pop
      //   315: aload_1
      //   316: invokevirtual 153	java/io/File:listFiles	()[Ljava/io/File;
      //   319: astore_1
      //   320: aload_1
      //   321: ifnull -76 -> 245
      //   324: aload_1
      //   325: arraylength
      //   326: bipush 10
      //   328: if_icmple -83 -> 245
      //   331: aload_1
      //   332: arraylength
      //   333: istore 5
      //   335: iload 6
      //   337: istore 4
      //   339: iload 4
      //   341: iload 5
      //   343: if_icmpge -98 -> 245
      //   346: aload_1
      //   347: iload 4
      //   349: aaload
      //   350: astore_2
      //   351: ldc 11
      //   353: aload_2
      //   354: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
      //   357: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   360: ifne +41 -> 401
      //   363: aload_2
      //   364: invokevirtual 156	java/io/File:isDirectory	()Z
      //   367: ifne +34 -> 401
      //   370: aload_2
      //   371: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
      //   374: ldc -119
      //   376: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   379: ifeq +22 -> 401
      //   382: lload 11
      //   384: aload_2
      //   385: invokevirtual 163	java/io/File:lastModified	()J
      //   388: lsub
      //   389: ldc2_w 164
      //   392: lcmp
      //   393: ifle +8 -> 401
      //   396: aload_2
      //   397: invokevirtual 168	java/io/File:delete	()Z
      //   400: pop
      //   401: iload 4
      //   403: iconst_1
      //   404: iadd
      //   405: istore 4
      //   407: goto -68 -> 339
      //   410: astore_1
      //   411: aconst_null
      //   412: astore_2
      //   413: goto -157 -> 256
      //   416: astore_3
      //   417: aload_2
      //   418: astore_1
      //   419: goto -170 -> 249
      //   422: iload 5
      //   424: iload 8
      //   426: if_icmpge +58 -> 484
      //   429: aload_1
      //   430: iload 4
      //   432: iload 5
      //   434: iadd
      //   435: baload
      //   436: istore 10
      //   438: aload_1
      //   439: iload 4
      //   441: iload 5
      //   443: iadd
      //   444: aload_1
      //   445: iload 4
      //   447: iload 8
      //   449: iadd
      //   450: iload 5
      //   452: iadd
      //   453: baload
      //   454: iload 9
      //   456: ixor
      //   457: i2b
      //   458: bastore
      //   459: aload_1
      //   460: iload 4
      //   462: iload 8
      //   464: iadd
      //   465: iload 5
      //   467: iadd
      //   468: iload 10
      //   470: iload 9
      //   472: ixor
      //   473: i2b
      //   474: bastore
      //   475: iload 5
      //   477: iconst_1
      //   478: iadd
      //   479: istore 5
      //   481: goto -59 -> 422
      //   484: iload 8
      //   486: iconst_1
      //   487: ishl
      //   488: iload 4
      //   490: iadd
      //   491: istore 4
      //   493: goto -409 -> 84
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	496	0	this	LogHandler
      //   0	496	1	paramMessage	Message
      //   53	365	2	localObject1	Object
      //   118	93	3	arrayOfByte	byte[]
      //   246	4	3	localIOException1	java.io.IOException
      //   251	4	3	localObject2	Object
      //   416	1	3	localIOException2	java.io.IOException
      //   82	410	4	i	int
      //   107	373	5	j	int
      //   1	335	6	k	int
      //   56	60	7	m	int
      //   79	409	8	n	int
      //   104	369	9	i1	int
      //   436	37	10	i2	int
      //   272	111	11	l	long
      // Exception table:
      //   from	to	target	type
      //   190	207	246	java/io/IOException
      //   209	214	251	finally
      //   216	220	251	finally
      //   249	251	251	finally
      //   38	72	262	java/io/IOException
      //   96	106	262	java/io/IOException
      //   112	190	262	java/io/IOException
      //   220	224	262	java/io/IOException
      //   256	262	262	java/io/IOException
      //   190	207	410	finally
      //   209	214	416	java/io/IOException
      //   216	220	416	java/io/IOException
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\map\geolocation\internal\TencentLogImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */