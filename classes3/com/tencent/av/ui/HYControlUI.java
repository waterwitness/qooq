package com.tencent.av.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TipsManager.TipsListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.c2b.C2BBrowserActivity;
import cooperation.c2b.C2BWebPlugin;
import cooperation.huangye.C2BAuthorisationActivity;
import cooperation.huangye.HYSharedPref;
import cooperation.qzone.QZoneHelper;
import gui;
import guj;
import guk;
import gul;
import gum;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HYControlUI
  extends DoubleVideoCtrlUI
  implements TipsManager.TipsListener
{
  public static CustomWebView a;
  static final String jdField_b_of_type_JavaLangString = "HYControlUI";
  public static final String c = "com.tencent.mobile.qq.action.hycontroluiready";
  public static final String d = ".qq.com";
  public static final String e = "about:blank";
  public static final String f = "mqqc2b://callcenter/";
  public static final String g = "onWebReady";
  public static final String h = "doClientReport";
  public static final String i = "clientShowAudioWave";
  public static final String j = "clientShowPage";
  public static final String k = "clientLog";
  public static final String l = "getCallTime";
  public static final String m = "clientSendDtmf";
  public static final String n = "clientShowLoadingPage";
  public static final String o = "getEnvInfo";
  public static final String p = "getAuthorisation";
  public static final String q = "gotoArtificial";
  public long a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public Button a;
  public EditText a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver;
  guj jdField_a_of_type_Guj;
  gul jdField_a_of_type_Gul;
  public long b;
  public View b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  View jdField_c_of_type_AndroidViewView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public RelativeLayout d;
  TextView d;
  TextView e;
  TextView f;
  public TextView g;
  boolean g;
  public boolean h;
  boolean i;
  boolean j;
  public boolean k;
  public String r;
  public String s;
  public String t;
  String u;
  String v;
  
  public HYControlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver, String paramString)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.r = "http://sqimg.qq.com/qq_product_operations/c2b/1.0.1/app/index.html";
    this.s = "http://sqimg.qq.com/qq_product_operations/c2b/2.0.1/app/index.html";
    this.jdField_g_of_type_Boolean = false;
    this.t = null;
    this.u = null;
    this.v = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_d_of_type_AndroidWidgetTextView = null;
    this.e = null;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.f = null;
    this.jdField_a_of_type_Gul = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidWidgetEditText = null;
    this.jdField_g_of_type_AndroidWidgetTextView = null;
    this.j = false;
    this.k = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new gui(this);
    this.t = this.jdField_a_of_type_ComTencentAvVideoController.a().c;
    this.jdField_a_of_type_Gul = new gul(this, null);
    this.u = this.t;
    int i1 = 10 - this.u.length();
    if (i1 > 0) {
      this.u = (String.format(new StringBuilder().append("%0").append(i1).append("d").toString(), new Object[] { Integer.valueOf(0) }) + this.u);
    }
    this.u = ("c2bBizUin=o" + this.u);
    this.v = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount();
    i1 = 10 - this.v.length();
    if (i1 > 0) {
      this.v = (String.format(new StringBuilder().append("%0").append(i1).append("d").toString(), new Object[] { Integer.valueOf(0) }) + this.v);
    }
    this.v = ("uin=o" + this.v);
    paramVideoAppInterface = a();
    if ((paramVideoAppInterface != null) && (!paramVideoAppInterface.equals(""))) {
      this.r = paramVideoAppInterface;
    }
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
      j(true);
    }
  }
  
  private void I()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    long l1 = System.currentTimeMillis();
    Object localObject2;
    if (jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null)
    {
      jdField_a_of_type_ComTencentBizPubaccountCustomWebView = new CustomWebView(localActivity.getApplicationContext());
      localObject1 = new LinearLayout.LayoutParams(-1, -1);
      jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      jdField_a_of_type_ComTencentBizPubaccountCustomWebView.addJavascriptInterface(new guk(null), "mqqc2bclient");
      WebSettings localWebSettings = jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings();
      localWebSettings.setJavaScriptEnabled(true);
      localObject2 = localWebSettings.getUserAgentString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localWebSettings.setUserAgentString((String)localObject1 + " " + QZoneHelper.a() + " " + "QQ/" + "6.5.5" + "." + "2880");
      localWebSettings.setSaveFormData(false);
      localWebSettings.setSavePassword(false);
      localWebSettings.setPluginsEnabled(true);
      localWebSettings.setDatabaseEnabled(true);
      localWebSettings.setDomStorageEnabled(true);
      localWebSettings.setAppCacheEnabled(true);
      localWebSettings.setPluginState(WebSettings.PluginState.ON);
      localWebSettings.setDefaultTextEncodingName("utf-8");
      localWebSettings.setSupportZoom(false);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
      jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setBackgroundColor(0);
      jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getBackground().setAlpha(0);
      jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setContentDescription("可视化菜单");
    }
    Object localObject1 = new ArrayList();
    try
    {
      ((List)localObject1).add(new SosoPlugin());
      localObject1 = new WebViewPluginEngine(jdField_a_of_type_ComTencentBizPubaccountCustomWebView, localActivity, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (List)localObject1);
      ((WebViewPluginEngine)localObject1).a(new String[] { "mqqc2b" });
      localObject2 = (C2BWebPlugin)((WebViewPluginEngine)localObject1).a("mqqc2b");
      if (localObject2 != null) {
        ((C2BWebPlugin)localObject2).a(0);
      }
      localObject2 = new gum(this, (WebViewPluginEngine)localObject1);
      jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setPluginEngine((WebViewPluginEngine)localObject1);
      jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setWebViewClient((WebViewClient)localObject2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
      if (QLog.isDevelopLevel()) {
        QLog.d("HYControlUI", 2, "initWebView cost time = " + (System.currentTimeMillis() - l1));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("HYControlUI", 2, "Create C2BWebPlugin fail : " + localException.toString());
        }
      }
    }
  }
  
  private void J()
  {
    jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:window.webc2b.showArtPage(\"\")");
  }
  
  private void a(Context paramContext)
  {
    if (ImmersiveUtils.isSupporImmersive() == 0)
    {
      int i1 = ImmersiveUtils.a(paramContext);
      paramContext = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramContext.topMargin -= i1;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramContext);
      paramContext = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      paramContext.topMargin -= i1;
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramContext);
    }
  }
  
  void G()
  {
    this.f.setVisibility(8);
    l(false);
    a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ".qq.com");
    j(true);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(b());
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    k(false);
  }
  
  protected int a()
  {
    return 2130903534;
  }
  
  public int a(String paramString, char paramChar)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("HYControlUI", 4, "sendDTMFMessage:num = " + paramChar);
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, paramChar);
  }
  
  protected String a()
  {
    String str2 = "";
    String str1 = str2;
    Object localObject;
    if ("".length() < 4)
    {
      localObject = HYSharedPref.a().a("FileConfigure", "");
      str1 = str2;
      if (((String)localObject).equals("")) {}
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      str1 = str2;
      if (((JSONObject)localObject).has("ivr_url")) {
        str1 = ((JSONObject)localObject).getString("ivr_url");
      }
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    if (localJSONArray != null)
    {
      localJSONArray.put("doClientReport");
      localJSONArray.put("clientShowAudioWave");
      localJSONArray.put("clientShowPage");
      localJSONArray.put("clientLog");
      localJSONArray.put("getCallTime");
      localJSONArray.put("clientSendDtmf");
      localJSONArray.put("clientShowLoadingPage");
      localJSONArray.put("getEnvInfo");
      localJSONArray.put("getAuthorisation");
    }
    return localJSONArray;
  }
  
  public void a(Context paramContext, String paramString)
  {
    CookieSyncManager.createInstance(paramContext);
    paramContext = CookieManager.getInstance();
    paramContext.setAcceptCookie(true);
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    paramContext.setCookie(paramString, this.u);
    paramContext.setCookie(paramString, this.v);
    paramContext.setCookie(paramString, "skey=" + str);
    paramContext.setCookie(paramString, "clientVersion=6.5.5");
    paramContext.setCookie(paramString, "c2bkey=" + str);
    CookieSyncManager.getInstance().sync();
  }
  
  void a(Bitmap paramBitmap) {}
  
  void a(String paramString, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt)
  {
    paramString = String.format("javascript:window.webc2b.setNoticeTip('%s',%d,%s,%d,%d)", new Object[] { paramString, Long.valueOf(paramLong1), Boolean.valueOf(paramBoolean), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString);
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (paramString.equals("正在转接对方手机")) {}
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, long paramLong, String paramString, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HYControlUI", 2, "showTips = " + paramBoolean1 + ",type = " + paramInt + ",isResident = " + paramBoolean2 + ",period = " + paramLong + ",msg = " + paramString + ",showIcon = " + paramBoolean3 + ",showLoading = " + paramBoolean4);
    }
    int i1 = 0;
    if (paramBoolean4) {
      i1 = 1;
    }
    if (paramBoolean3) {
      i1 = 2;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().u) {
      if (paramString == null) {
        break label147;
      }
    }
    for (;;)
    {
      a(paramString, paramInt, paramBoolean2, paramLong, i1);
      return;
      label147:
      paramString = "";
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QLog.d("HYControlUI", 4, "telAuthorisation Enter");
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject != null) && ((localObject instanceof Activity)))
    {
      localObject = (Activity)localObject;
      Intent localIntent = new Intent((Context)localObject, C2BAuthorisationActivity.class);
      localIntent.putExtra("bind_state", paramBoolean);
      localIntent.putExtra("app_id", paramString1);
      localIntent.putExtra("scope", paramString4);
      localIntent.putExtra("package_name", paramString2);
      localIntent.putExtra("sign_md5", paramString3);
      localIntent.putExtra("param_callback", paramString5);
      ((Activity)localObject).startActivity(localIntent);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 == this.j)) {
      return;
    }
    this.j = paramBoolean2;
    super.a(paramBoolean1, paramBoolean2);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public String b()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().x != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().x.equals("1")) {
        str1 = "#directartificial=1";
      }
    }
    return this.r + "?uin=" + this.t + str1;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().u) {
      l(paramInt1);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject != null) && ((localObject instanceof Activity)))
    {
      localObject = (Activity)localObject;
      Intent localIntent = new Intent((Context)localObject, C2BBrowserActivity.class);
      localIntent.putExtra("caller", getClass().getName());
      localIntent.putExtra("portraitOnly", true);
      localIntent.putExtra("url", paramString1);
      localIntent.putExtra("fromType", 0);
      if (!TextUtils.isEmpty(paramString2))
      {
        localIntent.putExtra("destroynotify", true);
        localIntent.putExtra("dtmf", paramString2);
      }
      ((Activity)localObject).startActivity(localIntent);
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      a(this.t, paramString1.charAt(0));
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = String.format("javascript:window.%s(%d)", new Object[] { paramString2, Integer.valueOf(0) });
        jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString1);
      }
    }
  }
  
  public void d()
  {
    super.d();
    Object localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localObject1 != null) && (AVActivity.class.isInstance(localObject1)))
    {
      localObject1 = (AVActivity)localObject1;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((AVActivity)localObject1).findViewById(2131299071));
      I();
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299064));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((AVActivity)localObject1).findViewById(2131299062));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((AVActivity)localObject1).findViewById(2131299063));
      this.e = ((TextView)((AVActivity)localObject1).findViewById(2131299067));
      this.f = ((TextView)((AVActivity)localObject1).findViewById(2131299059));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299070));
      this.jdField_h_of_type_AndroidWidgetTextView = this.e;
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null) {
        break label935;
      }
      Object localObject2 = (LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299068);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a((LinearLayout)localObject2);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(false);
      if (QLog.isColorLevel()) {
        QLog.d("HYControlUI", 2, "onCreate set tips layout");
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.d(0);
      }
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvVideoController.a().d);
      }
      localObject2 = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((AVActivity)localObject1).findViewById(2131299069));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299055));
      Object localObject3 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((Resources)localObject2).getDimensionPixelSize(2131494166);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = ((Resources)localObject2).getDimensionPixelSize(2131494167);
      ((RelativeLayout.LayoutParams)localObject3).height = ((Resources)localObject2).getDimensionPixelSize(2131494167);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299061);
      a((Context)localObject1);
      localObject2 = ((AVActivity)localObject1).getIntent();
      if ((localObject2 != null) && (((Intent)localObject2).getIntExtra("uinType", -1) != -1))
      {
        localObject3 = new Intent("com.tencent.mobile.qq.action.hycontroluiready");
        ((Intent)localObject3).putExtra("uin", ((Intent)localObject2).getStringExtra("uin"));
        ((Intent)localObject3).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject3);
      }
      if ("3316870573".equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_b_of_type_AndroidViewView = ((AVActivity)localObject1).findViewById(2131299072);
        this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131299075);
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131299074));
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131299073));
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131299077).setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131299078).setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131299076).setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131299079).setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131299080).setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131299081).setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131299082).setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299084).setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131299083));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_Gul);
        this.jdField_h_of_type_Boolean = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSharedPreferences("hycontrolui", 0).getBoolean("isWebViewCacheable", true);
        localObject2 = this.jdField_a_of_type_AndroidWidgetButton;
        if (!this.jdField_h_of_type_Boolean) {
          break label953;
        }
        localObject1 = "webcacheOff";
        label766:
        ((Button)localObject2).setText((CharSequence)localObject1);
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
        break label1010;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().u) {
        break label960;
      }
      G();
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("HYControlUI", 2, "onCreate isConnected = " + this.jdField_a_of_type_ComTencentAvVideoController.a().f());
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(this);
      this.jdField_a_of_type_Guj = new guj(this, null);
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("tencent.c2b.action.REQUEST_SEND_DTMF");
      ((IntentFilter)localObject1).addAction("tencent.c2b.action.REQUEST_MIC_STATE");
      ((IntentFilter)localObject1).addAction("tencent.c2b.action.C2BBrowser.destory");
      ((IntentFilter)localObject1).addAction("tencent.c2b.action.tel.authorisation");
      ((IntentFilter)localObject1).addAction("tencent.c2b.action.C2BBrowser.call.arti");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().registerReceiver(this.jdField_a_of_type_Guj, (IntentFilter)localObject1);
      return;
      label935:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("HYControlUI", 2, "onCreate mTipsManager == null , faild to set tipsLayout");
      break;
      label953:
      localObject1 = "webcacheOn";
      break label766;
      label960:
      this.jdField_g_of_type_Boolean = true;
      l(false);
      j(true);
      this.f.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      k(this.jdField_a_of_type_ComTencentAvVideoController.a().v);
      continue;
      label1010:
      if (jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
      {
        jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a("about:blank");
        if (QLog.isDevelopLevel()) {
          QLog.i("HYControlUI", 2, "onCreate isConnected = false but mMenuWeb != null then load about:blank");
        }
      }
      l(true);
      j(false);
      this.f.setVisibility(0);
      k(true);
    }
  }
  
  void d(String paramString1, String paramString2)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("bizuin", this.t);
      localHashMap.put("bizname", URLEncoder.encode(this.jdField_a_of_type_ComTencentAvVideoController.a().d, "UTF-8"));
      localHashMap.put("menuid", paramString1);
      localHashMap.put("menuname", URLEncoder.encode(paramString2, "UTF-8"));
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), "actC2BWebMenuInfo", true, 0L, 0L, localHashMap, null, true);
      return;
    }
    catch (UnsupportedEncodingException paramString1) {}
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (paramString1.equals("1"))
    {
      QLog.i("C2BWebLog", 1, paramString2);
      return;
    }
    QLog.i("C2BWebLog", 2, paramString2);
  }
  
  public void f(String paramString)
  {
    jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:window." + paramString + "(" + this.jdField_a_of_type_ComTencentAvVideoController.b() + ")");
  }
  
  public void g()
  {
    super.g();
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = true;
      H();
      this.jdField_i_of_type_Boolean = false;
    }
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
      k(this.jdField_a_of_type_ComTencentAvVideoController.a().v);
    }
  }
  
  public void g(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("strBizUin", this.t);
      localJSONObject.put("strJsonContext", paramString);
      if (jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
        jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:window.webc2b.showPushPage( '" + localJSONObject.toString() + "')");
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void h(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sessionInfo", this.jdField_a_of_type_ComTencentAvVideoController.a().m);
      localJSONObject.put("innerAbilityList", a());
      jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:window." + paramString + "('" + localJSONObject.toString() + "')");
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void i(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.getInt("reportType") == 1)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("bizuin", this.t);
        localHashMap.put("bizname", URLEncoder.encode(this.jdField_a_of_type_ComTencentAvVideoController.a().d, "UTF-8"));
        localHashMap.put("menuid", paramString.getString("menuid"));
        localHashMap.put("menuname", URLEncoder.encode(paramString.getString("menuname"), "UTF-8"));
        localHashMap.put("keyID", paramString.getString("keyID"));
        localHashMap.put("keyName", URLEncoder.encode(paramString.getString("keyName"), "UTF-8"));
        localHashMap.put("keyValue", URLEncoder.encode(paramString.getString("keyValue"), "UTF-8"));
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(), "actC2BInsuranceInquiryPageInfo", true, 0L, 0L, localHashMap, null, true);
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (UnsupportedEncodingException paramString) {}
  }
  
  void j(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    while (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void k()
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 1000L) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().u = false;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(this);
    this.jdField_i_of_type_AndroidWidgetTextView = null;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
    if (jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
    {
      jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setWebViewClient(null);
      localObject = jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a();
      if (localObject != null)
      {
        ((WebViewPluginEngine)localObject).a(jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl(), 8589934596L, null);
        ((WebViewPluginEngine)localObject).a();
      }
    }
    if (this.jdField_a_of_type_Guj != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().unregisterReceiver(this.jdField_a_of_type_Guj);
    }
    Object localObject = new Intent("tencent.c2b.action.C2B_DESTORY");
    ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().getPackageName());
    ((Intent)localObject).putExtra("caller", getClass().getName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast((Intent)localObject);
    super.k();
  }
  
  public void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(0);
      this.jdField_a_of_type_ComTencentAvUiQavPanel.d();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.e();
  }
  
  void l(int paramInt) {}
  
  void l(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
    while (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void m()
  {
    super.m();
    if (QLog.isColorLevel()) {
      QLog.d("HYControlUI", 2, "onConnected!");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().l = null;
    G();
  }
  
  public void m(int paramInt)
  {
    jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl("javascript:window.webc2b.onNetworkChange(" + paramInt + ")");
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.j == paramBoolean) {
      return;
    }
    this.j = paramBoolean;
    this.jdField_a_of_type_ComTencentAvVideoController.b(paramBoolean);
    super.a(true, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\HYControlUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */