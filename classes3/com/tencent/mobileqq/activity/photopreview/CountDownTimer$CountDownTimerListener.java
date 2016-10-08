package com.tencent.mobileqq.activity.photopreview;

import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class CountDownTimer$CountDownTimerListener
{
  private long jdField_a_of_type_Long;
  private CountDownTimer jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer;
  private long b;
  
  public CountDownTimer$CountDownTimerListener(long paramLong)
  {
    a(paramLong);
  }
  
  public CountDownTimer$CountDownTimerListener(CountDownTimer paramCountDownTimer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer = paramCountDownTimer;
  }
  
  public final void a()
  {
    long l = this.jdField_a_of_type_Long - SystemClock.elapsedRealtime();
    if (l > 1000L)
    {
      b(l);
      return;
    }
    b();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.a(paramLong);
    }
    this.b = paramLong;
    this.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() + 1000L * paramLong);
  }
  
  public abstract void b();
  
  public abstract void b(long paramLong);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photopreview\CountDownTimer$CountDownTimerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */