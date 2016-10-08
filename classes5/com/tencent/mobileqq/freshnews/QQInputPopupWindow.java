package com.tencent.mobileqq.freshnews;

import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dating.widget.InputBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.InputWindow;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;

public class QQInputPopupWindow
  extends InputWindow
{
  private QQInputPopupWindow.IQQInputPopupWindowCallback jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public QQInputPopupWindow(BaseActivity paramBaseActivity, boolean paramBoolean, ListView paramListView, int paramInt, String paramString1, String paramString2, QQInputPopupWindow.IQQInputPopupWindowCallback paramIQQInputPopupWindowCallback)
  {
    super(paramBaseActivity, paramBoolean, paramListView, paramInt);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback = paramIQQInputPopupWindowCallback;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    a();
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback.a();; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentWidgetListView, this.h, i);
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback != null) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback.a();
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_JavaLangString.length());
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
        return;
      }
      if (!TextUtils.isEmpty(this.b))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(this.b);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
      return;
    }
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback.a(paramString);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback.b(str);
    }
  }
  
  public void show()
  {
    super.show();
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputPopupWindow$IQQInputPopupWindowCallback.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\QQInputPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */