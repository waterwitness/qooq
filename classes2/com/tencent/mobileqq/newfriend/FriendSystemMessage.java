package com.tencent.mobileqq.newfriend;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class FriendSystemMessage
  extends NewFriendMessage
{
  public MessageForSystemMsg a;
  
  public FriendSystemMessage(MessageForSystemMsg paramMessageForSystemMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg = paramMessageForSystemMsg;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.extStr;
    this.jdField_a_of_type_Long = paramMessageForSystemMsg.time;
  }
  
  public FriendSystemMessage(String paramString, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.req_uin.get());
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.parse();
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.req_uin_nick.get() + " " + this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.msg_describe.get());
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a() {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.isread;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\newfriend\FriendSystemMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */