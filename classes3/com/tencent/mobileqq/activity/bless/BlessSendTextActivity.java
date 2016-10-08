package com.tencent.mobileqq.activity.bless;

import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import oga;

public class BlessSendTextActivity
  extends BlessBaseActivity
  implements TextWatcher, View.OnClickListener
{
  public static final String a = "param_ptv_enable";
  int jdField_a_of_type_Int;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  protected RelativeLayout a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  ArrayList b;
  
  public BlessSendTextActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new oga(this);
  }
  
  private void a()
  {
    findViewById(2131297194).setOnClickListener(this);
    findViewById(2131297136).setOnClickListener(this);
    findViewById(2131297201).setVisibility(4);
    findViewById(2131297204).setVisibility(4);
    findViewById(2131297140).setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297193));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297191));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  private void a(IBinder paramIBinder)
  {
    if (paramIBinder != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramIBinder, 2);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (b())
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (!str.equals(""))
      {
        this.jdField_b_of_type_Boolean = true;
        ChatActivityFacade.a(this.app, str, this.jdField_a_of_type_JavaUtilArrayList, a(paramBoolean, this.jdField_a_of_type_Int, -1));
        A();
        return;
      }
      B();
      return;
    }
    B();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Int < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      this.jdField_b_of_type_JavaUtilArrayList.set(this.jdField_a_of_type_Int, str);
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_Int, str, this.jdField_b_of_type_JavaUtilArrayList.size());
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    b();
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(true);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    int i;
    if (paramBoolean)
    {
      str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (!str.equals(""))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b(str);
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b();
        w();
        localQQAppInterface = this.app;
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (this.s != null) {
          break label101;
        }
      }
    }
    label101:
    for (String str = "";; str = this.s)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(1), String.valueOf(i), str, String.valueOf(this.jdField_a_of_type_Int));
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.v = 1;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903114);
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.b();
    a();
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void n()
  {
    A();
    ChatActivityFacade.a(this.app, this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        b();
        if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_JavaUtilArrayList.size() - 1) {}
        for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int += 1)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
          break;
        }
        if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals(""))
        {
          QQToast.a(this, 2131372385, 1).a();
          return;
        }
        b();
        C();
        continue;
        a(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken());
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\bless\BlessSendTextActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */