package com.tencent.mobileqq.dating.widget;

import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dating.DatingComment;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingStranger;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.InputWindow;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;

public class DatingInputPopupWindow
  extends InputWindow
{
  private DatingComment jdField_a_of_type_ComTencentMobileqqDatingDatingComment;
  private DatingInputPopupWindow.IDatingInputPopupWindowCallback jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingInputPopupWindow$IDatingInputPopupWindowCallback;
  private NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public DatingInputPopupWindow(BaseActivity paramBaseActivity, boolean paramBoolean, ListView paramListView, int paramInt, DatingComment paramDatingComment, DatingInputPopupWindow.IDatingInputPopupWindowCallback paramIDatingInputPopupWindowCallback, String paramString)
  {
    super(paramBaseActivity, paramBoolean, paramListView, paramInt);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment = paramDatingComment;
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingInputPopupWindow$IDatingInputPopupWindowCallback = paramIDatingInputPopupWindowCallback;
    if ((paramBaseActivity instanceof NearbyTitleBarActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyTitleBarActivity)paramBaseActivity).b;
    }
    a();
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentWidgetListView, this.h, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    DatingManager localDatingManager = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
    String str1;
    if (localDatingManager == null)
    {
      str1 = "";
      if (!TextUtils.isEmpty(str1))
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(str1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(str1.length());
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
      }
    }
    else
    {
      String str2 = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment == null) {}
      for (str1 = null;; str1 = this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_JavaLangString)
      {
        str1 = localDatingManager.a(str2, str1);
        break;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(String.format("回复%s：", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger.jdField_a_of_type_JavaLangString }));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("添加评论...");
    }
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingInputPopupWindow$IDatingInputPopupWindowCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingInputPopupWindow$IDatingInputPopupWindowCallback.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    String str2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    DatingManager localDatingManager = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(212);
    String str3;
    if (localDatingManager != null)
    {
      str3 = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment != null) {
        break label58;
      }
    }
    label58:
    for (String str1 = "";; str1 = this.jdField_a_of_type_ComTencentMobileqqDatingDatingComment.jdField_a_of_type_JavaLangString)
    {
      localDatingManager.a(str3, str1, str2);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\widget\DatingInputPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */