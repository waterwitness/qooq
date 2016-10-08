package com.tencent.beacon.a;

import android.content.Context;
import com.tencent.beacon.d.a;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  private static i c = null;
  private Context a = null;
  private Map<String, FileChannel> b = null;
  
  private i(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap(5);
  }
  
  public static i a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new i(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  private File b(String paramString)
  {
    try
    {
      File localFile = new File(this.a.getFilesDir(), "Beacon_" + paramString + ".lock");
      paramString = localFile;
      if (!localFile.exists())
      {
        a.b(" create lock file: %s", new Object[] { localFile.getAbsolutePath() });
        localFile.createNewFile();
        paramString = localFile;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        a.a(paramString);
        paramString = null;
      }
    }
    finally {}
    return paramString;
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +17 -> 20
    //   6: aload_1
    //   7: invokevirtual 91	java/lang/String:trim	()Ljava/lang/String;
    //   10: invokevirtual 95	java/lang/String:length	()I
    //   13: istore 5
    //   15: iload 5
    //   17: ifgt +11 -> 28
    //   20: iconst_0
    //   21: istore 6
    //   23: aload_0
    //   24: monitorexit
    //   25: iload 6
    //   27: ireturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 97	com/tencent/beacon/a/i:b	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnonnull +9 -> 46
    //   40: iconst_1
    //   41: istore 6
    //   43: goto -20 -> 23
    //   46: aload_0
    //   47: getfield 24	com/tencent/beacon/a/i:b	Ljava/util/Map;
    //   50: aload_1
    //   51: invokeinterface 103 2 0
    //   56: checkcast 105	java/nio/channels/FileChannel
    //   59: astore_3
    //   60: aload_3
    //   61: ifnull +12 -> 73
    //   64: aload_3
    //   65: astore_2
    //   66: aload_3
    //   67: invokevirtual 108	java/nio/channels/FileChannel:isOpen	()Z
    //   70: ifne +41 -> 111
    //   73: ldc 110
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_1
    //   82: aastore
    //   83: invokestatic 77	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: new 112	java/io/FileOutputStream
    //   89: dup
    //   90: aload 4
    //   92: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   95: invokevirtual 119	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   98: astore_2
    //   99: aload_0
    //   100: getfield 24	com/tencent/beacon/a/i:b	Ljava/util/Map;
    //   103: aload_1
    //   104: aload_2
    //   105: invokeinterface 123 3 0
    //   110: pop
    //   111: aload_2
    //   112: invokevirtual 127	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +25 -> 142
    //   120: aload_1
    //   121: invokevirtual 132	java/nio/channels/FileLock:isValid	()Z
    //   124: istore 6
    //   126: iload 6
    //   128: ifeq +14 -> 142
    //   131: iconst_1
    //   132: istore 6
    //   134: goto -111 -> 23
    //   137: astore_1
    //   138: aload_1
    //   139: invokestatic 83	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   142: iconst_0
    //   143: istore 6
    //   145: goto -122 -> 23
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	i
    //   0	153	1	paramString	String
    //   65	47	2	localFileChannel1	FileChannel
    //   59	8	3	localFileChannel2	FileChannel
    //   33	58	4	localFile	File
    //   13	3	5	i	int
    //   21	123	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   46	60	137	java/lang/Throwable
    //   66	73	137	java/lang/Throwable
    //   73	111	137	java/lang/Throwable
    //   111	116	137	java/lang/Throwable
    //   120	126	137	java/lang/Throwable
    //   6	15	148	finally
    //   28	35	148	finally
    //   46	60	148	finally
    //   66	73	148	finally
    //   73	111	148	finally
    //   111	116	148	finally
    //   120	126	148	finally
    //   138	142	148	finally
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */