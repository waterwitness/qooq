package com.tencent.mobileqq.newfriend;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;

public class ActivateFriendMessage
  extends NewFriendMessage
{
  private static final String b = "ActivateFriendMessage";
  public MessageForActivateFriends a;
  
  public ActivateFriendMessage(MessageForActivateFriends paramMessageForActivateFriends)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsMessageForActivateFriends = paramMessageForActivateFriends;
    this.jdField_a_of_type_Long = paramMessageForActivateFriends.time;
  }
  
  private boolean b(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("isOutOfDate ");
    }
    SubMsgType0x76.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsMessageForActivateFriends.getMsgBody();
    boolean bool;
    if (localMsgBody.uint32_msg_type.get() == 2)
    {
      int j = localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().size();
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
      int i = 0;
      if (i < j)
      {
        long l = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint64_uin.get();
        if (QLog.isColorLevel()) {
          localStringBuilder.append(l);
        }
        if (!paramQQAppInterface.b(String.valueOf(l))) {
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" not friend");
          }
        }
        int k;
        int m;
        do
        {
          i += 1;
          break;
          k = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_month.get();
          m = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_date.get();
        } while (ActivateFriendsManager.a(((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_year.get(), k, m) == 0);
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" not expired");
          bool = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(bool);
        QLog.d("ActivateFriendMessage", 2, localStringBuilder.toString());
      }
      return bool;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  public String a()
  {
    SubMsgType0x76.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsMessageForActivateFriends.getMsgBody();
    if ((localMsgBody.uint32_msg_type.get() == 2) && (localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().size() < 0)) {
      return String.valueOf(((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(0)).uint64_uin.get());
    }
    return super.a();
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsMessageForActivateFriends.msg;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a() {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsMessageForActivateFriends.isread;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = true;
    try
    {
      boolean bool2 = b(paramQQAppInterface);
      if (bool2) {
        bool1 = false;
      }
      return bool1;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return true;
    }
    catch (NoSuchFieldError paramQQAppInterface) {}
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\newfriend\ActivateFriendMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */