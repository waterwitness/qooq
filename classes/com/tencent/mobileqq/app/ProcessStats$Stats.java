package com.tencent.mobileqq.app;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ProcessStats$Stats
  extends RecyclablePool.Recyclable
{
  public int a;
  public long a;
  public String a;
  public long b;
  public long c;
  public long d;
  
  public ProcessStats$Stats()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void recycle()
  {
    super.recycle();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ProcessStats$Stats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */