package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class RecentItemActivateFriendsData
  extends RecentUserBaseData
{
  private static final String a = "ActivateFriends.Recent";
  
  public RecentItemActivateFriendsData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label111:
    do
    {
      return;
      super.a(paramQQAppInterface, paramContext);
      QQMessageFacade.Message localMessage = null;
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
      if (localQQMessageFacade != null) {
        localMessage = localQQMessageFacade.a(this.a.uin, this.a.type);
      }
      if (localMessage == null) {
        break label242;
      }
      this.jdField_b_of_type_Long = localMessage.time;
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface == null) {
        break;
      }
      this.H = paramQQAppInterface.a(localMessage.frienduin, localMessage.istroop);
      this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_b_of_type_Long);
      this.jdField_b_of_type_JavaLangCharSequence = localMessage.getMessageText();
      d();
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramContext.getString(2131371386);
      }
    } while (!AppSetting.j);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
    if (this.H == 0) {}
    for (;;)
    {
      if (this.jdField_c_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
      this.d = paramQQAppInterface.toString();
      return;
      this.H = 0;
      break;
      label242:
      this.H = 0;
      this.jdField_b_of_type_Long = 0L;
      if (QLog.isColorLevel()) {
        QLog.e("ActivateFriends.Recent", 2, "RecentActivateFriends update, last msg is null");
      }
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_b_of_type_JavaLangCharSequence = "";
      break label111;
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemActivateFriendsData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */