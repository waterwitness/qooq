package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import wit;
import wiu;
import wiv;
import wiw;

public class SwiftBrowserStatistics
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
{
  public static final String A = "Web_qqbrowser_state_machine_init_data";
  public static final String B = "Web_qqbrowser_state_machine_init_ui_frame";
  public static final String C = "Web_qqbrowser_state_machine_init_ui_main_content";
  public static final String D = "Web_qqbrowser_state_machine_init_webview";
  public static final String E = "Web_qqbrowser_state_machine_load_url";
  public static final String F = "Web_qqbrowser_state_machine_init_FINAL";
  public static final String G = "Web_qqbrowser_state_machine_all";
  public static final String H = "Web_qqbrowser_check_and_set_cookies";
  public static final String a = "redtouch";
  public static final String b = "Web_qqbrowser_from_click_to_onCreate";
  public static int c = 0;
  public static final String c = "unknown";
  public static final String d = "Web_onFirstPageStarted";
  public static final String e = "FORCE_BLANK_SCREEN_REPORTE";
  public static final String f = "fromAio";
  public static final String g = "web_browserAppinterface_onCreate";
  public static final String h = "Web_openIconsDB";
  public static final String i = "Web_IPCSetup";
  public static final String j = "Web_readyToLoadUrl";
  public static final String k = "Web_qqbrowser_dooncreate";
  public static final String l = "Web_qqbrowser_oncreate";
  public static boolean l = false;
  public static final String m = "Web_qqbrowser_doonresume";
  public static boolean m = false;
  @Deprecated
  public static final String n = "Web_qqbrowser_initVariable";
  @Deprecated
  public static final String o = "Web_qqbrowser_initAll";
  public static final String p = "Web_qqbrowser_initView";
  public static final String q = "Web_qqbrowser_initView_WebViewWrapper";
  @Deprecated
  public static final String r = "Web_qqbrowser_InitParameter";
  @Deprecated
  public static final String s = "Web_qqbrowser_initBrowser";
  public static final String t = "Web_qqbrowser_init";
  public static final String u = "Web_qqbrowser_ShowPreview";
  public static final String v = "Web_qqbrowser_from_click_to_readyLoadUrl";
  public static final String w = "Web_qqbrowser_init_plugin_engine";
  public static final String x = "Web_qqbrowser_loadurl_pagestart";
  public static final String y = "Web_qqbrowser_state_machine_init_titlebar";
  public static final String z = "Web_qqbrowser_state_machine_init_bottombar";
  public String I;
  public int a;
  public long a;
  Activity a;
  public SwiftBrowserStatistics.CrashStepStatsEntry a;
  public Runnable a;
  public JSONObject a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public boolean d;
  public long e;
  public boolean e;
  public long f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public boolean h;
  public long i;
  public boolean i;
  public long j;
  public boolean j;
  public long k;
  public boolean k;
  public long l;
  public long m;
  public long n;
  private boolean n;
  public long o;
  public long p;
  public long q = -1L;
  public long r;
  public long s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_Int = 10;
  }
  
  public SwiftBrowserStatistics()
  {
    this.jdField_n_of_type_Long = -1L;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry = new SwiftBrowserStatistics.CrashStepStatsEntry();
  }
  
  private String a(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    if (!paramBoolean) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramAppRuntime instanceof AppInterface)) {}
    for (paramAppRuntime = (AppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (paramAppRuntime == null) {
        return "";
      }
      String str = paramAppRuntime.a().getSharedPreferences("redTouchPref", 4).getString("lastClickPath", "");
      if (!"".equals(str))
      {
        paramAppRuntime = a(paramAppRuntime);
        if (paramAppRuntime == null) {
          break label211;
        }
        paramAppRuntime = paramAppRuntime.rptMsgAppInfo.get();
        if (paramAppRuntime == null) {
          break label211;
        }
        Iterator localIterator = paramAppRuntime.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramAppRuntime = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        } while (!paramAppRuntime.path.get().equals(str));
      }
      for (;;)
      {
        if (paramAppRuntime != null)
        {
          paramAppRuntime = paramAppRuntime.missions.get();
          if (paramAppRuntime != null)
          {
            int i1 = 0;
            while (i1 < paramAppRuntime.size())
            {
              localStringBuilder.append((String)paramAppRuntime.get(i1));
              if (i1 != paramAppRuntime.size() - 1) {
                localStringBuilder.append("_");
              }
              i1 += 1;
            }
          }
        }
        return localStringBuilder.toString();
        label211:
        paramAppRuntime = null;
      }
    }
  }
  
  private void a(Context paramContext, SwiftBrowserStatistics.CrashStepStatsEntry paramCrashStepStatsEntry)
  {
    paramContext = new File(paramContext.getFilesDir(), ClubContentJsonTask.i.b);
    if (!paramContext.exists()) {}
    do
    {
      do
      {
        return;
        paramContext = FileUtils.a(paramContext);
      } while (TextUtils.isEmpty(paramContext));
      try
      {
        paramContext = new JSONObject(paramContext);
        int i1 = paramContext.getInt("sample_rate");
        SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(i1));
        JSONArray localJSONArray = paramContext.getJSONArray("rules");
        int i2 = localJSONArray.length();
        i1 = 0;
        while (i1 < i2)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
          SwiftBrowserStatistics.CrashStepStatsEntry.jdField_a_of_type_JavaUtilHashMap.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
          i1 += 1;
        }
        paramCrashStepStatsEntry.jdField_c_of_type_Int = paramContext.getInt("tail_number");
        return;
      }
      catch (Throwable paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("QQBrowser", 2, "" + paramContext);
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface == null) || (paramAppInterface.getApplication() == null)) {}
    for (;;)
    {
      return null;
      Object localObject = paramAppInterface.getApplication().getFilesDir();
      paramAppInterface = paramAppInterface.a();
      paramAppInterface = new File((File)localObject, "BusinessInfoCheckUpdateItem_new_1_" + paramAppInterface);
      if (!paramAppInterface.exists()) {}
      try
      {
        paramAppInterface.createNewFile();
        paramAppInterface = FileUtils.a(paramAppInterface);
        if (paramAppInterface != null) {
          localObject = new BusinessInfoCheckUpdate.TimeRspBody();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          try
          {
            ((BusinessInfoCheckUpdate.TimeRspBody)localObject).mergeFrom(paramAppInterface);
            return (BusinessInfoCheckUpdate.TimeRspBody)localObject;
          }
          catch (Exception paramAppInterface)
          {
            paramAppInterface.printStackTrace();
          }
          localIOException = localIOException;
          localIOException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      label69:
      long l1;
      long l2;
      int i1;
      if (this.jdField_g_of_type_Long > 0L)
      {
        paramInt = (int)((this.jdField_e_of_type_Long - this.jdField_g_of_type_Long) / 1000000L);
        if (this.jdField_d_of_type_Boolean)
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_before_create", 0, 1, paramInt, HttpUtil.a() + "", "", "", "" + this.jdField_b_of_type_Int);
          paramBundle = HttpUtil.a() + "";
          l1 = System.currentTimeMillis();
          l2 = this.jdField_h_of_type_Long;
          if (!WebProcessManager.b()) {
            break label343;
          }
          i1 = 1;
          label185:
          if (!m) {
            break label348;
          }
        }
      }
      label343:
      label348:
      for (int i2 = 1;; i2 = 0)
      {
        ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFD", "0X8004FFD", 0, 1, 0, paramBundle, String.valueOf(l1 - l2), String.valueOf(i1), String.valueOf(i2));
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("web_report", 4, "web_before_create, cost = " + paramInt + ", url = " + Util.b(this.I, new String[0]) + ", isFromLeba = " + this.jdField_a_of_type_Boolean + ", hasRedDot = " + this.jdField_b_of_type_Boolean + ", isProgressCreate = " + l + ", flag=" + this.jdField_b_of_type_Int);
        return;
        paramInt = 0;
        break label69;
        i1 = 0;
        break label185;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("GOTOWEB", 2, "onQQBrowserResume() time = " + System.currentTimeMillis());
        return;
        if ((paramBundle != null) && (paramBundle.containsKey("url")))
        {
          b(paramBundle.getString("url"));
          return;
          if ((paramBundle != null) && (paramBundle.containsKey("url")))
          {
            a(paramBundle.getString("url"));
            return;
            if ((paramBundle != null) && (paramBundle.containsKey("url"))) {}
            for (paramBundle = paramBundle.getString("url"); !TextUtils.isEmpty(paramBundle); paramBundle = "")
            {
              a((TouchWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), paramBundle);
              return;
            }
          }
        }
      }
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("WebView_Report_Step", 0);
    }
    str3 = "UNKNOWN";
    try
    {
      int i1 = NetworkUtil.a(paramContext);
      str1 = str3;
      if (i1 != -1)
      {
        str1 = str3;
        if (i1 < AppConstants.b.length) {
          str1 = AppConstants.b[i1];
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2 = str3;
      }
    }
    ThreadManager.a(new wiv(this, paramString, paramContext, str1), 5, null, false);
  }
  
  public void a(Intent paramIntent)
  {
    int i3 = 1;
    this.jdField_e_of_type_Long = System.nanoTime();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
    this.jdField_b_of_type_Long = paramIntent.getLongExtra("startOpenPageTime", -1L);
    this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("reportMsfLog", false);
    this.i = paramIntent.getBooleanExtra("fromAio", false);
    paramIntent.getBooleanExtra("fromPublicAccount", false);
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = this.jdField_c_of_type_Long;
    }
    this.jdField_g_of_type_Long = paramIntent.getLongExtra("plugin_start_time", 0L);
    this.jdField_h_of_type_Long = paramIntent.getLongExtra("click_start_time", 0L);
    this.k = paramIntent.getBooleanExtra("FORCE_BLANK_SCREEN_REPORTE", false);
    if (this.jdField_g_of_type_Long > 0L) {
      paramIntent.putExtra("plugin_start_time", 0L);
    }
    if (this.jdField_h_of_type_Long > 0L) {
      paramIntent.putExtra("click_start_time", 0L);
    }
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("is_from_leba", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("has_red_dot", false);
    if (QLog.isColorLevel()) {
      QLog.i("GOTOWEB", 2, "onQQBrowserCreate() time = " + this.jdField_e_of_type_Long);
    }
    if (WebAccelerateHelper.isWebViewCache) {
      m = true;
    }
    this.r = System.currentTimeMillis();
    int i1;
    int i2;
    if (l)
    {
      i1 = 1;
      if (!this.jdField_a_of_type_Boolean) {
        break label293;
      }
      i2 = 1;
      label266:
      if (!this.jdField_b_of_type_Boolean) {
        break label298;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = ((i2 << 1) + (i1 << 2) + i3);
      return;
      i1 = 0;
      break;
      label293:
      i2 = 0;
      break label266;
      label298:
      i3 = 0;
    }
  }
  
  public void a(TouchWebView paramTouchWebView, int paramInt, String paramString1, String paramString2)
  {
    int i1;
    if (this.jdField_d_of_type_Boolean)
    {
      i1 = (int)((System.nanoTime() - this.jdField_f_of_type_Long) / 1000000L);
      paramString2 = HttpUtil.a();
      if (this.I == null) {
        break label70;
      }
    }
    label70:
    for (paramTouchWebView = this.I;; paramTouchWebView = "unknown")
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_load_url_error", 0, 1, i1, paramString2, paramTouchWebView, String.valueOf(paramInt), paramString1);
      return;
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString)
  {
    Object localObject2;
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_f_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      localObject2 = "";
      paramTouchWebView = paramTouchWebView.a();
      if (paramTouchWebView == null) {
        break label481;
      }
      paramTouchWebView = paramTouchWebView.a("offline");
      if ((paramTouchWebView == null) || (!(paramTouchWebView instanceof OfflinePlugin))) {
        break label481;
      }
    }
    label195:
    label213:
    label463:
    label469:
    label475:
    label481:
    for (Object localObject1 = (OfflinePlugin)paramTouchWebView;; localObject1 = null)
    {
      paramTouchWebView = (TouchWebView)localObject2;
      if (localObject1 != null) {
        paramTouchWebView = ((OfflinePlugin)localObject1).a();
      }
      int i1 = (int)((System.nanoTime() - this.jdField_f_of_type_Long) / 1000000L);
      localObject2 = HttpUtil.a();
      int i2;
      if (this.I != null)
      {
        localObject1 = this.I;
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_load_url", 0, 1, i1, (String)localObject2, (String)localObject1, paramTouchWebView, "" + this.jdField_b_of_type_Int);
        localObject1 = HttpUtil.a() + "";
        long l1 = (System.nanoTime() - this.jdField_f_of_type_Long) / 1000000L;
        if (!WebProcessManager.b()) {
          break label463;
        }
        i1 = 1;
        localObject2 = new StringBuilder();
        if (!m) {
          break label469;
        }
        i2 = 1;
        ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFE", "0X8004FFE", 0, 1, 0, (String)localObject1, String.valueOf(l1), String.valueOf(i1), String.valueOf(i2) + ", " + paramTouchWebView);
        if (QLog.isDevelopLevel()) {
          QLog.d("web_report", 4, "web_load_url, cost = " + (System.nanoTime() - this.jdField_f_of_type_Long) / 1000000L + ", url = " + Util.b(this.I, new String[0]) + ", isFromLeba = " + this.jdField_a_of_type_Boolean + ", hasRedDot = " + this.jdField_b_of_type_Boolean + ", " + paramTouchWebView);
        }
        if ((this.jdField_e_of_type_Boolean) && (this.i) && (!this.j))
        {
          this.j = true;
          if (paramString == null) {
            break label475;
          }
        }
      }
      for (;;)
      {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "msg_webview_url", "msg_webview_pvqq", 0, 1, 0, Util.b(URLEncoder.encode(paramString), new String[0]), "", "", "" + this.jdField_b_of_type_Int);
        return;
        localObject1 = "unknown";
        break;
        i1 = 0;
        break label195;
        i2 = 0;
        break label213;
        paramString = "unknown";
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String... paramVarArgs)
  {
    ThreadManager.a(new wiw(this, paramTouchWebView, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramVarArgs), 5, null, false);
  }
  
  public void a(String paramString)
  {
    if ("about:blank".equalsIgnoreCase(paramString)) {}
    while (!this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_f_of_type_Long = System.nanoTime();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser_report", 2, "try report web status, onPageStarted,  step: " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int + ", asyncMode: " + this.jdField_a_of_type_Int + ", stepTime: " + (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long - this.jdField_b_of_type_Long) + ", totalTime: " + (System.currentTimeMillis() - this.jdField_b_of_type_Long) + "\n" + paramString);
    }
    int i3;
    String str;
    int i1;
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
    {
      i3 = (int)((this.jdField_f_of_type_Long - this.jdField_e_of_type_Long) / 1000000L);
      str = HttpUtil.a();
      if (this.I == null) {
        break label457;
      }
      paramString = this.I;
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_before_load_url", 0, 1, i3, str, paramString, "", "" + this.jdField_b_of_type_Int);
      paramString = HttpUtil.a() + "";
      str = "" + i3;
      if (!WebProcessManager.b()) {
        break label463;
      }
      i1 = 1;
      label288:
      if (!m) {
        break label468;
      }
    }
    label457:
    label463:
    label468:
    for (int i2 = 1;; i2 = 0)
    {
      ReportController.b(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004F62", "0X8004F62", 0, 1, 0, paramString, str, String.valueOf(i1), String.valueOf(i2));
      if (QLog.isDevelopLevel()) {
        QLog.d("web_report", 4, "web_before_load_url, cost = " + i3 + ", url = " + Util.b(this.I, new String[0]) + ", isFromLeba = " + this.jdField_a_of_type_Boolean + ", hasRedDot = " + this.jdField_b_of_type_Boolean);
      }
      if ((this.jdField_n_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRunnable == null))
      {
        this.jdField_a_of_type_JavaLangRunnable = new wit(this);
        ThreadManager.c().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      return;
      paramString = "unknown";
      break;
      i1 = 0;
      break label288;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    while ((!this.jdField_d_of_type_Boolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ThreadManager.a(new wiu(this, paramString, paramInt), 5, null, false);
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (this.jdField_h_of_type_Boolean) {
        ReportController.b(null, "P_CliOper", "Grp_open", "", "time", "wide_time", 0, 1, 0, "", paramString.getQueryParameter("appid"), (int)((System.nanoTime() - this.jdField_e_of_type_Long) / 1000000L) + "", paramString.getQueryParameter("group_openid"));
      }
    }
    int i1;
    String str;
    if (this.jdField_d_of_type_Boolean)
    {
      i1 = (int)((System.nanoTime() - this.jdField_e_of_type_Long) / 1000000L);
      str = HttpUtil.a() + "";
      if (this.I == null) {
        break label300;
      }
    }
    label300:
    for (paramString = this.I;; paramString = "unknown")
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "web_stay_in_url", 0, 1, i1, str, URLEncoder.encode(paramString), "", "" + this.jdField_b_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.d("web_report", 4, "web_stay_in_url, cost = " + (System.nanoTime() - this.jdField_e_of_type_Long) / 1000000L + ", url = " + Util.b(this.I, new String[0]) + ", isFromLeba = " + this.jdField_a_of_type_Boolean + ", hasRedDot = " + this.jdField_b_of_type_Boolean);
      }
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        ThreadManager.c().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserStatistics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */