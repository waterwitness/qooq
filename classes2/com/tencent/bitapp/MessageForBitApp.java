package com.tencent.bitapp;

import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForBitApp
  extends ChatMessage
{
  public BitAppMsg bitAppMsg;
  
  public MessageForBitApp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.versionCode = 3;
  }
  
  public MessageForBitApp(MessageRecord paramMessageRecord)
  {
    this.extInt = paramMessageRecord.extInt;
    this.extLong = paramMessageRecord.extLong;
    this.extraflag = paramMessageRecord.extraflag;
    this.extStr = paramMessageRecord.extStr;
    this.frienduin = paramMessageRecord.frienduin;
    this.isread = paramMessageRecord.isread;
    this.issend = paramMessageRecord.issend;
    this.istroop = paramMessageRecord.istroop;
    this.isValid = paramMessageRecord.isValid;
    this.longMsgCount = paramMessageRecord.longMsgCount;
    this.longMsgId = paramMessageRecord.longMsgId;
    this.longMsgIndex = paramMessageRecord.longMsgIndex;
    this.msg = paramMessageRecord.msg;
    this.msgData = paramMessageRecord.msgData;
    this.msgseq = paramMessageRecord.msgseq;
    this.msgtype = paramMessageRecord.msgtype;
    this.msgUid = paramMessageRecord.msgUid;
    this.selfuin = paramMessageRecord.selfuin;
    this.senderuin = paramMessageRecord.senderuin;
    this.sendFailCode = paramMessageRecord.sendFailCode;
    this.shmsgseq = paramMessageRecord.shmsgseq;
    this.time = paramMessageRecord.time;
    this.uniseq = paramMessageRecord.uniseq;
    this.versionCode = paramMessageRecord.versionCode;
    this.vipBubbleID = paramMessageRecord.vipBubbleID;
    this.bitAppMsg = BitAppMsgFactory.a(this.msgData);
    if (this.bitAppMsg != null) {
      this.msg = this.bitAppMsg.getSummery();
    }
  }
  
  protected void doParse()
  {
    this.bitAppMsg = BitAppMsgFactory.a(this.msgData);
    if (this.bitAppMsg != null) {
      this.msg = this.bitAppMsg.getSummery();
    }
  }
  
  public String getContentForSearch()
  {
    if (this.bitAppMsg != null) {
      return this.bitAppMsg.mMsgBrief;
    }
    return null;
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.w(this.istroop);
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    if (this.bitAppMsg != null) {}
    try
    {
      this.msgData = this.bitAppMsg.getBytes();
      this.msg = this.bitAppMsg.getSummery();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("ID: " + getId()).append(", ");
    localStringBuilder.append("STATUS: " + getStatus()).append(", ");
    localStringBuilder.append("TIME: " + this.time).append(", ");
    localStringBuilder.append("UNISEQ: " + this.uniseq);
    if ("state: " + this.bitAppMsg != null) {}
    for (Object localObject = Integer.valueOf(this.bitAppMsg.mState);; localObject = "")
    {
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      localStringBuilder.append(super.toString());
      return localStringBuilder.toString();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\MessageForBitApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */