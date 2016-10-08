package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class PropertyUtils
{
  private static final String CMD_GET_PROP = "getprop";
  public static final String PROPERTY_DNS_PRIMARY = "net.dns1";
  public static final String PROPERTY_DNS_SECNDARY = "net.dns2";
  private static Class sClassSystemProperties;
  private static Method sMethodGetString;
  
  static
  {
    try
    {
      sClassSystemProperties = Class.forName("android.os.SystemProperties");
      sMethodGetString = sClassSystemProperties.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static String get(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    String str1;
    do
    {
      return paramString2;
      String str2 = getWithReflect(paramString1, null);
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getWithCmd(paramString1, null);
      }
    } while (TextUtils.isEmpty(str1));
    return str1;
  }
  
  public static String getQuickly(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return getWithReflect(paramString1, paramString2);
  }
  
  /* Error */
  private static String getWithCmd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: invokestatic 71	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: new 73	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   12: ldc 76
    //   14: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 88	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   27: astore 4
    //   29: aconst_null
    //   30: astore_3
    //   31: new 90	java/io/BufferedReader
    //   34: dup
    //   35: new 92	java/io/InputStreamReader
    //   38: dup
    //   39: aload 4
    //   41: invokevirtual 98	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: invokespecial 101	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   47: invokespecial 104	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_0
    //   51: new 73	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   58: astore_2
    //   59: aload_0
    //   60: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull +32 -> 97
    //   68: aload_2
    //   69: aload_3
    //   70: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: goto -15 -> 59
    //   77: astore_2
    //   78: aload_0
    //   79: ifnull +9 -> 88
    //   82: aload_1
    //   83: astore_2
    //   84: aload_0
    //   85: invokevirtual 110	java/io/BufferedReader:close	()V
    //   88: aload_1
    //   89: astore_0
    //   90: aload 4
    //   92: invokevirtual 113	java/lang/Process:destroy	()V
    //   95: aload_0
    //   96: areturn
    //   97: aload_2
    //   98: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_2
    //   102: aload_2
    //   103: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: istore 5
    //   108: iload 5
    //   110: ifne +5 -> 115
    //   113: aload_2
    //   114: astore_1
    //   115: aload_0
    //   116: ifnull +57 -> 173
    //   119: aload_1
    //   120: astore_2
    //   121: aload_0
    //   122: invokevirtual 110	java/io/BufferedReader:close	()V
    //   125: goto +48 -> 173
    //   128: aload_3
    //   129: ifnull +9 -> 138
    //   132: aload_1
    //   133: astore_2
    //   134: aload_3
    //   135: invokevirtual 110	java/io/BufferedReader:close	()V
    //   138: aload_1
    //   139: astore_2
    //   140: aload_0
    //   141: athrow
    //   142: astore_0
    //   143: aload_0
    //   144: astore_1
    //   145: aload_2
    //   146: astore_0
    //   147: aload_1
    //   148: invokevirtual 45	java/lang/Throwable:printStackTrace	()V
    //   151: aload_0
    //   152: areturn
    //   153: astore_1
    //   154: goto -7 -> 147
    //   157: astore_3
    //   158: aload_0
    //   159: astore_2
    //   160: aload_3
    //   161: astore_0
    //   162: aload_2
    //   163: astore_3
    //   164: goto -36 -> 128
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_0
    //   170: goto -92 -> 78
    //   173: aload_1
    //   174: astore_0
    //   175: goto -85 -> 90
    //   178: astore_0
    //   179: goto -51 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString1	String
    //   0	182	1	paramString2	String
    //   1	68	2	localObject1	Object
    //   77	1	2	localIOException	java.io.IOException
    //   83	80	2	str1	String
    //   30	105	3	str2	String
    //   157	4	3	localObject2	Object
    //   163	1	3	str3	String
    //   27	64	4	localProcess	Process
    //   106	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   51	59	77	java/io/IOException
    //   59	64	77	java/io/IOException
    //   68	74	77	java/io/IOException
    //   97	108	77	java/io/IOException
    //   2	29	142	java/lang/Throwable
    //   84	88	142	java/lang/Throwable
    //   121	125	142	java/lang/Throwable
    //   134	138	142	java/lang/Throwable
    //   140	142	142	java/lang/Throwable
    //   90	95	153	java/lang/Throwable
    //   51	59	157	finally
    //   59	64	157	finally
    //   68	74	157	finally
    //   97	108	157	finally
    //   31	51	167	java/io/IOException
    //   31	51	178	finally
  }
  
  private static String getWithReflect(String paramString1, String paramString2)
  {
    if ((sClassSystemProperties == null) || (sMethodGetString == null)) {
      return paramString2;
    }
    try
    {
      paramString1 = (String)sMethodGetString.invoke(sClassSystemProperties, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\PropertyUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */