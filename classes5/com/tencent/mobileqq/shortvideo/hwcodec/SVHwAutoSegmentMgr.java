package com.tencent.mobileqq.shortvideo.hwcodec;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicReference;

public class SVHwAutoSegmentMgr
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public AtomicReference a;
  private long b;
  
  public SVHwAutoSegmentMgr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramLong;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    if (((this.b - this.jdField_a_of_type_Long) / HwEnvData.jdField_a_of_type_Int == this.jdField_a_of_type_Int + 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null))
    {
      float f = (float)(paramLong2 * 1000.0D / paramLong1);
      ((SVHwEncoder)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).a(f, -1);
      this.jdField_a_of_type_Int += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\hwcodec\SVHwAutoSegmentMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */