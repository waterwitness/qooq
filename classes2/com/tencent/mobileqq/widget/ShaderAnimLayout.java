package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ReflectionUtil;
import woj;
import wok;

public class ShaderAnimLayout
  extends RelativeLayout
{
  public static final long a = 200L;
  public float a;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public boolean a;
  private boolean b;
  
  public ShaderAnimLayout(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new woj(this);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new wok(this);
    f();
  }
  
  public ShaderAnimLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new woj(this);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new wok(this);
    f();
  }
  
  public ShaderAnimLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new woj(this);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new wok(this);
    f();
  }
  
  private void f()
  {
    if (!this.b)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new LinearInterpolator());
      this.b = true;
    }
  }
  
  public void a()
  {
    if (getVisibility() != 0)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
      clearAnimation();
      setVisibility(0);
      startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void b()
  {
    clearAnimation();
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
    this.jdField_a_of_type_Boolean = false;
    setVisibility(0);
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public void c()
  {
    clearAnimation();
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(null);
    this.jdField_a_of_type_Boolean = true;
    setVisibility(8);
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  public void d()
  {
    if (getVisibility() == 0)
    {
      this.jdField_a_of_type_Boolean = true;
      clearAnimation();
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addRect(getWidth() * (1.0F - this.jdField_a_of_type_Float), 0.0F, getWidth(), getBottom(), Path.Direction.CW);
    try
    {
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath, Region.Op.INTERSECT);
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ReflectionUtil.a(this, 1, null);
      }
    }
  }
  
  public void e()
  {
    setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ShaderAnimLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */