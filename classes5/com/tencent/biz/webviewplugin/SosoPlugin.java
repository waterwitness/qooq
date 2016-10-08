package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider.SosoSrvAddrType;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import jin;

public class SosoPlugin
  extends WebViewPlugin
{
  public static final int a = 0;
  public static final String a;
  public static String[] a;
  public static final int b = 1;
  public static final String b = "key_isReadModeEnabled";
  private static boolean b = false;
  public static final String c = "http://htdata.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080";
  public static final String d = "http://htdata2.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080";
  public static final String e = "/cgi-bin/httpconn?htcmd=0x6ff0080";
  public static final String f = "#__SOSO_RAW_URL___";
  private static final String h = "1004";
  private static final String i = "domain_white_list.txt";
  private static final String j = "http://pub.idqqimg.com/qqmobile/client/android/forbidden.html";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  SosoSrvAddrProvider jdField_a_of_type_ComTencentMobileqqTransfileSosoSrvAddrProvider;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean;
  private int d = this.jdField_c_of_type_Int;
  private int e = -1;
  String g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SosoPlugin.class.getSimpleName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "http://htdata.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080", "http://htdata2.qq.com/cgi-bin/httpconn?htcmd=0x6ff0080" };
  }
  
  public SosoPlugin()
  {
    this.mPluginNameSpace = jdField_a_of_type_JavaLangString;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new jin(this);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "registerReceiver soso receiver");
      }
      this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.receiver.soso"));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, "registerReceiver soso receiver error", localException);
    }
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: getfield 78	com/tencent/biz/webviewplugin/SosoPlugin:TAG	Ljava/lang/String;
    //   13: iconst_2
    //   14: ldc -127
    //   16: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: new 131	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 132	java/util/ArrayList:<init>	()V
    //   27: putfield 134	com/tencent/biz/webviewplugin/SosoPlugin:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   30: new 136	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: new 139	java/io/FileInputStream
    //   42: dup
    //   43: aload_1
    //   44: invokespecial 142	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_3
    //   48: new 144	java/io/BufferedReader
    //   51: dup
    //   52: new 146	java/io/InputStreamReader
    //   55: dup
    //   56: aload_3
    //   57: invokespecial 149	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   60: invokespecial 152	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: astore_2
    //   64: aload_2
    //   65: invokevirtual 155	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull +57 -> 127
    //   73: aload_0
    //   74: getfield 134	com/tencent/biz/webviewplugin/SosoPlugin:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   77: aload_1
    //   78: invokevirtual 159	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   81: pop
    //   82: goto -18 -> 64
    //   85: astore 4
    //   87: aload_3
    //   88: astore_1
    //   89: aload 4
    //   91: astore_3
    //   92: invokestatic 162	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   95: ifeq +15 -> 110
    //   98: aload_0
    //   99: getfield 78	com/tencent/biz/webviewplugin/SosoPlugin:TAG	Ljava/lang/String;
    //   102: iconst_4
    //   103: aload_3
    //   104: invokestatic 166	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   107: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 169	java/io/BufferedReader:close	()V
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 172	java/io/InputStream:close	()V
    //   126: return
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 169	java/io/BufferedReader:close	()V
    //   135: aload_3
    //   136: ifnull -10 -> 126
    //   139: aload_3
    //   140: invokevirtual 172	java/io/InputStream:close	()V
    //   143: return
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 175	java/io/IOException:printStackTrace	()V
    //   149: return
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 175	java/io/IOException:printStackTrace	()V
    //   155: goto -20 -> 135
    //   158: astore_2
    //   159: aload_2
    //   160: invokevirtual 175	java/io/IOException:printStackTrace	()V
    //   163: goto -45 -> 118
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 175	java/io/IOException:printStackTrace	()V
    //   171: return
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_2
    //   175: aconst_null
    //   176: astore_3
    //   177: aload_2
    //   178: ifnull +7 -> 185
    //   181: aload_2
    //   182: invokevirtual 169	java/io/BufferedReader:close	()V
    //   185: aload_3
    //   186: ifnull +7 -> 193
    //   189: aload_3
    //   190: invokevirtual 172	java/io/InputStream:close	()V
    //   193: aload_1
    //   194: athrow
    //   195: astore_2
    //   196: aload_2
    //   197: invokevirtual 175	java/io/IOException:printStackTrace	()V
    //   200: goto -15 -> 185
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 175	java/io/IOException:printStackTrace	()V
    //   208: goto -15 -> 193
    //   211: astore_1
    //   212: aconst_null
    //   213: astore_2
    //   214: goto -37 -> 177
    //   217: astore_1
    //   218: goto -41 -> 177
    //   221: astore 4
    //   223: aload_1
    //   224: astore_3
    //   225: aload 4
    //   227: astore_1
    //   228: goto -51 -> 177
    //   231: astore_3
    //   232: aconst_null
    //   233: astore_2
    //   234: aload 4
    //   236: astore_1
    //   237: goto -145 -> 92
    //   240: astore 4
    //   242: aconst_null
    //   243: astore_2
    //   244: aload_3
    //   245: astore_1
    //   246: aload 4
    //   248: astore_3
    //   249: goto -157 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	SosoPlugin
    //   0	252	1	paramString	String
    //   63	69	2	localBufferedReader	java.io.BufferedReader
    //   158	2	2	localIOException1	java.io.IOException
    //   174	8	2	localObject1	Object
    //   195	2	2	localIOException2	java.io.IOException
    //   203	2	2	localIOException3	java.io.IOException
    //   213	31	2	localObject2	Object
    //   47	178	3	localObject3	Object
    //   231	14	3	localIOException4	java.io.IOException
    //   248	1	3	localIOException5	java.io.IOException
    //   1	1	4	localObject4	Object
    //   85	5	4	localIOException6	java.io.IOException
    //   221	14	4	localObject5	Object
    //   240	7	4	localIOException7	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   64	69	85	java/io/IOException
    //   73	82	85	java/io/IOException
    //   139	143	144	java/io/IOException
    //   131	135	150	java/io/IOException
    //   114	118	158	java/io/IOException
    //   122	126	166	java/io/IOException
    //   39	48	172	finally
    //   181	185	195	java/io/IOException
    //   189	193	203	java/io/IOException
    //   48	64	211	finally
    //   64	69	217	finally
    //   73	82	217	finally
    //   92	110	221	finally
    //   39	48	231	java/io/IOException
    //   48	64	240	java/io/IOException
  }
  
  private boolean a()
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
      return false;
    }
    return this.mRuntime.a().getIntent().getBooleanExtra("key_isReadModeEnabled", false);
  }
  
  private String b(String paramString)
  {
    if (this.jdField_c_of_type_Int == 1) {
      if (AuthorizeConfig.a().b(paramString)) {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "Url is on cig skip white list,the url:" + Util.b(paramString, new String[0]));
        }
      }
    }
    while ((!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) || (!QLog.isColorLevel()))
    {
      do
      {
        return paramString;
      } while (!this.jdField_a_of_type_Boolean);
      return a(this.mRuntime.a().getIntent(), paramString, SosoSrvAddrProvider.a());
    }
    QLog.e(this.TAG, 2, "VIEW_MODE_SYSTEM_BROWSER_MODE! url is not original!");
    return paramString;
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_Int == 1)
    {
      this.d = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = 0;
      return;
    }
    this.d = this.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = 1;
  }
  
  String a(Intent paramIntent, String paramString, SosoSrvAddrProvider paramSosoSrvAddrProvider)
  {
    if ((paramString.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) || (paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      return paramString;
    }
    for (;;)
    {
      try
      {
        String str = jdField_a_of_type_ArrayOfJavaLangString[new java.util.Random().nextInt(2)];
        paramSosoSrvAddrProvider = new StringBuilder();
        paramSosoSrvAddrProvider.append(str);
        paramSosoSrvAddrProvider.append("&u=");
        paramSosoSrvAddrProvider.append(URLEncoder.encode(paramString, "UTF-8"));
        paramSosoSrvAddrProvider.append("&wap=3");
        if (paramIntent.getBooleanExtra("fromQrcode", false))
        {
          paramSosoSrvAddrProvider.append("&qq-pf-to=mqq.qrcode");
          str = paramIntent.getStringExtra("uin");
          if (TextUtils.isEmpty(str)) {
            break label251;
          }
          paramSosoSrvAddrProvider.append("&uin=").append(str);
          paramIntent = paramIntent.getStringExtra("friendUin");
          if (!TextUtils.isEmpty(paramIntent)) {
            paramSosoSrvAddrProvider.append("&originuin=").append(paramIntent);
          }
          return paramSosoSrvAddrProvider.toString();
        }
        switch (paramIntent.getIntExtra("curtype", 0))
        {
        case 0: 
          paramSosoSrvAddrProvider.append("&qq-pf-to=mqq.temporaryc2c");
          continue;
          paramSosoSrvAddrProvider.append("&qq-pf-to=mqq.c2c");
        }
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        paramIntent.printStackTrace();
        return paramString;
      }
      continue;
      paramSosoSrvAddrProvider.append("&qq-pf-to=mqq.group");
      continue;
      paramSosoSrvAddrProvider.append("&qq-pf-to=mqq.discussion");
      continue;
      label251:
      if (!TextUtils.isEmpty(this.g)) {
        paramSosoSrvAddrProvider.append("&uin=").append(this.g);
      }
    }
  }
  
  String a(String paramString)
  {
    if (!a()) {
      return paramString;
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      String str;
      if (paramString.indexOf("#__SOSO_RAW_URL___") == -1) {
        str = b(paramString);
      }
      for (;;)
      {
        paramString = str;
        if (this.d != 0) {
          break;
        }
        this.e = -1;
        return str;
        this.d = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = 0;
        this.e = this.jdField_a_of_type_ComTencentSmttSdkWebView.copyBackForwardList().getCurrentIndex();
        str = paramString;
        if (QLog.isColorLevel())
        {
          QLog.d(this.TAG, 2, "anchorIndex org " + this.e);
          str = paramString;
        }
      }
    }
    this.d = this.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = 0;
    return paramString;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    int k;
    if (paramLong == 8589934601L)
    {
      k = this.jdField_a_of_type_ComTencentSmttSdkWebView.copyBackForwardList().getCurrentIndex();
      if (this.e == k - 1)
      {
        b();
        this.e = k;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "anchorIndex back " + this.e);
        }
      }
    }
    for (;;)
    {
      return false;
      if (paramLong == 8589934594L)
      {
        this.jdField_a_of_type_Boolean = true;
        if (paramString.contains("http://pub.idqqimg.com/qqmobile/client/android/forbidden.html"))
        {
          this.jdField_a_of_type_ComTencentSmttSdkWebView.clearHistory();
        }
        else if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http")))
        {
          if (this.jdField_c_of_type_Boolean) {}
          for (k = 1;; k = 0)
          {
            ReportController.b(null, "P_CliOper", "BizTechReport", "", "web_safe", "url_safe_check", 0, k, "", "", "", "");
            break;
          }
        }
      }
      else if (paramLong == 8589934595L)
      {
        this.jdField_a_of_type_Boolean = true;
        SosoSrvAddrProvider.a().a(SosoSrvAddrProvider.SosoSrvAddrType.URL_ENCODE_SRV, paramString);
      }
      else if (paramLong == 8589934593L)
      {
        this.jdField_a_of_type_Boolean = false;
      }
      else if (paramLong == 8589934602L)
      {
        k = this.jdField_a_of_type_ComTencentSmttSdkWebView.copyBackForwardList().getCurrentIndex();
        if (this.e == k + 1)
        {
          b();
          this.e = k;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "anchorIndex forward " + this.e);
          }
        }
      }
    }
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (((!"http".equals(paramString2)) && (!"https".equals(paramString2))) || (paramString1.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) || (paramString1.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) || (!a())) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "check url safety with old solution (<5.3)");
      }
      paramString2 = a(paramString1);
    } while (paramString1.equalsIgnoreCase(paramString2));
    this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString2);
    return true;
  }
  
  public void onActivityReady()
  {
    a();
  }
  
  public void onAppRuntimeReady(AppInterface paramAppInterface)
  {
    this.g = paramAppInterface.a();
  }
  
  protected void onCreate()
  {
    SosoSrvAddrProvider.a().c();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "unregisterReceiver sosoReceiver");
      }
      this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramCustomWebView;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\SosoPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */