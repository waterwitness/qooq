package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ChatMessage
  extends MessageRecord
{
  public boolean isAioAnimChecked;
  public boolean isMarketFaceFlow;
  public boolean mAnimFlag;
  public boolean mIsParsed;
  @Deprecated
  public CharSequence mMessageSource;
  @Deprecated
  public boolean mNeedGrayTips;
  public boolean mNeedTimeStamp;
  public boolean mPendantAnimatable;
  
  public ChatMessage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected abstract void doParse();
  
  public String getSummaryMsg()
  {
    return this.msg;
  }
  
  public boolean isSupportReply()
  {
    return false;
  }
  
  public void parse()
  {
    if (!this.mIsParsed) {
      try
      {
        if (!this.mIsParsed)
        {
          doParse();
          this.mIsParsed = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public void reParse()
  {
    if (!this.mIsParsed) {
      return;
    }
    this.mIsParsed = false;
    parse();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ChatMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */