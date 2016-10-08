package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import lsh;
import lsi;
import lsj;
import lsk;

public class LikeSettingActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "LikeSettingActivity";
  public CompoundButton.OnCheckedChangeListener a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  NearbyRelevantObserver jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver;
  public FormSwitchItem a;
  public FormSwitchItem b;
  
  public LikeSettingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new lsh(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver = new lsi(this);
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new lsj(this);
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  void a()
  {
    boolean bool = ((NearByGeneralManager)this.app.getManager(160)).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    ThreadManager.a(new lsk(this), 5, null, true);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904236);
    setTitle("赞设置");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131301925));
    this.b = ((FormSwitchItem)super.findViewById(2131301926));
    a();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
    this.app.t();
    ((NearbyRelevantHandler)this.app.a(66)).c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\LikeSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */