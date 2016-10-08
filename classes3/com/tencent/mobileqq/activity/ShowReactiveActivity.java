package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormMutiItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import mlc;

public class ShowReactiveActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  FormMutiItem jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem;
  public FormSwitchItem a;
  FormMutiItem b;
  FormMutiItem c;
  FormMutiItem d;
  FormMutiItem e;
  FormMutiItem f;
  
  public ShowReactiveActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new mlc(this);
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this);
  }
  
  public View a(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131302430));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem = ((FormMutiItem)a(2131302477));
    this.b = ((FormMutiItem)a(2131302478));
    this.c = ((FormMutiItem)a(2131302479));
    this.d = ((FormMutiItem)a(2131302480));
    this.e = ((FormMutiItem)a(2131302481));
    this.f = ((FormMutiItem)a(2131302482));
    Card localCard = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.app.a());
    FormSwitchItem localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (!localCard.allowCalInteractive) {}
    for (boolean bool = true;; bool = false)
    {
      localFormSwitchItem.setChecked(bool);
      ((CardHandler)this.app.a(2)).k();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setLeftIcon(getResources().getDrawable(2130843190));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setFirstLineText(2131372679);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormMutiItem.setSecondLineText(getString(2131372680, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b) }));
      this.b.setLeftIcon(getResources().getDrawable(2130843184));
      this.b.setFirstLineText(2131372681);
      this.b.setSecondLineText(getString(2131372682, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c) }));
      this.c.setLeftIcon(getResources().getDrawable(2130843192));
      this.c.setFirstLineText(2131372683);
      this.c.setSecondLineText(getString(2131372684, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d) }));
      this.d.setLeftIcon(getResources().getDrawable(2130843186));
      this.d.setFirstLineText(2131372685);
      this.d.setSecondLineText(getString(2131372686, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e) }));
      this.e.setLeftIcon(getResources().getDrawable(2130843191));
      this.e.setFirstLineText(2131372687);
      this.e.setSecondLineText(getString(2131372688, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.f) }));
      this.f.setLeftIcon(getResources().getDrawable(2130843185));
      this.f.setFirstLineText(2131372689);
      this.f.setSecondLineText(getString(2131372690, new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.g) }));
      if (AppSetting.j) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131372670));
      }
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904352);
    setTitle(2131369665);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (!NetworkUtil.e(getActivity()))
    {
      QQToast.a(getApplicationContext(), 2131370267, 1).a();
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
      a(paramCompoundButton, bool1);
    }
    while (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
      return;
    }
    paramCompoundButton = this.app;
    int i;
    if (paramBoolean)
    {
      i = 1;
      ReportController.b(paramCompoundButton, "CliOper", "", "", "0X8007021", "0X8007021", 0, 0, String.valueOf(i), "", "", "");
      paramCompoundButton = (CardHandler)this.app.a(2);
      if (paramBoolean) {
        break label127;
      }
    }
    label127:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      paramCompoundButton.d(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ShowReactiveActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */