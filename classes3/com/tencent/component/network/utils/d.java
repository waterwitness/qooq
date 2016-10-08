package com.tencent.component.network.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public final class d
{
  private static Class a;
  private static Method b;
  
  static
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      a = localClass;
      b = localClass.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str2 = b(paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = c(paramString);
    }
    paramString = str1;
    if (TextUtils.isEmpty(str1)) {
      paramString = null;
    }
    return paramString;
  }
  
  private static String b(String paramString)
  {
    if ((a == null) || (b == null)) {
      return null;
    }
    try
    {
      paramString = (String)b.invoke(a, new Object[] { paramString, null });
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  /* Error */
  private static String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 59	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: new 61	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 63
    //   11: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokevirtual 79	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   24: astore 4
    //   26: new 81	java/io/BufferedReader
    //   29: dup
    //   30: new 83	java/io/InputStreamReader
    //   33: dup
    //   34: aload 4
    //   36: invokevirtual 89	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   39: invokespecial 92	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_0
    //   46: new 61	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   53: astore_2
    //   54: aload_0
    //   55: invokevirtual 100	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnonnull +38 -> 98
    //   63: aload_2
    //   64: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_3
    //   68: aload_3
    //   69: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: istore 5
    //   74: aload_0
    //   75: astore_2
    //   76: iload 5
    //   78: ifne +7 -> 85
    //   81: aload_3
    //   82: astore_1
    //   83: aload_0
    //   84: astore_2
    //   85: aload_2
    //   86: invokevirtual 103	java/io/BufferedReader:close	()V
    //   89: aload_1
    //   90: astore_0
    //   91: aload 4
    //   93: invokevirtual 106	java/lang/Process:destroy	()V
    //   96: aload_0
    //   97: areturn
    //   98: aload_2
    //   99: aload_3
    //   100: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: goto -50 -> 54
    //   107: astore_2
    //   108: aload_0
    //   109: astore_2
    //   110: aload_0
    //   111: ifnonnull -26 -> 85
    //   114: aconst_null
    //   115: astore_0
    //   116: goto -25 -> 91
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 103	java/io/BufferedReader:close	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_0
    //   133: aconst_null
    //   134: areturn
    //   135: astore_0
    //   136: aload_1
    //   137: areturn
    //   138: astore_1
    //   139: aload_0
    //   140: areturn
    //   141: astore_1
    //   142: goto -20 -> 122
    //   145: astore_0
    //   146: aconst_null
    //   147: astore_0
    //   148: goto -40 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramString	String
    //   1	89	1	localObject1	Object
    //   119	18	1	str1	String
    //   138	1	1	localThrowable	Throwable
    //   141	1	1	localObject2	Object
    //   53	46	2	localObject3	Object
    //   107	1	2	localIOException	java.io.IOException
    //   109	1	2	str2	String
    //   58	42	3	str3	String
    //   24	68	4	localProcess	Process
    //   72	5	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   46	54	107	java/io/IOException
    //   54	59	107	java/io/IOException
    //   63	74	107	java/io/IOException
    //   98	104	107	java/io/IOException
    //   26	46	119	finally
    //   2	26	132	java/lang/Throwable
    //   126	130	132	java/lang/Throwable
    //   130	132	132	java/lang/Throwable
    //   85	89	135	java/lang/Throwable
    //   91	96	138	java/lang/Throwable
    //   46	54	141	finally
    //   54	59	141	finally
    //   63	74	141	finally
    //   98	104	141	finally
    //   26	46	145	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */