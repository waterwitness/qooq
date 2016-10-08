package com.tencent.mobileqq.persistence.fts;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public abstract class FTSOptSync
  extends Entity
{
  public String mContent;
  public long mOId;
  public int mOpt;
  public int mType;
  
  public FTSOptSync()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\fts\FTSOptSync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */