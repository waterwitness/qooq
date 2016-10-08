package com.tencent.mobileqq.troop.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateMapViewSupportActivity
  extends TroopCreateBaseActivity
{
  private static final String c = "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ";
  private static final String d = "73dfcdeff8636c1d3501fa9a2860ebb7";
  int jdField_a_of_type_Int;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  AutoLocationMapView jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView;
  
  public TroopCreateMapViewSupportActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void h()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getParent();
    localViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2130903655, null, true));
    this.jdField_a_of_type_Int = ((int)getResources().getDimension(2131493227));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView = new AutoLocationMapView(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setId(2131296428);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView, new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131296428);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, 2131297082);
    localViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.getLayoutParams();
      localLayoutParams.height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        if (paramBoolean1) {
          startTitleProgress();
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.a("LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ", new TroopCreateMapViewSupportActivity.AutoLocationJSCallback(this, paramString));
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.clearAllOverlays();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.setVisibility(8);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.getVisibility() != 0) {
      return;
    }
    if (paramBoolean) {}
    for (TroopCreateMapViewSupportActivity.TroopCreateMapViewAnimation localTroopCreateMapViewAnimation = new TroopCreateMapViewSupportActivity.TroopCreateMapViewAnimation(this, 0, this.jdField_a_of_type_Int);; localTroopCreateMapViewAnimation = new TroopCreateMapViewSupportActivity.TroopCreateMapViewAnimation(this, this.jdField_a_of_type_Int, 0))
    {
      localTroopCreateMapViewAnimation.setDuration(600L);
      localTroopCreateMapViewAnimation.setFillAfter(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.startAnimation(localTroopCreateMapViewAnimation);
      return;
    }
  }
  
  public void c(String paramString)
  {
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(paramString)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("mapViewHeight", this.jdField_a_of_type_Int);
      b(paramString, localJSONObject.toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onDestroy();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onPause();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onResume();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onStop();
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView.onRestart();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopCreateMapViewSupportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */