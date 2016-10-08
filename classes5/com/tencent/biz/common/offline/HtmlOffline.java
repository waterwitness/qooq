package com.tencent.biz.common.offline;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.offline.util.DefaultThreadManager;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.biz.common.offline.util.IOfflineDownloader;
import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.biz.common.offline.util.MyLog;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.QQThreadManager;
import com.tencent.biz.common.util.ReportUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import hgp;
import hgv;
import hgw;
import hgx;
import hgy;
import hgz;
import hha;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.sso.offlinpkg.OfflinePkg.BidPkg;
import tencent.im.sso.offlinpkg.OfflinePkg.ReqBody;

public class HtmlOffline
{
  public static final int A = 13;
  public static final int B = 14;
  public static final int C = 0;
  public static final int D = 1;
  public static final int E = 0;
  public static final int F = 1;
  public static final int G = 2;
  public static final int H = 3;
  public static final int I = 0;
  public static final int J = 1;
  public static int K = 0;
  protected static final int L = 0;
  public static final int M = 10;
  private static final int N = 0;
  private static final int O = 1;
  private static final int P = 2;
  private static final int Q = 3;
  private static final int R = 4;
  private static final int S = 5;
  public static final int a = 0;
  private static Context a;
  public static AsyncBack a;
  public static ILog a;
  public static IOfflineDownloader a;
  public static IThreadManager a;
  public static final String a = "updateNotification";
  protected static ArrayList a;
  protected static HashMap a;
  public static ConcurrentHashMap a;
  public static boolean a = false;
  protected static final String[] a;
  public static final int b = 1;
  public static final String b = "wording";
  protected static final String[] b;
  public static final int c = 2;
  public static final String c = "wifiUpdatingText";
  public static final int d = 3;
  public static final String d = "nonWifiUpdatingText";
  public static final int e = 4;
  public static final String e = "updateCompletedText";
  public static final int f = 5;
  public static final String f = "expirelist";
  public static final int g = 6;
  public static final String g = "bid";
  public static final int h = 7;
  public static final String h = "expired";
  public static final int i = 8;
  public static final String i = "tencent/MobileQQ/qbiz/";
  public static final int j = 13;
  public static final String j = "tencent/MobileQQ/qbiz/html5/";
  public static final int k = 9;
  protected static String k;
  public static final int l = -1;
  public static String l;
  protected static final int m = 30;
  protected static String m;
  protected static final int n = 1;
  protected static String n;
  protected static final int o = 5;
  protected static String o;
  protected static final int p = 60;
  protected static String p;
  public static final int q = 0;
  protected static final String q = "config.json";
  public static final int r = 2;
  protected static final String r = "local_html";
  public static final int s = 3;
  protected static final String s = "HtmlCheckUpdate";
  public static final int t = 4;
  public static final String t = "HtmlCheckUpdate";
  public static final int u = 5;
  protected static final String u = "HtmlCheckUpdate";
  public static final int v = 6;
  public static final int w = 7;
  public static final int x = 8;
  public static final int y = 9;
  public static final int z = 10;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    k = "qbiz/";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "config.json", "verify.json", "verify.signature" };
    b = new String[] { "0", "1" };
    K = 0;
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager = new DefaultThreadManager();
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader = new OfflineDownloader();
    jdField_a_of_type_ComTencentBizCommonOfflineUtilILog = new MyLog();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = new hgx();
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("local_html", 0).getInt("expire_" + paramString, 0);
  }
  
  protected static long a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("local_html", 0).getLong("last_up_" + paramString, 0L);
  }
  
  public static HtmlOffline.MyWebResourceResponse a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith("http")))
    {
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "shouldInterceptRequest: businessId null ");
      }
      return null;
    }
    Object localObject = a(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    paramString1 = (String)localObject + paramString1;
    paramString2 = g(paramString2);
    localObject = paramString1 + "/" + paramString2;
    if (!new File((String)localObject).exists())
    {
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.b()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 4, "getResponse local file not exists :" + paramString2);
      }
      return null;
    }
    paramString1 = "text/html";
    if (paramString2.contains(".css")) {
      paramString1 = "text/css";
    }
    for (;;)
    {
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.b()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 4, "getResponse ****************** :" + paramString2);
      }
      try
      {
        localObject = new BufferedInputStream(new FileInputStream((String)localObject));
        return new HtmlOffline.MyWebResourceResponse(paramString1, (InputStream)localObject);
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        if (!jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.b()) {
          break label358;
        }
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 4, "getResponse get local file fail:" + paramString2);
      }
      if (paramString2.contains(".js")) {
        paramString1 = "application/x-javascript";
      } else if ((paramString2.contains(".jpg")) || (paramString2.contains(".gif")) || (paramString2.contains(".png")) || (paramString2.contains(".jpeg"))) {
        paramString1 = "image/*";
      }
    }
    label358:
    return null;
  }
  
  public static String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
      str = e(str + "tencent/MobileQQ/qbiz/" + "html5/");
      if (!TextUtils.isEmpty(str)) {
        localStringBuffer.append(str);
      }
    }
    if (jdField_a_of_type_AndroidContentContext == null) {
      jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.a().getApplicationContext();
    }
    Object localObject2 = null;
    try
    {
      str = jdField_a_of_type_AndroidContentContext.getFilesDir().toString() + File.separator + k;
      if (!TextUtils.isEmpty(str))
      {
        str = e(str + "html5/");
        if (!TextUtils.isEmpty(str))
        {
          if (localStringBuffer.length() > 0) {
            localStringBuffer.append(",");
          }
          localStringBuffer.append(str);
        }
      }
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.b("HtmlCheckUpdate", 2, "getLocalOfflineVersions:" + localStringBuffer.toString());
      }
      return localStringBuffer.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject1 = localObject2;
        if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a())
        {
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "getLocalOfflineVersions getFilesDir error");
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return null;
    }
    if (b(paramString)) {
      return l;
    }
    return o;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return paramString1;
    }
    if (paramString1.contains("#"))
    {
      String[] arrayOfString = paramString1.split("\\#");
      String str = arrayOfString[0];
      paramString1 = "";
      int i1 = 1;
      int i2 = arrayOfString.length;
      while (i1 < i2)
      {
        paramString1 = paramString1 + "#" + arrayOfString[i1];
        i1 += 1;
      }
      if (str.contains("?")) {
        return str.replace("?", new StringBuilder().append("?").append(paramString2).append("&").toString()) + paramString1;
      }
      return str + "?" + paramString2 + paramString1;
    }
    if (paramString1.contains("?")) {
      return paramString1.replace("?", "?" + paramString2 + "&");
    }
    return paramString1 + "?" + paramString2;
  }
  
  public static String a(String[] paramArrayOfString)
  {
    Object localObject = null;
    StringBuffer localStringBuffer = new StringBuffer();
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      paramArrayOfString = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
      paramArrayOfString = e(paramArrayOfString + "tencent/MobileQQ/qbiz/" + "html5/");
      if (!TextUtils.isEmpty(paramArrayOfString)) {
        localStringBuffer.append(paramArrayOfString);
      }
    }
    if (jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    try
    {
      paramArrayOfString = jdField_a_of_type_AndroidContentContext.getFilesDir().toString() + File.separator + k;
      if (!TextUtils.isEmpty(paramArrayOfString))
      {
        paramArrayOfString = e(paramArrayOfString + "html5/");
        if (!TextUtils.isEmpty(paramArrayOfString))
        {
          if (localStringBuffer.length() > 0) {
            localStringBuffer.append(",");
          }
          localStringBuffer.append(paramArrayOfString);
        }
      }
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.b("HtmlCheckUpdate", 2, "getLocalOfflineVersions:" + localStringBuffer.toString());
      }
      return localStringBuffer.toString();
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        paramArrayOfString.printStackTrace();
        paramArrayOfString = (String[])localObject;
        if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a())
        {
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "getLocalOfflineVersions getFilesDir error");
          paramArrayOfString = (String[])localObject;
        }
      }
    }
  }
  
  /* Error */
  public static JSONObject a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 167	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc -33
    //   26: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 89
    //   31: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_1
    //   38: new 167	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 306
    //   48: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_1
    //   59: aload_0
    //   60: invokevirtual 377	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   63: aload_1
    //   64: invokevirtual 383	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   67: astore_1
    //   68: aload_1
    //   69: invokestatic 388	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   72: astore_0
    //   73: aload_1
    //   74: invokevirtual 393	java/io/InputStream:close	()V
    //   77: new 395	org/json/JSONObject
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 396	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 397	org/json/JSONException:printStackTrace	()V
    //   93: getstatic 146	com/tencent/biz/common/offline/HtmlOffline:jdField_a_of_type_ComTencentBizCommonOfflineUtilILog	Lcom/tencent/biz/common/offline/util/ILog;
    //   96: invokeinterface 211 1 0
    //   101: ifeq +17 -> 118
    //   104: getstatic 146	com/tencent/biz/common/offline/HtmlOffline:jdField_a_of_type_ComTencentBizCommonOfflineUtilILog	Lcom/tencent/biz/common/offline/util/ILog;
    //   107: ldc 95
    //   109: iconst_2
    //   110: ldc_w 399
    //   113: invokeinterface 216 4 0
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 400	java/io/IOException:printStackTrace	()V
    //   128: goto -51 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramContext	Context
    //   0	131	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   77	86	88	org/json/JSONException
    //   59	68	120	java/io/IOException
    //   73	77	123	java/io/IOException
  }
  
  public static JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      String str = a(paramString);
      if (!TextUtils.isEmpty(str))
      {
        paramString = new File(str + paramString + "/" + "config.json");
        if (paramString.exists()) {
          try
          {
            paramString = new FileInputStream(paramString);
            if (paramString != null) {
              str = Util.a(paramString);
            }
          }
          catch (IOException paramString)
          {
            try
            {
              paramString.close();
              try
              {
                paramString = new JSONObject(str);
                return paramString;
              }
              catch (JSONException paramString)
              {
                paramString.printStackTrace();
                return null;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
              paramString = paramString;
              paramString.printStackTrace();
              paramString = null;
            }
            catch (IOException paramString)
            {
              for (;;)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_AndroidContentContext == null)
    {
      a(new QQThreadManager());
      a(new OfflineDownloader());
      a(new MyLog());
      a(BaseApplicationImpl.getContext());
    }
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 0);
    paramString = "last_up_" + paramString;
    paramContext = paramContext.edit();
    paramContext.putLong(paramString, System.currentTimeMillis());
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 0);
    paramString = "expire_" + paramString;
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, AsyncBack paramAsyncBack)
  {
    if (paramAsyncBack == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramAsyncBack.a(null, 1);
      return;
    }
    String str = b(paramString1);
    if (TextUtils.isEmpty(str))
    {
      paramAsyncBack.a(null, 3);
      return;
    }
    JSONObject localJSONObject = a(paramString1);
    if (localJSONObject != null)
    {
      l1 = 30L;
      try
      {
        l2 = localJSONObject.getLong("frequency");
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l2;
          localException.printStackTrace();
        }
      }
      l2 = (System.currentTimeMillis() - a(paramContext, paramString1)) / 60000L;
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "checkUpdate check freq:" + l1 + ", time:" + l2);
      }
      if (l2 < l1)
      {
        paramAsyncBack.a(null, 5);
        return;
      }
    }
    if (hgp.a(paramString1))
    {
      paramAsyncBack.a(null, 7);
      return;
    }
    hgp.a(paramString1);
    str = str + paramString1 + ".zip";
    long l1 = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept-Encoding", "gzip");
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new hha(paramContext, paramString2, paramString1, str, l1, paramAsyncBack, localHashMap));
  }
  
  public static void a(ILog paramILog)
  {
    jdField_a_of_type_ComTencentBizCommonOfflineUtilILog = paramILog;
  }
  
  public static void a(IOfflineDownloader paramIOfflineDownloader)
  {
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader = paramIOfflineDownloader;
  }
  
  public static void a(IThreadManager paramIThreadManager)
  {
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager = paramIThreadManager;
  }
  
  protected static void a(hgp paramhgp)
  {
    if (jdField_a_of_type_JavaUtilArrayList == null) {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    int i2 = jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      hgp localhgp = (hgp)jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (paramhgp.jdField_a_of_type_JavaLangString.equals(localhgp.jdField_a_of_type_JavaLangString)) {
        return;
      }
      i1 += 1;
    }
    jdField_a_of_type_JavaUtilArrayList.add(paramhgp);
  }
  
  public static void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString, paramInt1, paramLong, paramInt2, "lixian_update", "");
  }
  
  public static void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    for (;;)
    {
      int i1;
      int i2;
      try
      {
        i1 = Integer.valueOf(paramString1).intValue();
        if (paramString3 != null) {
          break label292;
        }
        paramString1 = "";
        paramString3 = "";
        try
        {
          if (jdField_a_of_type_AndroidContentContext == null) {
            jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
          }
          String str = jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
          paramString3 = str;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
          continue;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
        i2 = paramInt2;
        if (paramInt2 == -1)
        {
          i2 = paramInt2;
          if (jdField_a_of_type_AndroidContentContext != null) {
            i2 = NetworkUtil.a(jdField_a_of_type_AndroidContentContext);
          }
        }
        if (jdField_a_of_type_Boolean)
        {
          ReportUtil.a(null, "P_CliOper", "Pb_account_lifeservice", paramString3, "mp_msg_sys_14", paramString2, i1, paramInt1, "" + paramLong, "3", "" + i2, paramString1);
          return;
        }
      }
      catch (NumberFormatException paramString1)
      {
        i1 = -1;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("HtmlCheckUpdate", 2, "reportDownTime qver=" + paramString3 + ", mainAction=" + paramString2 + ", bid=" + i1 + ", code=" + paramInt1 + ", time=" + paramLong + ", netType=" + i2 + ", ex5=" + paramString1);
      return;
      label292:
      paramString1 = paramString3;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      File localFile = new File(paramString1 + "/b.zip");
      if (localFile.exists())
      {
        String str = c(paramString2) + paramString2 + ".zip";
        Util.b(str);
        localFile.renameTo(new File(str));
      }
      OfflinePlugin.d(paramString2);
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "dealVerifyErroFile e=" + paramString2.getMessage());
        }
      }
    }
    Util.a(paramString1);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, paramAppRuntime, true, jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack)
  {
    if (paramAsyncBack == null) {
      return;
    }
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.a(new hgw(paramString, paramAppRuntime, paramAsyncBack));
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean)
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(paramString);
    paramString = new HashMap(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = a(str);
      if (localObject2 != null)
      {
        localObject2 = ((JSONObject)localObject2).optString("version");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString.put(str, localObject2);
        }
      }
      else
      {
        paramString.put(str, "0");
      }
    }
    a(paramAppRuntime, paramString, paramAsyncBack, paramBoolean, false);
  }
  
  protected static void a(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean, int paramInt)
  {
    if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
      jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId " + paramString);
    }
    if (paramAsyncBack == null) {
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId, callback is null!");
      }
    }
    for (;;)
    {
      return;
      if (!a(paramString))
      {
        if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,no sd card!");
        }
        paramAsyncBack.a(null, 3);
        return;
      }
      if (Arrays.asList(b).contains(paramString))
      {
        if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,do not update");
        }
      }
      else if ((paramInt > 60) || (paramInt < 0))
      {
        if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,delayed too long.");
        }
      }
      else
      {
        JSONObject localJSONObject = a(paramString);
        long l2 = 30L;
        long l1 = l2;
        if (localJSONObject != null) {}
        try
        {
          l1 = localJSONObject.getLong("frequency");
          l2 = (System.currentTimeMillis() - a(paramAppRuntime.getApplication(), paramString)) / 60000L;
          if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
            jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:checkUpdate check freq:" + l1 + ", time:" + l2);
          }
          if (l2 < l1)
          {
            paramAsyncBack.a(null, 5);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            l1 = l2;
          }
          if (hgp.a(paramString))
          {
            if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
              jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:" + paramString + " is downloading");
            }
            paramAsyncBack.a(null, 7);
            return;
          }
          a(paramAppRuntime.getApplication().getApplicationContext(), paramString);
          if (jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager == null)
          {
            if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
              jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "threadManager is null");
            }
          }
          else
          {
            HashMap localHashMap = new HashMap(1);
            int i1 = 0;
            if (localJSONObject != null) {
              i1 = localJSONObject.optInt("version", 0);
            }
            localHashMap.put(paramString, i1 + "");
            jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.a(new hgy(paramInt, paramString, paramAppRuntime, localHashMap, paramAsyncBack));
          }
        }
      }
    }
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "parseExpire:" + paramString);
    }
    ArrayList localArrayList;
    JSONObject localJSONObject;
    label142:
    int i3;
    do
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("data");
        localArrayList = new ArrayList();
        int i2 = paramString.length();
        int i1 = 0;
        while (i1 < i2)
        {
          localJSONObject = paramString.optJSONObject(i1);
          if (localJSONObject != null) {
            break label142;
          }
          i1 += 1;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      QLog.i("HtmlCheckUpdate", 2, "parseExpire: " + QLog.getStackTraceString(paramString));
      return;
      i3 = localJSONObject.optInt("code");
    } while ((i3 <= 0) || (i3 >= 10));
    int i4 = localJSONObject.optInt("bid");
    localArrayList.add(i4 + "");
    hgp localhgp = new hgp(i4 + "", paramAppRuntime, null, true, i3);
    localhgp.jdField_c_of_type_Int = localJSONObject.optInt("id");
    if (localJSONObject.optInt("isWifi", 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localhgp.f = bool;
      localhgp.jdField_a_of_type_Boolean = paramBoolean;
      localhgp.jdField_c_of_type_JavaLangString = localJSONObject.optString("url");
      localhgp.b = localJSONObject.optInt("filesize");
      localhgp.a();
      break;
    }
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, AsyncBack paramAsyncBack)
  {
    if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
      jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:checkUp,url=" + paramString + ",callback=" + paramAsyncBack);
    }
    if (paramAsyncBack == null) {
      return;
    }
    String str = Uri.parse(paramString).getQueryParameter("_bid");
    int i2 = AuthorizeConfig.a(jdField_a_of_type_AndroidContentContext).a(paramString);
    int i1 = i2;
    if (i2 == 0) {
      i1 = 5;
    }
    a(str, paramAppRuntime, paramAsyncBack, paramBoolean, i1);
  }
  
  public static void a(ArrayList paramArrayList, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean)
  {
    if (paramArrayList.size() == 0) {
      return;
    }
    HashMap localHashMap = new HashMap(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      Object localObject = a(str);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("version");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put(str, localObject);
        }
      }
      else
      {
        localHashMap.put(str, "0");
      }
    }
    a(paramAppRuntime, localHashMap, paramAsyncBack, paramBoolean, false);
  }
  
  public static void a(ArrayList paramArrayList, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAsyncBack == null) {
      return;
    }
    if ((paramAppRuntime == null) || (paramArrayList.size() == 0))
    {
      paramAsyncBack.a("{\"r\":-1}", -1);
      return;
    }
    b(paramArrayList, paramAppRuntime, paramAsyncBack, paramBoolean1, paramBoolean2);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, AsyncBack paramAsyncBack) {}
  
  public static void a(AppRuntime paramAppRuntime, HashMap paramHashMap, AsyncBack paramAsyncBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HtmlCheckUpdate", 2, "-->offline:checkUpdate");
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication().getApplicationContext(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", "offlinepkg.check");
    OfflinePkg.ReqBody localReqBody = new OfflinePkg.ReqBody();
    localReqBody.uint32_cmd.set(3);
    localReqBody.uint32_platform.set(3);
    localReqBody.str_qver.set(ByteStringMicro.copyFrom("6.5.5".getBytes()));
    localReqBody.str_osrelease.set(ByteStringMicro.copyFrom(Build.VERSION.RELEASE.getBytes()));
    i1 = NetworkUtil.a(paramAppRuntime.getApplication());
    localReqBody.int32_network.set(i1);
    localReqBody.str_from.set(ByteStringMicro.copyFrom("predown".getBytes()));
    Iterator localIterator = paramHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      String str = (String)paramHashMap.get(localObject);
      for (;;)
      {
        try
        {
          i1 = Integer.valueOf((String)localObject).intValue();
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          try
          {
            i3 = Integer.valueOf(str).intValue();
            i2 = i1;
            i1 = i3;
            if (i2 == 0) {
              break;
            }
            localObject = new OfflinePkg.BidPkg();
            ((OfflinePkg.BidPkg)localObject).uint32_bid.set(i2);
            ((OfflinePkg.BidPkg)localObject).uint32_pkg_id.add(Integer.valueOf(i1));
            localReqBody.st_bid_pkg.add((MessageMicro)localObject);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              int i3;
              int i2 = i1;
            }
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            continue;
          }
          localNumberFormatException1 = localNumberFormatException1;
          i1 = 0;
          localNumberFormatException1.printStackTrace();
          i3 = 0;
          i2 = i1;
          i1 = i3;
          continue;
        }
        catch (Exception localException1)
        {
          i2 = 0;
        }
        i1 = 0;
      }
    }
    try
    {
      localNewIntent.putExtra("data", localReqBody.toByteArray());
      localNewIntent.setObserver(new hgz(localNewIntent, paramAsyncBack, paramBoolean1, paramAppRuntime, paramBoolean2));
      paramAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HtmlCheckUpdate", 2, "offline check update exception!", paramAppRuntime);
      return;
    }
  }
  
  public static boolean a(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
  {
    if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
      jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,url:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = Uri.parse(paramString).getQueryParameter("_bid");
    if (TextUtils.isEmpty(str))
    {
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,business id is null!");
      }
      return false;
    }
    if (paramContext == null)
    {
      a(str, 3, 0L, 4, "lixian_cover", "0");
      return false;
    }
    if (!a(str))
    {
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,initEnv fail!");
      }
      a(str, 2, 0L, NetworkUtil.a(paramContext), "lixian_cover", "0");
      return false;
    }
    if (Arrays.asList(b).contains(str))
    {
      a(str, 4, 0L, NetworkUtil.a(paramContext), "lixian_cover", "0");
      return false;
    }
    if (jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager == null)
    {
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,threadManager is null");
      }
      return false;
    }
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.b(new hgv(paramContext, paramString, paramAsyncCallBack));
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getAssets().open(paramString1);
      paramString1 = new FileOutputStream(new File(paramString2));
      paramString2 = new byte['က'];
      for (;;)
      {
        int i1 = paramContext.read(paramString2);
        if (i1 == -1)
        {
          paramString1.flush();
          paramContext.close();
          paramString1.close();
          return true;
        }
        paramString1.write(paramString2, 0, i1);
      }
      return false;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  protected static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if (b(paramString)) {
        try
        {
          if (!Environment.getExternalStorageState().equals("mounted"))
          {
            if (!jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
              continue;
            }
            jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "no sd");
            return false;
          }
        }
        catch (Exception paramString)
        {
          return false;
        }
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramString = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;
        paramString = paramString + "tencent/MobileQQ/qbiz/";
        localObject = paramString + "html5/";
        l = (String)localObject;
        m = paramString + "tmp/";
        localObject = new File((String)localObject);
        if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
          break;
        }
        paramString = new File(paramString + "tmp/");
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        paramString = new File("");
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return true;
      }
      catch (Exception paramString) {}
      if (jdField_a_of_type_AndroidContentContext == null) {
        break;
      }
      try
      {
        localObject = jdField_a_of_type_AndroidContentContext.getFilesDir().toString() + File.separator + k;
        paramString = (String)localObject;
        localObject = paramString + "html5/";
        o = (String)localObject;
        p = paramString + "tmp/";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "getFilesDir error");
        }
        a(paramString, 0, 0L, -1, "lixian_error", "0");
        return false;
      }
    }
    return false;
  }
  
  protected static boolean a(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    int i1 = 0;
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory())) {}
    do
    {
      return false;
      paramString = paramString.listFiles();
    } while (paramString == null);
    List localList = Arrays.asList(jdField_a_of_type_ArrayOfJavaLangString);
    if (i1 < paramString.length)
    {
      if (paramString[i1] == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        try
        {
          String str1 = paramString[i1].getCanonicalPath();
          if (!paramString[i1].isFile()) {
            break label209;
          }
          String str2 = paramString[i1].getName();
          if (((!TextUtils.isEmpty(str2)) && (localList.contains(str2))) || (str2.equals("b.zip"))) {
            continue;
          }
          str1 = str1.substring(paramInt);
          try
          {
            paramJSONObject.get(str1);
          }
          catch (JSONException localJSONException)
          {
            if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
              jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, " delete :" + str1);
            }
            paramString[i1].delete();
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
        continue;
        label209:
        if (paramString[i1].isDirectory()) {
          a(localIOException, paramInt, paramJSONObject);
        }
      }
    }
    return true;
  }
  
  public static boolean a(String paramString1, Context paramContext, String paramString2, AsyncCallBack paramAsyncCallBack)
  {
    return a(paramContext, "http://" + paramString1 + "?_bid=" + paramString2, paramAsyncCallBack);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "verfyFile: businessId null ");
      }
    }
    long l1;
    do
    {
      return false;
      String str = a(paramString1);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      str = str + paramString1;
      if (!new File(str).exists()) {
        return true;
      }
      paramString2 = g(paramString2);
      l1 = System.currentTimeMillis();
      if (OfflineSecurity.c(paramString2, str, paramString1)) {
        break;
      }
      a(str, paramString1);
    } while (!jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a());
    jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "verfySingleFile fail :" + paramString2);
    return false;
    if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.b()) {
      jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.b("HtmlCheckUpdate", 4, "verifyFile:time=" + (System.currentTimeMillis() - l1) + ", file:" + paramString2);
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return null;
    }
    if (b(paramString)) {
      return m;
    }
    return p;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    try
    {
      String str = c(paramString2) + paramString2 + ".tmp";
      Util.b(str);
      paramString1 = new File(paramString1);
      if (paramString1.exists()) {
        paramString1.renameTo(new File(str));
      }
      if ((jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString2)) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString2))) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString2);
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime)
  {
    a(paramString, paramAppRuntime, false, jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack);
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, AsyncBack paramAsyncBack)
  {
    a(paramString, paramAppRuntime, paramAsyncBack, paramBoolean, 5);
  }
  
  private static void b(ArrayList paramArrayList, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayList.size() == 0) {
      return;
    }
    HashMap localHashMap = new HashMap(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      Object localObject = a(str);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("version");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put(str, localObject);
        }
      }
      else
      {
        localHashMap.put(str, "0");
      }
    }
    a(paramAppRuntime, localHashMap, paramAsyncBack, paramBoolean1, paramBoolean2);
  }
  
  protected static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return true;
        try
        {
          int i1 = Integer.valueOf(paramString).intValue();
          if ((i1 >= 1000) && (i1 < 2000)) {
            return false;
          }
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a());
    jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "initEnv NumberFormatException");
    return true;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!a(paramString)) {
      return null;
    }
    return n;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    String str1 = b(paramString);
    str1 = str1 + paramString + ".zip";
    String str2 = a(paramString);
    str2 = str2 + paramString;
    File localFile = new File(str2 + "/b.zip");
    if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
      jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "combine zip" + paramString);
    }
    boolean bool1 = bool2;
    if (localFile.exists())
    {
      bool1 = bool2;
      if (!new File(str1).exists()) {}
    }
    try
    {
      bool1 = BspatchUtil.a(str2 + "/b.zip", str1, str1);
      return bool1;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        do
        {
          return null;
        } while (!a(paramString));
        paramString = a(paramString);
      } while (paramString == null);
      l1 = System.currentTimeMillis();
      l2 = paramString.optLong("expired", 0L);
    } while ((l2 > 0L) && (l1 > l2));
    try
    {
      paramString = paramString.getString("version");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean d(String paramString)
  {
    for (;;)
    {
      String str2;
      File localFile2;
      int i1;
      try
      {
        if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doUpdateZip start:" + paramString);
        }
        bool1 = TextUtils.isEmpty(paramString);
        if (bool1)
        {
          bool1 = false;
          return bool1;
        }
        String str1 = b(paramString);
        if (TextUtils.isEmpty(str1))
        {
          if (!jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
            break label541;
          }
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,zip root dir is null:");
          break label541;
        }
        str1 = str1 + paramString + ".zip";
        File localFile1 = new File(str1);
        if (!localFile1.exists())
        {
          if (!jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
            break label547;
          }
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doUpdateZip:no zip ! : businessId:" + paramString);
          break label547;
        }
        String str3 = a(paramString);
        str2 = str3 + paramString;
        str3 = str3 + paramString + "_new";
        Util.a(str3);
        localFile2 = new File(str3);
        if (!localFile2.mkdirs())
        {
          if (!jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
            break label553;
          }
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.b("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,mkdirs: error:" + str3);
          break label553;
        }
        long l1 = System.currentTimeMillis();
        i1 = ZipUtils.a(str1, str3);
        if (i1 > 0)
        {
          if (K == 0) {
            K = 2;
          }
          Util.b(str1);
          a(paramString, 13, 0L, i1, "lixian_update", "0");
          if (!jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
            break label535;
          }
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,unZipFolder fail!");
          bool2 = false;
          bool1 = bool2;
          if (!jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
            continue;
          }
          jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:time of unzip：" + (System.currentTimeMillis() - l1) + ", isSuccess: " + bool2);
          bool1 = bool2;
          continue;
        }
        localFile1.renameTo(new File(str3 + "/b.zip"));
      }
      finally {}
      Util.a(str2);
      boolean bool2 = localFile2.renameTo(new File(str2));
      a(paramString, 13, 0L, i1, "lixian_time", "0");
      continue;
      label535:
      bool2 = false;
      continue;
      label541:
      boolean bool1 = false;
      continue;
      label547:
      bool1 = false;
      continue;
      label553:
      bool1 = false;
    }
  }
  
  protected static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        int i1 = 0;
        for (;;)
        {
          if ((i1 < paramString.length) && (i1 < 100))
          {
            Object localObject = paramString[i1];
            JSONObject localJSONObject;
            if ((((File)localObject).isDirectory()) && (TextUtils.isDigitsOnly(((File)localObject).getName())))
            {
              localJSONObject = a(((File)localObject).getName());
              if (localJSONObject == null) {}
            }
            try
            {
              localStringBuffer.append(((File)localObject).getName() + "|" + localJSONObject.getString("version") + ",");
              i1 += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  protected static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return false;
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.b()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 4, "checkOfflineFiles " + paramString);
      }
      localObject = a(paramString);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    paramString = (String)localObject + paramString + "/";
    try
    {
      localObject = new BufferedInputStream(new FileInputStream(paramString + "verify.json"));
      JSONObject localJSONObject = new JSONObject(OfflineSecurity.a((BufferedInputStream)localObject));
      ((BufferedInputStream)localObject).close();
      a(paramString, paramString.length(), localJSONObject);
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static String f(String paramString)
  {
    String str = "file://" + Environment.getExternalStorageDirectory().getPath() + "/" + "tencent/MobileQQ/qbiz/html5/";
    if ((paramString == null) || (!paramString.startsWith(str))) {
      return "";
    }
    paramString = paramString.substring(str.length());
    int i1 = paramString.indexOf('/');
    if (i1 <= 0) {
      return "";
    }
    try
    {
      Integer.parseInt(paramString.substring(0, i1), 10);
      paramString = paramString.substring(i1 + 1);
      if (paramString.length() > 0) {
        return "http://" + paramString;
      }
    }
    catch (NumberFormatException paramString)
    {
      return "";
    }
    return "";
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "verfySign: businessId null ");
      }
    }
    do
    {
      return false;
      String str = a(paramString);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      str = str + paramString;
      if (!new File(str).exists()) {
        return true;
      }
      if (OfflineSecurity.b(str, paramString)) {
        return true;
      }
      a(str, paramString);
    } while (!jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a());
    jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "verfySign fail :" + paramString);
    return false;
  }
  
  public static String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String[] arrayOfString = paramString.substring(paramString.indexOf(":") + 3).split("\\?");
    paramString = arrayOfString;
    if (arrayOfString[0].contains("#")) {
      paramString = arrayOfString[0].split("\\#");
    }
    return paramString[0];
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\offline\HtmlOffline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */