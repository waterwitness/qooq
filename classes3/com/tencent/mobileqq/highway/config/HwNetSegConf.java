package com.tencent.mobileqq.highway.config;

import java.io.Serializable;

public class HwNetSegConf
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 3334652520215468712L;
  public long curConnNum;
  public long netType;
  public long segNum;
  public long segSize;
  
  public HwNetSegConf(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.netType = paramLong1;
    this.segSize = paramLong2;
    this.segNum = paramLong3;
    this.curConnNum = paramLong4;
  }
  
  public HwNetSegConf clone()
    throws CloneNotSupportedException
  {
    return (HwNetSegConf)super.clone();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\config\HwNetSegConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */