package com.tencent.mobileqq.apollo.store;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import prg;

public class ApolloFloatActivity
  extends ApolloBaseActivity
{
  public static final String d = "extra_key_weburl";
  public static final String e = "extra_key_close_btn";
  private static final String f = "ApolloFloatActivity";
  public TextView a;
  
  public ApolloFloatActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = new RelativeLayout(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = super.b(null);
    paramBundle.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getBackground() != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getBackground().setAlpha(0);
    }
    localObject = super.getIntent().getStringExtra("extra_key_weburl");
    this.c = ((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.g = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl((String)localObject);
    }
    for (;;)
    {
      localObject = super.getResources();
      if (this.mSystemBarComp != null)
      {
        int i = ((Resources)localObject).getColor(2131427379);
        this.mSystemBarComp.a(i);
        this.mSystemBarComp.b(i);
      }
      if (super.getIntent().getBooleanExtra("extra_key_close_btn", false)) {
        paramBundle.postDelayed(new prg(this, (Resources)localObject, paramBundle), 1500L);
      }
      super.setContentView(paramBundle);
      super.hideTitleBar();
      if (!WebIPCOperator.a().a()) {
        WebIPCOperator.a().a().doBindService(paramBundle.getContext().getApplicationContext());
      }
      this.b = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return false;
      if (QLog.isColorLevel()) {
        QLog.e("ApolloFloatActivity", 2, "ApolloFloat WebUrl is empty!");
      }
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView) {
      super.onBackEvent();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloFloatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */