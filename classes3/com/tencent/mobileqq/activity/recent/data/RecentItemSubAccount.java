package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemSubAccount
  extends RecentUserBaseData
{
  public RecentItemSubAccount(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.G = 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    MsgSummary localMsgSummary = a();
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131370492);
    Object localObject1 = SubAccountControll.a(paramQQAppInterface, this.a.uin);
    if (localObject1 != null)
    {
      localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      localMsgSummary.g = 1;
    }
    localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (this.H = ((ConversationFacade)localObject1).a(this.a.uin, this.a.type);; this.H = 7000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "RecentItemSubAccount.update mUser.uin=" + this.a.uin + " mUser.type=" + this.a.type + " mUnreadNum=" + this.H);
      }
      if (!AppConstants.ah.equals(this.a.uin)) {
        break label311;
      }
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_b_of_type_Long = a();
      a(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      if (!AppSetting.j) {
        break;
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
      if (this.H != 0) {
        break label594;
      }
      label232:
      if (this.jdField_c_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
      this.d = paramQQAppInterface.toString();
      return;
      this.H = 0;
    }
    label311:
    long l1 = ((SubAccountManager)paramQQAppInterface.getManager(60)).a(this.a.uin);
    long l2 = a();
    if (this.a.showUpTime > 0L)
    {
      label350:
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_b_of_type_Long = l1;
      localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);
      if (localObject1 == null) {
        break label659;
      }
    }
    label594:
    label659:
    for (localObject1 = ((FriendsManager)localObject1).c(this.a.uin);; localObject1 = null)
    {
      if ((localObject1 != null) && (((Friends)localObject1).name != null)) {}
      for (Object localObject2 = ((Friends)localObject1).name;; localObject2 = this.a.uin)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals(this.a.uin)) {}
        }
        else
        {
          String str = ContactUtils.c(paramQQAppInterface, this.a.uin, true);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = str;
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.a.uin;
        }
        this.jdField_b_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + " ( " + (String)localObject2 + " ) ");
        if ((!paramQQAppInterface.d) || (paramQQAppInterface.a == null) || (!paramQQAppInterface.a.c())) {
          break;
        }
        localObject1 = (FriendListHandler)paramQQAppInterface.a(1);
        if (localObject1 != null) {
          ((FriendListHandler)localObject1).b(this.a.uin);
        }
        paramQQAppInterface.d = false;
        break;
        l1 = Math.max(l2, l1);
        break label350;
      }
      if (this.H == 1)
      {
        paramQQAppInterface.append("有一条未读");
        break label232;
      }
      if (this.H == 2)
      {
        paramQQAppInterface.append("有两条未读");
        break label232;
      }
      if (this.H <= 0) {
        break label232;
      }
      paramQQAppInterface.append("有").append(this.H).append("条未读,");
      break label232;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemSubAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */