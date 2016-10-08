package com.tencent.av.opengl.gesturedetectors;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseGestureDetector
{
  static final String a = "BaseGestureDetector";
  protected static final float c = 0.67F;
  protected float a;
  protected long a;
  protected final Context a;
  protected MotionEvent a;
  protected boolean a;
  protected float b;
  protected MotionEvent b;
  
  public BaseGestureDetector(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewMotionEvent != null)
    {
      this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
      this.jdField_a_of_type_AndroidViewMotionEvent = null;
    }
    if (this.jdField_b_of_type_AndroidViewMotionEvent != null)
    {
      this.jdField_b_of_type_AndroidViewMotionEvent.recycle();
      this.jdField_b_of_type_AndroidViewMotionEvent = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected abstract void a(int paramInt, MotionEvent paramMotionEvent);
  
  protected void a(MotionEvent paramMotionEvent)
  {
    MotionEvent localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
    if ((paramMotionEvent == null) || (localMotionEvent == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseGestureDetector", 2, "updateStateByEvent-->Curr Or Prev is null");
      }
      return;
    }
    if (this.jdField_b_of_type_AndroidViewMotionEvent != null)
    {
      this.jdField_b_of_type_AndroidViewMotionEvent.recycle();
      this.jdField_b_of_type_AndroidViewMotionEvent = null;
    }
    this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
    this.jdField_a_of_type_Long = (paramMotionEvent.getEventTime() - localMotionEvent.getEventTime());
    this.jdField_a_of_type_Float = paramMotionEvent.getPressure(paramMotionEvent.getActionIndex());
    this.jdField_b_of_type_Float = localMotionEvent.getPressure(localMotionEvent.getActionIndex());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (!this.jdField_a_of_type_Boolean) {
      a(i, paramMotionEvent);
    }
    for (;;)
    {
      return true;
      b(i, paramMotionEvent);
    }
  }
  
  public long b()
  {
    return this.jdField_b_of_type_AndroidViewMotionEvent.getEventTime();
  }
  
  protected abstract void b(int paramInt, MotionEvent paramMotionEvent);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\gesturedetectors\BaseGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */