package com.tencent.mobileqq.app;

import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadRegulator$CpuBusyness
  extends RecyclablePool.Recyclable
{
  public int a;
  public long a;
  public ConcurrentHashMap a;
  public long b;
  
  public ThreadRegulator$CpuBusyness()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  }
  
  public void recycle()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    super.recycle();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ThreadRegulator$CpuBusyness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */