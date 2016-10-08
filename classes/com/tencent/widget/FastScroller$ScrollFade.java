package com.tencent.widget;

import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FastScroller$ScrollFade
  implements Runnable
{
  static final int jdField_a_of_type_Int = 208;
  static final long c = 200L;
  long jdField_a_of_type_Long;
  long b;
  
  public FastScroller$ScrollFade(FastScroller paramFastScroller)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  int a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller.b() != 4) {
      return 208;
    }
    long l = SystemClock.uptimeMillis();
    if (l > this.jdField_a_of_type_Long + this.b) {
      return 0;
    }
    return (int)(208L - (l - this.jdField_a_of_type_Long) * 208L / this.b);
  }
  
  void a()
  {
    this.b = 200L;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentWidgetFastScroller.b(4);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentWidgetFastScroller.b() != 4)
    {
      a();
      return;
    }
    if (a() > 0)
    {
      this.jdField_a_of_type_ComTencentWidgetFastScroller.a.invalidate();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetFastScroller.b(0);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\FastScroller$ScrollFade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */