package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qpk;

public class FramePerformanceMonitor
{
  private int jdField_a_of_type_Int;
  private FramePerformanceMonitor.FrameRefreshListener jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener;
  private GapDataCollector jdField_a_of_type_ComTencentMobileqqArGapDataCollector;
  private boolean jdField_a_of_type_Boolean;
  
  public FramePerformanceMonitor()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_ComTencentMobileqqArGapDataCollector = new GapDataCollector(100);
  }
  
  public long a(float paramFloat)
  {
    return this.jdField_a_of_type_ComTencentMobileqqArGapDataCollector.a(paramFloat).longValue();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener == null) {
      return;
    }
    ThreadManager.a(new qpk(this), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(FramePerformanceMonitor.FrameRefreshListener paramFrameRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor$FrameRefreshListener = paramFrameRefreshListener;
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqArGapDataCollector.a(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqArGapDataCollector.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\FramePerformanceMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */