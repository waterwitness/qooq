package com.tencent.mobileqq.systemmsg;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class MessageForSystemMsg
  extends ChatMessage
{
  public static final String TAG = "MessageForSystemMsg";
  public int mSysmsgMenuFlag;
  public structmsg.StructMsg structMsg;
  
  public MessageForSystemMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mSysmsgMenuFlag = 0;
    this.mSysmsgMenuFlag |= 0x1;
  }
  
  protected void doParse()
  {
    try
    {
      this.structMsg = new structmsg.StructMsg();
      this.structMsg.mergeFrom(this.msgData);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
  }
  
  public structmsg.StructMsg getSystemMsg()
  {
    if ((this.structMsg == null) && (!this.mIsParsed)) {
      parse();
    }
    return this.structMsg;
  }
  
  protected void postRead() {}
  
  protected void prewrite()
  {
    if (this.structMsg != null) {}
    try
    {
      this.msgData = this.structMsg.toByteArray();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\systemmsg\MessageForSystemMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */