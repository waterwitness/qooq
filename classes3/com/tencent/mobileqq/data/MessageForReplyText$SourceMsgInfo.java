package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.Serializable;

public class MessageForReplyText$SourceMsgInfo
  implements Serializable
{
  public static final int REPLY_TYPE_NORMAL = 0;
  public static final int REPLY_TYPE_SHARE_COMMENT = 1;
  public static final int SOURCE_SUMMARY_FLAG_CPMPLETE = 1;
  public static final int SOURCE_SUMMARY_FLAG_DIRTY = 0;
  private static final long serialVersionUID = 1L;
  public String mAnonymousNickName;
  public int mLocalAtInfoDone;
  public String mRichMsg;
  public long mSourceMsgSenderUin;
  public long mSourceMsgSeq;
  public String mSourceMsgText;
  public int mSourceMsgTime;
  public int mSourceSummaryFlag;
  public int mType;
  
  public MessageForReplyText$SourceMsgInfo()
  {
    this.mSourceSummaryFlag = 1;
  }
  
  public MessageForReplyText$SourceMsgInfo(SourceMsgInfo paramSourceMsgInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mSourceSummaryFlag = 1;
    this.mSourceMsgSeq = paramSourceMsgInfo.mSourceMsgSeq;
    this.mSourceMsgSenderUin = paramSourceMsgInfo.mSourceMsgSenderUin;
    this.mSourceMsgText = paramSourceMsgInfo.mSourceMsgText;
    this.mSourceMsgTime = paramSourceMsgInfo.mSourceMsgTime;
    this.mAnonymousNickName = paramSourceMsgInfo.mAnonymousNickName;
    this.mSourceSummaryFlag = paramSourceMsgInfo.mSourceSummaryFlag;
    this.mType = paramSourceMsgInfo.mType;
    this.mRichMsg = paramSourceMsgInfo.mRichMsg;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForReplyText$SourceMsgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */