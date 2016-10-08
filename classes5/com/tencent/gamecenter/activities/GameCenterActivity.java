package com.tencent.gamecenter.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.WebAIOController;
import com.tencent.biz.webviewbase.WebAIOController.Builder;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.common.util.ReportInfoManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.open.base.APNUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;

public class GameCenterActivity
  extends QQBrowserActivity
  implements Handler.Callback
{
  public static final int a = 2003;
  public static long a = 0L;
  public static final String a;
  public static final int b = 2004;
  public static long b = 0L;
  public static final int c = 2006;
  public static final int d = 5127;
  public static final int e = 3;
  public static int f;
  public Handler a;
  private DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  private WebAIOController jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController;
  protected boolean a;
  private AppInterface b;
  protected String b;
  public boolean b;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private String d = "";
  public long g;
  private long h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = GameCenterActivity.class.getSimpleName();
  }
  
  public GameCenterActivity()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appids", paramString2);
    paramString2 = "uin=" + paramString3;
    paramString3 = new Bundle();
    paramString3.putString("Cookie", paramString2);
    try
    {
      paramContext = HttpUtil.a(paramContext, paramString1, "POST", localBundle, paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest: result:" + paramContext);
      }
      return paramContext;
    }
    catch (ClientProtocolException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest:ClientProtocolException");
      }
      return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenter", 2, "httpRequest:" + paramContext.getMessage());
      }
    }
    return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_b_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface;
    }
    if (this.jdField_b_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ComTencentCommonAppAppInterface.a();
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.ab)) && (b(this.ab))) {}
      try
      {
        String str = Uri.parse(this.ab).getQueryParameter("uin");
        if (str == null)
        {
          this.ab = HtmlOffline.a(this.ab, "uin=" + this.jdField_b_of_type_JavaLangString);
          getIntent().putExtra("url", this.ab);
        }
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "GameCenterActivity..gcRuntime is null");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject = null;
        }
      }
    }
  }
  
  private String b()
  {
    String str = "http://gamecenter.qq.com/front/release/index/index.html?plat=qq&_wv=5127";
    if (!TextUtils.isEmpty(this.d)) {
      str = "http://gamecenter.qq.com/front/release/index/index.html?plat=qq&_wv=5127" + "&" + this.d;
    }
    return str + "&st=" + this.h;
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("_bid");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void b(String paramString)
  {
    String str3 = null;
    try
    {
      boolean bool = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
      String str1 = str3;
      if (!bool) {}
      for (;;)
      {
        try
        {
          str1 = Uri.parse(this.jdField_c_of_type_JavaLangString).getQueryParameter("status");
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "parseExtraParamToReport , status" + str1);
          }
          if (!TextUtils.isEmpty(str1))
          {
            if (TextUtils.isEmpty(paramString))
            {
              paramString = "0";
              str3 = APNUtil.a(getApplicationContext());
              String str4 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels + " * " + this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
              paramString = ReportInfoManager.a().a(this.jdField_b_of_type_JavaLangString, str1, paramString, str3, str4);
              ReportInfoManager.a().a(paramString);
            }
          }
          else {
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          String str2 = str3;
        }
      }
    }
    finally {}
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = null;
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("status");
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
    }
    return true;
  }
  
  protected int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if (this.centerView != null)
    {
      this.centerView.setVisibility(0);
      if ((this.centerView instanceof TextView)) {
        this.centerView.setText(2131366099);
      }
    }
    return i;
  }
  
  protected WebAIOController a()
  {
    WebAIOController.Builder localBuilder = new WebAIOController.Builder(getTitleBarView());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.jdField_c_of_type_Long & 0xFFFFFFFF80000000) != 0L)
    {
      bool1 = bool2;
      if (WebAccelerateHelper.getInstance().isEnableWebAio()) {
        bool1 = true;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("enable_switch", bool1);
    localBundle.putString("banner_txt", "返回游戏中心继续浏览");
    localBundle.putInt("banner_icon_res", 2130837681);
    this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController = localBuilder.a(localBundle).a();
    return this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController;
  }
  
  protected String a()
  {
    return "gamecenter";
  }
  
  protected void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (b(paramString))) {
      jdField_b_of_type_Long = System.currentTimeMillis();
    }
    super.a(paramWebView, paramString, paramBitmap);
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      localObject = null;
    }
    while ((!this.jdField_c_of_type_Boolean) && (!paramString.startsWith("data")) && (localObject != null))
    {
      localObject = ((WebViewPluginEngine)localObject).a("offline");
      if ((localObject != null) && ((localObject instanceof OfflinePlugin)))
      {
        if (((OfflinePlugin)localObject).c == 0) {
          b("0");
        }
      }
      else
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
        continue;
      }
      b(HtmlOffline.d(b(paramString)));
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void b()
  {
    super.b();
    a();
  }
  
  protected void b(WebView paramWebView, String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.i))
    {
      if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack())) {
        break label58;
      }
      this.leftView.setText(2131366637);
    }
    for (;;)
    {
      a(paramString);
      this.jdField_b_of_type_Boolean = false;
      super.b(paramWebView, paramString);
      return;
      label58:
      setLeftViewName(getIntent());
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    f += 1;
    this.h = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    if (getIntent() != null)
    {
      this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("url");
      this.d = getIntent().getStringExtra("redTouch");
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        this.jdField_c_of_type_JavaLangString = b();
        getIntent().putExtra("url", this.jdField_c_of_type_JavaLangString);
      }
      Object localObject;
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (b(this.jdField_c_of_type_JavaLangString)))
      {
        jdField_a_of_type_Long = getIntent().getLongExtra("plugin_start_time", 0L);
        if (jdField_a_of_type_Long == 0L) {
          localObject = null;
        }
      }
      try
      {
        String str = Uri.parse(this.jdField_c_of_type_JavaLangString).getQueryParameter("st");
        localObject = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        jdField_a_of_type_Long = Long.valueOf((String)localObject).longValue();
      }
    }
    for (;;)
    {
      super.doOnCreate(paramBundle);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
      MyAppApi.a().b(this, "ANDROIDQQ.WIFIDLYYB.GAME", 2);
      return true;
      Toast.makeText(getApplicationContext(), 2131366102, 0).show();
      finish();
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    f -= 1;
    if (f == 0)
    {
      this.g = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController != null) {
        this.jdField_a_of_type_ComTencentBizWebviewbaseWebAIOController.a(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "enterGameCenterTime = " + jdField_a_of_type_Long + " , startLoadGameCenterTime = " + jdField_b_of_type_Long + " , exitGameCenterTime = " + this.g);
      }
      VipUtils.a(this.app, "vip", "0X8004BFB", "0X8004BFB", 0, 0, new String[] { String.valueOf(jdField_a_of_type_Long), String.valueOf(jdField_b_of_type_Long), String.valueOf(this.g) });
    }
    super.doOnDestroy();
    System.gc();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    switch (paramMessage.what)
    {
    case 2005: 
    default: 
      return true;
    case 2003: 
      startTitleProgress();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2004, 45000L);
      return true;
    case 2004: 
      stopTitleProgress();
      return true;
    }
    Toast.makeText(getApplicationContext(), (String)paramMessage.obj, 0).show();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\gamecenter\activities\GameCenterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */