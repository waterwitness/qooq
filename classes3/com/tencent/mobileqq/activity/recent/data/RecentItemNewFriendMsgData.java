package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.ActivateFriendMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.qphone.base.util.QLog;

public class RecentItemNewFriendMsgData
  extends RecentUserBaseData
{
  private static final String a = "RecentItemNewFriendMsgData";
  int P;
  private boolean c;
  
  public RecentItemNewFriendMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.P = 0;
    this.jdField_c_of_type_Boolean = true;
    this.P = 2131367582;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemNewFriendMsgData", 2, "RecentItemNewFriendMsgData update");
    }
    super.a(paramQQAppInterface, paramContext);
    NewFriendManager localNewFriendManager = (NewFriendManager)paramQQAppInterface.getManager(33);
    NewFriendMessage localNewFriendMessage = localNewFriendManager.a();
    if ((localNewFriendMessage instanceof ActivateFriendMessage))
    {
      this.jdField_b_of_type_JavaLangString = paramContext.getString(2131371387);
      if (localNewFriendMessage != null) {
        break label235;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentItemNewFriendMsgData", 2, "isFirstShow = " + this.jdField_c_of_type_Boolean);
      }
      this.jdField_b_of_type_JavaLangCharSequence = "";
      this.H = 0;
      this.jdField_c_of_type_JavaLangCharSequence = "";
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_JavaLangString = "";
      if (AppSetting.j)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
        if (this.H != 0) {
          break label321;
        }
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
      this.jdField_b_of_type_JavaLangString = paramContext.getString(this.P);
      break;
      label235:
      this.jdField_c_of_type_JavaLangCharSequence = "";
      if (localNewFriendMessage.a(paramQQAppInterface) != null) {}
      for (paramQQAppInterface = localNewFriendMessage.a(paramQQAppInterface);; paramQQAppInterface = this.jdField_b_of_type_JavaLangCharSequence)
      {
        this.jdField_b_of_type_JavaLangCharSequence = paramQQAppInterface;
        this.H = localNewFriendManager.c();
        if (this.jdField_b_of_type_Long < localNewFriendMessage.a) {
          this.jdField_b_of_type_Long = localNewFriendMessage.a;
        }
        this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_b_of_type_Long);
        break;
      }
      label321:
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemNewFriendMsgData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */