package com.tencent.mfsdk.collector;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DropFrameMonitor$MonitorItem
  extends RecyclablePool.Recyclable
{
  public long a;
  public String a;
  public long[] a;
  public long b;
  public long c;
  
  public DropFrameMonitor$MonitorItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfLong = new long[6];
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfLong.length)
    {
      this.jdField_a_of_type_ArrayOfLong[i] = 0L;
      i += 1;
    }
    this.c = 0L;
  }
  
  public void recycle()
  {
    super.recycle();
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mfsdk\collector\DropFrameMonitor$MonitorItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */