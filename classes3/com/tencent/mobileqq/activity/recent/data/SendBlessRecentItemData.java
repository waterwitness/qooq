package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class SendBlessRecentItemData
  extends RecentUserBaseData
{
  public SendBlessRecentItemData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    BlessManager localBlessManager = (BlessManager)paramQQAppInterface.getManager(137);
    BlessTask localBlessTask = localBlessManager.a();
    int i;
    if (!localBlessManager.h())
    {
      this.jdField_b_of_type_JavaLangString = paramContext.getResources().getString(2131372352);
      this.jdField_b_of_type_JavaLangCharSequence = localBlessManager.e();
      this.jdField_c_of_type_JavaLangCharSequence = "";
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800618A", "0X800618A", 0, 0, "", "", "", "");
      if (localBlessManager.a() < 0) {
        break label374;
      }
      if (localBlessManager.a() != 0) {
        break label368;
      }
      i = 2;
      label98:
      this.G = i;
    }
    label368:
    label374:
    for (this.H = 1;; this.H = 0)
    {
      this.jdField_b_of_type_Long = this.a.lastmsgtime;
      if (this.jdField_b_of_type_Long > 0L) {
        this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_b_of_type_Long);
      }
      localBlessManager.d();
      if (AppSetting.j)
      {
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
        if (this.H == 1) {
          paramQQAppInterface.append("有一条未读");
        }
        if (this.jdField_c_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(' ').append(this.jdField_c_of_type_JavaLangString);
        this.d = paramQQAppInterface.toString();
      }
      return;
      if (localBlessTask == null) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = localBlessTask.starWord;
      this.jdField_b_of_type_JavaLangCharSequence = localBlessTask.starBless;
      this.jdField_c_of_type_JavaLangCharSequence = localBlessTask.ex2;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence))
      {
        this.jdField_c_of_type_JavaLangCharSequence = ("[" + this.jdField_c_of_type_JavaLangCharSequence + "] ");
        this.J = paramContext.getResources().getColor(2131428324);
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800632B", "0X800632B", 0, 0, "", "", "", "");
      break;
      i = 1;
      break label98;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\SendBlessRecentItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */