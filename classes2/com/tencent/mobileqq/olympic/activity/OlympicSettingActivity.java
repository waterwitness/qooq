package com.tencent.mobileqq.olympic.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicHandler;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import trq;
import trr;
import trs;
import trt;

public class OlympicSettingActivity
  extends IphoneTitleBarActivity
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private OlympicObserver jdField_a_of_type_ComTencentMobileqqOlympicOlympicObserver;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressNotifier a;
  boolean jdField_a_of_type_Boolean;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private OlympicObserver jdField_b_of_type_ComTencentMobileqqOlympicOlympicObserver;
  public FormSwitchItem b;
  public boolean b;
  boolean c;
  boolean d;
  
  public OlympicSettingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicObserver = new trs(this);
    this.jdField_b_of_type_ComTencentMobileqqOlympicOlympicObserver = new trt(this);
  }
  
  private boolean a()
  {
    boolean bool1 = false;
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    boolean bool3 = localSharedPreferences.contains("olympic_flag_setting");
    boolean bool2 = localSharedPreferences.getBoolean("olympic_setting_ever_fetch_flag_switch_here", false);
    if ((!bool3) || (!bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904272);
    setTitle(2131372636);
    paramBundle = (OlympicManager)this.app.getManager(166);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302134));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302136));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302135));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302137));
    if (paramBundle != null)
    {
      this.c = paramBundle.e();
      this.d = paramBundle.f();
      if (this.c)
      {
        this.jdField_a_of_type_Boolean = paramBundle.a("olympic_entrance_setting", true);
        if (!this.jdField_a_of_type_Boolean) {
          break label301;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new trq(this, paramBundle));
      }
      if (this.d)
      {
        this.jdField_b_of_type_Boolean = paramBundle.a("olympic_flag_setting", true);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_b_of_type_Boolean);
        this.app.a(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicObserver);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new trr(this));
        if (a())
        {
          this.app.a(this.jdField_b_of_type_ComTencentMobileqqOlympicOlympicObserver);
          ((OlympicHandler)this.app.a(94)).c();
        }
      }
    }
    int i = getIntent().getIntExtra("fromWhere", -1);
    if (i == 0) {
      this.app.a("CliOper", "", "", "0X80069E5", "0X80069E5", 0, 0, "1", "", "", "");
    }
    label301:
    while (i != 1)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      break;
    }
    this.app.a("CliOper", "", "", "0X80069E5", "0X80069E5", 0, 0, "2", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.c) && ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() ^ this.jdField_a_of_type_Boolean)))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        str = "1";
        this.app.a("CliOper", "", "", "0X80069E6", "0X80069E6", 0, 0, str, "", "", "");
      }
    }
    else if (this.d)
    {
      this.app.b(this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicObserver);
      this.app.b(this.jdField_b_of_type_ComTencentMobileqqOlympicOlympicObserver);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() ^ this.jdField_b_of_type_Boolean)) {
        if (!this.jdField_b_of_type_Boolean) {
          break label153;
        }
      }
    }
    label153:
    for (String str = "1";; str = "2")
    {
      this.app.a("CliOper", "", "", "0X80069E7", "0X80069E7", 0, 0, str, "", "", "");
      a();
      return;
      str = "2";
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\activity\OlympicSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */