package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForTroopUnreadTips
  extends ChatMessage
{
  public MessageForTroopUnreadTips()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForTroopUnreadTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */