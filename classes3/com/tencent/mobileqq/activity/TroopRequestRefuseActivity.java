package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;
import mxp;
import oicq.wlogin_sdk.tools.MD5;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopRequestRefuseActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener
{
  protected static final int a = 25;
  protected static final String a = "share_troop_request_refuse";
  Handler jdField_a_of_type_AndroidOsHandler;
  protected CheckBox a;
  protected EditText a;
  public TextView a;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private String b;
  
  public TroopRequestRefuseActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = "";
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  protected String a()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("share_troop_request_refuse", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(MD5.toMD5(this.app.a()), "");
    }
    return "";
  }
  
  protected void a(String paramString)
  {
    Object localObject = getSharedPreferences("share_troop_request_refuse", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString(MD5.toMD5(this.app.a()), paramString);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      long l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int k = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      Object localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((List)localObject).size() < 0)
        {
          localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
          if (!TextUtils.isEmpty(paramString)) {
            ((structmsg.SystemMsgActionInfo)localObject).msg.set(paramString);
          }
          ((structmsg.SystemMsgActionInfo)localObject).blacklist.set(paramBoolean);
          this.app.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 0);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable == null) || (paramEditable.length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(25));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.rgb(119, 119, 119));
      enableRightHighlight(true);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new mxp(this, paramEditable));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130905081);
    setTitle(2131365104);
    setLeftButton(2131367262, this);
    setRightHighlightButton(2131368951, this);
    enableRightHighlight(true);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131305227));
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305228));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(25));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131305229));
    paramBundle = a();
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramBundle);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.length());
    }
    long l = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a(Long.valueOf(l));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) {
      this.b = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    }
    ReportController.b(this.app, "P_CliOper", "Grp_sysmsg", "", "Grp_ask", "exp_reject", 0, 0, this.b, "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        a(str);
      }
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightHighLView) {
      if (!NetworkUtil.e(this)) {
        QQToast.a(this, getString(2131367481), 0).b(getTitleBarHeight());
      }
    }
    label138:
    while (paramView != this.leftViewNotBack)
    {
      return;
      paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      boolean bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      a(paramView, bool);
      setResult(-1);
      finish();
      QQAppInterface localQQAppInterface = this.app;
      String str2 = this.b;
      if (TextUtils.isEmpty(paramView))
      {
        paramView = "0";
        if (!bool) {
          break label138;
        }
      }
      for (String str1 = "0";; str1 = "1")
      {
        ReportController.b(localQQAppInterface, "P_CliOper", "Grp_sysmsg", "", "Grp_ask", "Clk_send_reject", 0, 0, str2, paramView, str1, "");
        return;
        paramView = "1";
        break;
      }
    }
    finish();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopRequestRefuseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */