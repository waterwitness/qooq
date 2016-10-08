package cooperation.qzone.util;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class WnsProxyUtils
{
  private static long jdField_a_of_type_Long = 0L;
  private static final String jdField_a_of_type_JavaLangString = "req";
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static String b = "";
  private static String c = "";
  private static final String d = "com.qzone";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    String str = a(paramContext, "file", false, false);
    if (b(paramUri)) {}
    for (paramContext = paramUri.toString();; paramContext = paramUri.getAuthority() + paramUri.getPath())
    {
      paramContext = MD5.toMD5(paramContext);
      return str + paramContext + ".txt";
    }
  }
  
  private static String a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a();
    String str = Environment.getExternalStorageState();
    int i = 0;
    if ((!paramBoolean1) && ("mounted".equals(str))) {
      if ((paramBoolean2) && (!TextUtils.isEmpty(b)))
      {
        c = b;
        str = c + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache";
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        c = Environment.getDataDirectory().getAbsolutePath();
        str = paramContext.getCacheDir().getAbsolutePath();
      }
      paramContext = paramString;
      if (!paramString.startsWith(File.separator)) {
        paramContext = File.separator + paramString;
      }
      paramString = paramContext;
      if (!paramContext.endsWith(File.separator)) {
        paramString = paramContext + File.separator;
      }
      paramContext = new File(str + paramString);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      paramString = paramContext.getAbsolutePath();
      paramContext = paramString;
      if (!paramString.endsWith(File.separator)) {
        paramContext = paramString + File.separator;
      }
      return paramContext;
      if ((Environment.getExternalStorageDirectory().canWrite()) && (b(Environment.getExternalStorageDirectory().getAbsolutePath())))
      {
        c = Environment.getExternalStorageDirectory().getAbsolutePath();
        str = c + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache";
        i = 1;
      }
      else
      {
        str = "";
      }
    }
  }
  
  public static String a(Uri paramUri)
  {
    if (b(paramUri)) {
      return paramUri.toString();
    }
    return paramUri.getAuthority() + paramUri.getPath();
  }
  
  public static String a(String paramString)
  {
    try
    {
      Object localObject = Uri.parse(paramString);
      if (b((Uri)localObject)) {
        return ((Uri)localObject).toString();
      }
      localObject = ((Uri)localObject).getAuthority() + ((Uri)localObject).getPath();
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WnsProxyUtils", 2, "getUrlKey", localThrowable);
    }
    return paramString;
  }
  
  private static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      jdField_a_of_type_JavaUtilHashMap.clear();
      b = "";
      jdField_a_of_type_Long = 0L;
      a("/etc/vold.fstab");
      a("/etc/internal_sd.fstab");
      a("/etc/external_sd.fstab");
      Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            Object localObject2 = new File(str);
            if ((((File)localObject2).exists()) && (((File)localObject2).canWrite()) && (b(str)))
            {
              localObject2 = new StatFs(str);
              long l = ((StatFs)localObject2).getAvailableBlocks() * ((StatFs)localObject2).getBlockSize();
              if ((l > 0L) && (jdField_a_of_type_Long < l))
              {
                jdField_a_of_type_Long = l;
                b = str;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
  }
  
  /* Error */
  private static void a(String paramString)
  {
    // Byte code:
    //   0: new 100	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 135	java/io/File:exists	()Z
    //   13: ifeq +111 -> 124
    //   16: new 214	java/io/BufferedReader
    //   19: dup
    //   20: new 216	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 219	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 222	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 225	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +85 -> 125
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc -29
    //   48: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   51: ifeq -19 -> 32
    //   54: aload_1
    //   55: astore_0
    //   56: aload_2
    //   57: ldc -27
    //   59: invokevirtual 233	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   62: astore_3
    //   63: aload_1
    //   64: astore_0
    //   65: aload_3
    //   66: arraylength
    //   67: iconst_3
    //   68: if_icmplt -36 -> 32
    //   71: aload_3
    //   72: iconst_2
    //   73: aaload
    //   74: astore_2
    //   75: aload_3
    //   76: iconst_1
    //   77: aaload
    //   78: astore_3
    //   79: aload_1
    //   80: astore_0
    //   81: new 100	java/io/File
    //   84: dup
    //   85: aload_2
    //   86: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 135	java/io/File:exists	()Z
    //   92: ifeq -60 -> 32
    //   95: aload_1
    //   96: astore_0
    //   97: getstatic 32	cooperation/qzone/util/WnsProxyUtils:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   100: aload_3
    //   101: aload_2
    //   102: invokevirtual 237	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: goto -74 -> 32
    //   109: astore_2
    //   110: aload_1
    //   111: astore_0
    //   112: aload_2
    //   113: invokevirtual 238	java/lang/Exception:printStackTrace	()V
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 241	java/io/BufferedReader:close	()V
    //   124: return
    //   125: aload_1
    //   126: astore_0
    //   127: aload_1
    //   128: invokevirtual 241	java/io/BufferedReader:close	()V
    //   131: aload_1
    //   132: ifnull -8 -> 124
    //   135: aload_1
    //   136: invokevirtual 241	java/io/BufferedReader:close	()V
    //   139: return
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   145: return
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   151: return
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_0
    //   155: aload_0
    //   156: ifnull +7 -> 163
    //   159: aload_0
    //   160: invokevirtual 241	java/io/BufferedReader:close	()V
    //   163: aload_1
    //   164: athrow
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   170: goto -7 -> 163
    //   173: astore_1
    //   174: goto -19 -> 155
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_1
    //   180: goto -70 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramString	String
    //   31	105	1	localBufferedReader	java.io.BufferedReader
    //   152	12	1	localObject1	Object
    //   173	1	1	localObject2	Object
    //   179	1	1	localObject3	Object
    //   38	64	2	str	String
    //   109	4	2	localException1	Exception
    //   177	1	2	localException2	Exception
    //   62	39	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   34	39	109	java/lang/Exception
    //   45	54	109	java/lang/Exception
    //   56	63	109	java/lang/Exception
    //   65	71	109	java/lang/Exception
    //   81	95	109	java/lang/Exception
    //   97	106	109	java/lang/Exception
    //   127	131	109	java/lang/Exception
    //   135	139	140	java/io/IOException
    //   120	124	146	java/io/IOException
    //   16	32	152	finally
    //   159	163	165	java/io/IOException
    //   34	39	173	finally
    //   45	54	173	finally
    //   56	63	173	finally
    //   65	71	173	finally
    //   81	95	173	finally
    //   97	106	173	finally
    //   112	116	173	finally
    //   127	131	173	finally
    //   16	32	177	java/lang/Exception
  }
  
  public static boolean a(Uri paramUri)
  {
    boolean bool2 = false;
    String str = null;
    if (paramUri != null) {}
    try
    {
      str = paramUri.getQueryParameter("_proxy");
      boolean bool1 = bool2;
      if (str != null) {
        if (!"1".equals(str))
        {
          boolean bool3 = "true".equals(str);
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramUri) {}
    return false;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      boolean bool = a(Uri.parse(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String b(Context paramContext, Uri paramUri)
  {
    String str = a(paramContext, "file", false, false);
    if (b(paramUri)) {}
    for (paramContext = paramUri.toString();; paramContext = paramUri.getAuthority() + paramUri.getPath())
    {
      paramContext = MD5.toMD5(paramContext);
      return str + paramContext + "_temp.txt";
    }
  }
  
  public static String b(Uri paramUri)
  {
    paramUri = new File(a(BaseApplicationImpl.getContext(), paramUri));
    if (!paramUri.exists()) {
      return null;
    }
    return d(paramUri.getAbsolutePath());
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      paramString = new File(a(BaseApplicationImpl.getContext(), paramString));
      if ((paramString == null) || (!paramString.exists())) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("WnsProxyUtils", 2, "getCacheData", paramString);
        paramString = null;
      }
    }
    return d(paramString.getAbsolutePath());
  }
  
  private static boolean b(Uri paramUri)
  {
    boolean bool2 = false;
    String str = null;
    if (paramUri != null) {}
    try
    {
      str = paramUri.getQueryParameter("_query");
      boolean bool1 = bool2;
      if (str != null) {
        if (!"1".equals(str))
        {
          boolean bool3 = "true".equals(str);
          bool1 = bool2;
          if (!bool3) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramUri) {}
    return false;
  }
  
  /* Error */
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 275	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: invokevirtual 279	java/lang/Thread:getId	()J
    //   9: lstore_2
    //   10: new 100	java/io/File
    //   13: dup
    //   14: new 63	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   21: aload_0
    //   22: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 281
    //   28: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: lload_2
    //   32: invokevirtual 284	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore_0
    //   42: aload_0
    //   43: invokevirtual 135	java/io/File:exists	()Z
    //   46: ifeq +24 -> 70
    //   49: aload_0
    //   50: invokevirtual 287	java/io/File:delete	()Z
    //   53: ifeq +9 -> 62
    //   56: aload_0
    //   57: invokevirtual 290	java/io/File:createNewFile	()Z
    //   60: istore 4
    //   62: aload_0
    //   63: invokevirtual 287	java/io/File:delete	()Z
    //   66: pop
    //   67: iload 4
    //   69: ireturn
    //   70: aload_0
    //   71: invokevirtual 290	java/io/File:createNewFile	()Z
    //   74: istore 4
    //   76: goto -14 -> 62
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 208	java/lang/Throwable:printStackTrace	()V
    //   84: aload_0
    //   85: invokevirtual 287	java/io/File:delete	()Z
    //   88: pop
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_1
    //   92: aload_0
    //   93: invokevirtual 287	java/io/File:delete	()Z
    //   96: pop
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramString	String
    //   79	2	1	localThrowable	Throwable
    //   91	7	1	localObject	Object
    //   9	23	2	l	long
    //   1	74	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   42	49	79	java/lang/Throwable
    //   49	62	79	java/lang/Throwable
    //   70	76	79	java/lang/Throwable
    //   42	49	91	finally
    //   49	62	91	finally
    //   70	76	91	finally
    //   80	84	91	finally
  }
  
  public static final String c(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      paramString = new File(b(BaseApplicationImpl.getContext(), paramString));
      if ((paramString == null) || (!paramString.exists())) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("WnsProxyUtils", 2, "getUrlKey", paramString);
        paramString = null;
      }
    }
    return d(paramString.getAbsolutePath());
  }
  
  /* Error */
  private static String d(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_0
    //   5: ifnull +12 -> 17
    //   8: aload_0
    //   9: invokevirtual 299	java/lang/String:length	()I
    //   12: ifne +7 -> 19
    //   15: aload_3
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 301	java/io/FileInputStream
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: aload_1
    //   31: invokevirtual 305	java/io/FileInputStream:available	()I
    //   34: newarray <illegal type>
    //   36: astore_2
    //   37: aload_1
    //   38: astore_0
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 309	java/io/FileInputStream:read	([B)I
    //   44: pop
    //   45: aload_1
    //   46: astore_0
    //   47: aload_2
    //   48: ldc_w 311
    //   51: invokestatic 317	org/apache/http/util/EncodingUtils:getString	([BLjava/lang/String;)Ljava/lang/String;
    //   54: astore_2
    //   55: aload_2
    //   56: astore_0
    //   57: aload_0
    //   58: astore_2
    //   59: aload_1
    //   60: ifnull -43 -> 17
    //   63: aload_1
    //   64: invokevirtual 318	java/io/FileInputStream:close	()V
    //   67: aload_0
    //   68: areturn
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   74: aload_0
    //   75: areturn
    //   76: astore_2
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: aload_2
    //   82: invokevirtual 319	java/io/FileNotFoundException:printStackTrace	()V
    //   85: aload_3
    //   86: astore_2
    //   87: aload_1
    //   88: ifnull -71 -> 17
    //   91: aload_1
    //   92: invokevirtual 318	java/io/FileInputStream:close	()V
    //   95: aconst_null
    //   96: areturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_2
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_0
    //   109: aload_2
    //   110: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   113: aload_3
    //   114: astore_2
    //   115: aload_1
    //   116: ifnull -99 -> 17
    //   119: aload_1
    //   120: invokevirtual 318	java/io/FileInputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_0
    //   137: aload_2
    //   138: invokevirtual 320	java/lang/OutOfMemoryError:printStackTrace	()V
    //   141: aload_3
    //   142: astore_2
    //   143: aload_1
    //   144: ifnull -127 -> 17
    //   147: aload_1
    //   148: invokevirtual 318	java/io/FileInputStream:close	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_0
    //   163: aload_0
    //   164: ifnull +7 -> 171
    //   167: aload_0
    //   168: invokevirtual 318	java/io/FileInputStream:close	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 242	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_1
    //   182: goto -19 -> 163
    //   185: astore_2
    //   186: goto -51 -> 135
    //   189: astore_2
    //   190: goto -83 -> 107
    //   193: astore_2
    //   194: goto -115 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramString	String
    //   27	37	1	localFileInputStream	java.io.FileInputStream
    //   69	2	1	localIOException1	java.io.IOException
    //   78	70	1	localObject1	Object
    //   160	12	1	localObject2	Object
    //   181	1	1	localObject3	Object
    //   3	56	2	localObject4	Object
    //   76	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   86	1	2	localObject5	Object
    //   104	6	2	localIOException2	java.io.IOException
    //   114	1	2	localObject6	Object
    //   132	6	2	localOutOfMemoryError1	OutOfMemoryError
    //   142	1	2	localObject7	Object
    //   185	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   189	1	2	localIOException3	java.io.IOException
    //   193	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	141	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   63	67	69	java/io/IOException
    //   19	28	76	java/io/FileNotFoundException
    //   91	95	97	java/io/IOException
    //   19	28	104	java/io/IOException
    //   119	123	125	java/io/IOException
    //   19	28	132	java/lang/OutOfMemoryError
    //   147	151	153	java/io/IOException
    //   19	28	160	finally
    //   167	171	173	java/io/IOException
    //   30	37	181	finally
    //   39	45	181	finally
    //   47	55	181	finally
    //   81	85	181	finally
    //   109	113	181	finally
    //   137	141	181	finally
    //   30	37	185	java/lang/OutOfMemoryError
    //   39	45	185	java/lang/OutOfMemoryError
    //   47	55	185	java/lang/OutOfMemoryError
    //   30	37	189	java/io/IOException
    //   39	45	189	java/io/IOException
    //   47	55	189	java/io/IOException
    //   30	37	193	java/io/FileNotFoundException
    //   39	45	193	java/io/FileNotFoundException
    //   47	55	193	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\util\WnsProxyUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */