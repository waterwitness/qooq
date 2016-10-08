package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import miq;
import mir;
import mis;
import mit;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class RegisterPhoneNumActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "RegisterPhoneNumActivity";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  
  public RegisterPhoneNumActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_MqqOsMqqHandler = new miq(this);
    this.jdField_a_of_type_MqqObserverAccountObserver = new mit(this);
  }
  
  private String a(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.e)) {
          break label175;
        }
        if ("853".equals(this.e))
        {
          break label175;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        i = j;
        if (!paramString.startsWith("1"))
        {
          i = j;
          if ("86".equals(this.e)) {
            i = 0;
          }
        }
        if (!"86".equals(this.e)) {
          break label167;
        }
        j = paramString.length();
        if (j == 11) {
          break label167;
        }
        i = k;
      }
      catch (Exception localException)
      {
        for (;;) {}
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.e);
      if (bool)
      {
        i = 9;
        continue;
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label167:
        continue;
        label175:
        i = 6;
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298437));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303011));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131368535) + getString(2131362093));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303013));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131368536) + getString(2131362093));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301831));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131368573) + "+" + this.e);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298567));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301832));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ViewCompat.setImportantForAccessibility(findViewById(2131298438), 2);
    String str = getString(2131368534) + getString(2131368535) + "和" + getString(2131368536);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(str);
    ViewCompat.setImportantForAccessibility(findViewById(2131303012), 2);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(str);
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent(this, RegisterSendUpSms.class);
    localIntent.putExtra("phonenum", this.d);
    localIntent.putExtra("key", this.e);
    localIntent.putExtra("key_register_now_account", this.f);
    localIntent.putExtra("key_register_prompt_info", paramString);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("key_register_has_pwd", this.jdField_c_of_type_Boolean);
    localIntent.putExtra("key_register_binded_qq", this.jdField_b_of_type_JavaLangString);
    startActivity(localIntent);
  }
  
  private boolean a()
  {
    this.d = a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString());
    if (this.d == null)
    {
      a(2131368511, 1);
      return false;
    }
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
    {
      a(2131368490, 1);
      return false;
    }
    return true;
  }
  
  private void b()
  {
    if (!a()) {
      return;
    }
    String str = this.e + this.d;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if ((localObject != null) && ((localObject instanceof RegisterPhoneNumActivity.UserRegTimeInfo)))
      {
        localObject = (RegisterPhoneNumActivity.UserRegTimeInfo)localObject;
        if ((((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Int > 0) && (((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Long > 0L))
        {
          long l = System.currentTimeMillis() - ((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("RegisterPhoneNumActivity", 2, "startQueryAccount countryCode=" + this.e + ", phoneNum=" + this.d + ", leftTime=" + ((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Int + ", exitTime=" + ((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Long + ", interval=" + l);
          }
          if ((l > 0L) && (l < ((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Int * 1000L))
          {
            a(((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Int, ((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Long);
            return;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(str);
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131367256, 0);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("queryMobile", 2, "RegisterPhoneNumActivity.startQueryAccount countryCode=" + this.e + " phoneNum=" + this.d);
      }
      ((AccountManager)this.app.getManager(0)).sendRegisterQueryMobile(this.e, this.d, null);
      a(2131368493);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(String paramString)
  {
    if (!a()) {
      return;
    }
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.e, this.d, Long.valueOf(AppSetting.jdField_a_of_type_Int), null);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new mis(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(this, RegisterVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.d);
    localIntent.putExtra("key", this.e);
    localIntent.putExtra("key_register_now_account", this.f);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("key_register_has_pwd", this.jdField_c_of_type_Boolean);
    localIntent.putExtra("key_register_binded_qq", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_register_left_time", paramInt);
    localIntent.putExtra("key_register_exit_time", paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterPhoneNumActivity", 2, "go2next countryCode=" + this.e + ", phoneNum=" + this.d + ", leftTime=" + paramInt + ", exitTime=" + paramLong);
    }
    startActivityForResult(localIntent, 2);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((a(paramEditable.toString()) != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1;
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra("k_name");
      this.e = paramIntent.getStringExtra("k_code");
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str1 + " +" + this.e);
      try
      {
        if ((a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      String str2 = paramIntent.getStringExtra("phonenum");
      String str3 = paramIntent.getStringExtra("key");
      str1 = str3 + str2;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str1)) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str1);
      }
      paramInt1 = paramIntent.getIntExtra("key_register_left_time", 0);
      long l = paramIntent.getLongExtra("key_register_exit_time", 0L);
      if (QLog.isColorLevel()) {
        QLog.d("RegisterPhoneNumActivity", 2, "doOnActivityResult countryCode=" + str3 + ", phoneNum=" + str2 + ", leftTime=" + paramInt1 + ", exitTime=" + l);
      }
      if ((paramInt1 > 0) && (l > 0L))
      {
        paramIntent = new RegisterPhoneNumActivity.UserRegTimeInfo(this);
        paramIntent.jdField_a_of_type_Int = paramInt1;
        paramIntent.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramIntent);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130904517));
    setTitle(2131368519);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.f = paramBundle.getStringExtra("key_register_now_account");
    }
    this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    a();
    ReportController.b(this.app, "CliOper", "", "", "0X8006650", "0X8006650", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    d();
    this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.app.a(getClass());
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton == this.jdField_a_of_type_AndroidWidgetCheckBox) && (paramBoolean) && (a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X8006651", "0X8006651", 0, 0, "", "", "", "");
      b();
      return;
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new mir(this), 1000L);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.app.a());
    localIntent.putExtra("ba_is_login", false);
    if (paramView.getId() == 2131303011) {}
    for (paramView = "http://zc.qq.com/chs/agreement1_chs.html";; paramView = "http://www.qq.com/privacy.htm")
    {
      localIntent.putExtra("url", paramView);
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
      return;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\RegisterPhoneNumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */