import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.IOException;

public class wuo
{
  protected static final File a;
  public static String a;
  protected static File b;
  protected static File c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
    jdField_a_of_type_JavaIoFile = new File(jdField_a_of_type_JavaLangString + File.separator + "Android" + File.separator + "data");
  }
  
  public static File a(Context paramContext)
  {
    try
    {
      paramContext = a(paramContext.getPackageName());
      boolean bool = paramContext.exists();
      if (!bool) {
        try
        {
          new File(jdField_a_of_type_JavaIoFile, ".nomedia").createNewFile();
          if (!paramContext.mkdirs()) {
            return null;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
    }
    finally {}
    return paramContext;
  }
  
  /* Error */
  public static File a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 65	android/content/Context:getPackageName	()Ljava/lang/String;
    //   7: invokestatic 89	wuo:b	(Ljava/lang/String;)Ljava/io/File;
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 72	java/io/File:exists	()Z
    //   15: istore_3
    //   16: iload_3
    //   17: ifne +31 -> 48
    //   20: new 25	java/io/File
    //   23: dup
    //   24: getstatic 55	wuo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   27: ldc 74
    //   29: invokespecial 77	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: invokevirtual 80	java/io/File:createNewFile	()Z
    //   35: pop
    //   36: aload_0
    //   37: invokevirtual 83	java/io/File:mkdirs	()Z
    //   40: ifne +8 -> 48
    //   43: ldc 2
    //   45: monitorexit
    //   46: aconst_null
    //   47: areturn
    //   48: aload_1
    //   49: ifnonnull +8 -> 57
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: areturn
    //   57: new 25	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: aload_1
    //   63: invokespecial 77	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 72	java/io/File:exists	()Z
    //   71: ifne +21 -> 92
    //   74: aload_0
    //   75: invokevirtual 83	java/io/File:mkdirs	()Z
    //   78: ifne +14 -> 92
    //   81: ldc 2
    //   83: monitorexit
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: ldc 2
    //   89: monitorexit
    //   90: aload_0
    //   91: athrow
    //   92: ldc 2
    //   94: monitorexit
    //   95: aload_0
    //   96: areturn
    //   97: astore_2
    //   98: goto -62 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramContext	Context
    //   0	101	1	paramString	String
    //   97	1	2	localIOException	IOException
    //   15	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	16	86	finally
    //   20	36	86	finally
    //   36	46	86	finally
    //   52	55	86	finally
    //   57	84	86	finally
    //   87	90	86	finally
    //   92	95	86	finally
    //   20	36	97	java/io/IOException
  }
  
  public static File a(String paramString)
  {
    if (b != null) {
      return b;
    }
    b = new File(jdField_a_of_type_JavaIoFile, paramString + File.separator + "qzone" + File.separator + "cache");
    return b;
  }
  
  public static File b(String paramString)
  {
    if (c != null) {
      return c;
    }
    c = new File(jdField_a_of_type_JavaIoFile, paramString + File.separator + "qzone" + File.separator + "files");
    return c;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wuo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */