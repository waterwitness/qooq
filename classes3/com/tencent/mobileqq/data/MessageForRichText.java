package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import tencent.im.msg.im_msg_body.RichText;

public abstract class MessageForRichText
  extends ChatMessage
{
  public im_msg_body.RichText richText;
  
  public MessageForRichText()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForRichText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */