package com.tencent.mobileqq.structmsg.view;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgNode;

public class StructMsgItemVote$OptionItem
{
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public StructMsgItemVote$OptionItem(StructMsgItemVote paramStructMsgItemVote, StructMsgNode paramStructMsgNode)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (paramStructMsgNode == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramStructMsgNode.a("c");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramStructMsgNode.a("r");
    }
    this.b = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
  }
  
  public StructMsgItemVote$OptionItem(StructMsgItemVote paramStructMsgItemVote, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemVote$OptionItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */