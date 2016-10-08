package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewplugin.Hole;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import wjh;
import wji;
import wjj;
import wjl;

public class SwiftBrowserUIStyleHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements View.OnClickListener
{
  public static final String a;
  public static final String b = "left_close_button_text";
  public static final String c = "hide_left_button";
  public static final String d = "show_right_close_button";
  public static final String e = "Web_updateTitleBarUI";
  public static final String f = "Configuration";
  public static final String g = "is_initView";
  private int jdField_a_of_type_Int;
  public Activity a;
  public View a;
  public ViewGroup a;
  public FrameLayout a;
  public ImageView a;
  public ProgressBar a;
  public TextView a;
  public RefreshView a;
  public Hole a;
  SwiftBrowserStatistics jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics = null;
  public final SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle a;
  public final SwiftBrowserUIStyleHandler.SwiftIphoneTitleBarUI a;
  public WebViewProgressBar a;
  public WebViewProgressBarController a;
  public boolean a;
  private int b;
  public View b;
  public ViewGroup b;
  public ImageView b;
  public View c;
  public ImageView c;
  public View d;
  public ImageView d;
  public View e;
  public View f;
  public View g;
  public View h;
  public String h;
  public View i;
  public View j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SwiftBrowserUIStyleHandler.class.getSimpleName();
  }
  
  public SwiftBrowserUIStyleHandler()
  {
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle = new SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI = new SwiftBrowserUIStyleHandler.SwiftIphoneTitleBarUI();
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) || (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.g)) {}
    ViewStub localViewStub;
    do
    {
      return;
      localViewStub = (ViewStub)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299837);
    } while (localViewStub == null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localViewStub.inflate());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131298843));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297425));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299841));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (TextUtils.isEmpty(BaseApplicationImpl.a().a().getAccount())) {
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
    }
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297448));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299838);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.postDelayed(new wjl(this), 400L);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
      ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarView();
    }
    if (0 == 0) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p = false;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p = true;
        throw new NullPointerException();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q) || (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.p = true;
    this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131428295);
    throw new NullPointerException();
  }
  
  public int a()
  {
    try
    {
      int k = ((Integer)Class.forName("com.android.internal.R$dimen").getField("status_bar_height").get(null)).intValue();
      k = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(k);
      return k;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 38;
  }
  
  public JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Uri localUri;
    Object localObject;
    do
    {
      do
      {
        return null;
      } while (Build.VERSION.SDK_INT < 11);
      localUri = Uri.parse(paramString);
      localObject = localUri.getQueryParameterNames();
    } while ((localObject == null) || (((Set)localObject).size() == 0));
    paramString = new JSONObject();
    try
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        if (str1.contains("_nav_"))
        {
          String str2 = localUri.getQueryParameter(str1);
          paramString.put(str1.replace("_nav_", ""), str2);
          continue;
          return paramString;
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString = null;
    }
    for (;;) {}
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics = ((SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2));
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = null;
    super.a(paramInt, paramBundle);
    switch (paramInt)
    {
    case 5: 
    default: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          do
          {
            return;
            Util.a("Web_updateTitleBarUI");
            if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.n) {
              f();
            }
            Util.b("Web_updateTitleBarUI");
            return;
          } while (this.jdField_b_of_type_AndroidViewView == null);
          paramBundle = this.jdField_b_of_type_AndroidViewView.getParent();
        } while ((paramBundle == null) || (!(paramBundle instanceof ViewGroup)));
        ((ViewGroup)paramBundle).removeView(this.jdField_b_of_type_AndroidViewView);
        return;
        localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
        this.jdField_a_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
        this.jdField_b_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
        if ((this.e != null) && (8 == this.g.getVisibility()))
        {
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.e.getLayoutParams();
          localLayoutParams.leftMargin = ((int)(this.jdField_a_of_type_Int - 50.0F * ((DisplayMetrics)localObject).density));
          localLayoutParams.topMargin = ((int)(this.jdField_b_of_type_Int - ((DisplayMetrics)localObject).density * 100.0F));
          this.e.setLayoutParams(localLayoutParams);
        }
        if (paramBundle.containsKey("Configuration"))
        {
          localObject = (Configuration)paramBundle.getParcelable("Configuration");
          if (!paramBundle.containsKey("is_initView")) {
            break label319;
          }
        }
        for (boolean bool = paramBundle.getBoolean("is_initView");; bool = false)
        {
          paramInt = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[7].intValue();
          if ((localObject == null) || (1 != paramInt) || (!bool)) {
            break;
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.g) || (2 != ((Configuration)localObject).orientation)) {
            break label325;
          }
          b(false);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.t = true;
          return;
          localObject = null;
          break label238;
        }
      } while ((1 != ((Configuration)localObject).orientation) || (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.t));
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.t = false;
      return;
    case 6: 
      label238:
      label319:
      label325:
      if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.e) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.b() != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((paramBundle == null) || (!paramBundle.containsKey("url"))) {
        break;
      }
    }
    for (paramBundle = paramBundle.getString("url");; paramBundle = null)
    {
      if (!TextUtils.isEmpty(paramBundle)) {
        localObject = Uri.parse(paramBundle);
      }
      if ((localObject != null) && (((Uri)localObject).isHierarchical()) && ("simple".equals(((Uri)localObject).getQueryParameter("style"))))
      {
        b(false);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.u = true;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
      try
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText("网页由 " + Uri.parse(paramBundle).getHost() + " 提供");
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_AndroidWidgetTextView.setText("由 " + paramBundle + " 提供");
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)2);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.g) {
        break;
      }
      b(true);
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.i) {
        this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
      return;
    }
  }
  
  public void a(Intent paramIntent, TouchWebView paramTouchWebView)
  {
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297378));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299498);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Long != 0L)) {
      b();
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.p = (l1 - l2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297379));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = new WebViewProgressBarController();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.e) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.b() != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
    }
    Util.a("Web_qqbrowser_initView_WebViewWrapper");
    this.jdField_a_of_type_ComTencentBizUiRefreshView = ((RefreshView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299836));
    paramTouchWebView.setOnOverScrollHandler(this.jdField_a_of_type_ComTencentBizUiRefreshView);
    paramTouchWebView.setId(2131296688);
    this.jdField_a_of_type_ComTencentBizUiRefreshView.addView(paramTouchWebView, 0, new ViewGroup.LayoutParams(-1, -1));
    Util.b("Web_qqbrowser_initView_WebViewWrapper");
    l2 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.i = (l2 - l1);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299834));
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))) {
      ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();
    }
    if (paramTouchWebView.getX5WebViewExtension() != null) {
      this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299835).setVisibility(0);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297005));
      }
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299833);
      return;
      this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299835).setVisibility(8);
    }
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.e;
    boolean bool1 = bool3;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.c)
    {
      bool1 = bool3;
      if (this.jdField_a_of_type_AndroidAppActivity.getRequestedOrientation() != 0)
      {
        bool1 = bool3;
        if (!bool3)
        {
          bool1 = bool3;
          if (1 == com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[7].intValue()) {
            bool1 = true;
          }
        }
      }
    }
    c();
    paramIntent = new Rect();
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(paramIntent);
    if (paramIntent.top == 0) {
      a();
    }
    this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297376).setBackgroundDrawable(null);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean)
    {
      b(false);
      return;
    }
    if (!bool1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      b(bool1);
      return;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      paramView.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new wji(this, paramView, paramInt2));
    localValueAnimation.setDuration(paramInt3);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.s = true;
    paramView.startAnimation(localValueAnimation);
  }
  
  public void a(View paramView, boolean paramBoolean, int paramInt)
  {
    Object localObject = null;
    ImageView localImageView = null;
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        localObject = localImageView;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.x) {
          localObject = SkinEngine.getInstances().getDefaultThemeDrawable(paramInt);
        }
      } while (localObject == null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      return;
      if ((paramView instanceof ImageView))
      {
        localImageView = (ImageView)paramView;
        paramView = (View)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.x) {
          paramView = SkinEngine.getInstances().getDefaultThemeDrawable(paramInt);
        }
        if (paramView != null)
        {
          localImageView.setImageDrawable(paramView);
          return;
        }
        localImageView.setImageResource(paramInt);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AbsBaseWebViewActivity", 2, "-->setShowDefaultThemeIcon err! resId=" + paramInt);
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {}
    for (View localView = ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarView();; localView = null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.n) && (localView != null) && (a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.o = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.q = true;
        localView.setBackgroundResource(2130843510);
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.a().a(), false, null)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        }
        paramTouchWebView.setOnScrollChangedListener(new wjh(this));
      }
      return;
    }
  }
  
  public void a(WebView paramWebView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.g)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      if ((paramString2 != null) && (paramString2.length() != 0)) {
        break label135;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c.setVisibility(8);
      label45:
      if (TextUtils.isEmpty(paramString3)) {
        break label172;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
        ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle(paramString3);
      }
      return;
      if (paramString1.equals("RETURN")) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("leftViewText"));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      }
      label135:
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c.setText(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label45;
      label172:
      paramString3 = "";
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.r) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.r = a();
      }
      if (paramJSONObject == null) {
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.r) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "titlebar config:" + paramJSONObject.toString());
      }
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
        break label600;
      }
      localView = ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarView();
    }
    catch (Exception paramJSONObject)
    {
      View localView;
      String str;
      Object localObject;
      int k;
      boolean bool;
      int m;
      while (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "game center,doTransparent error:" + paramJSONObject.toString());
        return;
        localView.getBackground().mutate().setAlpha(m);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Int = m;
        return;
        k = -1;
        continue;
        k = -1;
        continue;
        k = -1;
        continue;
        label600:
        localView = null;
      }
    }
    if (localView != null)
    {
      str = paramJSONObject.optString("bgclr", "");
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        if (!str.startsWith("#")) {
          localObject = "#" + str;
        }
        k = Color.parseColor((String)localObject);
        localView.setBackgroundColor(k);
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
        {
          localObject = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
          if (((BaseActivity)localObject).mSystemBarComp != null) {
            ((BaseActivity)localObject).mSystemBarComp.b(0);
          }
        }
        str = paramJSONObject.optString("txtclr", "");
        if (!TextUtils.isEmpty(str))
        {
          localObject = str;
          if (!str.startsWith("#")) {
            localObject = "#" + str;
          }
          k = Color.parseColor((String)localObject);
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setTextColor(k);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c instanceof TextView)) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c.setTextColor(k);
          }
          localObject = ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.getBackground(), k);
          if (localObject != null) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
          }
          str = paramJSONObject.optString("titleclr", "");
          if (!TextUtils.isEmpty(str))
          {
            localObject = str;
            if (!str.startsWith("#")) {
              localObject = "#" + str;
            }
            k = Color.parseColor((String)localObject);
            if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.b instanceof TextView))
            {
              if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.b.getText())) && (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))) {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.b.setText(this.jdField_h_of_type_JavaLangString);
              }
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.b.setTextColor(k);
            }
            bool = paramJSONObject.optBoolean("anim", false);
            k = paramJSONObject.optInt("dur", 0);
            m = paramJSONObject.optInt("alpha", 0);
            if ((bool) && (k > 0))
            {
              a(localView, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Int, m, k);
              return;
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.m == paramBoolean) {}
    View localView;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.m = paramBoolean;
      localView = null;
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
        localView = ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarView();
      }
    } while (localView == null);
    localView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131428295));
    if (paramBoolean)
    {
      a(localView, 255, 0, 200);
      return;
    }
    a(localView, 0, 255, 200);
  }
  
  protected boolean a()
  {
    View localView2 = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297082);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AbsBaseWebViewActivity)) {}
    for (View localView1 = ((AbsBaseWebViewActivity)this.jdField_a_of_type_AndroidAppActivity).a();; localView1 = null)
    {
      if ((localView1 != null) && (localView2 != null) && (Build.VERSION.SDK_INT >= 17))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
        localLayoutParams.removeRule(3);
        localView1.setLayoutParams(localLayoutParams);
        if (this.jdField_d_of_type_AndroidViewView != null) {
          this.jdField_d_of_type_AndroidViewView.setPadding(0, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, 50.0F), 0, 0);
        }
        localView2.bringToFront();
        return true;
      }
      return false;
    }
  }
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!Uri.parse(paramString).isHierarchical())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject = a(paramString);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.length() == 0));
    return true;
  }
  
  protected void b()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = ((DisplayMetrics)localObject1).widthPixels;
    this.jdField_b_of_type_Int = ((DisplayMetrics)localObject1).heightPixels;
    ((ViewStub)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297380)).inflate();
    this.e = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299847);
    this.g = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299844);
    this.f = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299846);
    this.jdField_h_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297573);
    this.i = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131297583);
    this.j = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131296812);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Long & 1L) != 0L)
    {
      this.i.setVisibility(0);
      this.e.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Long & 0x4) != 0L)
    {
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      this.e.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Long & 0x2) != 0L)
    {
      this.j.setVisibility(0);
      this.e.setVisibility(0);
    }
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("secondHandSharePre", 0);
    if (localObject2 != null) {
      if (((SharedPreferences)localObject2).contains("first_float_tip"))
      {
        this.g.setVisibility(8);
        localObject2 = (FrameLayout.LayoutParams)this.e.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject2).leftMargin = ((int)(this.jdField_a_of_type_Int - 50.0F * ((DisplayMetrics)localObject1).density));
        ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)(this.jdField_b_of_type_Int - 100.0F * ((DisplayMetrics)localObject1).density));
        this.e.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = new wjj(this, (DisplayMetrics)localObject1);
      this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
      this.i.setOnClickListener(this);
      this.j.setOnClickListener(this);
      this.e.setOnTouchListener((View.OnTouchListener)localObject1);
      this.g.setOnTouchListener((View.OnTouchListener)localObject1);
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)localObject1);
      return;
      this.jdField_a_of_type_ComTencentBizWebviewpluginHole = ((Hole)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131299845));
      ((SharedPreferences)localObject2).edit().putBoolean("first_float_tip", true).commit();
      continue;
      this.g.setVisibility(8);
    }
  }
  
  public void b(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().setVisibility(0);
    }
    for (;;)
    {
      return;
      if (paramString != null) {}
      try
      {
        Uri localUri = Uri.parse(paramString);
        Object localObject = localUri.getQueryParameter("_wvNb");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (((String)localObject).startsWith("0x")) {
            localObject = ((String)localObject).substring(2);
          }
        }
        else
        {
          try
          {
            k = (int)Long.parseLong((String)localObject, 16);
            if (((String)localObject).length() > 6) {
              break label851;
            }
            k |= 0xFF000000;
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(0);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(k);
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setCustomColor(k);
            }
            if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
            {
              localObject = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
              ((BaseActivity)localObject).mNeedStatusTrans = true;
              ((BaseActivity)localObject).mActNeedImmersive = true;
              ((BaseActivity)localObject).setImmersiveStatus();
              if (((BaseActivity)localObject).mSystemBarComp != null)
              {
                ((BaseActivity)localObject).mSystemBarComp.init();
                ((BaseActivity)localObject).mSystemBarComp.a(k | 0xFF000000);
                ((BaseActivity)localObject).mSystemBarComp.b(k | 0xFF000000);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.h = true;
              }
            }
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            for (;;)
            {
              int k;
              if (QLog.isDevelopLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 4, "Illegal param _wvNb");
              }
            }
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Long & 0x4) == 0L) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131367975));
          }
          localObject = localUri.getQueryParameter("_wvNt");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if (((String)localObject).startsWith("0x")) {
              localObject = ((String)localObject).substring(2);
            }
          }
          else
          {
            try
            {
              k = (int)Long.parseLong((String)localObject, 16);
              if (((String)localObject).length() > 6) {
                break label845;
              }
              k |= 0xFF000000;
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              for (;;)
              {
                boolean bool;
                if (QLog.isDevelopLevel())
                {
                  QLog.d(jdField_a_of_type_JavaLangString, 4, "Illegal param _wvNt");
                  continue;
                  if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity))
                  {
                    ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle("");
                    continue;
                    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c.setText(2131369134);
                  }
                }
              }
            }
            if ((this.jdField_a_of_type_AndroidAppActivity instanceof AbsBaseWebViewActivity)) {
              ((AbsBaseWebViewActivity)this.jdField_a_of_type_AndroidAppActivity).b(k);
            }
            if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("youxi.vip.qq.com/imoj"))) {
              paramIntent.putExtra("isScreenOrientationPortrait", true);
            }
            localObject = paramIntent.getStringExtra("title");
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.i = paramIntent.getBooleanExtra("ishiderefresh", false);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.j = paramIntent.getBooleanExtra("ishidebackforward", false);
            bool = paramIntent.getBooleanExtra("hide_left_button", false);
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k = paramIntent.getBooleanExtra("show_right_close_button", false);
            if (QLog.isColorLevel()) {
              QLog.d("QQBrowser", 2, "QQBrowser url=" + Util.b(paramString, new String[0]));
            }
            if ((localObject != null) && (((String)localObject).length() > 0))
            {
              if ((this.jdField_a_of_type_AndroidAppActivity instanceof IphoneTitleBarActivity)) {
                ((IphoneTitleBarActivity)this.jdField_a_of_type_AndroidAppActivity).setTitle((CharSequence)localObject);
              }
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c.setOnClickListener(this);
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131369908));
              if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d)
              {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838290);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131368933));
              }
              if (bool) {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k)
              {
                paramIntent = paramIntent.getStringExtra("left_close_button_text");
                if (TextUtils.isEmpty(paramIntent)) {
                  break label829;
                }
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c.setText(paramIntent);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c.setVisibility(0);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.c.bringToFront();
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(0);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(0);
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              }
              a((TouchWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
              if (!a(paramString)) {
                continue;
              }
              a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject);
            }
          }
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        for (;;)
        {
          label829:
          label845:
          label851:
          if (QLog.isDevelopLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 4, "Illegal param _wvNb OR _wvNt");
            continue;
            continue;
          }
        }
      }
    }
  }
  
  public void b(WebView paramWebView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.g)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.j) {
        a(paramWebView);
      }
    }
    else {
      return;
    }
    boolean bool = paramWebView.canGoBack();
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(bool);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(paramWebView.canGoForward());
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) && (!paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.g = false;
    }
    int k;
    label73:
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.g == paramBoolean));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.g = paramBoolean;
      if (!paramBoolean) {
        break;
      }
      k = 0;
      if (!paramBoolean) {
        break label189;
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
        break label182;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(k);
      if ((!paramBoolean) && (this.jdField_b_of_type_AndroidViewView != null))
      {
        localObject = this.jdField_b_of_type_AndroidViewView.getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup))) {
          ((ViewGroup)localObject).removeView(this.jdField_b_of_type_AndroidViewView);
        }
      }
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizUiRefreshView.getLayoutParams();
    } while (localObject == null);
    DisplayMetrics localDisplayMetrics;
    float f1;
    if (paramBoolean)
    {
      localDisplayMetrics = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
      f1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_Int;
    }
    for (((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(localDisplayMetrics.density * f1));; ((FrameLayout.LayoutParams)localObject).bottomMargin = 0)
    {
      this.jdField_a_of_type_ComTencentBizUiRefreshView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      k = 8;
      break;
      label182:
      e();
      break label73;
      label189:
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(k);
      break label73;
    }
  }
  
  public boolean b()
  {
    return ImmersiveUtils.isSupporImmersive() == 1;
  }
  
  public void c()
  {
    int k;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.c) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_JavaLangBoolean.booleanValue()))
    {
      k = 1;
      if (k != 0) {
        break label74;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.d) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.f)) {
        break label69;
      }
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        break label88;
      }
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      return;
      k = 0;
      break;
      label69:
      bool = false;
      continue;
      label74:
      bool = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_JavaLangBoolean.booleanValue();
    }
    label88:
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.c)
    {
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(-1);
  }
  
  public void d()
  {
    if ((8 == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.v) && (1 == com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[4].intValue()) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null))
    {
      int k = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493370);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, k);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(800L);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new CycleInterpolator(2.0F));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setStartOffset(1500L);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setRepeatCount(1);
      this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      ReportController.b(null, "P_CliOper", "webview_report", "", "0X8006598", "0X8006598", 0, 0, null, null, null, null);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof View.OnClickListener)) {
      ((View.OnClickListener)this.jdField_a_of_type_AndroidAppActivity).onClick(paramView);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserUIStyleHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */