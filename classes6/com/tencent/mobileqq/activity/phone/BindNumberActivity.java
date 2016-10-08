package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.TelephonyUtils;
import com.tencent.widget.OnSizeChangeListener;
import onz;
import ooa;
import oob;
import ooc;
import ood;
import ooe;

public class BindNumberActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener, OnSizeChangeListener
{
  static final int jdField_a_of_type_Int = 2;
  public static final String a = "http://vac.qq.com/hall/phone/phone_tos.html?_wv=3";
  private static final int jdField_b_of_type_Int = 1;
  public static final String b = "key_is_modal_pop";
  private static final int jdField_c_of_type_Int = 0;
  public static final String c = "key_change_number";
  private static final int jdField_d_of_type_Int = 2;
  public static final String d = "key_is_qqwifi";
  private static final int jdField_e_of_type_Int = 3;
  public static final String e = "key_from_setting";
  private static final int jdField_f_of_type_Int = 4;
  public static final String f = "key_from_Tab";
  public static final String g = "k_is_block";
  public static final String h = "k_block_time";
  private static final int i = 0;
  public static final String i = "k_block_msg";
  private static final int j = 1;
  public static final String j = "key_is_from_qav_multi_call";
  private static final int k = 2;
  public static final String k = "key_is_from_qqhotspot";
  private static final int l = 3;
  public static final String l = "key_user_cancel";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  public Button a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public EditText a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public QQCustomDialog a;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public QQCustomDialog b;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public QQCustomDialog c;
  private boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h;
  public String m;
  public String n;
  private String o;
  
  public BindNumberActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.m = "+86";
    this.o = "中国";
    this.jdField_g_of_type_Int = -100000;
    this.h = -1;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, "更换手机号码", "QQ更换绑定新的手机号码前，需要将当前的绑定关系解除，请确定是否更换。", "确定", "取消", new oob(this), new ooc(this));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      if (getIntent().getBooleanExtra("k_is_block", false)) {
        ReportController.b(this.app, "CliOper", "", "", "0X80053D6", "0X80053D6", 0, 0, "", "", "", "");
      }
      if (this.h != 0) {
        break label196;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005B76", "0X8005B76", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_g_of_type_Boolean) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005D0E", "0X8005D0E", 0, 0, "", "", "", "");
      }
      return;
      b();
      break;
      label196:
      if (this.h == 1) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005B76", "0X8005B76", 2, 0, "", "", "", "");
      } else if (this.h == 8) {
        ReportController.b(this.app, "dc00898", "", "", "0X800650C", "0X800650C", 1, 0, this.app.f(), "", "", "");
      } else if (this.h == 10) {
        ReportController.b(this.app, "dc00898", "", "", "0X8006AA3", "0X8006AA3", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "finish2, reason = " + paramInt + ", isReqBlock = " + this.jdField_b_of_type_Boolean);
    }
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(10);
    if ((paramInt == 0) && (!this.jdField_b_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      localPhoneContactManagerImp.a(bool);
      super.finish();
      if (this.jdField_c_of_type_Boolean) {
        overridePendingTransition(2130968589, 2130968795);
      }
      return;
    }
  }
  
  private void b()
  {
    this.n = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if ((this.m.equalsIgnoreCase("+86")) && (this.n.length() != 11))
    {
      b(2131362956);
      return;
    }
    if (!NetworkUtil.e(this))
    {
      b(2131368805);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      ((BounceScrollView)findViewById(2131297373)).c(130);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {}
    for (boolean bool = true; (this.h == 10) || (this.h == 11); bool = false)
    {
      this.rightViewText.setEnabled(bool);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.o = paramIntent.getStringExtra("k_name");
      this.m = ("+" + paramIntent.getStringExtra("k_code"));
      paramIntent = this.o + " " + this.m;
      localRect = new Rect();
      this.jdField_b_of_type_AndroidWidgetTextView.getPaint().getTextBounds(paramIntent, 0, paramIntent.length(), localRect);
      paramInt1 = getResources().getDimensionPixelSize(2131493807);
      paramInt2 = getResources().getDimensionPixelSize(2131493808);
      if (localRect.right > paramInt1 - paramInt2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.m);
        if (AppSetting.j) {
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + "按钮");
        }
      }
    }
    while ((paramInt1 != 2) || (paramInt2 == 0)) {
      for (;;)
      {
        Rect localRect;
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramIntent);
      }
    }
    setResult(paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (!getIntent().getBooleanExtra("key_from_setting", false)) {
        break label355;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X80053E2", "0X80053E2", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.h == 11) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006EFA", "0X8006EFA", 0, 0, "", "", "", "");
      }
      if (this.f)
      {
        paramIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
        paramIntent.putExtra("kSrouce", this.h);
        paramIntent.putExtra("kBindNew", true);
        startActivity(paramIntent);
      }
      a(3);
      return;
      label355:
      if (getIntent().getBooleanExtra("key_from_Tab", false)) {
        ReportController.b(this.app, "CliOper", "", "", "0X80053DC", "0X80053DC", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnBackPressed()
  {
    boolean bool = false;
    if ((this.h == 10) || (this.h == 11))
    {
      if (this.h == 10) {
        bool = true;
      }
      b(bool);
    }
    do
    {
      return;
      if ((this.leftViewNotBack == null) || (this.leftView == null))
      {
        super.doOnBackPressed();
        return;
      }
    } while ((this.leftViewNotBack.getVisibility() != 0) && (this.leftView.getVisibility() != 0));
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X80053D4", "0X80053D4", 0, 0, "", "", "", "");
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.h = getIntent().getIntExtra("kSrouce", -1);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "doOnCreate ,mSource = " + this.h);
    }
    label254:
    int i1;
    if ((this.h == 10) || (this.h == 11))
    {
      getWindow().setSoftInputMode(18);
      setContentView(2130903430);
      if ((Build.MANUFACTURER.equalsIgnoreCase("Letv")) && (Build.MODEL.equalsIgnoreCase("X900+")))
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
        this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("kNeedUnbind", false);
        this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_is_modal_pop", false);
        this.d = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
        this.e = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
        this.f = getIntent().getBooleanExtra("kUnityWebBind", false);
        this.jdField_g_of_type_Boolean = getIntent().getBooleanExtra("key_is_from_qav_multi_call", false);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298564));
        if (!getIntent().getBooleanExtra("key_change_number", false)) {
          break label802;
        }
        setTitle("更改手机号码", "请输入手机号码");
        if ((this.h != 10) && (this.h != 11)) {
          break label822;
        }
        setTitle("绑定手机通讯录", "绑定手机通讯录");
        if (this.h != 11) {
          break label815;
        }
        i1 = 2131369134;
        label295:
        setLeftButton(i1, this);
        setRightButton(2131368949, this);
        label309:
        if (!getIntent().getBooleanExtra("key_is_qqwifi", false)) {
          break label851;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText("首次使用QQWiFi功能时，需要验证你的手机号码并推荐绑定通讯录。");
        label332:
        if (this.d)
        {
          setTitle("获取验证码", "请输入手机号码");
          this.jdField_c_of_type_AndroidWidgetTextView.setText("绑定手机号码需要通过短信验证。");
          this.jdField_c_of_type_AndroidWidgetTextView.setGravity(1);
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.rgb(74, 74, 74));
          this.leftView.setText(2131366637);
        }
        paramBundle = TelephonyUtils.a(this);
        if (paramBundle == null) {
          break label1032;
        }
        this.o = "";
        this.m = ('+' + paramBundle[0]);
        this.n = paramBundle[1];
        label440:
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298566));
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.o + " " + this.m);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        if (AppSetting.j) {
          this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + "按钮");
        }
        this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131297859));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("已同意");
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298568));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        if ((this.h != 10) && (this.h != 11)) {
          break label1079;
        }
        this.n = LoginWelcomeManager.a(this.app).e;
        this.rightViewText.setEnabled(false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131298567));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.n);
      if (!TextUtils.isEmpty(this.n)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.n.length());
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131298569);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298570));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (this.jdField_g_of_type_Boolean) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005D0D", "0X8005D0D", 0, 0, "", "", "", "");
      }
      return true;
      ((BounceScrollView)findViewById(2131297373)).setOnSizeChangeListener(this);
      break;
      setContentView(2130903429);
      break;
      label802:
      setTitle("验证手机号码", "请输入手机号码");
      break label254;
      label815:
      i1 = 2131370486;
      break label295;
      label822:
      if (this.jdField_c_of_type_Boolean)
      {
        setLeftButton(2131369134, null);
        break label309;
      }
      setLeftButton(2131367975, null);
      break label309;
      label851:
      if (getIntent().getBooleanExtra("k_is_block", false))
      {
        this.jdField_b_of_type_Boolean = true;
        this.leftViewNotBack.setVisibility(8);
        this.leftViewNotBack.setOnClickListener(new onz(this));
        this.jdField_g_of_type_Int = getIntent().getIntExtra("k_block_time", -100000);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getIntent().getStringExtra("k_block_msg"));
        setRightButton(2131369871, this);
        break label332;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131363953);
        this.rightViewText.setVisibility(8);
        break label332;
      }
      if (getIntent().getBooleanExtra("key_is_from_qqhotspot", false))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("首次使用QQ Wi-Fi需要通过短信验证。");
        this.jdField_c_of_type_AndroidWidgetTextView.setGravity(1);
        break label332;
      }
      paramBundle = ((PhoneContactManagerImp)this.app.getManager(10)).c();
      if (StringUtil.b(paramBundle)) {
        break label332;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramBundle);
      break label332;
      label1032:
      paramBundle = PhoneCodeUtils.b(this);
      if ("86".equals(paramBundle)) {
        break label440;
      }
      this.o = "";
      this.m = ('+' + paramBundle);
      break label440;
      label1079:
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((TextUtils.isEmpty(this.n)) && (this.h != 11)) {
      this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new ooa(this), 300L);
    }
    if (this.jdField_g_of_type_Int > 0) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    }
    while (this.jdField_g_of_type_Int == -100000) {
      return;
    }
    this.leftViewNotBack.setVisibility(0);
  }
  
  public void finish()
  {
    a(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 0: 
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new ood(this);
      this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      paramMessage = (PhoneContactManager)this.app.getManager(10);
      a(2131368647, 1000L, true);
      paramMessage.b(this.d, this.e);
    }
    do
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new ooe(this);
        this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      if ((this.h == 10) || (this.h == 11)) {
        this.rightViewText.setEnabled(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.m, this.n, 0, this.d, this.e);
        if (3 == paramMessage.what) {
          break;
        }
        a(2131368647, 1000L, true);
        return true;
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      int i1 = this.jdField_g_of_type_Int - 1;
      this.jdField_g_of_type_Int = i1;
      if (i1 >= 0) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().length() != 0);
    this.leftViewNotBack.setVisibility(0);
    return true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    return true;
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_user_cancel", 1);
    setResult(0, localIntent);
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
    finish();
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().length() > 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
    {
      paramBoolean = true;
      if ((this.h != 10) && (this.h != 11)) {
        break label83;
      }
      this.rightViewText.setEnabled(paramBoolean);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label94;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("已同意");
      return;
      paramBoolean = false;
      break;
      label83:
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    }
    label94:
    this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("未同意");
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    switch (paramView.getId())
    {
    default: 
      this.app.logout(true);
      startActivity(new Intent(this, LoginActivity.class));
      a(1);
      ReportController.b(this.app, "CliOper", "", "", "0X80053D3", "0X80053D3", 0, 0, "", "", "", "");
    case 2131298566: 
    case 2131297391: 
    case 2131297183: 
      do
      {
        do
        {
          return;
          startActivityForResult(new Intent(this, CountryActivity.class), 1);
          return;
        } while ((this.h != 10) && (this.h != 11));
        if (this.h == 10) {
          bool1 = true;
        }
        b(bool1);
        return;
        if (this.jdField_g_of_type_Boolean)
        {
          finish();
          return;
        }
      } while ((this.h != 10) && (this.h != 11));
      a();
      return;
    case 2131298568: 
      a();
      return;
    case 2131298570: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", "http://vac.qq.com/hall/phone/phone_tos.html?_wv=3");
      startActivity(paramView);
      return;
    }
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramView.setChecked(bool1);
      return;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_g_of_type_Int == -1)
    {
      paramCharSequence = this.leftViewNotBack;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().length() <= 0) {
        break label41;
      }
    }
    label41:
    for (paramInt1 = 8;; paramInt1 = 0)
    {
      paramCharSequence.setVisibility(paramInt1);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\phone\BindNumberActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */