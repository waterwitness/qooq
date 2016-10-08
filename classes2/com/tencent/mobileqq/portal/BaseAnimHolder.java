package com.tencent.mobileqq.portal;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseAnimHolder
{
  public float a;
  public int a;
  public Drawable a;
  public Transformation a;
  public ArrayList a;
  public float b;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public BaseAnimHolder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.e = 255;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public void a(Animation paramAnimation)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAnimation);
    paramAnimation.start();
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (this.e != 0)
    {
      paramCanvas.save();
      paramCanvas.translate(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.e);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.c, this.d);
      paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c / 2, this.d / 2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    paramCanvas = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    if (paramCanvas.hasNext())
    {
      Animation localAnimation = (Animation)paramCanvas.next();
      if ((bool) || (localAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\BaseAnimHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */