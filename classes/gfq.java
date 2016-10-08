import android.os.Bundle;
import com.tencent.av.app.AvAddFriendService;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gfq
  extends FriendListObserver
{
  public gfq(AvAddFriendService paramAvAddFriendService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onAddFriend 进入好友列表" + paramString);
    }
    AvAddFriendService.a(this.a, paramString, 4);
    this.a.a(paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 147)
    {
      if (QLog.isColorLevel()) {
        QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onQueryUinSafetyFlag isSuccess=" + paramBoolean + ",status=" + paramInt2 + ",uin=" + paramLong);
      }
      if ((!paramBoolean) || (paramInt2 == 0)) {
        AvAddFriendService.a(this.a, String.valueOf(paramLong));
      }
    }
    else
    {
      return;
    }
    AvAddFriendService.a(this.a, String.valueOf(paramLong), 3, paramInt2);
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("uin");
    int i = paramBundle.getInt("friend_setting");
    if (QLog.isColorLevel()) {
      QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onUpdateAddFriendSetting  isSuccess= " + paramBoolean + ",uin" + str + ",friendSetting=" + i);
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(str)) && (i == 0)) {
      this.a.jdField_a_of_type_Boolean = true;
    }
    do
    {
      return;
      localFriendListHandler.a(str, null, i, (byte)0, "", this.a.f, 0, true, null, true, "", "");
    } while (!paramBoolean);
    if (this.a.a(str) == 2) {
      this.a.c(str);
    }
    for (;;)
    {
      paramBundle.getStringArrayList("user_question");
      paramBundle.getBoolean("contact_bothway");
      return;
      AvAddFriendService.a(this.a, str, 1);
      this.a.a(str);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    paramObject = String.valueOf((Long)paramObject);
    if (QLog.isColorLevel()) {
      QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onUpdateDelFriend 删除好友" + (String)paramObject);
    }
    AvAddFriendService.a(this.a, (String)paramObject, 0);
    this.a.a((String)paramObject);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "好友onUpdateCustomHead success = " + paramBoolean + ", uin = " + paramString);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onGetAutoInfo  isSuccess= " + paramBoolean + ",uin=" + paramString1 + ",remark=" + paramString2 + ",groupId" + paramInt);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    super.a(paramBoolean1, paramBoolean2, paramBoolean3, paramString, paramBundle);
    int i = paramBundle.getInt("friend_setting");
    if (QLog.isColorLevel()) {
      QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onUpdateAddFriend 请求加好友回调  isSuccess= " + paramBoolean1 + ",addSuccess=" + paramBoolean2 + ",reqestUin=" + paramString + ",friendSetting" + i);
    }
    if ((paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().equals(paramString)) && (i == 0)) {
      this.a.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\gfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */