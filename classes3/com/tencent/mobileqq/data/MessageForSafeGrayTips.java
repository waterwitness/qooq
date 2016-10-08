package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.SafeMsg.SafeMoreInfo;

public class MessageForSafeGrayTips
  extends ChatMessage
{
  private String TAG;
  public SafeMsg.SafeMoreInfo safeInfo;
  
  public MessageForSafeGrayTips()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.TAG = "Q.msg.SafeGrayTips";
  }
  
  public void doParse()
  {
    this.safeInfo = new SafeMsg.SafeMoreInfo();
    QLog.d(this.TAG, 2, "doParse versionCode:" + this.versionCode);
    if (this.versionCode < 3)
    {
      super.postRead();
      QLog.d(this.TAG, 2, "doParse oldversion");
      return;
    }
    try
    {
      this.safeInfo.mergeFrom(this.msgData);
      QLog.d(this.TAG, 2, "doParse msg:");
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
      QLog.d(this.TAG, 2, "dopase exception:" + localInvalidProtocolBufferMicroException.getMessage());
    }
  }
  
  protected void postRead()
  {
    this.msgId = getLogicMsgID(getId(), this.versionCode);
    parse();
  }
  
  protected void prewrite()
  {
    QLog.d(this.TAG, 2, "prewrite versionCode:" + this.versionCode);
    if (this.versionCode < 3) {
      super.prewrite();
    }
    while (this.safeInfo == null) {
      return;
    }
    this.msgData = this.safeInfo.toByteArray();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForSafeGrayTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */