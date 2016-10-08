package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForVideoVip
  extends ChatMessage
{
  public String url;
  public String wording;
  
  public MessageForVideoVip()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse()
  {
    if (this.msg != null) {}
    for (String[] arrayOfString = this.msg.split("\\|");; arrayOfString = null)
    {
      if ((arrayOfString != null) && (arrayOfString.length == 2))
      {
        this.wording = arrayOfString[0];
        this.url = arrayOfString[1];
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForVideoVip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */