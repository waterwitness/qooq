package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class AsynLoadDrawable
  extends Drawable
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  protected ColorFilter a;
  protected Drawable a;
  protected boolean a;
  protected Drawable b;
  protected Drawable c;
  protected int d;
  protected int e;
  
  protected AsynLoadDrawable(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 0;
    this.e = -1;
    this.b = paramDrawable1;
    this.c = paramDrawable2;
  }
  
  public Bitmap a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable))) {
      return ((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
    }
    return null;
  }
  
  public abstract Drawable a();
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public Drawable b()
  {
    switch (this.d)
    {
    default: 
      return null;
    case 0: 
      return this.b;
    case 1: 
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    }
    return this.c;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = b();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  public int getIntrinsicHeight()
  {
    int i = 0;
    Drawable localDrawable = b();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    int i = 0;
    Drawable localDrawable = b();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicWidth();
    }
    return i;
  }
  
  public int getMinimumHeight()
  {
    int i = 0;
    Drawable localDrawable = b();
    if (localDrawable != null) {
      i = localDrawable.getMinimumHeight();
    }
    return i;
  }
  
  public int getMinimumWidth()
  {
    int i = 0;
    Drawable localDrawable = b();
    if (localDrawable != null) {
      i = localDrawable.getMinimumWidth();
    }
    return i;
  }
  
  public int getOpacity()
  {
    int i = 0;
    Drawable localDrawable = b();
    if (localDrawable != null) {
      i = localDrawable.getOpacity();
    }
    return i;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if (this.d == 1)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BaseApplicationImpl.a().getResources(), SkinUtils.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramRect);
      invalidateSelf();
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = b();
    } while (localDrawable == null);
    localDrawable.setBounds(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.e = paramInt;
    Drawable localDrawable = b();
    if (localDrawable != null) {
      localDrawable.setAlpha(paramInt);
    }
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = b();
    if (localDrawable != null) {
      localDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
    Drawable localDrawable = b();
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\AsynLoadDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */