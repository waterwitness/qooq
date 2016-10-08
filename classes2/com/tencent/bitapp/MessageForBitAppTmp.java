package com.tencent.bitapp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MessageForBitAppTmp
  extends MessageForBitApp
{
  public boolean isCanRetry;
  public int tryCounts;
  
  public MessageForBitAppTmp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MessageForBitAppTmp(MessageForBitApp paramMessageForBitApp)
  {
    this.extInt = paramMessageForBitApp.extInt;
    this.extLong = paramMessageForBitApp.extLong;
    this.extraflag = paramMessageForBitApp.extraflag;
    this.extStr = paramMessageForBitApp.extStr;
    this.frienduin = paramMessageForBitApp.frienduin;
    this.isread = paramMessageForBitApp.isread;
    this.issend = paramMessageForBitApp.issend;
    this.istroop = paramMessageForBitApp.istroop;
    this.isValid = paramMessageForBitApp.isValid;
    this.longMsgCount = paramMessageForBitApp.longMsgCount;
    this.longMsgId = paramMessageForBitApp.longMsgId;
    this.longMsgIndex = paramMessageForBitApp.longMsgIndex;
    this.msg = paramMessageForBitApp.msg;
    if (paramMessageForBitApp.bitAppMsg == null) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = paramMessageForBitApp.bitAppMsg.getBytes())
    {
      this.msgData = arrayOfByte;
      this.msgseq = paramMessageForBitApp.msgseq;
      this.msgtype = paramMessageForBitApp.msgtype;
      this.msgUid = paramMessageForBitApp.msgUid;
      this.selfuin = paramMessageForBitApp.selfuin;
      this.senderuin = paramMessageForBitApp.senderuin;
      this.sendFailCode = paramMessageForBitApp.sendFailCode;
      this.shmsgseq = paramMessageForBitApp.shmsgseq;
      this.time = paramMessageForBitApp.time;
      this.uniseq = paramMessageForBitApp.uniseq;
      this.versionCode = paramMessageForBitApp.versionCode;
      this.vipBubbleID = paramMessageForBitApp.vipBubbleID;
      this.bitAppMsg = BitAppMsgFactory.a(this.msgData);
      return;
    }
  }
  
  public static String getTableName_v()
  {
    return "mr_bitapp";
  }
  
  public String getTableName()
  {
    return getTableName_v();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("ID: " + getId()).append(", ");
    localStringBuilder.append("STATUS: " + getStatus()).append(", ");
    localStringBuilder.append("TIME: " + this.time).append(", ");
    localStringBuilder.append("UNISEQ: " + this.uniseq).append(", ");
    localStringBuilder.append("TRYCOUNTS: " + this.tryCounts);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\MessageForBitAppTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */