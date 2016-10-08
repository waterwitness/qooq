package com.tencent.mobileqq.newfriend;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.FriendAnniver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FriendAnniverMessage
  extends NewFriendMessage
{
  public FriendAnniver a;
  
  public FriendAnniverMessage(FriendAnniver paramFriendAnniver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver = paramFriendAnniver;
    this.jdField_a_of_type_Long = paramFriendAnniver.timestamp;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver.uin;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    Friends localFriends;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).c(this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver.uin);
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver.uin;
      if (localFriends != null)
      {
        if (!TextUtils.isEmpty(localFriends.remark)) {
          break label121;
        }
        if (!TextUtils.isEmpty(localFriends.name)) {
          break label113;
        }
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver.uin;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver.year + "年前的今天，你和" + paramQQAppInterface + "成为好友。");
      return this.jdField_a_of_type_JavaLangString;
      label113:
      paramQQAppInterface = localFriends.name;
      continue;
      label121:
      paramQQAppInterface = localFriends.remark;
    }
  }
  
  public void a() {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriendAnniver.isReed;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\newfriend\FriendAnniverMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */