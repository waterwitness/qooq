package com.tencent.component.network.module.cache;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.component.network.module.cache.a.e;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.PlatformUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class a
{
  private static final HashMap<String, com.tencent.component.network.module.cache.a.b> a = new HashMap();
  private static final e b = new e(new b());
  
  public static com.tencent.component.network.module.cache.a.b a(Context paramContext)
  {
    String str2 = "tmp";
    String str3 = com.tencent.component.network.downloader.common.a.a(paramContext);
    String str1 = str2;
    if (str3 != null)
    {
      str1 = str2;
      if (str3.contains(":"))
      {
        int i = str3.lastIndexOf(":");
        str1 = str2;
        if (i > 0) {
          str1 = "tmp" + "_" + str3.substring(i + 1);
        }
      }
    }
    return a(paramContext, str1, 500, 200);
  }
  
  public static com.tencent.component.network.module.cache.a.b a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    for (;;)
    {
      AssertUtil.assertTrue(bool);
      synchronized (a)
      {
        com.tencent.component.network.module.cache.a.b localb2 = (com.tencent.component.network.module.cache.a.b)a.get(paramString);
        com.tencent.component.network.module.cache.a.b localb1 = localb2;
        if (localb2 == null)
        {
          localb1 = new com.tencent.component.network.module.cache.a.b(paramContext, paramString, paramInt1, paramInt2);
          localb1.a(b);
          a.put(paramString, localb1);
        }
        return localb1;
        bool = true;
      }
    }
  }
  
  public static String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (!a()) {
      paramContext = null;
    }
    while (paramContext == null)
    {
      return null;
      if (!paramBoolean) {}
      for (paramContext = a.a(paramContext);; paramContext = a.a(paramContext, "cache"))
      {
        if (paramContext != null) {
          break label42;
        }
        paramContext = null;
        break;
      }
      label42:
      paramContext = paramContext.getAbsolutePath();
    }
    if (TextUtils.isEmpty(paramString)) {
      return paramContext;
    }
    paramContext = new File(paramContext + File.separator + paramString);
    try
    {
      if (paramContext.isFile()) {
        FileUtils.delete(paramContext);
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    finally {}
  }
  
  public static boolean a()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static String b(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramContext = paramContext.getCacheDir().getAbsolutePath(); TextUtils.isEmpty(paramString); paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "cache") {
      return paramContext;
    }
    paramContext = new File(paramContext + File.separator + paramString);
    if (paramContext.isFile()) {
      FileUtils.delete(paramContext);
    }
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  static class a
  {
    private static final File a = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
    
    public static File a(Context paramContext)
    {
      if (PlatformUtil.version() >= 8) {
        return paramContext.getExternalCacheDir();
      }
      try
      {
        paramContext = paramContext.getPackageName();
        paramContext = new File(new File(a, paramContext), "cache");
        boolean bool = paramContext.exists();
        if (!bool) {
          try
          {
            new File(a, ".nomedia").createNewFile();
            if (!paramContext.mkdirs())
            {
              com.tencent.component.network.downloader.common.a.c("InnerEnvironment", "Unable to create external cache directory");
              return null;
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              com.tencent.component.network.downloader.common.a.b("InnerEnvironment", "", localIOException);
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
      //   0: invokestatic 40	com/tencent/component/network/utils/PlatformUtil:version	()I
      //   3: bipush 8
      //   5: if_icmplt +9 -> 14
      //   8: aload_0
      //   9: aload_1
      //   10: invokevirtual 98	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
      //   13: areturn
      //   14: ldc 2
      //   16: monitorenter
      //   17: new 47	java/lang/StringBuilder
      //   20: dup
      //   21: aload_0
      //   22: invokevirtual 51	android/content/Context:getPackageName	()Ljava/lang/String;
      //   25: invokestatic 57	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   28: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   31: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   34: astore_0
      //   35: new 12	java/io/File
      //   38: dup
      //   39: new 12	java/io/File
      //   42: dup
      //   43: getstatic 28	com/tencent/component/network/module/cache/a$a:a	Ljava/io/File;
      //   46: aload_0
      //   47: invokespecial 24	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   50: ldc 100
      //   52: invokespecial 24	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   55: astore_0
      //   56: aload_0
      //   57: invokevirtual 69	java/io/File:exists	()Z
      //   60: istore_3
      //   61: iload_3
      //   62: ifne +45 -> 107
      //   65: new 12	java/io/File
      //   68: dup
      //   69: getstatic 28	com/tencent/component/network/module/cache/a$a:a	Ljava/io/File;
      //   72: ldc 71
      //   74: invokespecial 24	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   77: invokevirtual 74	java/io/File:createNewFile	()Z
      //   80: pop
      //   81: aload_0
      //   82: invokevirtual 77	java/io/File:mkdirs	()Z
      //   85: ifne +22 -> 107
      //   88: ldc 79
      //   90: ldc 102
      //   92: invokestatic 108	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   95: pop
      //   96: ldc 2
      //   98: monitorexit
      //   99: aconst_null
      //   100: areturn
      //   101: astore_0
      //   102: ldc 2
      //   104: monitorexit
      //   105: aload_0
      //   106: athrow
      //   107: aload_1
      //   108: ifnonnull +8 -> 116
      //   111: ldc 2
      //   113: monitorexit
      //   114: aload_0
      //   115: areturn
      //   116: new 12	java/io/File
      //   119: dup
      //   120: aload_0
      //   121: aload_1
      //   122: invokespecial 24	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   125: astore_0
      //   126: aload_0
      //   127: invokevirtual 69	java/io/File:exists	()Z
      //   130: ifne +37 -> 167
      //   133: aload_0
      //   134: invokevirtual 77	java/io/File:mkdirs	()Z
      //   137: ifne +30 -> 167
      //   140: ldc 79
      //   142: new 47	java/lang/StringBuilder
      //   145: dup
      //   146: ldc 110
      //   148: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   151: aload_0
      //   152: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   155: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   158: invokestatic 108	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   161: pop
      //   162: ldc 2
      //   164: monitorexit
      //   165: aconst_null
      //   166: areturn
      //   167: ldc 2
      //   169: monitorexit
      //   170: aload_0
      //   171: areturn
      //   172: astore_2
      //   173: goto -92 -> 81
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	176	0	paramContext	Context
      //   0	176	1	paramString	String
      //   172	1	2	localIOException	IOException
      //   60	2	3	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   17	61	101	finally
      //   65	81	101	finally
      //   81	99	101	finally
      //   116	165	101	finally
      //   65	81	172	java/io/IOException
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\cache\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */