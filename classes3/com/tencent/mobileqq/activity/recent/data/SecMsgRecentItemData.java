package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecMsgManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SecMsgRecentItemData
  extends RecentUserBaseData
{
  public SecMsgRecentItemData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    paramQQAppInterface = (SecMsgManager)paramQQAppInterface.getManager(56);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = paramContext.getResources().getString(2131371329);
    }
    this.jdField_b_of_type_JavaLangCharSequence = "";
    this.jdField_c_of_type_JavaLangCharSequence = "";
    if ((paramQQAppInterface != null) && (paramQQAppInterface.e()))
    {
      this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface.a(paramContext);
      this.J = paramContext.getResources().getColor(2131428324);
      this.jdField_b_of_type_Long = this.a.lastmsgtime;
      if (this.jdField_b_of_type_Long > 0L) {
        this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_b_of_type_Long);
      }
      if (AppSetting.j)
      {
        paramQQAppInterface = new StringBuilder(24);
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
        if (this.H != 0) {
          break label231;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_c_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(' ').append(this.jdField_c_of_type_JavaLangString);
      this.d = paramQQAppInterface.toString();
      return;
      this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131371334);
      break;
      label231:
      if (this.H == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.H == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.H > 0) {
        paramQQAppInterface.append("有").append(this.H).append("条未读");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\SecMsgRecentItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */