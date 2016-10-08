package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public abstract class BaseRecentUser
  extends Entity
{
  public boolean mIsParsed;
  
  public BaseRecentUser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected abstract void doParse();
  
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


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\data\BaseRecentUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */