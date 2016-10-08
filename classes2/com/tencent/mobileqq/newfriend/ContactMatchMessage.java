package com.tencent.mobileqq.newfriend;

import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ContactMatchMessage
  extends NewFriendMessage
{
  public ContactMatch a;
  
  public ContactMatchMessage(ContactMatch paramContactMatch)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataContactMatch = paramContactMatch;
    this.jdField_a_of_type_Long = paramContactMatch.timestamp;
  }
  
  public void a() {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataContactMatch.isReaded;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\newfriend\ContactMatchMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */