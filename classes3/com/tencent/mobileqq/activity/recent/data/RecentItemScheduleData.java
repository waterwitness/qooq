package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class RecentItemScheduleData
  extends RecentUserBaseData
{
  public long a;
  
  public RecentItemScheduleData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    if (AppSetting.j)
    {
      paramQQAppInterface = new StringBuilder(24);
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
      if (this.H != 0) {
        break label102;
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
      label102:
      if (this.H == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.H == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.H > 0) {
        paramQQAppInterface.append("有").append(this.H).append("条未读");
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.a = paramLong;
    this.jdField_c_of_type_JavaLangString = TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemScheduleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */