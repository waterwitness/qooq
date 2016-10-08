package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VidUrl
{
  private static final long b = 3600000L;
  public long a;
  public String a;
  public String b;
  
  public VidUrl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean a(long paramLong)
  {
    return (paramLong - this.a > 0L) && (paramLong - this.a < 3600000L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\struct\VidUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */