package com.tencent.mobileqq.webview.swift.component;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.KeyInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils.JsInfo;
import com.tencent.mobileqq.webview.webso.SHA1Util;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.QUA;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import wjn;
import wjo;

public class SwiftWebViewHttpBridge
  implements Handler.Callback
{
  public static final int a = 0;
  static final String jdField_a_of_type_JavaLangString = "SwiftWebViewHttpBridge";
  public static boolean a = false;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final String d = "SwiftHttp";
  public static final int e = 10;
  private static final int m = 0;
  private static final int n = 1;
  private static final int o = 2;
  private static final int p = 3;
  private static final int q = 4;
  private static final int r = 5;
  private static final int s = 6;
  private static final int t = 7;
  public volatile long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderContext;
  SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderSupporter;
  volatile WebResourceResponse jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse;
  public Thread a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public volatile long b;
  public String b;
  public AtomicBoolean b;
  public boolean b;
  public volatile long c;
  public volatile String c;
  boolean c;
  public volatile boolean d;
  public String e;
  private boolean e;
  public int f;
  public String f;
  public final int g;
  private String g;
  public final int h;
  public final int i;
  public final int j;
  public final int k;
  public int l;
  
  public SwiftWebViewHttpBridge(SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext paramSwiftBrowserComponentProviderContext, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter paramSwiftBrowserComponentProviderSupporter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_g_of_type_Int = 1;
    this.h = 2;
    this.i = 3;
    this.j = 4;
    this.k = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "null";
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(this);
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.l = -1;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderContext = paramSwiftBrowserComponentProviderContext;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderSupporter = paramSwiftBrowserComponentProviderSupporter;
  }
  
  private CustomWebView a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderContext.a() instanceof CustomWebView)) {
      return (CustomWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderContext.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwiftWebViewHttpBridge", 2, "webView not be init");
    }
    return null;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = this.jdField_b_of_type_JavaLangString.replace(":8080", "").replace("asyncMode=3", "asyncMode=10");
    }
    return str;
  }
  
  private String a(String paramString1, Uri paramUri, boolean paramBoolean, String paramString2, String paramString3)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        l1 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject1 = new JSONObject(paramString1);
          if (localObject1 == null)
          {
            if (!QLog.isColorLevel()) {
              break label1041;
            }
            QLog.d("SwiftWebViewHttpBridge", 2, "exception: server data is null");
            break label1041;
          }
          paramString1 = new JSONObject();
          if (QLog.isColorLevel()) {
            QLog.d("SwiftWebViewHttpBridge", 2, "--> start step one");
          }
          localObject3 = new File(SwiftWebViewHttpBridgeUtils.b(paramUri) + "_template.txt");
          bool = ((File)localObject3).exists();
          if ((((JSONObject)localObject1).has("template-tag")) && (bool))
          {
            l2 = BaseApplicationImpl.a().a().getLongAccountUin();
            localObject2 = SwiftWebViewHttpBridgeUtils.a(paramUri);
            localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("swift_html_etags", 0).getString("templateTag_" + String.valueOf(l2) + (String)localObject2, "");
            localObject4 = ((JSONObject)localObject1).optString("template-tag");
            if (QLog.isColorLevel()) {
              QLog.d("SwiftWebViewHttpBridge", 2, "template valid: " + ((String)localObject2).equals(localObject4));
            }
          }
          if (((JSONObject)localObject1).has("data"))
          {
            localObject2 = ((JSONObject)localObject1).optJSONObject("data");
            if (localObject2 == null)
            {
              if (!QLog.isColorLevel()) {
                break label1043;
              }
              QLog.d("SwiftWebViewHttpBridge", 2, "exception data is null");
              break label1043;
            }
            String str1 = FileUtils.b((File)localObject3);
            if (!TextUtils.isEmpty(str1))
            {
              Iterator localIterator = ((JSONObject)localObject2).keys();
              str2 = FileUtils.b(new File(SwiftWebViewHttpBridgeUtils.b(paramUri) + "_data.txt"));
              localObject4 = null;
              localObject3 = str1;
              if (!TextUtils.isEmpty(str2))
              {
                localObject4 = new JSONObject(str2);
                localObject3 = str1;
              }
              if (localIterator.hasNext())
              {
                str2 = localIterator.next().toString();
                str3 = ((JSONObject)localObject2).optString(str2);
                if (TextUtils.isEmpty(str3)) {
                  continue;
                }
                str1 = ((String)localObject3).replace(str2, str3);
                localObject3 = str1;
                if (localObject4 == null) {
                  continue;
                }
                if (QLog.isColorLevel()) {
                  QLog.i("SwiftWebViewHttpBridge", 2, "local check key: " + str2);
                }
                if (!((JSONObject)localObject4).has(str2))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("SwiftWebViewHttpBridge", 2, "local refresh key1: " + str2);
                  }
                  paramString1.put(str2, str3);
                  localObject3 = str1;
                  if (paramString1.length() <= 0) {
                    continue;
                  }
                  paramString1.put("local_refresh_time", System.currentTimeMillis());
                  localObject3 = str1;
                  continue;
                }
              }
            }
          }
        }
      }
      catch (IOException paramString1)
      {
        Object localObject4;
        String str2;
        String str3;
        VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "mergeDiffError", 0, 0, 2, 0, this.jdField_b_of_type_JavaLangString, "");
        QLog.e("SwiftWebViewHttpBridge", 1, "compareAndDiffData io error " + paramString1.getMessage());
        SwiftWebViewHttpBridgeUtils.a(paramUri);
        return null;
        if (str3.equalsIgnoreCase(((JSONObject)localObject4).optString(str2, ""))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.i("SwiftWebViewHttpBridge", 2, "local refresh key2: " + str2);
        }
        paramString1.put(str2, str3);
        continue;
      }
      catch (JSONException paramString1)
      {
        long l1;
        Object localObject3;
        long l2;
        VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "mergeDiffError", 0, 0, 3, 0, this.jdField_b_of_type_JavaLangString, "");
        QLog.e("SwiftWebViewHttpBridge", 1, "compareAndDiffData json error " + paramString1.getMessage());
        SwiftWebViewHttpBridgeUtils.a(paramUri);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridge", 2, "--> start step two");
        }
        if (((JSONObject)localObject1).has("html-sha1"))
        {
          localObject1 = ((JSONObject)localObject1).optString("html-sha1", "");
          l2 = System.currentTimeMillis();
          bool = SHA1Util.a((String)localObject3).equals(localObject1);
          localObject3 = ((String)localObject3).getBytes();
          localObject2 = ((JSONObject)localObject2).toString().getBytes();
          ThreadManager.a().post(new wjn(this, bool, paramBoolean, paramUri, (byte[])localObject3, (byte[])localObject2, paramString2, paramString3, (String)localObject1, l2));
          if (!QLog.isColorLevel()) {
            break label1045;
          }
          QLog.d("SwiftWebViewHttpBridge", 2, "check html data result: " + bool + " cost=" + (System.currentTimeMillis() - l2));
          break label1045;
          if (QLog.isColorLevel()) {
            QLog.d("SwiftWebViewHttpBridge", 2, "compareAndDiffData needSaveData :" + paramBoolean + " changeData: " + paramString1 + " costTime: " + (System.currentTimeMillis() - l1));
          }
          if (paramString1 != null)
          {
            return paramString1.toString();
            if (QLog.isColorLevel()) {
              QLog.d("SwiftWebViewHttpBridge", 2, "local template file empty");
            }
            VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "mergeDiffError", 0, 0, 1, 0, this.jdField_b_of_type_JavaLangString, "");
            SwiftWebViewHttpBridgeUtils.a(paramUri);
            paramString1 = null;
            continue;
          }
          return null;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "oom", 0, 0, 1, 0, this.jdField_b_of_type_JavaLangString, "");
        QLog.e("SwiftWebViewHttpBridge", 1, "compareAndDiffData oom error " + paramString1.getMessage());
        continue;
        continue;
        Object localObject2 = null;
        continue;
        Object localObject1 = null;
        continue;
      }
      label1041:
      return null;
      label1043:
      return null;
      label1045:
      if (!bool) {
        paramString1 = null;
      }
    }
  }
  
  private HttpURLConnection a(Intent paramIntent)
  {
    if (this.jdField_b_of_type_JavaLangString.contains("http://mc.vip.qq.com?")) {
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.replace("http://mc.vip.qq.com?", "http://mc.vip.qq.com/?");
    }
    HttpURLConnection localHttpURLConnection2 = null;
    HttpURLConnection localHttpURLConnection1 = localHttpURLConnection2;
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        String str2 = "";
        String str1 = str2;
        localHttpURLConnection1 = localHttpURLConnection2;
        if (this.jdField_b_of_type_Boolean)
        {
          str1 = str2;
          localHttpURLConnection1 = localHttpURLConnection2;
          if (this.jdField_f_of_type_Int == 1)
          {
            localHttpURLConnection1 = localHttpURLConnection2;
            str2 = a();
            localHttpURLConnection1 = localHttpURLConnection2;
            if (QLog.isColorLevel())
            {
              localHttpURLConnection1 = localHttpURLConnection2;
              QLog.d("SwiftWebViewHttpBridge", 2, "get cookie cost: " + (System.currentTimeMillis() - l1));
            }
            str1 = str2;
            localHttpURLConnection1 = localHttpURLConnection2;
            if (TextUtils.isEmpty(str2))
            {
              localHttpURLConnection1 = localHttpURLConnection2;
              if (QLog.isColorLevel())
              {
                localHttpURLConnection1 = localHttpURLConnection2;
                QLog.w("SwiftWebViewHttpBridge", 2, "asyncMode: " + this.jdField_f_of_type_Int + ", cookie is null!");
              }
              localHttpURLConnection1 = localHttpURLConnection2;
              this.jdField_c_of_type_JavaLangString = "Cookie_Not_Valid";
              return null;
            }
          }
        }
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2 = (HttpURLConnection)new URL(this.jdField_b_of_type_JavaLangString).openConnection();
        if (localHttpURLConnection2 == null)
        {
          localHttpURLConnection1 = localHttpURLConnection2;
          if (QLog.isColorLevel())
          {
            localHttpURLConnection1 = localHttpURLConnection2;
            QLog.d("SwiftWebViewHttpBridge", 2, "HttpURLConnection is null!");
          }
          localHttpURLConnection1 = localHttpURLConnection2;
          this.jdField_c_of_type_JavaLangString = "URLConnection_NULL";
          return null;
        }
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setConnectTimeout(15000);
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setReadTimeout(15000);
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setInstanceFollowRedirects(false);
        localHttpURLConnection1 = localHttpURLConnection2;
        if (this.jdField_f_of_type_Int != 1) {
          continue;
        }
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setRequestProperty("Cookie", str1);
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setRequestProperty("Http-AsyncMode", String.valueOf(this.jdField_f_of_type_Int));
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setRequestProperty("User-Agent", SwiftWebViewUtils.a(SwiftWebViewUtils.b("httpAsync 1.0"), "", false));
        localHttpURLConnection1 = localHttpURLConnection2;
        i2 = localHttpURLConnection2.getResponseCode();
        localHttpURLConnection1 = localHttpURLConnection2;
        this.jdField_c_of_type_JavaLangString = String.valueOf(i2);
        if (i2 == 200) {
          break label1053;
        }
        i1 = 1;
        localHttpURLConnection1 = localHttpURLConnection2;
        if (this.jdField_f_of_type_Int != 3) {
          continue;
        }
        switch (i2)
        {
        }
      }
      catch (Exception paramIntent)
      {
        int i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SwiftWebViewHttpBridge", 2, "http async get handleEvent exception !!!!mode : " + this.jdField_f_of_type_Int, paramIntent);
        if (this.jdField_f_of_type_Int != 3) {
          continue;
        }
        paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
        VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "timeout", 0, 0, 0, 0, this.jdField_b_of_type_JavaLangString, "");
        if (localHttpURLConnection1 == null) {
          continue;
        }
        localHttpURLConnection1.disconnect();
        i1 = 1;
        continue;
        localHttpURLConnection1 = localHttpURLConnection2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localHttpURLConnection1 = localHttpURLConnection2;
        QLog.d("SwiftWebViewHttpBridge", 2, "monster is null");
        localHttpURLConnection1 = localHttpURLConnection2;
        VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "noCookie", 0, 0, 0, 1, this.jdField_b_of_type_JavaLangString, "");
        paramIntent = "";
        continue;
        localHttpURLConnection1 = localHttpURLConnection2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localHttpURLConnection1 = localHttpURLConnection2;
        QLog.d("SwiftWebViewHttpBridge", 2, "304 happen");
        localHttpURLConnection1 = localHttpURLConnection2;
        paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
        localHttpURLConnection1 = localHttpURLConnection2;
        paramIntent.arg1 = 304;
        localHttpURLConnection1 = localHttpURLConnection2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
        continue;
        localHttpURLConnection1 = localHttpURLConnection2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localHttpURLConnection1 = localHttpURLConnection2;
        QLog.d("SwiftWebViewHttpBridge", 2, "302 happen");
        localHttpURLConnection1 = localHttpURLConnection2;
        VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "302", 0, 0, 0, 0, this.jdField_b_of_type_JavaLangString, "");
        localHttpURLConnection1 = localHttpURLConnection2;
        paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        localHttpURLConnection1 = localHttpURLConnection2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
        continue;
        continue;
        return localHttpURLConnection1;
        continue;
        localHttpURLConnection1 = localHttpURLConnection2;
        if (i1 == 0) {
          continue;
        }
        return null;
      }
      if (i2 != 200)
      {
        localHttpURLConnection1 = localHttpURLConnection2;
        paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        localHttpURLConnection1 = localHttpURLConnection2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
        localHttpURLConnection1 = localHttpURLConnection2;
        VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "timeout", 0, 0, 0, 1, this.jdField_b_of_type_JavaLangString, "");
      }
      localHttpURLConnection1 = localHttpURLConnection2;
      paramIntent = localHttpURLConnection2.getHeaderField("cache-offline");
      localHttpURLConnection1 = localHttpURLConnection2;
      if (QLog.isColorLevel())
      {
        localHttpURLConnection1 = localHttpURLConnection2;
        QLog.d("SwiftWebViewHttpBridge", 2, "mode: " + this.jdField_f_of_type_Int + " response: " + i2 + " cacheOffline: " + paramIntent);
      }
      localHttpURLConnection1 = localHttpURLConnection2;
      if ("http".equals(paramIntent))
      {
        localHttpURLConnection1 = localHttpURLConnection2;
        a("http", Uri.parse(this.jdField_b_of_type_JavaLangString), "", false, "");
        i1 = 1;
        continue;
        localHttpURLConnection1 = localHttpURLConnection2;
        if (this.jdField_f_of_type_Int != 3) {
          continue;
        }
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setRequestProperty("If-None-Match", paramIntent.getStringExtra("eTag"));
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setRequestProperty("accept-diff", "true");
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setRequestProperty("template-tag", paramIntent.getStringExtra("template_tag"));
        localHttpURLConnection1 = localHttpURLConnection2;
        localHttpURLConnection2.setRequestProperty("uri", this.jdField_b_of_type_JavaLangString);
        localHttpURLConnection1 = localHttpURLConnection2;
        paramIntent = SwiftBrowserCookieMonster.a(this.jdField_b_of_type_JavaLangString);
        if (paramIntent != null)
        {
          localHttpURLConnection1 = localHttpURLConnection2;
          paramIntent = paramIntent.a();
          localHttpURLConnection1 = localHttpURLConnection2;
          localHttpURLConnection2.setRequestProperty("cookie", paramIntent + "; qua=" + QUA.a() + "; ");
          localHttpURLConnection1 = localHttpURLConnection2;
          localHttpURLConnection2.setRequestProperty("no-Chunked", "true");
          localHttpURLConnection1 = localHttpURLConnection2;
          localHttpURLConnection2.setRequestProperty("method", "GET");
          localHttpURLConnection1 = localHttpURLConnection2;
          localHttpURLConnection2.setRequestProperty("accept-Charset", "utf-8");
          localHttpURLConnection1 = localHttpURLConnection2;
          localHttpURLConnection2.setRequestProperty("accept-Encoding", "gzip");
          localHttpURLConnection1 = localHttpURLConnection2;
          localHttpURLConnection2.setRequestProperty("accept-Language", "zh-CN,zh;");
          localHttpURLConnection1 = localHttpURLConnection2;
          localHttpURLConnection2.setRequestProperty("User-Agent", WebSoUtils.a());
          continue;
        }
      }
      label1053:
      int i1 = 0;
    }
  }
  
  /* Error */
  private void a(BufferedInputStream paramBufferedInputStream, HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_1
    //   4: ifnull +7 -> 11
    //   7: aload_2
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aload_2
    //   13: invokevirtual 586	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   16: invokevirtual 587	java/net/URL:toString	()Ljava/lang/String;
    //   19: astore 4
    //   21: new 589	java/io/ByteArrayOutputStream
    //   24: dup
    //   25: invokespecial 590	java/io/ByteArrayOutputStream:<init>	()V
    //   28: astore_3
    //   29: sipush 10240
    //   32: newarray <illegal type>
    //   34: astore 5
    //   36: aload_1
    //   37: aload 5
    //   39: invokevirtual 596	java/io/BufferedInputStream:read	([B)I
    //   42: istore 9
    //   44: iload 9
    //   46: iconst_m1
    //   47: if_icmpeq +196 -> 243
    //   50: aload_3
    //   51: aload 5
    //   53: iconst_0
    //   54: iload 9
    //   56: invokevirtual 600	java/io/ByteArrayOutputStream:write	([BII)V
    //   59: goto -23 -> 36
    //   62: astore_1
    //   63: iconst_1
    //   64: istore 9
    //   66: iload 9
    //   68: ifne +170 -> 238
    //   71: aload 4
    //   73: invokestatic 501	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   76: astore_1
    //   77: aload_2
    //   78: ldc_w 602
    //   81: invokevirtual 487	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore 6
    //   86: aload_2
    //   87: ldc -50
    //   89: invokevirtual 487	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 5
    //   94: aload_2
    //   95: ldc_w 604
    //   98: invokevirtual 487	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 7
    //   103: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +30 -> 136
    //   109: ldc 12
    //   111: iconst_2
    //   112: new 184	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 606
    //   122: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 7
    //   127: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: iload 10
    //   138: istore 9
    //   140: aload 7
    //   142: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +32 -> 177
    //   148: aload 7
    //   150: ldc_w 608
    //   153: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifne +304 -> 460
    //   159: iload 10
    //   161: istore 9
    //   163: aload 7
    //   165: ldc_w 517
    //   168: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +6 -> 177
    //   174: goto +286 -> 460
    //   177: aload_3
    //   178: ldc_w 610
    //   181: invokevirtual 612	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   184: astore 8
    //   186: aload_2
    //   187: ldc_w 484
    //   190: invokevirtual 487	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 7
    //   195: aload 7
    //   197: invokestatic 614	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridgeUtils:c	(Ljava/lang/String;)Z
    //   200: istore 11
    //   202: iload 9
    //   204: ifeq +72 -> 276
    //   207: aload_0
    //   208: aload 7
    //   210: aload_1
    //   211: aload 5
    //   213: iconst_1
    //   214: aload 8
    //   216: invokespecial 504	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:a	(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;ZLjava/lang/String;)V
    //   219: aload 8
    //   221: aload 4
    //   223: iconst_0
    //   224: aload 6
    //   226: aload 5
    //   228: iload 11
    //   230: invokestatic 617	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridgeUtils:a	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)Z
    //   233: pop
    //   234: aload_3
    //   235: invokevirtual 620	java/io/ByteArrayOutputStream:close	()V
    //   238: aload_2
    //   239: invokevirtual 563	java/net/HttpURLConnection:disconnect	()V
    //   242: return
    //   243: iconst_0
    //   244: istore 9
    //   246: goto -180 -> 66
    //   249: astore_1
    //   250: ldc 21
    //   252: ldc 21
    //   254: ldc_w 386
    //   257: iconst_0
    //   258: iconst_0
    //   259: iconst_0
    //   260: iconst_0
    //   261: aload_0
    //   262: getfield 64	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   265: ldc 62
    //   267: invokestatic 317	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:reportVasStatus	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;)V
    //   270: iconst_1
    //   271: istore 9
    //   273: goto -207 -> 66
    //   276: aload_0
    //   277: aload 8
    //   279: aload_1
    //   280: iload 11
    //   282: aload 6
    //   284: aload 5
    //   286: invokespecial 622	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:a	(Ljava/lang/String;Landroid/net/Uri;ZLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   289: astore 6
    //   291: aload 6
    //   293: ifnull +63 -> 356
    //   296: aload_0
    //   297: aload 7
    //   299: aload_1
    //   300: aload 5
    //   302: iconst_0
    //   303: aload 6
    //   305: invokespecial 504	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:a	(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;ZLjava/lang/String;)V
    //   308: goto -74 -> 234
    //   311: astore_1
    //   312: ldc 12
    //   314: iconst_1
    //   315: new 184	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 624
    //   325: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_1
    //   329: invokevirtual 322	java/io/IOException:getMessage	()Ljava/lang/String;
    //   332: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload_3
    //   342: invokevirtual 620	java/io/ByteArrayOutputStream:close	()V
    //   345: goto -107 -> 238
    //   348: astore_1
    //   349: aload_1
    //   350: invokevirtual 627	java/io/IOException:printStackTrace	()V
    //   353: goto -115 -> 238
    //   356: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq -125 -> 234
    //   362: ldc 12
    //   364: iconst_2
    //   365: ldc_w 629
    //   368: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: goto -137 -> 234
    //   374: astore_1
    //   375: ldc 12
    //   377: iconst_1
    //   378: new 184	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   385: ldc_w 631
    //   388: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_1
    //   392: invokevirtual 389	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   395: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 324	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: ldc 21
    //   406: ldc 21
    //   408: ldc_w 386
    //   411: iconst_0
    //   412: iconst_0
    //   413: iconst_4
    //   414: iconst_0
    //   415: aload 4
    //   417: ldc 62
    //   419: invokestatic 317	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:reportVasStatus	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;)V
    //   422: aload_3
    //   423: invokevirtual 620	java/io/ByteArrayOutputStream:close	()V
    //   426: goto -188 -> 238
    //   429: astore_1
    //   430: aload_1
    //   431: invokevirtual 627	java/io/IOException:printStackTrace	()V
    //   434: goto -196 -> 238
    //   437: astore_1
    //   438: aload_1
    //   439: invokevirtual 627	java/io/IOException:printStackTrace	()V
    //   442: goto -204 -> 238
    //   445: astore_1
    //   446: aload_3
    //   447: invokevirtual 620	java/io/ByteArrayOutputStream:close	()V
    //   450: aload_1
    //   451: athrow
    //   452: astore_2
    //   453: aload_2
    //   454: invokevirtual 627	java/io/IOException:printStackTrace	()V
    //   457: goto -7 -> 450
    //   460: iconst_1
    //   461: istore 9
    //   463: goto -286 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	this	SwiftWebViewHttpBridge
    //   0	466	1	paramBufferedInputStream	BufferedInputStream
    //   0	466	2	paramHttpURLConnection	HttpURLConnection
    //   28	419	3	localByteArrayOutputStream	ByteArrayOutputStream
    //   19	397	4	str1	String
    //   34	267	5	localObject	Object
    //   84	220	6	str2	String
    //   101	197	7	str3	String
    //   184	94	8	str4	String
    //   42	420	9	i1	int
    //   1	159	10	i2	int
    //   200	81	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   29	36	62	java/io/IOException
    //   36	44	62	java/io/IOException
    //   50	59	62	java/io/IOException
    //   29	36	249	java/lang/OutOfMemoryError
    //   36	44	249	java/lang/OutOfMemoryError
    //   50	59	249	java/lang/OutOfMemoryError
    //   71	136	311	java/io/IOException
    //   140	159	311	java/io/IOException
    //   163	174	311	java/io/IOException
    //   177	202	311	java/io/IOException
    //   207	234	311	java/io/IOException
    //   276	291	311	java/io/IOException
    //   296	308	311	java/io/IOException
    //   356	371	311	java/io/IOException
    //   341	345	348	java/io/IOException
    //   71	136	374	java/lang/OutOfMemoryError
    //   140	159	374	java/lang/OutOfMemoryError
    //   163	174	374	java/lang/OutOfMemoryError
    //   177	202	374	java/lang/OutOfMemoryError
    //   207	234	374	java/lang/OutOfMemoryError
    //   276	291	374	java/lang/OutOfMemoryError
    //   296	308	374	java/lang/OutOfMemoryError
    //   356	371	374	java/lang/OutOfMemoryError
    //   422	426	429	java/io/IOException
    //   234	238	437	java/io/IOException
    //   71	136	445	finally
    //   140	159	445	finally
    //   163	174	445	finally
    //   177	202	445	finally
    //   207	234	445	finally
    //   276	291	445	finally
    //   296	308	445	finally
    //   312	341	445	finally
    //   356	371	445	finally
    //   375	422	445	finally
    //   446	450	452	java/io/IOException
  }
  
  private void a(String paramString1, Uri paramUri, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftWebViewHttpBridge", 2, "handleCacheOffline, templateTag == null:" + TextUtils.isEmpty(paramString2) + " offlineMode: " + paramString1 + " fullRefresh: " + paramBoolean);
    }
    if ("http".equals(paramString1))
    {
      QLog.i("SwiftWebViewHttpBridge", 1, "now 503, so start reLoadUrl");
      SwiftWebViewHttpBridgeUtils.b(paramUri);
      paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      paramString1.obj = paramString3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      return;
    }
    if ("true".equals(paramString1))
    {
      if (paramBoolean)
      {
        paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
        paramString1.obj = paramString3;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
        return;
      }
      paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramString1.arg1 = 200;
      paramString1.obj = paramString3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      return;
    }
    if ("store".equals(paramString1))
    {
      paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4);
      paramString1.obj = paramString3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      return;
    }
    if ((paramString1 == null) || ("false".equals(paramString1)))
    {
      if (paramBoolean)
      {
        paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
        paramString1.obj = paramString3;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      }
      for (;;)
      {
        SwiftWebViewHttpBridgeUtils.a(paramUri);
        return;
        paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
        paramString1.arg1 = 200;
        paramString1.obj = paramString3;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      }
    }
    SwiftWebViewHttpBridgeUtils.a(paramUri);
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    paramString1.obj = paramString3;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 3)) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridge", 2, "now notify all thread!");
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
        return;
      }
    }
  }
  
  private void c()
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "state not right: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
      }
      return;
    }
    long l1 = BaseApplicationImpl.a().a().getLongAccountUin();
    Object localObject3 = Uri.parse(this.jdField_b_of_type_JavaLangString);
    Object localObject4;
    Object localObject1;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject4 = String.valueOf(l1);
      Object localObject5 = BaseApplicationImpl.getContext().getSharedPreferences("swift_html_etags", 0);
      String str = SwiftWebViewHttpBridgeUtils.a((Uri)localObject3);
      localObject1 = ((SharedPreferences)localObject5).getString("eTag_" + (String)localObject4 + str, "");
      localObject2 = ((SharedPreferences)localObject5).getString("templateTag_" + (String)localObject4 + str, "");
      localObject4 = ((SharedPreferences)localObject5).getString("htmlSha1_" + (String)localObject4 + str, "");
      localObject5 = new File(SwiftWebViewHttpBridgeUtils.b((Uri)localObject3) + ".txt");
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (((File)localObject5).exists()))
      {
        localObject4 = SwiftWebViewHttpBridgeUtils.a((Uri)localObject3, (String)localObject4, (File)localObject5);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
      }
    }
    for (;;)
    {
      label273:
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject2 = "";
        localObject3 = "";
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          if (!this.jdField_b_of_type_JavaLangString.contains("?")) {
            break label496;
          }
          localObject1 = this.jdField_b_of_type_JavaLangString + "&_preload=1";
          label333:
          this.jdField_b_of_type_JavaLangString = ((String)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("SwiftWebViewHttpBridge", 2, "first load, add preload: " + this.jdField_b_of_type_JavaLangString);
          }
        }
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        bool = true;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("eTag", (String)localObject2);
        ((Intent)localObject3).putExtra("template_tag", (String)localObject1);
        localObject1 = a((Intent)localObject3);
        l1 = System.currentTimeMillis();
        if (localObject1 == null) {
          break;
        }
        a(l1, (HttpURLConnection)localObject1, bool);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridge", 2, "set eTag to get all data");
        }
        VasWebviewUtil.reportVasStatus("SwiftHttp", "SwiftHttp", "tagsEmpty", 0, 0, 0, 0, this.jdField_b_of_type_JavaLangString, "");
        localObject3 = "";
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break label273;
        label496:
        localObject1 = this.jdField_b_of_type_JavaLangString + "?_preload=1";
        break label333;
        localObject4 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
        ((Message)localObject4).obj = localObject3;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
      }
      localObject2 = "";
      localObject1 = "";
      localObject3 = "";
    }
  }
  
  private boolean c(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ("about:blank".equals(paramString))) {
      return false;
    }
    int i2 = SwiftWebViewHttpBridgeUtils.a(paramString);
    if ((i2 != 3) && (i2 != 10))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SwiftWebViewHttpBridge", 2, new Object[] { "clear history not support asyncMode: ", Integer.valueOf(i2) });
      }
      return false;
    }
    CustomWebView localCustomWebView = a();
    if (localCustomWebView == null) {
      return false;
    }
    paramString = localCustomWebView.copyBackForwardList();
    if ((paramString == null) || (paramString.getSize() == 0))
    {
      if (this.jdField_e_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SwiftWebViewHttpBridge", 2, "now clear webView history!");
        }
        localCustomWebView.clearHistory();
        this.jdField_e_of_type_Boolean = false;
      }
      return false;
    }
    int i1;
    Object localObject;
    if (QLog.isColorLevel())
    {
      i1 = paramString.getSize() - 1;
      while (i1 >= 0)
      {
        localObject = paramString.getItemAtIndex(i1);
        if (localObject != null) {
          QLog.i("SwiftWebViewHttpBridge", 2, " history: " + i1 + " " + ((WebHistoryItem)localObject).getUrl());
        }
        i1 -= 1;
      }
    }
    if (paramString.getSize() >= 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "check history url, mode: " + i2);
      }
      String str1 = "";
      String str2 = "";
      i1 = paramString.getSize() - 1;
      WebHistoryItem localWebHistoryItem1 = paramString.getItemAtIndex(i1);
      WebHistoryItem localWebHistoryItem2 = paramString.getItemAtIndex(i1 - 1);
      localObject = str2;
      paramString = str1;
      if (localWebHistoryItem1 != null)
      {
        localObject = str2;
        paramString = str1;
        if (localWebHistoryItem2 != null)
        {
          paramString = localWebHistoryItem1.getUrl();
          localObject = localWebHistoryItem2.getUrl();
        }
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString))) {
        if (!((String)localObject).equals(paramString)) {
          break label380;
        }
      }
    }
    for (this.jdField_e_of_type_Boolean = true; this.jdField_e_of_type_Boolean; this.jdField_e_of_type_Boolean = paramString.equals(a(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SwiftWebViewHttpBridge", 2, "now clear webView history!");
      }
      localCustomWebView.clearHistory();
      this.jdField_e_of_type_Boolean = false;
      return true;
      label380:
      paramString = a((String)localObject);
    }
    return false;
  }
  
  private void d()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(1, 2)) {}
    long l1;
    HttpURLConnection localHttpURLConnection;
    do
    {
      return;
      if (!a())
      {
        this.jdField_c_of_type_JavaLangString = "Global_Config_Disable";
        return;
      }
      if (a(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_c_of_type_JavaLangString = "Has_Local_Offline";
        return;
      }
      l1 = System.currentTimeMillis();
      localHttpURLConnection = a(null);
    } while (localHttpURLConnection == null);
    a(l1, localHttpURLConnection, true);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftWebViewHttpBridge", 2, "notifyJsResultToWebView start");
    }
    CustomWebView localCustomWebView = a();
    if (localCustomWebView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "webView not be init");
      }
    }
    do
    {
      do
      {
        return;
        if (this.l != -1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SwiftWebViewHttpBridge", 2, "data not be init");
      return;
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SwiftWebViewHttpBridge", 2, "js not be init");
    return;
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2;
    long l1;
    try
    {
      switch (this.l)
      {
      case 200: 
        localJSONObject2 = new JSONObject(this.jdField_f_of_type_JavaLangString);
        l1 = System.currentTimeMillis() - localJSONObject2.optLong("local_refresh_time", 0L);
        if (l1 > 30000L)
        {
          if (QLog.isColorLevel()) {
            QLog.w("SwiftWebViewHttpBridge", 1, "receive js call too late, " + l1 / 1000.0D + "s");
          }
          this.jdField_f_of_type_JavaLangString = "";
          this.jdField_e_of_type_JavaLangString = "";
          return;
        }
        break;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("SwiftWebViewHttpBridge", 1, localException, new Object[] { "dispatchDiffData to website error!" });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SwiftWebViewHttpBridge", 1, "receive js call in time: " + l1 / 1000.0D + "s");
    }
    if (l1 > 0L) {
      localJSONObject1.put("local_refresh_time", l1);
    }
    localJSONObject2.remove("local_refresh_time");
    localJSONObject1.put("result", localJSONObject2.toString());
    localJSONObject1.put("code", 200);
    if (QLog.isColorLevel()) {
      QLog.i("SwiftWebViewHttpBridge", 1, "now call jsCallback data: , " + localJSONObject1.toString());
    }
    localException.a(this.jdField_e_of_type_JavaLangString, new String[] { localJSONObject1.toString() });
    this.l = -1;
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    return;
    localJSONObject1.put("code", this.l);
    if (QLog.isColorLevel()) {
      QLog.i("SwiftWebViewHttpBridge", 1, "now call jsCallback data: , " + localJSONObject1.toString());
    }
    localException.a(this.jdField_e_of_type_JavaLangString, new String[] { localJSONObject1.toString() });
    this.l = -1;
    this.jdField_e_of_type_JavaLangString = "";
    return;
  }
  
  public WebResourceResponse a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        ??? = Uri.parse(this.jdField_b_of_type_JavaLangString);
        Uri localUri = Uri.parse(paramString);
        Object localObject2 = ((Uri)???).getHost() + ((Uri)???).getPath();
        String str = localUri.getHost() + localUri.getPath();
        if (!((Uri)???).getHost().equalsIgnoreCase(localUri.getHost())) {
          return null;
        }
        ??? = localObject2;
        if (!((String)localObject2).endsWith("/")) {
          ??? = (String)localObject2 + "/";
        }
        localObject2 = str;
        if (!str.endsWith("/")) {
          localObject2 = str + "/";
        }
        if (!((String)???).equalsIgnoreCase((String)localObject2)) {
          return null;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SwiftWebViewHttpBridge", 2, "asyncMode: " + this.jdField_f_of_type_Int + " some thing goes wrong！" + " WebResourceResponse is null!", localException);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftWebViewHttpBridge", 2, "state not connecting: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
        continue;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(3, 4)) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("SwiftWebViewHttpBridge", 2, "can not use response !");
        this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse = null;
        this.jdField_b_of_type_Long = (System.currentTimeMillis() - l1);
        paramString = (SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderSupporter.b().a(-2);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftWebViewHttpBridge", 2, "asyncMode: " + this.jdField_f_of_type_Int + ", return reponse for url, wait for : " + (System.currentTimeMillis() - l1) + ", from loadUrl: " + (System.currentTimeMillis() - paramString.n) + ", from click: " + (System.currentTimeMillis() - paramString.jdField_b_of_type_Long));
        QLog.d("QQBrowser_report", 2, "asyncMode: " + this.jdField_f_of_type_Int + ", return reponse for url, wait for : " + (System.currentTimeMillis() - l1) + ", from loadUrl: " + (System.currentTimeMillis() - paramString.n) + ", from click: " + (System.currentTimeMillis() - paramString.jdField_b_of_type_Long));
        continue;
        this.d = true;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString = new StringBuilder().append("asyncMode: ").append(this.jdField_f_of_type_Int).append(" url: ").append(paramString).append(" response==null: ");
        if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse != null) {
          break label715;
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        try
        {
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
          {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
            if (QLog.isColorLevel()) {
              QLog.d("SwiftWebViewHttpBridge", 2, "now wait for response!");
            }
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait(30000L);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          QLog.e("SwiftWebViewHttpBridge", 1, "wait fror response failed", localInterruptedException);
          continue;
        }
        if (this.jdField_f_of_type_Int == 1) {
          if (this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse == null)
          {
            if (QLog.isColorLevel()) {
              QLog.w("SwiftWebViewHttpBridge", 2, "asyncMode: 1, some thing goes wrong！ WebResourceResponse is null!");
            }
            a();
            this.jdField_b_of_type_JavaLangString = "";
            return this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse;
          }
        }
      }
    }
    for (;;)
    {
      QLog.e("SwiftWebViewHttpBridge", 2, bool);
      break;
      label715:
      bool = false;
    }
  }
  
  public String a()
  {
    long l1 = System.currentTimeMillis();
    String str1 = "";
    try
    {
      if (CookieSyncManager.createInstance(BaseApplicationImpl.a().getApplicationContext()) != null) {
        str1 = CookieManager.getInstance().getCookie(this.jdField_b_of_type_JavaLangString);
      }
      localObject2 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject2 == null)
      {
        localObject1 = "";
        return (String)localObject1;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      String str2;
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("SwiftWebViewHttpBridge", 2, "get cookie encounter exception! " + localException.getMessage());
          }
          str2 = "";
        }
        localObject1 = str2;
      } while (!TextUtils.isEmpty(str2));
      long l2 = System.currentTimeMillis();
      Object localObject1 = KeyInfo.a();
      ((KeyInfo)localObject1).a((AppRuntime)localObject2, this.jdField_b_of_type_JavaLangString);
      ((KeyInfo)localObject1).a((AppRuntime)localObject2, null);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, " KeyInfo wait for: " + (System.currentTimeMillis() - l2));
      }
      if (((KeyInfo)localObject1).a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridge", 2, " now try format cookie from KeyInfo!");
        }
        localObject2 = BaseApplicationImpl.a().a().getAccount();
        if ((!TextUtils.isEmpty(((KeyInfo)localObject1).jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(((KeyInfo)localObject1).jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          if (!TextUtils.isEmpty(((KeyInfo)localObject1).d)) {}
          for (str2 = String.format("uin=o0%s; skey=%s; vkey=%s; p_skey=%s", new Object[] { localObject2, ((KeyInfo)localObject1).jdField_c_of_type_JavaLangString, ((KeyInfo)localObject1).jdField_b_of_type_JavaLangString, ((KeyInfo)localObject1).d });; str2 = String.format("uin=o0%s; skey=%s; vkey=%s", new Object[] { localObject2, ((KeyInfo)localObject1).jdField_c_of_type_JavaLangString, ((KeyInfo)localObject1).jdField_b_of_type_JavaLangString }))
          {
            if (QLog.isColorLevel()) {
              QLog.i("SwiftWebViewHttpBridge", 2, "format cookie : " + Util.c(str2, new String[0]) + ", cost:" + (System.currentTimeMillis() - l1));
            }
            return str2;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("SwiftWebViewHttpBridge", 2, "cookie has probleme! " + str2);
      }
    }
    return "";
  }
  
  public void a()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    int i1 = this.jdField_b_of_type_JavaLangString.indexOf("?");
    String str;
    StringBuilder localStringBuilder;
    if (i1 != -1)
    {
      str = this.jdField_b_of_type_JavaLangString.substring(0, i1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str).append("|");
      localStringBuilder.append(String.valueOf(1)).append("|");
      localStringBuilder.append(String.valueOf(this.jdField_a_of_type_Long)).append("|");
      localStringBuilder.append(String.valueOf(this.jdField_b_of_type_Long)).append("|");
      if (!this.d) {
        break label326;
      }
      i1 = 1;
      label117:
      localStringBuilder.append(String.valueOf(i1)).append("|");
      if (!jdField_a_of_type_Boolean) {
        break label331;
      }
      i1 = 3;
    }
    for (;;)
    {
      localStringBuilder.append(String.valueOf(this.jdField_c_of_type_Long)).append("|");
      localStringBuilder.append(String.valueOf(i1)).append("|");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString).append("|");
      localStringBuilder.append(com.tencent.mobileqq.app.AppConstants.b[com.tencent.mobileqq.utils.NetworkUtil.a(null)]);
      if (QLog.isColorLevel()) {
        QLog.i("SwiftWebViewHttpBridge", 2, "mode:1,isSucessFul: " + this.d + "," + "web process status:" + i1 + "," + "repsonse code: " + this.jdField_c_of_type_JavaLangString + "," + "report detail: " + localStringBuilder.toString());
      }
      DcReportUtil.a(null, "dc00877", localStringBuilder.toString(), false);
      VasWebviewUtil.reportVasStatus("AsyncGet", "http", String.valueOf(1), 0, 0);
      return;
      str = this.jdField_b_of_type_JavaLangString;
      break;
      label326:
      i1 = 0;
      break label117;
      label331:
      if (SwiftBrowserStatistics.l) {
        i1 = 1;
      } else {
        i1 = 2;
      }
    }
  }
  
  /* Error */
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 90	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   20: iconst_0
    //   21: iconst_1
    //   22: invokevirtual 696	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   25: pop
    //   26: aload_0
    //   27: iload_1
    //   28: putfield 403	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:jdField_f_of_type_Int	I
    //   31: aload_0
    //   32: aload_2
    //   33: putfield 64	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload_0
    //   37: iload_3
    //   38: putfield 401	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:jdField_b_of_type_Boolean	Z
    //   41: aload_0
    //   42: new 997	wjm
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 999	wjm:<init>	(Lcom/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge;)V
    //   50: ldc 12
    //   52: iconst_5
    //   53: invokestatic 1002	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;Ljava/lang/String;I)Ljava/lang/Thread;
    //   56: putfield 1004	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   59: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +49 -> 111
    //   65: ldc 12
    //   67: iconst_2
    //   68: new 184	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 1006
    //   78: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_2
    //   82: iconst_0
    //   83: anewarray 149	java/lang/String
    //   86: invokestatic 1008	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   89: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 1010
    //   95: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: getfield 403	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:jdField_f_of_type_Int	I
    //   102: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 294	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: getfield 1004	com/tencent/mobileqq/webview/swift/component/SwiftWebViewHttpBridge:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   115: invokevirtual 1015	java/lang/Thread:start	()V
    //   118: goto -105 -> 13
    //   121: astore_2
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_2
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	SwiftWebViewHttpBridge
    //   0	126	1	paramInt	int
    //   0	126	2	paramString	String
    //   0	126	3	paramBoolean	boolean
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	121	finally
    //   16	111	121	finally
    //   111	118	121	finally
  }
  
  void a(long paramLong, HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    Object localObject1;
    try
    {
      this.jdField_c_of_type_Long = paramHttpURLConnection.getContentLength();
      if (QLog.isColorLevel())
      {
        localObject1 = Formatter.formatFileSize(BaseApplicationImpl.a().getApplicationContext(), this.jdField_c_of_type_Long);
        QLog.d("SwiftWebViewHttpBridge", 2, "data encoding: " + paramHttpURLConnection.getContentEncoding() + " now read content: " + (String)localObject1 + " reportWebsiteLength: " + this.jdField_c_of_type_Long);
      }
      localObject1 = paramHttpURLConnection.getInputStream();
      if (localObject1 != null) {
        break label159;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "inputstream or contentType goes wrong!");
      }
      this.jdField_c_of_type_JavaLangString = "InputStream_Error";
      throw new RuntimeException("InputStream is null!");
    }
    catch (Exception paramHttpURLConnection)
    {
      QLog.e("SwiftWebViewHttpBridge", 1, "swiftHttp read data exception !!!! mode: " + this.jdField_f_of_type_Int, paramHttpURLConnection);
    }
    return;
    label159:
    label190:
    Object localObject2;
    Object localObject4;
    int i1;
    int i2;
    label216:
    Object localObject3;
    if ("gzip".equalsIgnoreCase(paramHttpURLConnection.getContentEncoding()))
    {
      localObject1 = new BufferedInputStream(new GZIPInputStream((InputStream)localObject1));
      long l1 = System.currentTimeMillis();
      if (!paramBoolean) {
        break label684;
      }
      localObject2 = null;
      localObject4 = new byte['⠀'];
      i1 = 0;
      i2 = 0;
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        i1 = ((BufferedInputStream)localObject1).read((byte[])localObject4);
        if (i1 != -1) {
          break label570;
        }
      }
      this.jdField_c_of_type_Long = i2;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "now read data: " + i2 + ", now is ShouldIntercept: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      }
      localObject3 = localObject1;
      if (i1 == -1)
      {
        localObject3 = localObject1;
        if (i2 > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("SwiftWebViewHttpBridge", 2, "now read all data!");
          }
          localObject3 = null;
          paramHttpURLConnection.disconnect();
          this.jdField_c_of_type_JavaLangString = "Read_All_Data";
        }
      }
      localObject4 = null;
      if (localObject2 != null) {
        localObject4 = new BufferedInputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "read byte stream cost : " + (System.currentTimeMillis() - l1) + ", total cost: " + (System.currentTimeMillis() - paramLong));
      }
      localObject1 = Uri.parse(this.jdField_b_of_type_JavaLangString).getPath();
      if (!((String)localObject1).contains(".css")) {
        break label618;
      }
      localObject1 = "text/css";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse = new WebResourceResponse((String)localObject1, "utf-8", new wjo(this, (BufferedInputStream)localObject4, (BufferedInputStream)localObject3, (ByteArrayOutputStream)localObject2, paramHttpURLConnection, this.jdField_f_of_type_Int));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SwiftWebViewHttpBridge", 2, "swiftHttp get cost " + (System.currentTimeMillis() - paramLong));
      QLog.d("QQBrowser_report", 2, "Web_qqbrowser_http_async_get, cost " + (System.currentTimeMillis() - paramLong));
      return;
      localObject1 = new BufferedInputStream((InputStream)localObject1);
      break label190;
      label570:
      i2 += i1;
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = new ByteArrayOutputStream();
      }
      ((ByteArrayOutputStream)localObject3).write((byte[])localObject4, 0, i1);
      Thread.sleep(20L);
      localObject2 = localObject3;
      break label216;
      label618:
      if (((String)localObject1).contains(".js"))
      {
        localObject1 = "application/x-javascript";
      }
      else
      {
        if ((!((String)localObject1).contains(".jpg")) && (!((String)localObject1).contains(".gif")) && (!((String)localObject1).contains(".png")))
        {
          if (((String)localObject1).contains(".jpeg"))
          {
            break label713;
            label684:
            this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesWebResourceResponse = null;
            if (this.jdField_f_of_type_Int != 3) {
              break;
            }
            a((BufferedInputStream)localObject1, paramHttpURLConnection);
            return;
          }
          localObject1 = "text/html";
          continue;
        }
        label713:
        localObject1 = "image/*";
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (paramLong == 8589934594L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "EVENT_LOAD_FINISH: ");
      }
      c(paramString);
    }
    while ((paramLong != 8589934593L) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.d("SwiftWebViewHttpBridge", 2, "EVENT_LOAD_START: ");
  }
  
  public boolean a()
  {
    try
    {
      Object localObject = new File(BaseApplicationImpl.a().getApplicationContext().getFilesDir(), ClubContentJsonTask.i.jdField_b_of_type_JavaLangString);
      if (((File)localObject).exists())
      {
        localObject = new JSONObject(FileUtils.a((File)localObject));
        if (((JSONObject)localObject).has("useAsyncMode"))
        {
          bool = ((JSONObject)localObject).getBoolean("useAsyncMode");
          if (!bool) {
            QLog.w("SwiftWebViewHttpBridge", 1, "can not use webview async mode!");
          }
          return bool;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SwiftWebViewHttpBridge", 2, "parse asyncMode config error!", localException);
        }
        boolean bool = true;
      }
    }
  }
  
  public boolean a(SwiftWebViewUtils.JsInfo paramJsInfo)
  {
    if ((paramJsInfo == null) || (TextUtils.isEmpty(paramJsInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramJsInfo.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return false;
      if (("SwiftHttp".equals(paramJsInfo.jdField_a_of_type_JavaLangString)) && ("getSwiftHttpDiffData".equals(paramJsInfo.jdField_b_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridge", 2, "SwiftHttp get swift http js api, data: " + Arrays.toString(paramJsInfo.jdField_a_of_type_ArrayOfJavaLangString));
        }
        if (paramJsInfo.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
          try
          {
            paramJsInfo = new JSONObject(paramJsInfo.jdField_a_of_type_ArrayOfJavaLangString[0]).getString("callback");
            if (!TextUtils.isEmpty(paramJsInfo))
            {
              this.jdField_e_of_type_JavaLangString = paramJsInfo;
              paramJsInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
              this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramJsInfo);
              return true;
            }
          }
          catch (Exception paramJsInfo)
          {
            paramJsInfo.printStackTrace();
          }
        }
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = "";
    try
    {
      str = Uri.parse(paramString).getQueryParameter("_bid");
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str;
        localException.printStackTrace();
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      str = HtmlOffline.a((String)localObject);
      if (!TextUtils.isEmpty(str))
      {
        localObject = str + (String)localObject;
        paramString = HtmlOffline.g(paramString);
        paramString = (String)localObject + "/" + paramString;
        if (new File(paramString).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("SwiftWebViewHttpBridge", 2, "async get url has local res: " + paramString);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SwiftWebViewHttpBridge", 2, "async http get cost too much time, now destroy!");
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangThread = null;
        boolean bool = c(this.jdField_b_of_type_JavaLangString);
        this.jdField_b_of_type_JavaLangString = "";
        return bool;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.jdField_f_of_type_Int != 3) || (!paramString.startsWith("jsbridge://"))) {
      return false;
    }
    return a(SwiftWebViewUtils.a(paramString));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "webView is null, continue to poll: " + paramMessage.what);
      }
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramMessage.what);
      ((Message)localObject).arg1 = paramMessage.arg1;
      ((Message)localObject).obj = paramMessage.obj;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 50L);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (!this.jdField_c_of_type_Boolean) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("SwiftWebViewHttpBridge", 2, "activity has destroy");
            return false;
            switch (paramMessage.what)
            {
            }
          } while (!QLog.isColorLevel());
          QLog.d("SwiftWebViewHttpBridge", 2, "can not  recognize refresh type!");
          return false;
        } while (!(paramMessage.obj instanceof String));
        paramMessage = (String)paramMessage.obj;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridge", 2, "load url has cache, length: " + paramMessage.length());
        }
        this.jdField_g_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
        paramMessage = WebSoUtils.a(paramMessage, this.jdField_g_of_type_JavaLangString, null);
        ((CustomWebView)localObject).loadDataWithBaseURL(this.jdField_b_of_type_JavaLangString, paramMessage, "text/html", "utf-8", this.jdField_b_of_type_JavaLangString);
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftWebViewHttpBridge", 2, "load url because cache is null: " + this.jdField_b_of_type_JavaLangString);
        }
        ((CustomWebView)localObject).a(this.jdField_b_of_type_JavaLangString);
        return false;
        if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          paramMessage = a(this.jdField_b_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("SwiftWebViewHttpBridge", 2, "auto switch to normal url");
          }
          ((CustomWebView)localObject).a(paramMessage);
          return false;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SwiftWebViewHttpBridge", 2, "503, url is null");
      return false;
    } while (!(paramMessage.obj instanceof String));
    String str = (String)paramMessage.obj;
    boolean bool = TextUtils.isEmpty(str);
    if (QLog.isColorLevel()) {
      QLog.d("SwiftWebViewHttpBridge", 2, "msg: " + paramMessage.what + " content: " + bool);
    }
    if (!bool)
    {
      long l1 = System.currentTimeMillis();
      paramMessage = WebSoUtils.a(str, this.jdField_g_of_type_JavaLangString, String.valueOf(l1));
      ((CustomWebView)localObject).loadDataWithBaseURL(this.jdField_b_of_type_JavaLangString, paramMessage, "text/html", "utf-8", this.jdField_b_of_type_JavaLangString);
      return false;
    }
    ((CustomWebView)localObject).a(this.jdField_b_of_type_JavaLangString);
    return false;
    if ((paramMessage.arg1 == 304) || (paramMessage.arg1 == 1000)) {
      this.l = paramMessage.arg1;
    }
    for (;;)
    {
      e();
      return false;
      if (paramMessage.arg1 == 200)
      {
        this.l = 200;
        this.jdField_f_of_type_JavaLangString = ((String)paramMessage.obj);
        if ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (this.jdField_f_of_type_JavaLangString.equals("{}"))) {
          this.l = 304;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftWebViewHttpBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */