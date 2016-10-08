package com.tencent.mobileqq.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class DrawableContainer$ContainerState
  extends Drawable.ConstantState
{
  public int a;
  public Drawable a;
  private boolean a;
  private boolean b;
  
  public DrawableContainer$ContainerState(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(paramDrawableContainer);
  }
  
  public DrawableContainer$ContainerState(ContainerState paramContainerState, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    if (paramContainerState != null) {
      if (paramResources == null) {
        break label46;
      }
    }
    label46:
    for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContainerState.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable(paramResources);; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContainerState.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable())
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(paramDrawableContainer);
      this.b = true;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() == null) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      this.jdField_a_of_type_Boolean = true;
      return this.b;
    }
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\DrawableContainer$ContainerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */