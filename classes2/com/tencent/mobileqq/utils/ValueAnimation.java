package com.tencent.mobileqq.utils;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Field;
import wdm;
import wdn;
import wdo;
import wdp;
import wdq;
import wdr;

public class ValueAnimation
  extends Animation
{
  static final wdr jdField_a_of_type_Wdr;
  static final wdr b;
  static final wdr c;
  static final wdr d;
  static final wdr e = new wdq();
  private long jdField_a_of_type_Long;
  protected ValueAnimation.AnimationUpdateListener a;
  protected Object a;
  protected boolean a;
  private Pair[] jdField_a_of_type_ArrayOfAndroidUtilPair;
  protected Object b;
  protected boolean b;
  protected Object c;
  protected boolean c;
  protected boolean d;
  protected wdr f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Wdr = new wdm();
    jdField_b_of_type_Wdr = new wdn();
    jdField_c_of_type_Wdr = new wdo();
    jdField_d_of_type_Wdr = new wdp();
  }
  
  public ValueAnimation(Object paramObject1, Object paramObject2, ValueAnimation.AnimationUpdateListener paramAnimationUpdateListener)
  {
    this(paramObject1, paramObject2, paramAnimationUpdateListener, false, false, null);
  }
  
  public ValueAnimation(Object paramObject1, Object paramObject2, ValueAnimation.AnimationUpdateListener paramAnimationUpdateListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramObject1, paramObject2, paramAnimationUpdateListener, paramBoolean1, paramBoolean2, null);
  }
  
  public ValueAnimation(Object paramObject1, Object paramObject2, ValueAnimation.AnimationUpdateListener paramAnimationUpdateListener, boolean paramBoolean1, boolean paramBoolean2, wdr paramwdr)
  {
    Class localClass = paramObject1.getClass();
    if (paramwdr != null) {
      this.f = paramwdr;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangObject = paramObject1;
      this.jdField_b_of_type_JavaLangObject = paramObject2;
      a(paramAnimationUpdateListener);
      this.jdField_a_of_type_Boolean = paramBoolean1;
      this.jdField_b_of_type_Boolean = paramBoolean2;
      return;
      if (localClass == Integer.class)
      {
        this.f = jdField_a_of_type_Wdr;
      }
      else if (Float.class == localClass)
      {
        this.f = jdField_b_of_type_Wdr;
      }
      else if (Rect.class == localClass)
      {
        this.f = jdField_c_of_type_Wdr;
      }
      else if (Point.class == localClass)
      {
        this.f = jdField_d_of_type_Wdr;
      }
      else
      {
        if (PointF.class != localClass) {
          break;
        }
        this.f = e;
      }
    }
    throw new IllegalArgumentException("Can't support type " + paramObject1.getClass().getSimpleName());
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Object a()
  {
    return this.jdField_c_of_type_JavaLangObject;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(ValueAnimation.AnimationUpdateListener paramAnimationUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener = paramAnimationUpdateListener;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_c_of_type_JavaLangObject = paramObject;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsValueAnimation$AnimationUpdateListener.onAnimationUpdate(this, paramFloat, this.f.a(paramFloat, this.jdField_a_of_type_JavaLangObject, this.jdField_b_of_type_JavaLangObject), paramTransformation);
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void cancel()
  {
    int i = 0;
    this.jdField_c_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT >= 8) {
      super.cancel();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ArrayOfAndroidUtilPair == null) {
        this.jdField_a_of_type_ArrayOfAndroidUtilPair = new Pair[] { new Pair("mEnded", Boolean.valueOf(true)), new Pair("mMore", Boolean.valueOf(false)), new Pair("mOneMoreTime", Boolean.valueOf(false)) };
      }
      try
      {
        Object localObject1 = getClass().getDeclaredField("mListener");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(this);
        if ((localObject1 instanceof Animation.AnimationListener)) {
          ((Animation.AnimationListener)localObject1).onAnimationEnd(this);
        }
        localObject1 = getClass().getDeclaredField("mStartTime");
        ((Field)localObject1).setAccessible(true);
        ((Field)localObject1).setLong(this, Long.MIN_VALUE);
        localObject1 = this.jdField_a_of_type_ArrayOfAndroidUtilPair;
        int j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          Field localField = getClass().getDeclaredField((String)((Pair)localObject2).first);
          localField.setAccessible(true);
          localField.setBoolean(this, ((Boolean)((Pair)localObject2).second).booleanValue());
          i += 1;
        }
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Long == 0L) {
        a(paramLong - getStartTime());
      }
      setStartTime(paramLong - this.jdField_a_of_type_Long);
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
  
  public void reset()
  {
    this.jdField_c_of_type_Boolean = false;
    super.reset();
  }
  
  public boolean willChangeBounds()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\ValueAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */