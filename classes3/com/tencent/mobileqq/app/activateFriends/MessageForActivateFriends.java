package com.tencent.mobileqq.app.activateFriends;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;

public class MessageForActivateFriends
  extends ChatMessage
{
  private static final String TAG = "ActivateFriends.Message";
  public SubMsgType0x76.MsgBody msgBody;
  
  public MessageForActivateFriends()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse()
  {
    try
    {
      this.msgBody = new SubMsgType0x76.MsgBody();
      this.msgBody.mergeFrom(this.msgData);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ActivateFriends.Message", 2, "Message parse error.", localException);
    }
  }
  
  public SubMsgType0x76.MsgBody getMsgBody()
  {
    if ((this.msgBody == null) && (!this.mIsParsed)) {
      parse();
    }
    return this.msgBody;
  }
  
  protected void postwrite() {}
  
  protected void prewrite() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\activateFriends\MessageForActivateFriends.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */