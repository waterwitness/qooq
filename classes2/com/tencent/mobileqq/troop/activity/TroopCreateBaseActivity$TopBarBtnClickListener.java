package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopCreateBaseActivity$TopBarBtnClickListener
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  TroopCreateBaseActivity jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity;
  String jdField_a_of_type_JavaLangString;
  int d;
  
  public TroopCreateBaseActivity$TopBarBtnClickListener(TroopCreateBaseActivity paramTroopCreateBaseActivity, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity = paramTroopCreateBaseActivity;
    this.d = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity == null) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (this.d == 0) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.c();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.a(this.d);
      return;
      if (this.d == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.f();
      }
      else if (this.d == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.g();
        continue;
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.a;
        if (paramView != null) {
          paramView.a(this.jdField_a_of_type_JavaLangString, new String[] { "" });
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopCreateBaseActivity$TopBarBtnClickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */