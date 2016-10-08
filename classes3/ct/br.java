package ct;

import android.content.Context;
import android.os.Bundle;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

final class br
  extends bp
{
  final Context a;
  
  public br(Context paramContext, String paramString)
  {
    super(paramString, "load libtencentloc.so myself");
    this.a = paramContext;
    new Thread()
    {
      public final void run()
      {
        File localFile = new File(br.this.a.getFilesDir(), "libtencentloc.so");
        if ((localFile.exists()) && (localFile.length() > 0L)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            localFile.delete();
            br.this.b();
          }
          return;
        }
      }
    }.start();
  }
  
  private static void a(InputStream paramInputStream, BufferedOutputStream paramBufferedOutputStream)
    throws IOException
  {
    if (paramInputStream == null) {
      return;
    }
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramBufferedOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  protected final boolean a(Bundle paramBundle)
  {
    paramBundle = new File(this.a.getFilesDir(), "libtencentloc.so");
    if ((paramBundle.exists()) && (paramBundle.length() > 0L)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramBundle.delete();
        b();
      }
      try
      {
        System.load(paramBundle.getAbsolutePath());
        return true;
      }
      catch (Error localError)
      {
        new StringBuilder("doWork0: load file(p=").append(paramBundle.getAbsolutePath()).append(",l=").append(paramBundle.length()).append(") failed");
      }
    }
    return false;
  }
  
  /* Error */
  final void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: new 46	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 17	ct/br:a	Landroid/content/Context;
    //   13: invokevirtual 52	android/content/Context:getFilesDir	()Ljava/io/File;
    //   16: ldc 54
    //   18: invokespecial 57	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 17	ct/br:a	Landroid/content/Context;
    //   26: invokevirtual 104	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   29: ldc 106
    //   31: invokevirtual 112	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore_2
    //   35: new 36	java/io/BufferedOutputStream
    //   38: dup
    //   39: new 114	java/io/FileOutputStream
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 120	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   50: astore_1
    //   51: aload_1
    //   52: astore 5
    //   54: aload_2
    //   55: astore 4
    //   57: aload_2
    //   58: aload_1
    //   59: invokestatic 122	ct/br:a	(Ljava/io/InputStream;Ljava/io/BufferedOutputStream;)V
    //   62: aload_1
    //   63: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   66: aload_2
    //   67: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   70: return
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_3
    //   76: aload_1
    //   77: astore 5
    //   79: aload_3
    //   80: astore 4
    //   82: new 46	java/io/File
    //   85: dup
    //   86: aload_0
    //   87: getfield 17	ct/br:a	Landroid/content/Context;
    //   90: invokevirtual 52	android/content/Context:getFilesDir	()Ljava/io/File;
    //   93: ldc 54
    //   95: invokespecial 57	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   98: astore 7
    //   100: aload_0
    //   101: invokevirtual 133	java/lang/Object:getClass	()Ljava/lang/Class;
    //   104: ldc -121
    //   106: invokevirtual 140	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   109: astore_2
    //   110: new 36	java/io/BufferedOutputStream
    //   113: dup
    //   114: new 114	java/io/FileOutputStream
    //   117: dup
    //   118: aload 7
    //   120: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   123: invokespecial 120	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   126: astore 7
    //   128: aload_2
    //   129: aload 7
    //   131: invokestatic 122	ct/br:a	(Ljava/io/InputStream;Ljava/io/BufferedOutputStream;)V
    //   134: aload_1
    //   135: astore 5
    //   137: aload_3
    //   138: astore 4
    //   140: aload 7
    //   142: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   145: aload_1
    //   146: astore 5
    //   148: aload_3
    //   149: astore 4
    //   151: aload_2
    //   152: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   155: aload_1
    //   156: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   159: aload_3
    //   160: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   163: return
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_1
    //   168: astore 5
    //   170: aload_3
    //   171: astore 4
    //   173: aload 6
    //   175: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   178: aload_1
    //   179: astore 5
    //   181: aload_3
    //   182: astore 4
    //   184: aload_2
    //   185: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   188: goto -33 -> 155
    //   191: astore_1
    //   192: aload 5
    //   194: astore_3
    //   195: aload 4
    //   197: astore_2
    //   198: aload_3
    //   199: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   202: aload_2
    //   203: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   206: aload_1
    //   207: athrow
    //   208: astore 6
    //   210: aconst_null
    //   211: astore_2
    //   212: aconst_null
    //   213: astore 7
    //   215: aload_1
    //   216: astore 5
    //   218: aload_3
    //   219: astore 4
    //   221: aload 7
    //   223: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   226: aload_1
    //   227: astore 5
    //   229: aload_3
    //   230: astore 4
    //   232: aload_2
    //   233: invokestatic 127	ct/b:a	(Ljava/io/Closeable;)V
    //   236: aload_1
    //   237: astore 5
    //   239: aload_3
    //   240: astore 4
    //   242: aload 6
    //   244: athrow
    //   245: astore_1
    //   246: aconst_null
    //   247: astore_2
    //   248: goto -50 -> 198
    //   251: astore_1
    //   252: goto -54 -> 198
    //   255: astore 6
    //   257: aconst_null
    //   258: astore 7
    //   260: goto -45 -> 215
    //   263: astore 6
    //   265: goto -50 -> 215
    //   268: astore 4
    //   270: goto -103 -> 167
    //   273: astore 4
    //   275: aload 7
    //   277: astore 6
    //   279: goto -112 -> 167
    //   282: astore_1
    //   283: aconst_null
    //   284: astore_1
    //   285: aload_2
    //   286: astore_3
    //   287: goto -211 -> 76
    //   290: astore_3
    //   291: aload_2
    //   292: astore_3
    //   293: goto -217 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	br
    //   21	42	1	localObject1	Object
    //   71	1	1	localIOException1	IOException
    //   73	106	1	localCloseable1	java.io.Closeable
    //   191	46	1	localObject2	Object
    //   245	1	1	localObject3	Object
    //   251	1	1	localObject4	Object
    //   282	1	1	localIOException2	IOException
    //   284	1	1	localObject5	Object
    //   34	118	2	localInputStream	InputStream
    //   164	1	2	localException1	Exception
    //   166	126	2	localObject6	Object
    //   1	286	3	localObject7	Object
    //   290	1	3	localIOException3	IOException
    //   292	1	3	localObject8	Object
    //   55	186	4	localObject9	Object
    //   268	1	4	localException2	Exception
    //   273	1	4	localException3	Exception
    //   52	186	5	localObject10	Object
    //   3	171	6	localCloseable2	java.io.Closeable
    //   208	35	6	localObject11	Object
    //   255	1	6	localObject12	Object
    //   263	1	6	localObject13	Object
    //   277	1	6	localObject14	Object
    //   98	178	7	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   22	35	71	java/io/IOException
    //   100	110	164	java/lang/Exception
    //   57	62	191	finally
    //   82	100	191	finally
    //   140	145	191	finally
    //   151	155	191	finally
    //   173	178	191	finally
    //   184	188	191	finally
    //   221	226	191	finally
    //   232	236	191	finally
    //   242	245	191	finally
    //   100	110	208	finally
    //   22	35	245	finally
    //   35	51	251	finally
    //   110	128	255	finally
    //   128	134	263	finally
    //   110	128	268	java/lang/Exception
    //   128	134	273	java/lang/Exception
    //   35	51	282	java/io/IOException
    //   57	62	290	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */