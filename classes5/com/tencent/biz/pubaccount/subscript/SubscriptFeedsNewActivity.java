package com.tencent.biz.pubaccount.subscript;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.SubscriptionViewController;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySubscriptionListViewGroup.OnSubscriptActionCallback;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.ui.CustomGuideView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import idw;
import idx;
import idy;
import idz;
import mqq.os.MqqHandler;

public class SubscriptFeedsNewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ReadInJoySubscriptionListViewGroup.OnSubscriptActionCallback
{
  public static final String a = "subscript_guid";
  private static final String jdField_b_of_type_JavaLangString = "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278";
  public long a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  protected ReadInJoyBaseViewController a;
  protected ReadInJoyObserver a;
  private CustomGuideView jdField_a_of_type_ComTencentBizUiCustomGuideView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  
  public SubscriptFeedsNewActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new idx(this);
  }
  
  public static void b()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.a, SubscriptFeedsActivity.class);
    localIntent.putExtra("come_from", 1);
    localIntent.setFlags(67108864);
    BaseApplicationImpl.a.startActivity(localIntent);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.titleRoot.findViewById(2131299936));
    Object localObject = (ViewStub)findViewById(2131299933);
    ((ViewStub)localObject).inflate();
    ((ViewStub)localObject).setVisibility(0);
    this.b = ((ViewGroup)findViewById(2131299962));
    localObject = new SubscriptionViewController(this);
    ((SubscriptionViewController)localObject).a(this);
    ((SubscriptionViewController)localObject).a(this.b);
    ((SubscriptionViewController)localObject).a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController = ((ReadInJoyBaseViewController)localObject);
    d();
    boolean bool = SubscriptRecommendController.f(this.app);
    this.rightViewText.setText(2131372084);
    if (bool) {
      this.rightViewText.setVisibility(0);
    }
    for (;;)
    {
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setOnClickListener(this);
      return;
      this.rightViewText.setVisibility(8);
    }
  }
  
  private void d()
  {
    int i = 1;
    Object localObject = "6.5.5" + this.app.f() + "subscript_guid";
    if ((this.app.getPreferences().getBoolean((String)localObject, true)) && (SubscriptRecommendController.f(this.app))) {
      if (i != 0) {
        break label70;
      }
    }
    label70:
    do
    {
      return;
      i = 0;
      break;
      this.app.getPreferences().edit().putBoolean((String)localObject, false).commit();
      try
      {
        localObject = getResources();
        this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow();
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView = new CustomGuideView(this);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.g = ((Resources)localObject).getColor(2131427729);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.f = ((Resources)localObject).getColor(2131427730);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Float = AIOUtils.a(2, 14, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.e = AIOUtils.a(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_Int = AIOUtils.a(30.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.b = AIOUtils.a(7.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.h = AIOUtils.a(12.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.c = AIOUtils.a(3.0F, (Resources)localObject);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.jdField_a_of_type_JavaLangString = "点击查看更多精彩内容";
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setId(2131296528);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_ComTencentBizUiCustomGuideView);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(false);
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(this.jdField_a_of_type_ComTencentBizUiCustomGuideView.b());
        this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
        i = this.jdField_a_of_type_ComTencentBizUiCustomGuideView.b();
        int j = getResources().getDisplayMetrics().widthPixels;
        this.rightViewText.post(new idw(this, j, i));
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("IphoneTitleBarActivity", 2, "showSubscriptCenterGuideWindow, " + localException);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentBizUiCustomGuideView.setOnClickListener(null);
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("IphoneTitleBarActivity", 2, "closeSubscriptCenterGuideWindow, " + localException);
    }
  }
  
  public void a()
  {
    e();
  }
  
  public void a(int paramInt)
  {
    this.leftView.post(new idy(this, paramInt));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    PublicTracker.a(null, "SUBSCRIPT_FEEDS_COST");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new idz(this), 1000L);
    }
    setContentView(2130903751);
    getWindow().setBackgroundDrawable(null);
    ((ReadInJoyLogicManager)this.app.getManager(162)).a();
    ReadInJoyLogicEngine.a().j();
    setTitle(PublicAccountConfigUtil.a(this.app, getApplicationContext()));
    c();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.d();
    ((ReadInJoyLogicManager)this.app.getManager(162)).b();
    ReadInJoyLogicEngine.a().k();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.g();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.h();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.e();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.f();
  }
  
  public void finish()
  {
    super.finish();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyBaseViewController.i();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131296528: 
      ReportController.b(this.app, "CliOper", "", "", "0X8006572", "0X8006572", 0, 0, "", "", "", "");
      PublicAccountSearchActivity.a(this, PublicAccountConfigUtil.a(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
      SubscriptRecommendController.b(this.app, false);
      e();
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005734", "0X8005734", 0, 0, "", "", "", "");
    PublicAccountSearchActivity.a(this, PublicAccountConfigUtil.a(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
    SubscriptRecommendController.b(this.app, false);
    e();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\subscript\SubscriptFeedsNewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */