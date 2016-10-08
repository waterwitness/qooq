package com.tencent.biz.pubaccount.reactnative.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.tencent.bitapp.BitAppAbilityUtils;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.preDownload.IRNPreDownloadListener;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.biz.pubaccount.reactnative.ReadInjoyBaseRNView;
import com.tencent.biz.pubaccount.reactnative.ReadInjoyPackageFactroy;
import com.tencent.biz.pubaccount.reactnative.ReadInjoyReactPackage;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.rn.NRNReportUtil;
import com.tencent.mobileqq.rn.QQBaseModule.RNPageListener;
import com.tencent.mobileqq.rn.RNAppManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import hwd;

public class ReadInjoyBaseRNActivity
  extends IphoneTitleBarActivity
  implements DefaultHardwareBackBtnHandler, IRNPreDownloadListener, QQBaseModule.RNPageListener
{
  static final int jdField_a_of_type_Int = 1;
  public static final String a = "ReadInjoyBaseRNActivity";
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 7;
  static final int h = 8;
  static final int i = 9;
  static final int j = 10;
  static final int k = 11;
  static final int l = 12;
  static final int m = 13;
  private long jdField_a_of_type_Long;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ReadInjoyBaseRNView jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyBaseRNView;
  private RNAppManager jdField_a_of_type_ComTencentMobileqqRnRNAppManager;
  Boolean jdField_a_of_type_JavaLangBoolean;
  private boolean jdField_a_of_type_Boolean;
  
  public ReadInjoyBaseRNActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangBoolean = null;
  }
  
  protected int a()
  {
    return 35;
  }
  
  protected Bundle a()
  {
    return null;
  }
  
  protected String a()
  {
    return "35";
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    QLog.d("ReadInjoyBaseRNActivity", 2, "IRNPreDownloadListener onLoadFail errorCode" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, ReadableMap paramReadableMap)
  {
    runOnUiThread(new hwd(this, paramInt1, paramInt2));
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(String paramString) {}
  
  protected int b()
  {
    return 1;
  }
  
  public void b()
  {
    RNPreDownloadFacade.a(this.app, this, false, this);
  }
  
  public void b(int paramInt)
  {
    try
    {
      ReportController.b(null, "CliOper", "", "", "0X8007139", "0X8007139", 0, 0, "4", "1", "init", Integer.toString(paramInt));
      String str = ReadInJoyActivityHelper.a;
      setResult(-1);
      finish();
      if (!TextUtils.isEmpty(str))
      {
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("url", str);
        startActivity(localIntent);
        return;
      }
      QQToast.a(BaseApplicationImpl.getContext(), "打开页面失败，请稍后再试...", 0).b(getTitleBarHeight());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(String paramString) {}
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyBaseRNActivity", 2, "timestamp initUI:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    ReportController.b(null, "CliOper", "", "", "0X8007139", "0X8007139", 0, 0, "4", "0", "init", "");
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRnRNAppManager = new RNAppManager(getAppInterface());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRnRNAppManager;
    RNAppManager.a(this.app, false, ReadInjoyPackageFactroy.class);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyBaseRNView = new ReadInjoyBaseRNView(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyBaseRNView.setBackgroundColor(-1);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyBaseRNView, (ViewGroup.LayoutParams)localObject);
    setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    d();
    boolean bool = ThemeUtil.isInNightMode(this.app);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296808);
    if (bool) {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      setTitle(2131362977);
      return;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyBaseRNActivity", 2, "timestamp start BundleFacade.loadBundle:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if ((!"562667629".equals(this.app.getAccount())) && ("284674242".equals(this.app.getAccount()))) {}
    this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyBaseRNView.initViews(a(), b(), "");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(RNPreDownloadFacade.a());
    if (!BitAppAbilityUtils.e())
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        b(2);
        return true;
      }
      b(1);
      return true;
    }
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      c();
      return true;
    }
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      b(11);
      return true;
    }
    if (NRNReportUtil.a())
    {
      b();
      b(13);
      return true;
    }
    b(12);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Boolean)
    {
      ReadInjoyReactPackage.a(null);
      BitAppInstanceManager.getInstance().detachRootView(this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyBaseRNView);
      if (this.jdField_a_of_type_ComTencentMobileqqRnRNAppManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqRnRNAppManager.onDestroy();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyBaseRNView.onDestroy();
      this.jdField_a_of_type_ComTencentBizPubaccountReactnativeReadInjoyBaseRNView = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    BitAppAbilityUtils.a();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    BitAppAbilityUtils.b();
    if (this.jdField_a_of_type_Boolean) {}
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {}
  }
  
  public void invokeDefaultOnBackPressed()
  {
    super.doOnBackPressed();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\reactnative\activity\ReadInjoyBaseRNActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */