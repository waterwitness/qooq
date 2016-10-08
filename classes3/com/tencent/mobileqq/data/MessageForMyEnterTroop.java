package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForMyEnterTroop
  extends ChatMessage
{
  public int iMemberCount;
  
  public MessageForMyEnterTroop()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iMemberCount = 1;
  }
  
  protected void doParse() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForMyEnterTroop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */