package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import lvi;
import lvj;
import lvl;
import lvm;
import lvn;
import lvo;
import lvp;
import lvr;
import lvs;
import lvt;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ModifyTroopMemberCardActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 60;
  static final String jdField_a_of_type_JavaLangString = "ModifyTroopMemberCardActivity";
  static final int b = 60;
  static final int c = 20;
  static final int d = 30;
  static final String j = "troopmembercardchanged";
  public Dialog a;
  public Handler a;
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener;
  public View a;
  public EditText a;
  public TroopMemberCardInfo a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  protected lvt a;
  public View b;
  public EditText b;
  public String b;
  protected lvt b;
  public View c;
  public EditText c;
  protected String c;
  protected lvt c;
  public View d;
  public EditText d;
  public String d;
  protected lvt d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public ModifyTroopMemberCardActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.jdField_a_of_type_AndroidOsHandler = new lvi(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new lvs(this);
  }
  
  private void a(TroopMemberCardInfo paramTroopMemberCardInfo)
  {
    if (paramTroopMemberCardInfo == null) {}
    do
    {
      return;
      if ((paramTroopMemberCardInfo.tel == null) || (TextUtils.getTrimmedLength(paramTroopMemberCardInfo.tel) <= 0)) {
        paramTroopMemberCardInfo.tel = "";
      }
      if ((paramTroopMemberCardInfo.email == null) || (TextUtils.getTrimmedLength(paramTroopMemberCardInfo.email) <= 0)) {
        paramTroopMemberCardInfo.email = "";
      }
      if ((paramTroopMemberCardInfo.job == null) || (TextUtils.getTrimmedLength(paramTroopMemberCardInfo.job) <= 0)) {
        paramTroopMemberCardInfo.job = "";
      }
      String str = this.e;
      if ((!this.jdField_a_of_type_Lvt.b) && (!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals(str)))
      {
        this.jdField_a_of_type_Lvt.a = true;
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
        a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131367934), str);
      }
      if ((!this.jdField_b_of_type_Lvt.b) && (!TextUtils.isEmpty(paramTroopMemberCardInfo.job)) && (!this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().equals(paramTroopMemberCardInfo.job)))
      {
        this.jdField_b_of_type_Lvt.a = true;
        this.jdField_b_of_type_AndroidWidgetEditText.setText(paramTroopMemberCardInfo.job);
        a(this.jdField_b_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131367935), paramTroopMemberCardInfo.job);
      }
      if ((!this.jdField_c_of_type_Lvt.b) && (!TextUtils.isEmpty(paramTroopMemberCardInfo.tel)) && (!this.jdField_c_of_type_AndroidWidgetEditText.getText().toString().equals(paramTroopMemberCardInfo.tel)))
      {
        this.jdField_c_of_type_Lvt.a = true;
        this.jdField_c_of_type_AndroidWidgetEditText.setText(paramTroopMemberCardInfo.tel);
        a(this.jdField_c_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131367936), paramTroopMemberCardInfo.tel);
      }
    } while ((this.jdField_d_of_type_Lvt.b) || (TextUtils.isEmpty(paramTroopMemberCardInfo.email)) || (this.jdField_d_of_type_AndroidWidgetEditText.getText().toString().equals(paramTroopMemberCardInfo.email)));
    this.jdField_d_of_type_Lvt.a = true;
    this.jdField_d_of_type_AndroidWidgetEditText.setText(paramTroopMemberCardInfo.email);
    a(this.jdField_d_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131367937), paramTroopMemberCardInfo.email);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, BusinessObserver paramBusinessObserver)
  {
    Oidb_0x8fc.ReqBody localReqBody = new Oidb_0x8fc.ReqBody();
    Oidb_0x8fc.MemberInfo localMemberInfo = new Oidb_0x8fc.MemberInfo();
    TroopManager localTroopManager = (TroopManager)this.app.getManager(51);
    try
    {
      localReqBody.uint64_group_code.set(Long.parseLong(this.jdField_b_of_type_JavaLangString));
      localMemberInfo.uint64_uin.set(Long.parseLong(this.jdField_d_of_type_JavaLangString));
      if (this.jdField_a_of_type_Lvt.b) {
        localMemberInfo.member_card_name.set(ByteStringMicro.copyFromUtf8(paramString1));
      }
      if (this.jdField_b_of_type_Lvt.b) {
        localMemberInfo.bytes_job.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      if (this.jdField_c_of_type_Lvt.b) {
        localMemberInfo.bytes_phone.set(ByteStringMicro.copyFromUtf8(paramString3));
      }
      if (this.jdField_d_of_type_Lvt.b) {
        localMemberInfo.bytes_email.set(ByteStringMicro.copyFromUtf8(paramString4));
      }
      localReqBody.rpt_mem_level_info.add(localMemberInfo);
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2300);
      paramString1.uint32_service_type.set(3);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramString2 = new NewIntent(this.app.a(), ProtoServlet.class);
      paramString2.putExtra("cmd", "OidbSvc.0x8fc_3");
      paramString2.putExtra("data", paramString1.toByteArray());
      paramString2.setObserver(paramBusinessObserver);
      this.app.startServlet(paramString2);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ModifyTroopMemberCardActivity", 2, "修改群名片包发送失败" + paramString1.toString());
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Lvt.b) || (this.jdField_b_of_type_Lvt.b) || (this.jdField_c_of_type_Lvt.b) || (this.jdField_d_of_type_Lvt.b);
  }
  
  private void b()
  {
    super.setContentView(2130905074);
    setTitle(2131367938);
    setRightHighlightButton(2131368729, this);
    enableRightHighlight(false);
    setLeftButton(2131367262, new lvn(this));
    this.leftView.setContentDescription(getString(2131367939));
    this.rightViewText.setContentDescription(getString(2131367940));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302179);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131302180));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131367941);
    this.jdField_a_of_type_Lvt = new lvt(this, 60, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_Lvt);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetEditText, getString(2131367942), "");
    this.jdField_b_of_type_AndroidViewView = findViewById(2131305201);
    this.jdField_b_of_type_AndroidViewView.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131305202));
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(2131367943);
    this.jdField_b_of_type_Lvt = new lvt(this, 60, this.jdField_b_of_type_AndroidWidgetEditText);
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_Lvt);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    a(this.jdField_b_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetEditText, getString(2131367935), "");
    this.jdField_c_of_type_AndroidViewView = findViewById(2131305203);
    this.jdField_c_of_type_AndroidViewView.setClickable(false);
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)this.jdField_c_of_type_AndroidViewView.findViewById(2131305204));
    this.jdField_c_of_type_AndroidWidgetEditText.setHint(2131367944);
    this.jdField_c_of_type_Lvt = new lvt(this, 20, this.jdField_c_of_type_AndroidWidgetEditText);
    this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_c_of_type_Lvt);
    this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    a(this.jdField_c_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetEditText, getString(2131367936), "");
    this.jdField_d_of_type_AndroidViewView = findViewById(2131305205);
    this.jdField_d_of_type_AndroidViewView.setClickable(false);
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)this.jdField_d_of_type_AndroidViewView.findViewById(2131302199));
    this.jdField_d_of_type_AndroidWidgetEditText.setHint(2131367945);
    this.jdField_d_of_type_Lvt = new lvt(this, 30, this.jdField_d_of_type_AndroidWidgetEditText);
    this.jdField_d_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_d_of_type_Lvt);
    this.jdField_d_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    a(this.jdField_d_of_type_AndroidViewView, this.jdField_d_of_type_AndroidWidgetEditText, getString(2131367937), "");
  }
  
  private void c()
  {
    try
    {
      ThreadManager.a(new lvp(this), 8, null, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ModifyTroopMemberCardActivity", 2, "修改成功 保存数据到本地 败" + localException.toString());
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    return ContactUtils.g(this.app, paramString1, paramString2);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(View paramView1, View paramView2, String paramString1, String paramString2)
  {
    String str = paramString1 + "," + paramString2 + ",";
    paramView1.setContentDescription(str);
    if ((paramView2 instanceof TextView))
    {
      paramView2.setContentDescription(str);
      return;
    }
    paramView2.setContentDescription(paramString1 + getString(2131367949) + paramString2 + ",");
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnKeyListener(new lvr(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("troopUin");
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("troopCode");
    this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("memberUin");
    this.e = paramBundle.getStringExtra("troopMemberNick");
    b();
    ThreadManager.a(new lvj(this), 8, null, false);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    super.finish();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (!this.jdField_d_of_type_JavaLangString.equals(this.app.a())) {
      ReportController.b(this.app, "CliOper", "", "", "0X80058F4", "0X80058F4", 0, 0, "", "", "", "");
    }
    while (a())
    {
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 2131367946, 2131370481, 2131369982, new lvl(this), new lvm(this));
      this.jdField_a_of_type_AndroidAppDialog.show();
      return true;
      ReportController.b(this.app, "CliOper", "", "", "0X80058F1", "0X80058F1", 0, 0, "", "", "", "");
    }
    finish();
    overridePendingTransition(0, 2130968584);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (!this.jdField_d_of_type_JavaLangString.equals(this.app.a())) {
      ReportController.b(this.app, "CliOper", "", "", "0X80058F3", "0X80058F3", 0, 0, "", "", "", "");
    }
    while (!NetworkUtil.e(this))
    {
      QQToast.a(this, 2131369008, 0).b(getTitleBarHeight());
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X80058F0", "0X80058F0", 0, 0, "", "", "", "");
    }
    this.f = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.g = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    this.h = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString();
    this.i = this.jdField_d_of_type_AndroidWidgetEditText.getText().toString();
    a(getString(2131367950));
    a(this.f, this.g.trim(), this.h.trim(), this.i.trim(), new lvo(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ModifyTroopMemberCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */