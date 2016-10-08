package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uin,type")
public class DraftTextInfo
  extends Entity
{
  public int mSourceMsgTime;
  public String mSourceRichMsg;
  public int mSourceSummaryFlag;
  public int mSourceType;
  public long sourceMsgSeq;
  public String sourceMsgText;
  public long sourceSenderUin;
  public String text;
  public long time;
  public int type;
  @unique
  public String uin;
  
  public DraftTextInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\DraftTextInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */