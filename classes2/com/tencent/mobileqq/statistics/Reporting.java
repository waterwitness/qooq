package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="mTag, mDetail")
public class Reporting
  extends Entity
  implements Cloneable
{
  public int mCount;
  public String mDetail;
  public int mDetailHashCode;
  public int mLockedCount;
  public int mSeqKey;
  public String mTag;
  
  public Reporting()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Reporting clone()
  {
    try
    {
      Reporting localReporting = (Reporting)super.clone();
      return localReporting;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\statistics\Reporting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */