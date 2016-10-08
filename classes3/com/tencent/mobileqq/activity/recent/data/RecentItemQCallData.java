package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;

public class RecentItemQCallData
  extends RecentUserBaseData
{
  public RecentItemQCallData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
    a(paramQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary);
    super.a(paramQQAppInterface, paramContext);
    if (AppSetting.j)
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
      if (this.H != 0) {
        break label142;
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
      this.d = paramQQAppInterface.toString();
      return;
      label142:
      if (this.H == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.H == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.H > 0) {
        paramQQAppInterface.append("有").append(this.H).append("条未读,");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemQCallData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */