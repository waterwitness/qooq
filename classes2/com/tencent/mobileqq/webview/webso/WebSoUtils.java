package com.tencent.mobileqq.webview.webso;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class WebSoUtils
{
  public static final String a = "tencent/MobileQQ/webso/offline/";
  public static final String b = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent/MobileQQ/webso/offline/";
  public static final String c = BaseApplication.getContext().getFilesDir() + "/webso/offline/";
  public static final String d = "wns_html_etags";
  private static final String e = "WebSoUtils";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    Object localObject = "Android Qzone/" + QUA.a();
    String str;
    switch (HttpUtil.a())
    {
    case 0: 
    default: 
      str = "";
    }
    for (;;)
    {
      localObject = new StringBuilder((String)localObject);
      ((StringBuilder)localObject).append(" ").append("QQ/").append("6.5.5").append(".").append("2880").append(str).append(" Pixel/").append(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels);
      return ((StringBuilder)localObject).toString();
      str = " NetType/UNKNOWN";
      continue;
      str = " NetType/WIFI";
      continue;
      str = " NetType/2G";
      continue;
      str = " NetType/3G";
      continue;
      str = " NetType/4G";
    }
  }
  
  public static String a(Uri paramUri)
  {
    try
    {
      if (b(paramUri)) {}
      for (String str = paramUri.toString();; str = paramUri.getAuthority() + paramUri.getPath()) {
        return MD5Utils.d(str);
      }
      return paramUri.toString();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSoUtils", 2, "getUrlKey..uri", localThrowable);
      }
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      str = a(Uri.parse(paramString));
      return str;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        String str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("WebSoUtils", 2, "getUrlKey..url", localThrowable);
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = String.valueOf(System.currentTimeMillis());
    WebSoService.a().a(paramString1, str);
    return a(paramString2, str, null);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      localStringBuilder.append("<script> var _WebSoLocalTime=" + paramString2 + ";</script>");
      localStringBuilder.append("<script> var _WebSoNetTime=" + paramString3 + ";</script>");
      QLog.i("WebSoService", 1, "add _WebSoLocalTime=" + paramString2 + ", add _WebSoNetTime=" + paramString3);
      return localStringBuilder.toString();
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return "";
    }
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static void a(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    e(b(paramUri));
    e(c(paramUri));
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0).edit();
    String str = String.valueOf(BaseApplicationImpl.a().a().getLongAccountUin());
    paramUri = a(paramUri);
    localEditor.remove("eTag_" + str + paramUri);
    localEditor.remove("templateTag_" + str + paramUri);
    localEditor.remove("htmlSha1_" + str + paramUri);
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  public static boolean a(Uri paramUri)
  {
    if (paramUri == null) {}
    for (;;)
    {
      return false;
      try
      {
        String str = paramUri.getQueryParameter("_proxy");
        int i;
        if ((str != null) && (("1".equals(str)) || ("true".equals(str))) && (!TextUtils.isEmpty(d(paramUri.toString()))))
        {
          i = 1;
          label53:
          paramUri = paramUri.getQueryParameter("_updateProxy");
          if (TextUtils.isEmpty(paramUri)) {
            break label99;
          }
          boolean bool = "0".equals(paramUri);
          if (bool) {
            break label99;
          }
        }
        label99:
        for (int j = 1; (i != 0) || (j != 0); j = 0)
        {
          return true;
          i = 0;
          break label53;
        }
        return false;
      }
      catch (Exception paramUri) {}
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("_updateProxy");
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool3 = "0".equals(paramString);
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 8
    //   10: aconst_null
    //   11: astore 7
    //   13: aconst_null
    //   14: astore 5
    //   16: aload_0
    //   17: ifnull +10 -> 27
    //   20: aload_1
    //   21: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +9 -> 33
    //   27: iconst_0
    //   28: istore 10
    //   30: iload 10
    //   32: ireturn
    //   33: new 37	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 298	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 301	java/io/File:exists	()Z
    //   48: ifeq +9 -> 57
    //   51: aload 4
    //   53: invokevirtual 304	java/io/File:delete	()Z
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 307	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: new 309	java/io/ByteArrayInputStream
    //   66: dup
    //   67: aload_0
    //   68: iconst_0
    //   69: aload_0
    //   70: arraylength
    //   71: invokespecial 312	java/io/ByteArrayInputStream:<init>	([BII)V
    //   74: astore_1
    //   75: new 314	java/io/BufferedOutputStream
    //   78: dup
    //   79: new 316	java/io/FileOutputStream
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   88: sipush 4096
    //   91: invokespecial 322	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   94: astore 4
    //   96: aload 8
    //   98: astore_0
    //   99: aload 4
    //   101: astore_3
    //   102: aload_1
    //   103: astore_2
    //   104: aload 7
    //   106: astore 6
    //   108: invokestatic 328	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   111: sipush 4096
    //   114: invokevirtual 332	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   117: astore 7
    //   119: aload 7
    //   121: astore 5
    //   123: aload 7
    //   125: astore_0
    //   126: aload 4
    //   128: astore_3
    //   129: aload_1
    //   130: astore_2
    //   131: aload 7
    //   133: astore 6
    //   135: aload_1
    //   136: aload 7
    //   138: invokevirtual 338	java/io/InputStream:read	([B)I
    //   141: istore 9
    //   143: iload 9
    //   145: iconst_m1
    //   146: if_icmpeq +81 -> 227
    //   149: aload 7
    //   151: astore 5
    //   153: aload 7
    //   155: astore_0
    //   156: aload 4
    //   158: astore_3
    //   159: aload_1
    //   160: astore_2
    //   161: aload 7
    //   163: astore 6
    //   165: aload 4
    //   167: aload 7
    //   169: iconst_0
    //   170: iload 9
    //   172: invokevirtual 343	java/io/OutputStream:write	([BII)V
    //   175: goto -56 -> 119
    //   178: astore_0
    //   179: aload 5
    //   181: astore 6
    //   183: aload_0
    //   184: astore 5
    //   186: aload 6
    //   188: astore_0
    //   189: aload 4
    //   191: astore_3
    //   192: aload_1
    //   193: astore_2
    //   194: aload 5
    //   196: invokevirtual 344	java/io/IOException:printStackTrace	()V
    //   199: invokestatic 328	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   202: aload 6
    //   204: invokevirtual 348	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 351	java/io/InputStream:close	()V
    //   215: aload 4
    //   217: ifnull +8 -> 225
    //   220: aload 4
    //   222: invokevirtual 352	java/io/OutputStream:close	()V
    //   225: iconst_0
    //   226: ireturn
    //   227: aload 7
    //   229: astore 5
    //   231: aload 7
    //   233: astore_0
    //   234: aload 4
    //   236: astore_3
    //   237: aload_1
    //   238: astore_2
    //   239: aload 7
    //   241: astore 6
    //   243: aload 4
    //   245: invokevirtual 355	java/io/OutputStream:flush	()V
    //   248: iconst_1
    //   249: istore 10
    //   251: invokestatic 328	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   254: aload 7
    //   256: invokevirtual 348	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 351	java/io/InputStream:close	()V
    //   267: aload 4
    //   269: ifnull -239 -> 30
    //   272: aload 4
    //   274: invokevirtual 352	java/io/OutputStream:close	()V
    //   277: iconst_1
    //   278: ireturn
    //   279: astore_0
    //   280: aload_0
    //   281: invokevirtual 223	java/lang/Exception:printStackTrace	()V
    //   284: iconst_0
    //   285: ireturn
    //   286: astore_0
    //   287: aload_0
    //   288: invokevirtual 223	java/lang/Exception:printStackTrace	()V
    //   291: iconst_0
    //   292: ireturn
    //   293: astore 5
    //   295: aconst_null
    //   296: astore 4
    //   298: aconst_null
    //   299: astore_1
    //   300: aload 6
    //   302: astore_0
    //   303: aload 4
    //   305: astore_3
    //   306: aload_1
    //   307: astore_2
    //   308: aload 5
    //   310: invokevirtual 223	java/lang/Exception:printStackTrace	()V
    //   313: invokestatic 328	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   316: aload 6
    //   318: invokevirtual 348	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   321: aload_1
    //   322: ifnull +7 -> 329
    //   325: aload_1
    //   326: invokevirtual 351	java/io/InputStream:close	()V
    //   329: aload 4
    //   331: ifnull +8 -> 339
    //   334: aload 4
    //   336: invokevirtual 352	java/io/OutputStream:close	()V
    //   339: iconst_0
    //   340: ireturn
    //   341: astore_0
    //   342: aload_0
    //   343: invokevirtual 223	java/lang/Exception:printStackTrace	()V
    //   346: iconst_0
    //   347: ireturn
    //   348: astore 4
    //   350: aconst_null
    //   351: astore_3
    //   352: aconst_null
    //   353: astore_1
    //   354: aload_2
    //   355: astore_0
    //   356: invokestatic 328	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   359: aload_0
    //   360: invokevirtual 348	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   363: aload_1
    //   364: ifnull +7 -> 371
    //   367: aload_1
    //   368: invokevirtual 351	java/io/InputStream:close	()V
    //   371: aload_3
    //   372: ifnull +7 -> 379
    //   375: aload_3
    //   376: invokevirtual 352	java/io/OutputStream:close	()V
    //   379: aload 4
    //   381: athrow
    //   382: astore_0
    //   383: aload_0
    //   384: invokevirtual 223	java/lang/Exception:printStackTrace	()V
    //   387: goto -8 -> 379
    //   390: astore 4
    //   392: aconst_null
    //   393: astore_3
    //   394: aload_2
    //   395: astore_0
    //   396: goto -40 -> 356
    //   399: astore 4
    //   401: aload_2
    //   402: astore_1
    //   403: goto -47 -> 356
    //   406: astore 5
    //   408: aconst_null
    //   409: astore 4
    //   411: goto -111 -> 300
    //   414: astore 5
    //   416: goto -116 -> 300
    //   419: astore 5
    //   421: aconst_null
    //   422: astore 4
    //   424: aconst_null
    //   425: astore_1
    //   426: aload_3
    //   427: astore 6
    //   429: goto -243 -> 186
    //   432: astore 5
    //   434: aconst_null
    //   435: astore 4
    //   437: aload_3
    //   438: astore 6
    //   440: goto -254 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	paramArrayOfByte	byte[]
    //   0	443	1	paramString	String
    //   6	396	2	str	String
    //   1	437	3	localObject1	Object
    //   41	294	4	localObject2	Object
    //   348	32	4	localObject3	Object
    //   390	1	4	localObject4	Object
    //   399	1	4	localObject5	Object
    //   409	27	4	localObject6	Object
    //   14	216	5	arrayOfByte1	byte[]
    //   293	16	5	localException1	Exception
    //   406	1	5	localException2	Exception
    //   414	1	5	localException3	Exception
    //   419	1	5	localIOException1	IOException
    //   432	1	5	localIOException2	IOException
    //   3	436	6	localObject7	Object
    //   11	244	7	arrayOfByte2	byte[]
    //   8	89	8	localObject8	Object
    //   141	30	9	i	int
    //   28	222	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   108	119	178	java/io/IOException
    //   135	143	178	java/io/IOException
    //   165	175	178	java/io/IOException
    //   243	248	178	java/io/IOException
    //   251	259	279	java/lang/Exception
    //   263	267	279	java/lang/Exception
    //   272	277	279	java/lang/Exception
    //   199	207	286	java/lang/Exception
    //   211	215	286	java/lang/Exception
    //   220	225	286	java/lang/Exception
    //   43	57	293	java/lang/Exception
    //   57	75	293	java/lang/Exception
    //   313	321	341	java/lang/Exception
    //   325	329	341	java/lang/Exception
    //   334	339	341	java/lang/Exception
    //   43	57	348	finally
    //   57	75	348	finally
    //   356	363	382	java/lang/Exception
    //   367	371	382	java/lang/Exception
    //   375	379	382	java/lang/Exception
    //   75	96	390	finally
    //   108	119	399	finally
    //   135	143	399	finally
    //   165	175	399	finally
    //   194	199	399	finally
    //   243	248	399	finally
    //   308	313	399	finally
    //   75	96	406	java/lang/Exception
    //   108	119	414	java/lang/Exception
    //   135	143	414	java/lang/Exception
    //   165	175	414	java/lang/Exception
    //   243	248	414	java/lang/Exception
    //   43	57	419	java/io/IOException
    //   57	75	419	java/io/IOException
    //   75	96	432	java/io/IOException
  }
  
  private static String b()
  {
    if (FileUtils.a()) {}
    for (Object localObject = b;; localObject = c)
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      String str = ((File)localObject).getAbsolutePath();
      localObject = str;
      if (!str.endsWith(File.separator)) {
        localObject = str + File.separator;
      }
      return (String)localObject;
    }
  }
  
  public static String b(Uri paramUri)
  {
    paramUri = d(paramUri);
    if (TextUtils.isEmpty(paramUri)) {
      return "";
    }
    return paramUri + ".txt";
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = new File(b(Uri.parse(paramString)));
      if ((paramString == null) || (!paramString.exists())) {
        return null;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebSoUtils", 2, "getHtmlData", paramString);
        }
        paramString = null;
      }
      try
      {
        paramString = FileUtils.b(paramString);
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2, WebSoService.a().a(paramString1), String.valueOf(System.currentTimeMillis()));
    WebSoService.a().a(paramString1);
    return paramString2;
  }
  
  public static void b(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    a(paramUri);
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0).edit();
    long l = BaseApplicationImpl.a().a().getLongAccountUin();
    paramUri = a(paramUri);
    localEditor.putLong("webso_" + String.valueOf(l) + paramUri + "_503", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
  
  private static boolean b(Uri paramUri)
  {
    boolean bool2 = false;
    String str = null;
    if (paramUri != null) {}
    try
    {
      str = paramUri.getQueryParameter("_proxyByURL");
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
  
  public static boolean b(String paramString)
  {
    try
    {
      boolean bool = a(Uri.parse(paramString));
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String c(Uri paramUri)
  {
    paramUri = d(paramUri);
    if (TextUtils.isEmpty(paramUri)) {
      return "";
    }
    return paramUri + "_template.txt";
  }
  
  public static String c(String paramString)
  {
    String str1 = b(paramString);
    if (TextUtils.isEmpty(str1)) {
      paramString = "";
    }
    do
    {
      return paramString;
      Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0);
      String str2 = a(paramString);
      long l = BaseApplicationImpl.a().a().getLongAccountUin();
      localObject = ((SharedPreferences)localObject).getString("htmlSha1_" + String.valueOf(l) + str2, "");
      if (!SHA1Util.a(str1).equals(localObject)) {
        break;
      }
      paramString = str1;
    } while (!QLog.isColorLevel());
    QLog.d("WebSoUtils", 2, "getHtmlDataAndCheck success");
    return str1;
    if (QLog.isColorLevel()) {
      QLog.d("WebSoUtils", 2, "html-sha1 check fail");
    }
    try
    {
      a(Uri.parse(paramString));
      return "";
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebSoUtils", 2, "clean web so data exception=" + paramString.getMessage());
        }
        paramString.printStackTrace();
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    try
    {
      String str1 = QzoneConfig.a().a("QzoneCover", "dynamicCoverPreviewUrl", "h5.qzone.qq.com/bgstore/dynamiccover");
      String str2 = QzoneConfig.a().a("QzoneCover", "dynamicCoverPreviewKeyword", "tplId=");
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.contains(str1))
        {
          boolean bool3 = paramString.contains(str2);
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String d(Uri paramUri)
  {
    if (paramUri == null) {
      return "";
    }
    String str = b();
    if (b(paramUri)) {}
    for (paramUri = paramUri.toString();; paramUri = paramUri.getAuthority() + paramUri.getPath())
    {
      paramUri = MD5Utils.d(paramUri + String.valueOf(BaseApplicationImpl.a().a().getLongAccountUin()));
      return str + paramUri;
    }
  }
  
  public static String d(String paramString)
  {
    Object localObject = QzoneConfig.a().a("QzUrlCache", "HttpProxyHost2Command", "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"} }");
    try
    {
      localObject = new JSONObject((String)localObject);
      Iterator localIterator = ((JSONObject)localObject).keys();
      paramString = Uri.parse(paramString).getHost();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        if ((paramString.equals(str)) || ((str.startsWith(".")) && (paramString.endsWith(str))))
        {
          localObject = (JSONObject)((JSONObject)localObject).get(str);
          paramString = ((JSONObject)localObject).optString("command");
          localObject = ((JSONObject)localObject).optString("msfCommand");
          boolean bool = TextUtils.isEmpty(paramString);
          if (bool) {
            return (String)localObject;
          }
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l;
    do
    {
      do
      {
        return false;
      } while (!a(paramString));
      Object localObject = Uri.parse(paramString);
      paramString = BaseApplicationImpl.getContext().getSharedPreferences("wns_html_etags", 0);
      l = BaseApplicationImpl.a().a().getLongAccountUin();
      localObject = a((Uri)localObject);
      l = paramString.getLong("webso_" + String.valueOf(l) + (String)localObject + "_503", -1L);
    } while ((l == -1L) || (System.currentTimeMillis() - l >= 43200000L));
    if (QLog.isColorLevel()) {
      QLog.e("WebSoUtils", 2, "now hit webso time, so return true");
    }
    return true;
  }
  
  public static String e(String paramString)
  {
    Object localObject = QzoneConfig.a().a("QzUrlCache", "HttpProxyHost2Command", "{\".qzone.qq.com\":{\"command\":\"qzoneh5.h5.wnshtml\",\"msfCommand\":\"qzoneh5.h5.wnshtml\"},\"web.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenter.websoh5\",\"msfCommand\":\"mqqweb.gamecenter.websoh5\"},\"m.gamecenter.qq.com\":{\"command\":\"mqqweb.gamecenterV2.h5\",\"msfCommand\":\"mqqweb.gamecenterV2.h5\"},\"mc.vip.qq.com\":{\"command\":\"mqqweb.mcvip.websoh5\",\"msfCommand\":\"mqqweb.mcvip.websoh5\"},\"zb.vip.qq.com\":{\"command\":\"mqqweb.zb.webso\",\"msfCommand\":\"mqqweb.zb.webso\"} }");
    try
    {
      localObject = new JSONObject((String)localObject);
      Iterator localIterator = ((JSONObject)localObject).keys();
      paramString = Uri.parse(paramString).getHost();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        if ((paramString.equals(str)) || ((str.startsWith(".")) && (paramString.endsWith(str))))
        {
          paramString = (JSONObject)((JSONObject)localObject).get(str);
          localObject = paramString.optString("command");
          paramString = paramString.optString("msfCommand");
          boolean bool = TextUtils.isEmpty(paramString);
          if (bool) {
            paramString = (String)localObject;
          }
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return FileUtils.d(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\webso\WebSoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */