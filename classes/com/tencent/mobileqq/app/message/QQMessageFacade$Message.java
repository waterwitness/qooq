package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.notColumn;

public class QQMessageFacade$Message
  extends MessageRecord
{
  public String actMsgContentValue;
  public String action;
  public int bizType;
  public int counter;
  public CharSequence emoRecentMsg;
  public long fileSize;
  public int fileType;
  public boolean hasReply;
  @notColumn
  public boolean isCacheValid;
  public Boolean isInWhisper;
  public String latestNormalMsgString;
  public String nickName;
  public String pttUrl;
  public long shareAppID;
  @Deprecated
  public int unReadNum;
  
  public QQMessageFacade$Message()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.fileType = -1;
    this.fileSize = -1L;
    this.isInWhisper = Boolean.valueOf(false);
    this.isCacheValid = true;
    this.bizType = -1;
  }
  
  public void cleanMessageRecordBaseField()
  {
    this.msg = null;
    this.emoRecentMsg = null;
    this.fileType = -1;
  }
  
  protected Class getClassForTable()
  {
    return Message.class;
  }
  
  public CharSequence getMessageText()
  {
    if (this.emoRecentMsg == null) {
      return this.msg;
    }
    return this.emoRecentMsg;
  }
  
  public boolean needNotification()
  {
    return (this.bizType == 14) || (this.bizType == 9) || (this.bizType == 3) || (this.bizType == 7) || (this.bizType == 16) || (this.bizType == 2) || (this.bizType == 8);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\QQMessageFacade$Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */