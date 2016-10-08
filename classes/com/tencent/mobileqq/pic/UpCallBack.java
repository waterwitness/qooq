package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageRecord;
import tencent.im.msg.im_msg_body.RichText;

public abstract interface UpCallBack
{
  public abstract MessageRecord a(im_msg_body.RichText paramRichText);
  
  public abstract void a(UpCallBack.SendResult paramSendResult);
  
  public abstract void b(UpCallBack.SendResult paramSendResult);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pic\UpCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */