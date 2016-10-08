package com.dataline.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.dataline.util.DLRouterSessionListAdapter;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.widget.XListView;
import q;
import r;

public class DLRouterSessionInfoActivity
  extends IphoneTitleBarActivity
{
  public static String a;
  public static String b = "sSelfUin";
  long a;
  public ViewGroup a;
  public DLRouterSessionListAdapter a;
  public ScrollerRunnable a;
  public XListView a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "dataline.DLRouterSessionInfoActivity";
  }
  
  public DLRouterSessionInfoActivity()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new r(this), 10L);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    this.jdField_a_of_type_Long = Long.parseLong(paramBundle.getStringExtra("uin"));
    long l = paramBundle.getLongExtra(b, 0L);
    super.getWindow().setBackgroundDrawableResource(2131427369);
    super.setContentView(2130903271);
    super.setTitle(2131362395);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131297948));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296449, "n/a");
    this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter = new DLRouterSessionListAdapter(this.app, LayoutInflater.from(this), this.jdField_a_of_type_Long, l, this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131297949));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter);
    paramBundle = LayoutInflater.from(this).inflate(2130903206, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(super.getResources().getDrawable(2130840536));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new q(this));
    return true;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.a();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\activities\DLRouterSessionInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */