package com.tencent.mobileqq.newfriend;

import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ContactBindedMessage
  extends NewFriendMessage
{
  public ContactBinded a;
  
  public ContactBindedMessage(ContactBinded paramContactBinded)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataContactBinded = paramContactBinded;
    this.jdField_a_of_type_Long = paramContactBinded.timestamp;
  }
  
  public void a() {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataContactBinded.isReaded;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\newfriend\ContactBindedMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */