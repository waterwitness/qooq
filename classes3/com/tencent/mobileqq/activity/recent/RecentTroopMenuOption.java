package com.tencent.mobileqq.activity.recent;

import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import oyc;

public class RecentTroopMenuOption
{
  protected static final int a = 2;
  private static final String jdField_a_of_type_JavaLangString = "RecentTroopMenuOption";
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  public QQProgressNotifier a;
  
  public RecentTroopMenuOption(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_set_right", 0, 0, paramString1, String.valueOf(i - 1), "", "");
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    localActionSheet.a(localResources.getString(2131369944, new Object[] { paramString2 }));
    localActionSheet.a(localResources.getString(2131364688), false);
    localActionSheet.a(localResources.getString(2131364689), false);
    localActionSheet.a(localResources.getString(2131364690), false);
    localActionSheet.a(localResources.getString(2131364691), false);
    i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(String.valueOf(paramString1));
    switch (i)
    {
    }
    for (;;)
    {
      localActionSheet.d(2131367262);
      localActionSheet.a(new oyc(this, i, paramString1, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.e(0);
      continue;
      localActionSheet.e(1);
      continue;
      localActionSheet.e(2);
      continue;
      localActionSheet.e(3);
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    a(paramRecentBaseData.a(), paramRecentBaseData.b());
  }
  
  public void a(RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    TroopAssistantManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = paramRecentBaseData.a();
    if (paramBoolean) {}
    for (paramRecentBaseData = "1";; paramRecentBaseData = "0")
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_top_right", 0, 0, str, "4", paramRecentBaseData, "");
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentTroopMenuOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */