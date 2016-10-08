package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

public class MessageForLongTextMsg
  extends MessageForText
{
  public boolean loading;
  public String mFileName;
  public long mFileSize;
  public String mResid;
  public AbsStructMsg structingMsg;
  
  public MessageForLongTextMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse()
  {
    doParse(false);
  }
  
  public String getSummaryMsg()
  {
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.w(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    super.postRead();
  }
  
  protected void prewrite()
  {
    super.prewrite();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForLongTextMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */