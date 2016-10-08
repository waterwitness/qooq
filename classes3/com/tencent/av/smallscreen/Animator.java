package com.tencent.av.smallscreen;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Animator
  extends Handler
{
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long;
  Animator.AnimatorListener jdField_a_of_type_ComTencentAvSmallscreenAnimator$AnimatorListener;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  long jdField_b_of_type_Long;
  float jdField_c_of_type_Float;
  long jdField_c_of_type_Long;
  long d;
  
  public Animator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_Long = 300L;
    this.jdField_b_of_type_Long = 0L;
    this.d = 10L;
  }
  
  public static Animator a(float paramFloat1, float paramFloat2)
  {
    Animator localAnimator = new Animator();
    localAnimator.jdField_c_of_type_Float = paramFloat1;
    localAnimator.jdField_b_of_type_Float = paramFloat2;
    return localAnimator;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public Animator a(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    }
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  void a()
  {
    long l3 = System.currentTimeMillis();
    long l4 = this.jdField_b_of_type_Long;
    long l2 = l3 - this.jdField_c_of_type_Long;
    long l1 = l2;
    if (l2 > this.jdField_a_of_type_Long) {
      l1 = this.jdField_a_of_type_Long;
    }
    if (l3 - l4 > this.d)
    {
      this.jdField_b_of_type_Long = l3;
      this.jdField_a_of_type_Float = ((float)l1 * (this.jdField_b_of_type_Float - this.jdField_c_of_type_Float) / (float)this.jdField_a_of_type_Long + this.jdField_c_of_type_Float);
      if (this.jdField_a_of_type_ComTencentAvSmallscreenAnimator$AnimatorListener != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenAnimator$AnimatorListener.a(this);
      }
      if (l1 >= this.jdField_a_of_type_Long) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    if (this.jdField_a_of_type_Boolean) {
      a(this.d);
    }
    while ((l1 < this.jdField_a_of_type_Long) || (this.jdField_a_of_type_ComTencentAvSmallscreenAnimator$AnimatorListener == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenAnimator$AnimatorListener.c(this);
  }
  
  void a(long paramLong)
  {
    removeMessages(0);
    sendMessageDelayed(obtainMessage(0), paramLong);
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenAnimator$AnimatorListener = paramAnimatorListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentAvSmallscreenAnimator$AnimatorListener != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenAnimator$AnimatorListener.b(this);
    }
    a();
  }
  
  public void b(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSmallscreenAnimator$AnimatorListener != null)) {
      this.jdField_a_of_type_ComTencentAvSmallscreenAnimator$AnimatorListener.d(this);
    }
    c();
  }
  
  public void handleMessage(Message paramMessage)
  {
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\smallscreen\Animator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */