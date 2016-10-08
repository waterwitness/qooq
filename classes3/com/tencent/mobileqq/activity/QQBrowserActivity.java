package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.ui.CustomScrollView.OnGestureListener;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewplugin.Hole;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserNavigator;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.PreloadIdleTask;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.ShareApiInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebFeaturesInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareReportInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mce;
import mcf;
import mcg;
import mch;
import mci;
import mcj;
import mck;
import mcl;
import mcm;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.opengroup.AppUrlOpenGroup.ReqBody;

public class QQBrowserActivity
  extends AbsBaseWebViewActivity
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, CustomScrollView.OnGestureListener, WebUiUtils.QQBrowserBaseActivityInterface, WebUiUtils.ShareApiInterface, WebUiUtils.WebFeaturesInterface, WebUiUtils.WebShareInterface, WebUiUtils.WebShareReportInterface, WebUiUtils.WebTitleBarInterface, WebUiUtils.WebUiMethodInterface
{
  public static final int A = 6;
  public static final int B = 7;
  public static final int C = 9;
  public static final int D = 10;
  public static final int E = 11;
  public static final int F = 12;
  public static final int G = 13;
  public static final int H = 14;
  public static final int I = 100;
  public static int K = 0;
  static final String L = "QQBrowser";
  public static final String M = "web_report";
  public static final int N = 0;
  public static final String N = "action_name";
  protected static final int O = 1;
  public static final String O = "webview";
  protected static final int P = 2;
  public static final String P = "ba_is_login";
  protected static final int Q = 3;
  public static final String Q = "finish_animation_up_down";
  protected static final int R = 4;
  @Deprecated
  public static final String R = "avoidLoginWeb";
  protected static final int S = 5;
  public static final String S = "ignoreLoginWeb";
  protected static final int T = 6;
  public static final String T = "url";
  protected static final int U = 7;
  public static final String U = "isOpeningQunApp";
  protected static final int V = 8;
  public static final String V = "appid";
  public static final String W = "troopid";
  public static final String X = "extraParams";
  public static final String Y = "articalChannelId";
  public static final String Z = "ARTICAL_CHANNEL_EXTRAL_INFO";
  protected static final String aF = "http://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155";
  protected static final String aa = "update_time";
  public static final String ac = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079";
  public static final String ad = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10367";
  public static final String ae = "com.tencent.mobileqq.card.modify";
  public static final String af = "com.tencent.mobileqq.view.self.album";
  public static final String ag = "com.tencent.mobileqq.opencenter.vipInfo";
  public static final String ah = "broadcastAction";
  public static final String ai = "key_pay_action_result";
  public static final String aj = "reqType";
  public static final String ak = "2909288299";
  public static final String al = "miniqb://home";
  public static final String am = "version_code_key";
  public static final String an = "friendUin";
  public static final String ao = "groupUin";
  public static final String ap = "uinType";
  public static final String aq = "fromPublicAccount";
  public static final String ar = "fromNearby";
  public static final String as = "qqbrowser_float_shortcut";
  protected static final String au = "Xiaomi_MI 2";
  public static final String av = "isShowAd";
  public static final int g = 4660;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 5;
  public static final int m = 6;
  public static final int n = 1;
  public static final int o = 2;
  public static final int p = 3;
  public static final int q = 4;
  public static final int r = 5;
  public static final int s = 10000;
  public static final int u = 0;
  public static final int v = 1;
  public static final int w = 2;
  public static final int x = 3;
  public static final int y = 4;
  public static final int z = 5;
  int J;
  public int L;
  public int M;
  public int W;
  public TouchWebView a;
  protected Share a;
  public BrowserAppInterface a;
  protected Client.onRemoteRespObserver a;
  protected final SwiftBrowserStateMachineScheduler a;
  protected QQProgressDialog a;
  private boolean a;
  String aA;
  public String aB;
  public String aC;
  public String aD;
  public String aE;
  public String ab;
  public String at;
  public String aw;
  public String ax;
  public String ay;
  public String az;
  private boolean b;
  protected boolean m;
  public boolean n;
  public boolean o;
  public int t;
  
  public QQBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.at = "";
    this.aw = "";
    this.ax = "";
    this.ay = "";
    this.az = "";
    this.jdField_J_of_type_Int = 0;
    this.aA = "";
    this.W = 0;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler = new SwiftBrowserStateMachineScheduler(new mce(this));
  }
  
  private Share a()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare == null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
    }
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appids", paramString2);
    paramString3 = "vkey=" + paramString3 + ";uin=" + paramString4;
    if (QLog.isColorLevel()) {
      QLog.d("gamecenter", 2, "<--httpRequest vookies=" + paramString3 + ",appids=" + paramString2);
    }
    paramString2 = new Bundle();
    paramString2.putString("Cookie", paramString3);
    try
    {
      paramContext = HttpUtil.a(paramContext, paramString1, "POST", localBundle, paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest: result:" + paramContext);
      }
      return paramContext;
    }
    catch (ClientProtocolException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest:ClientProtocolException");
      }
      return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest:" + paramContext.getMessage());
      }
    }
    return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
  }
  
  private void a()
  {
    this.ab = super.c();
    Object localObject1 = Uri.parse(this.ab);
    Object localObject2;
    if (((Uri)localObject1).isHierarchical())
    {
      localObject2 = ((Uri)localObject1).getQueryParameter("_wv");
      if (localObject2 == null) {}
    }
    try
    {
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
      l1 = Long.parseLong((String)localObject2, 10);
      this.jdField_c_of_type_Long = l1;
      localSwiftBrowserUIStyle.jdField_a_of_type_Long = l1;
      localObject2 = ((Uri)localObject1).getQueryParameter("_fv");
      if (localObject2 == null) {}
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      try
      {
        SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
        l1 = Long.parseLong((String)localObject2, 10);
        this.d = l1;
        localSwiftBrowserUIStyle.jdField_b_of_type_Long = l1;
        localObject1 = ((Uri)localObject1).getQueryParameter("_wwv");
        if (localObject1 == null) {}
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        try
        {
          do
          {
            for (;;)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
              long l1 = Long.parseLong((String)localObject1, 10);
              this.e = l1;
              ((SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle)localObject2).jdField_c_of_type_Long = l1;
              if (this.jdField_c_of_type_Long != 4L)
              {
                localObject1 = getIntent();
                if ((this.jdField_c_of_type_Long & 0x2) != 0L) {
                  ((Intent)localObject1).putExtra("hide_more_button", true);
                }
                if ((this.jdField_c_of_type_Long & 1L) != 0L) {
                  ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
                }
                if ((this.jdField_c_of_type_Long & 0x100000) > 0L) {
                  ((Intent)localObject1).putExtra("ignoreLoginWeb", true);
                }
              }
              return;
              localNumberFormatException2 = localNumberFormatException2;
              if (QLog.isDevelopLevel()) {
                QLog.d("QQBrowser", 4, "_wv param not found");
              }
            }
            localNumberFormatException3 = localNumberFormatException3;
          } while (!QLog.isDevelopLevel());
          QLog.d("QQBrowser", 4, "_fv param not found");
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("QQBrowser", 4, "_wwv param not found");
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    AppUrlOpenGroup.ReqBody localReqBody = new AppUrlOpenGroup.ReqBody();
    localReqBody.uint32_appid.set(paramInt);
    localReqBody.bytes_url.set(ByteStringMicro.copyFromUtf8(this.ab));
    localReqBody.bytes_param.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new NewIntent(this, ProtoServlet.class);
    paramString.putExtra("cmd", "GroupOpen.CheckAppUrl");
    paramString.putExtra("data", localReqBody.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.startServlet(paramString);
  }
  
  private void i()
  {
    if (this.W != 0)
    {
      int i1 = this.W;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a(null);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Int;
  }
  
  public int a(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_FINAL");
    Util.a("Web_IPCSetup");
    if (!WebIPCOperator.a().a()) {
      WebIPCOperator.a().a().doBindService(getApplicationContext());
    }
    Util.b("Web_IPCSetup");
    if ((this.jdField_c_of_type_Long & 0x400000) > 0L)
    {
      SosoInterface.a(new mcg(this, 0, false, false, 0L, false, false, "webview"));
      SosoInterface.a(new mch(this, 0, true, false, 0L, false, false, "webview"));
    }
    ThreadManager.a(new mci(this), 5, null, false);
    SwiftBrowserIdleTaskHelper.a().a(new mcj(this, 2));
    Util.b("Web_qqbrowser_state_machine_init_FINAL");
    Util.b("Web_qqbrowser_state_machine_all");
    this.W = 0;
    return -1;
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, byte paramByte, boolean paramBoolean)
  {
    return super.switchRequestCode(paramWebViewPlugin, paramByte);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_Long;
  }
  
  public WebView a()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public SystemBarCompact a()
  {
    return this.mSystemBarComp;
  }
  
  public String a(String paramString)
  {
    paramString = a(this, "http://cgi.connect.qq.com/api/get_openids_by_appids", paramString, getIntent().getStringExtra("vkey"), this.jdField_J_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "<--getOpenidBatch result" + paramString);
    }
    return paramString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b(paramIntent, paramString);
  }
  
  protected void a(WebView paramWebView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.b() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)1);
    }
    if (paramInt == 100) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    i();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b(paramWebView);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    QLog.e("QQBrowser", 1, "errorCode=" + paramInt + "descrip=" + paramString1 + "failingUrl" + Util.b(paramString2, new String[0]));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramInt, paramString1, paramString2);
  }
  
  protected void a(WebView paramWebView, String paramString)
  {
    if (!TextUtils.isEmpty(this.at)) {}
    label10:
    do
    {
      do
      {
        do
        {
          break label10;
          do
          {
            return;
          } while (paramString == null);
          if (this.titleRoot == null) {
            break;
          }
          localObject = (RelativeLayout)this.titleRoot.findViewById(2131297138);
        } while (localObject == null);
        paramWebView = (TextView)((RelativeLayout)localObject).findViewById(2131297829);
        Object localObject = (TextView)((RelativeLayout)localObject).findViewById(2131297830);
        if (this.m)
        {
          this.b.postDelayed(new mcl(this, (TextView)localObject, paramWebView, paramString), 50L);
          return;
        }
        if (!TextUtils.isEmpty(((TextView)localObject).getText().toString()))
        {
          paramWebView.setText(paramString);
          return;
        }
        setTitle(paramString);
        return;
      } while (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.l);
      paramWebView = (TextView)findViewById(2131297139);
    } while (paramWebView == null);
    paramWebView.setText(paramString);
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    i();
    paramWebView = new Bundle();
    paramWebView.putString("url", paramString);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(6, paramWebView);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.e)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_fv", 0, 1, 0, this.d + "", this.ab, HttpUtil.a() + "", this.jdField_J_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.e = false;
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowser", 2, "X5 webkit detect 302 url: " + paramString2);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.q = System.currentTimeMillis();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener) {}
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    super.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, paramJsBridgeListener, paramOnClickListener);
    ((SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4)).d();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    QfavBuilder.a(paramString).c(str).a(this, str, 2, null);
    paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (paramBoolean) {}
    for (int i1 = 42;; i1 = 45)
    {
      QfavReport.a(paramString, i1, 2);
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(paramJSONObject);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ((SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4)).d();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c();
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(paramWebView);
    if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      g();
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        this.ab = paramString;
        SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
        if (localSwiftBrowserShareMenuHandler != null) {
          localSwiftBrowserShareMenuHandler.a(this.ab);
        }
      }
    }
    if (a(this)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    if (paramWebView.getX5WebViewExtension() == null)
    {
      paramWebView = paramWebView.getHitTestResult();
      if ((paramWebView != null) && (paramWebView.getType() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQBrowser", 2, "system webkit detect 302 url: " + paramString);
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.q = System.currentTimeMillis();
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return ((SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4)).a(paramString);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    return a().a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  public int b(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_data");
    QbSdk.setQQBuildNumber("2880");
    paramBundle = getIntent();
    Object localObject = paramBundle.getStringExtra("options");
    if (localObject != null) {}
    try
    {
      localObject = new JSONObject((String)localObject);
      paramBundle.putExtra("url", ((JSONObject)localObject).getString("url"));
      if (!paramBundle.hasExtra("key_isReadModeEnabled")) {
        paramBundle.putExtra("key_isReadModeEnabled", true);
      }
      paramBundle.putExtra("ba_is_login", ((JSONObject)localObject).optBoolean("ba_is_login", true));
      paramBundle.putExtra("isShowAd", ((JSONObject)localObject).optBoolean("isShowAd", true));
      paramBundle.putExtra("avoidLoginWeb", ((JSONObject)localObject).optBoolean("avoidLoginWeb", false));
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        boolean bool;
        int i2;
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.d("QQBrowser", 2, localJSONException.toString());
          continue;
          bool = false;
          continue;
          i1 = 0;
          continue;
          bool = false;
        }
      }
    }
    if ((this.mRuntime != null) && (this.mRuntime.getLongAccountUin() != 0L))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics;
      if (this.mRuntime.getLongAccountUin() % SwiftBrowserStatistics.jdField_c_of_type_Int == 6L)
      {
        bool = true;
        ((SwiftBrowserStatistics)localObject).d = bool;
      }
    }
    else
    {
      if (("Xiaomi_MI 2".equals(Build.MANUFACTURER + "_" + Build.MODEL)) && (Build.VERSION.SDK_INT == 16)) {
        this.m = true;
      }
      this.jdField_J_of_type_Int = paramBundle.getIntExtra("articalChannelId", 100);
      this.aA = paramBundle.getStringExtra("ARTICAL_CHANNEL_EXTRAL_INFO");
      this.o = paramBundle.getBooleanExtra("fromQZone", false);
      if ((this.app == null) && ((getAppRuntime() instanceof BrowserAppInterface))) {
        this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface = ((BrowserAppInterface)getAppRuntime());
      }
      bool = paramBundle.getBooleanExtra("fromNearby", false);
      localObject = getClass();
      i2 = hashCode();
      if (!bool) {
        break label510;
      }
      i1 = 1;
      ViewExposeUtil.a((Class)localObject, i2, i1, this.ab);
      if (paramBundle.getBooleanExtra("vasUsePreWebview", false)) {
        break label515;
      }
      bool = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting.a("web_view_long_click", bool);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_b_of_type_Int = getIntent().getIntExtra("individuation_url_type", -1);
      if (K == 1) {
        SwiftBrowserStatistics.CrashStepStatsEntry.d = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_b_of_type_Int;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_b_of_type_Int == -1) && (SwiftBrowserStatistics.CrashStepStatsEntry.d != -1)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_b_of_type_Int = SwiftBrowserStatistics.CrashStepStatsEntry.d;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.I = this.ab;
      this.at = paramBundle.getStringExtra("title");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_h_of_type_JavaLangString = this.at;
      if ((this.jdField_c_of_type_Long & 0x4000000) == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserSetting.a("image_long_click", true);
      }
      Util.b("Web_qqbrowser_state_machine_init_data");
      this.W = 2;
      return 0;
    }
  }
  
  public long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public Activity b()
  {
    return sTopActivity;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  public void b(long paramLong)
  {
    SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    this.jdField_c_of_type_Long = paramLong;
    localSwiftBrowserUIStyle.jdField_a_of_type_Long = paramLong;
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    i();
    if ((!"about:blank".equalsIgnoreCase(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Int = 8;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics$CrashStepStatsEntry.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_J_of_type_Int = 100;
    paramWebView = new Bundle();
    paramWebView.putString("url", paramString);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(7, paramWebView);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.f)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.f = false;
      a();
      SwiftBrowserIdleTaskHelper.a().a(new SwiftBrowserIdleTaskHelper.PreloadIdleTask(1));
    }
  }
  
  protected void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.b(paramWebView, paramString, paramBitmap);
    if ((!this.jdField_a_of_type_Boolean) && (PublicAccountUtil.a(paramString, this.jdField_J_of_type_Int, this.aA))) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.h = paramBoolean;
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b();
  }
  
  public int c(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_ui_frame");
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_Boolean) {
      showPreview();
    }
    this.W = 5;
    Util.b("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      onBackEvent();
    }
    HashMap localHashMap;
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack()) {
        break;
      }
      localHashMap = new HashMap(1);
      localHashMap.put("target", Integer.valueOf(2));
    } while (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.a(localHashMap));
    g();
    return;
    onBackEvent();
  }
  
  public void c(boolean paramBoolean)
  {
    this.mNeedStatusTrans = paramBoolean;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public int d(Bundle paramBundle)
  {
    int i1 = -1;
    Util.a("Web_qqbrowser_state_machine_init_webview");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.u = System.currentTimeMillis();
    long l1;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = super.b(null);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnLongClickListener(new mcm(this, null));
      l1 = System.currentTimeMillis();
      if ((this.jdField_c_of_type_Long & 0x10000) == 0L) {
        break label209;
      }
      i1 = 2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setCacheMode(i1);
      if (QLog.isColorLevel()) {
        QLog.i("QQBrowser", 2, "setCacheMode=" + i1);
      }
      long l2 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.j = (l2 - l1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.w = l2;
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser", 2, "init browser, cost = " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.j);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.v = System.currentTimeMillis();
      Util.b("Web_qqbrowser_state_machine_init_webview");
      this.W = 3;
      return 0;
      label209:
      switch (getIntent().getIntExtra("reqType", -1))
      {
      case 2: 
      case 3: 
      default: 
        break;
      case 1: 
        i1 = 2;
        break;
      case 4: 
        i1 = 0;
      }
    }
  }
  
  public String d()
  {
    if (a() == null) {
      return "";
    }
    return a().a();
  }
  
  public void d(boolean paramBoolean)
  {
    this.mActNeedImmersive = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "QQBrowserActivity onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      if ((!TextUtils.isEmpty(this.ab)) && (this.ab.contains("closeSpecialLogic=1")) && (paramIntent != null) && (paramIntent.getBooleanExtra("closeSpecialLogic", false)))
      {
        setResult(-1, paramIntent);
        finish();
      }
      break;
    }
    Object localObject;
    do
    {
      return;
      QfavBuilder.a(this, paramIntent);
      return;
      if (paramInt1 != 21) {
        break;
      }
      localObject = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    } while (paramIntent == null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    startActivity((Intent)localObject);
    return;
    if (paramInt1 == 100003)
    {
      paramIntent = getIntent();
      localObject = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
      if (localObject != null) {
        ((SwiftBrowserShareMenuHandler)localObject).a(paramIntent);
      }
      overridePendingTransition(2130968620, 2130968621);
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_dooncreate");
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    StatisticCollector.a(this, 10000L);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.s = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.t = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(getIntent().getStringArrayExtra("insertPluginsArray"));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(this.ab, 1L, null);
    }
    Util.a("Web_qqbrowser_state_machine_all");
    this.W = 1;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putString("url", this.ab);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(5, paramBundle);
    Util.b("Web_qqbrowser_dooncreate");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.x = System.currentTimeMillis();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.W != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
      this.W = 0;
    }
    Object localObject = Long.valueOf(getIntent().getLongExtra("Gif_msg_uniseq_key", 0L));
    if (((Long)localObject).longValue() > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("Gif_msg_uniseq_key", ((Long)localObject).longValue());
      localObject = DataFactory.a("close_annimate", null, -1, localBundle);
      WebIPCOperator.a().a((Bundle)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver != null) {
      WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
    if (localObject != null) {
      ((WebViewPluginEngine)localObject).a(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934596L, null);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("url", this.ab);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(3, (Bundle)localObject);
    super.doOnDestroy();
    if (K == 0)
    {
      WebIPCOperator.a().a().doUnbindService(getApplicationContext());
      SwiftBrowserStatistics.CrashStepStatsEntry.d = -1;
    }
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare != null) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.b();
    }
    localObject = ViewExposeUtil.a(getClass(), hashCode());
    if (localObject != null) {
      ReportController.b(this.app, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_b_of_type_Long), "", "", "");
    }
    SwiftBrowserIdleTaskHelper.a().a(2);
    AIOOpenWebMonitor.d(getIntent());
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction")))
    {
      break label21;
      break label21;
    }
    label21:
    while (("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction())) || (paramIntent.getBooleanExtra("fromNotification", false))) {
      return;
    }
    this.mStopFlag = 0;
    Object localObject = paramIntent.getDataString();
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl((String)localObject);
    }
    for (;;)
    {
      boolean bool = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser", 2, "doOnNewIntent, isPhotoPlusEditSend = " + bool);
      }
      if (!bool) {
        break;
      }
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent == null) || (paramIntent.size() <= 0)) {
        break;
      }
      paramIntent = (String)paramIntent.get(0);
      QLog.d("QQBrowser", 2, "editScreenShotBack:" + paramIntent);
      localObject = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
      if (localObject == null) {
        break;
      }
      ((SwiftBrowserShareMenuHandler)localObject).b(paramIntent);
      return;
      setIntent(paramIntent);
      a();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a(paramIntent.getExtras());
    }
  }
  
  public void doOnPause()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(1, null);
    if (this.o) {
      QzoneOnlineTimeCollectRptService.a().a();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    Util.a("Web_qqbrowser_doonresume");
    super.doOnResume();
    Bundle localBundle = new Bundle();
    localBundle.putInt("state_machine_step", this.W);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(2, localBundle);
    if (MyAppApi.d()) {
      MyAppApi.a().a(this);
    }
    if (this.o) {
      QzoneOnlineTimeCollectRptService.a().b(1);
    }
    Util.b("Web_qqbrowser_doonresume");
  }
  
  protected void doOnUserLeaveHint()
  {
    Intent localIntent = new Intent("tencent.notify.background");
    localIntent.putExtra("selfuin", this.jdField_J_of_type_JavaLangString);
    localIntent.putExtra("AccountInfoSync", "mobileqq.web");
    localIntent.putExtra("classname", getClass().getName());
    sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    super.doOnUserLeaveHint();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public int e(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_load_url");
    long l1 = System.currentTimeMillis();
    Util.a("Web_qqbrowser_init");
    h();
    Util.b("Web_qqbrowser_init");
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.k = (l2 - l1);
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "init param and load url, cost = " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.k);
    }
    Util.b("Web_qqbrowser_state_machine_load_url");
    this.W = 4;
    return 0;
  }
  
  public String e()
  {
    return this.ax;
  }
  
  public void e()
  {
    super.e();
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentBizUiRefreshView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentBizUiRefreshView.b(paramBoolean);
    }
  }
  
  public int f(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_ui_main_content");
    Util.a("Web_qqbrowser_initView");
    if (!this.n)
    {
      this.n = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(getIntent(), this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentBizUiRefreshView.setOnFlingGesture(this);
    }
    Util.b("Web_qqbrowser_initView");
    if (this.o) {
      QzoneOnlineTimeCollectRptService.a().b(1);
    }
    Util.b("Web_qqbrowser_state_machine_init_ui_main_content");
    this.W = 6;
    return 1;
  }
  
  public String f()
  {
    return this.aw;
  }
  
  protected void f()
  {
    Intent localIntent = getIntent();
    SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
    if (((this.jdField_c_of_type_Long & 0x20000) != 0L) || (localIntent.getBooleanExtra("isFullScreen", false)))
    {
      bool = true;
      localSwiftBrowserUIStyle.jdField_a_of_type_Boolean = bool;
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
      if ((this.jdField_c_of_type_Long & 0x1000000) == 0L) {
        break label476;
      }
      bool = true;
      label70:
      localSwiftBrowserUIStyle.jdField_b_of_type_Boolean = bool;
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
      if (((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_c_of_type_Long & 1L) == 0L) && (!localIntent.getBooleanExtra("isTransparentTitleAndClickable", false))) {
        break label482;
      }
      bool = true;
      label109:
      localSwiftBrowserUIStyle.l = bool;
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
      if (((this.jdField_c_of_type_Long & 0x2) == 0L) && (!localIntent.getBooleanExtra("hide_more_button", false))) {
        break label488;
      }
      bool = true;
      label147:
      localSwiftBrowserUIStyle.d = bool;
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle;
      if (((this.jdField_c_of_type_Long & 1L) == 0L) && (!localIntent.getBooleanExtra("hide_operation_bar", false)) && (!"noBottomBar".equals(localIntent.getStringExtra("webStyle")))) {
        break label494;
      }
    }
    label476:
    label482:
    label488:
    label494:
    for (boolean bool = true;; bool = false)
    {
      localSwiftBrowserUIStyle.e = bool;
      if (!TextUtils.isEmpty(localIntent.getStringExtra("key_params_qq")))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.e = true;
      }
      int i1 = localIntent.getIntExtra("reqType", -1);
      if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.e) && (i1 == 6)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.e = true;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d) && ((i1 == 3) || (i1 == 1) || (!localIntent.getBooleanExtra("ba_is_login", true)))) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d = true;
      }
      if ((this.jdField_c_of_type_Long & 0x20000) > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean = true;
      }
      if ((this.jdField_c_of_type_Long & 0x20000000) != 0L) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.n = true;
      }
      if ((this.jdField_c_of_type_Long & 0x800) > 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
      if ((this.e & 0x4) > 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
      if ((this.e & 0x2) > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.f = true;
      }
      if ((this.e & 0x8) > 0L)
      {
        this.at = localIntent.getStringExtra("title");
        localIntent.putExtra("title", "  ");
      }
      return;
      bool = false;
      break;
      bool = false;
      break label70;
      bool = false;
      break label109;
      bool = false;
      break label147;
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {}
    for (Object localObject = null;; localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a())
    {
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.ab, 8589934598L, null);
      }
      super.finish();
      if (localObject != null) {
        ((WebViewPluginEngine)localObject).a(this.ab, 8589934599L, null);
      }
      if (getIntent().getBooleanExtra("flow_key_from_guide", false))
      {
        localObject = new Intent();
        ((Intent)localObject).setClass(this, SplashActivity.class);
        ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
        ((Intent)localObject).addFlags(67108864);
        startActivity((Intent)localObject);
      }
      return;
    }
  }
  
  public int g(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_bottombar");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(getIntent(), this.ab);
    this.W = 7;
    Util.b("Web_qqbrowser_state_machine_init_bottombar");
    return 1;
  }
  
  public String g()
  {
    return this.ay;
  }
  
  protected void g()
  {
    a().a();
    this.H = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = null;
  }
  
  public String getCurrentUrl()
  {
    String str2 = this.ab;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl())) {
        str1 = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
      }
    }
    else {
      return str1;
    }
    return getIntent().getStringExtra("url");
  }
  
  public Share getShare()
  {
    return a();
  }
  
  public int getTitleBarHeight()
  {
    return super.getTitleBarHeight();
  }
  
  public CustomWebView getWebView()
  {
    return this.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public int h(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_titlebar");
    a(getIntent(), this.ab);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.t = paramBundle.getInt("uin_type");
      this.aw = paramBundle.getString("puin");
      this.ax = paramBundle.getString("msg_id");
      if (this.ax == null) {
        this.ax = "";
      }
      this.ay = paramBundle.getString("source_puin");
      if (this.ay == null) {
        this.ay = "";
      }
      this.az = paramBundle.getString("friendUin");
      if (this.az == null) {
        this.az = "";
      }
      boolean bool = paramBundle.getBoolean("isOpeningQunApp");
      this.L = paramBundle.getInt("appid");
      this.M = paramBundle.getInt("troopid");
      String str = paramBundle.getString("extraParams");
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      if (Boolean.valueOf(bool).booleanValue())
      {
        this.leftView.setText(getResources().getString(2131367975));
        a(this.L, paramBundle, new mcf(this));
      }
    }
    this.W = 8;
    ((SwiftBrowserShareMenuHandler)b().a(4)).d();
    Util.b("Web_qqbrowser_state_machine_init_titlebar");
    return 1;
  }
  
  public void h()
  {
    Util.a("Web_readyToLoadUrl");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      return;
    }
    b();
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.d) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.g > 0L))
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.g) / 1000000L), "", "", "", "" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.g = 0L;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.n = System.currentTimeMillis();
    long l1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.n;
    l1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_b_of_type_Long;
    if (!TextUtils.isEmpty(this.ab)) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.ab);
    }
    Util.b("Web_readyToLoadUrl");
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.ab, 0, 0, 0, 0, 0, null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public void hideQQBrowserButton()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public boolean isActivityResume()
  {
    return super.isResume();
  }
  
  public boolean isFullScreen()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.W != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
      this.W = 0;
    }
    if ((TextUtils.isEmpty(this.ab)) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)) {
      this.ab = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(getApplicationContext(), this.ab);
    AIOOpenWebMonitor.c(getIntent());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {}
    label692:
    label719:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetImageView)
            {
              if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())
              {
                paramView = new HashMap(1);
                paramView.put("target", Integer.valueOf(2));
                if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.a(paramView)) {
                  g();
                }
              }
            }
            else if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidWidgetImageView)
            {
              if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoForward()) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.b((Map)null))) {
                g();
              }
            }
            else if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d)
            {
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl()))
              {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Boolean = false;
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.n = System.currentTimeMillis();
                this.jdField_a_of_type_ComTencentBizUiTouchWebView.reload();
                this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnCustomScrollChangeListener(null);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 1, 0, 0, 0, 0, null);
                return;
              }
              paramView = getCurrentUrl();
              if (!TextUtils.isEmpty(paramView))
              {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Boolean = false;
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.n = System.currentTimeMillis();
                this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramView);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, paramView, 1, 0, 0, 0, 0, null);
              }
            }
            else
            {
              if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidViewView)
              {
                paramView = (SwiftBrowserTBSHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(16);
                if (paramView != null) {}
                try
                {
                  paramView.d();
                  paramView.e();
                  if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.hasEnded()))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
                    if (QLog.isColorLevel()) {
                      QLog.d("QQBrowser", 2, "QB icon animation is canceled");
                    }
                  }
                  HashMap localHashMap = new HashMap();
                  localHashMap.put("ChannelID", getApplication().getPackageName());
                  localHashMap.put("PosID", "5");
                  localHashMap.put("StatKey", "AGNI1");
                  localHashMap.put("entryId", "7");
                  if ((paramView != null) && (!QbSdk.startQbOrMiniQBToLoadUrl(this, this.ab, localHashMap, null))) {
                    paramView.a("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=50079", false);
                  }
                  ReportCenter.a().a("", "", "", "1000", "105", "0", false);
                  ReportController.b(null, "P_CliOper", "VIPCOMIC", "", "0X80061A1", "0X80061A1", 1000, 0, Util.b(this.ab, new String[0]), null, null, null);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  for (;;)
                  {
                    localThrowable.printStackTrace();
                  }
                }
              }
              if ((paramView == this.rightViewImg) || (paramView == this.rightHighLView))
              {
                paramView = new Intent();
                paramView.setAction("SignInSbumited");
                sendBroadcast(paramView);
                if (!a())
                {
                  ReportCenter.a().a("", "", "", "1000", "100", "0", false);
                  showActionSheet();
                }
                if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewView != null)
                {
                  paramView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewView.getParent();
                  if ((paramView != null) && ((paramView instanceof ViewGroup))) {
                    ((ViewGroup)paramView).removeView(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewView);
                  }
                }
              }
              else
              {
                if (paramView != this.rightViewText) {
                  break;
                }
                paramView = new Intent();
                paramView.setAction("SignInSbumited");
                sendBroadcast(paramView);
                if (!a())
                {
                  if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k) {
                    break label692;
                  }
                  onBackPressed();
                }
                for (;;)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewView == null) {
                    break label719;
                  }
                  paramView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewView.getParent();
                  if ((paramView == null) || (!(paramView instanceof ViewGroup))) {
                    break;
                  }
                  ((ViewGroup)paramView).removeView(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewView);
                  return;
                  ReportCenter.a().a("", "", "", "1000", "100", "0", false);
                  showActionSheet();
                }
              }
            }
          }
          if (paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_c_of_type_AndroidWidgetImageView) {
            break;
          }
          a(d(), false);
        } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewView == null);
        ThreadManager.b().post(new mck(this));
        return;
        if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_h_of_type_AndroidViewView)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.setBackgroundResource(2130839488);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_c_of_type_AndroidViewView.setVisibility(8);
          finish();
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "exit", "", "", "");
          return;
        }
        if (paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.i)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.setBackgroundResource(2130839488);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_c_of_type_AndroidViewView.setVisibility(8);
          showActionSheet();
          ReportCenter.a().a("", "", "", "1000", "100", "0", false);
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "share", "", "", "");
          return;
        }
      } while (paramView != this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.j);
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("key_isReadModeEnabled", true);
      paramView.putExtra("url", "http://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
      startActivity(paramView);
      finish();
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "mUIStyleHandler.moreGame", "http://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("zivonchen", 2, "QQBrowserActivity 1 loadUrl = http://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Configuration", paramConfiguration);
    localBundle.putBoolean("is_initView", this.n);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4, localBundle);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AIOOpenWebMonitor.a(getIntent());
    SwiftBrowserNavigator localSwiftBrowserNavigator = (SwiftBrowserNavigator)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(1);
    if ((localSwiftBrowserNavigator != null) && (!localSwiftBrowserNavigator.a(getIntent())))
    {
      finish();
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(getIntent());
    Util.a("Web_qqbrowser_oncreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.o = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.jdField_c_of_type_Long);
    Util.b("Web_qqbrowser_oncreate");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    super.onTouch(paramView, paramMotionEvent);
    if (((paramMotionEvent.getAction() & 0xFF) == 0) && (paramView.getId() == 2131299546))
    {
      paramMotionEvent = paramView.getParent();
      if ((paramMotionEvent != null) && ((paramMotionEvent instanceof ViewGroup))) {
        ((ViewGroup)paramMotionEvent).removeView(paramView);
      }
    }
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentBizWebviewpluginHole != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentBizWebviewpluginHole.setHole((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.getLeft() + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.getRight()) / 2 - 1, (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.getTop() + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.e.getBottom()) / 2 - 1, (int)(30.0F * getResources().getDisplayMetrics().density));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentBizWebviewpluginHole.invalidate();
    }
  }
  
  protected void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.mCanLock) && (!TextUtils.isEmpty(this.jdField_J_of_type_JavaLangString)) && (GesturePWDUtils.getGesturePWDState(this, this.jdField_J_of_type_JavaLangString) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.jdField_J_of_type_JavaLangString) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    if (getWindow().getContainer() == null) {
      requestWindowFeature(7);
    }
  }
  
  public void setBottomBarVisible(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b(paramBoolean);
  }
  
  public void setImmersiveStatus()
  {
    super.setImmersiveStatus();
  }
  
  public boolean setShareUrl(String paramString)
  {
    return a().a(paramString);
  }
  
  public boolean setSummary(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return a().a(paramString1, paramString2, paramString3, paramString4, paramBundle);
  }
  
  public void showActionSheet()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler != null) {
      localSwiftBrowserShareMenuHandler.a(a(), this.jdField_c_of_type_Long);
    }
  }
  
  public boolean showPreview()
  {
    Util.a("Web_qqbrowser_ShowPreview");
    long l1 = System.nanoTime();
    f();
    Object localObject = WebAccelerateHelper.getInstance().preloadBrowserView;
    if (WebAccelerateHelper.getInstance().preloadBrowserView != null) {
      WebAccelerateHelper.getInstance().preloadBrowserView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean)
    {
      getWindow().setFlags(1024, 1024);
      if (localObject != null) {
        setContentViewNoTitle((View)localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQBrowser", 2, "init view 1, cost = " + (System.nanoTime() - l1) / 1000000L);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131297005));
      ((FrameLayout)findViewById(2131297378)).setVisibility(8);
      Util.b("Web_qqbrowser_ShowPreview");
      return true;
      setContentViewNoTitle(2130903153);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.l))
      {
        if (localObject != null) {
          setContentViewNoTitle((View)localObject);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131297376));
          LayoutInflater.from(this).inflate(2130903157, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup);
          init(getIntent());
          localObject = (RelativeLayout.LayoutParams)this.vg.getLayoutParams();
          float f2 = UITools.a(getApplicationContext(), 50.0F);
          float f1 = f2;
          if (b()) {
            f1 = f2 + ImmersiveUtils.a(this);
          }
          ((RelativeLayout.LayoutParams)localObject).height = ((int)f1);
          if (b())
          {
            this.vg.setFitsSystemWindows(true);
            this.vg.setPadding(0, ImmersiveUtils.a(this), 0, 0);
            getWindow().addFlags(67108864);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.l) {
            this.vg.setOnTouchListener(null);
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.m = true;
          break;
          setContentViewNoTitle(2130903153);
        }
      }
      this.mNeedStatusTrans = true;
      this.mActNeedImmersive = true;
      setImmersiveStatus();
      if (this.mSystemBarComp != null) {
        this.mSystemBarComp.init();
      }
      if (localObject != null) {
        setContentView((View)localObject);
      } else {
        setContentView(2130903153);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\QQBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */