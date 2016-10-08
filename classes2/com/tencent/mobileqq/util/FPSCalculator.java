package com.tencent.mobileqq.util;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.TimeUnit;
import vxt;

public class FPSCalculator
{
  private static FPSCalculator jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator = new FPSCalculator();
  private static final String jdField_a_of_type_JavaLangString = "FPSCalculator";
  private int jdField_a_of_type_Int = 500;
  private long jdField_a_of_type_Long;
  public Choreographer.FrameCallback a;
  private Choreographer jdField_a_of_type_AndroidViewChoreographer;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private FPSCalculator()
  {
    this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback = new vxt(this);
    a();
  }
  
  public static FPSCalculator a()
  {
    return jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator;
  }
  
  private static long b(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMillis(paramLong);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewChoreographer = Choreographer.getInstance();
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      this.jdField_a_of_type_Long = 0L;
      this.b = 0;
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\FPSCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */