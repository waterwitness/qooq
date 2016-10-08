package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForEmo
  extends ChatMessage
{
  public MessageForEmo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForEmo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */