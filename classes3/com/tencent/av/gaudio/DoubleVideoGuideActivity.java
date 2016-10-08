package com.tencent.av.gaudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import gic;
import mqq.app.BaseActivity;

public class DoubleVideoGuideActivity
  extends BaseActivity
{
  public static final String a = "DoubleVideoGuideActivity";
  int jdField_a_of_type_Int;
  ChatActivityUtils.StartVideoListener jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public DoubleVideoGuideActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Int = 10004;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener = new gic(this);
  }
  
  private boolean a()
  {
    Intent localIntent = getIntent();
    String str1 = localIntent.getStringExtra("peerUin");
    String str2 = localIntent.getStringExtra("name");
    String str3 = localIntent.getStringExtra("phoneNum");
    int i = localIntent.getIntExtra("uinType", 0);
    return ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, i, str1, str2, str3, true, null, true, true, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, "from_internal");
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Int == 2007) || (this.jdField_a_of_type_Int == 3007) || (this.jdField_a_of_type_Int == 4007)) {
        ReportController.b(null, "CliOper", "", "", "0X8004B69", "0X8004B69", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        finish();
        return;
        ReportController.b(null, "CliOper", "", "", "0X8004B66", "0X8004B66", 0, 0, "", "", "", "");
      }
      if ((this.jdField_a_of_type_Int == 2007) || (this.jdField_a_of_type_Int == 3007) || (this.jdField_a_of_type_Int == 4007)) {
        ReportController.b(null, "CliOper", "", "", "0X8004B6A", "0X8004B6A", 0, 0, "", "", "", "");
      }
      while (a())
      {
        finish();
        return;
        ReportController.b(null, "CliOper", "", "", "0X8004B67", "0X8004B67", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968686);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("DoubleVideoGuideActivity", 2, "onCreate");
    }
    super.setContentView(2130903540);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoubleVideoGuideActivity", 2, "onCreate-->can not get AppRuntime");
      }
      finish();
    }
    this.jdField_a_of_type_Int = getIntent().getIntExtra("sourceId", 10004);
    if ((this.jdField_a_of_type_Int == 2007) || (this.jdField_a_of_type_Int == 3007) || (this.jdField_a_of_type_Int == 4007))
    {
      ReportController.b(null, "CliOper", "", "", "0X8004B68", "0X8004B68", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8004B65", "0X8004B65", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gaudio\DoubleVideoGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */