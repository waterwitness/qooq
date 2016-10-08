package com.tencent.mobileqq.nearby.flat.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public abstract class AbstractUIElement
  implements UIElement
{
  static final String jdField_a_of_type_JavaLangString = "AbstractUIElement";
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  UIElementHost jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost;
  Object jdField_a_of_type_JavaLangObject;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  int c;
  int d = 0;
  
  public AbstractUIElement(UIElementHost paramUIElementHost)
  {
    this(paramUIElementHost, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AbstractUIElement(UIElementHost paramUIElementHost, AttributeSet paramAttributeSet)
  {
    if (paramUIElementHost == null) {
      throw new IllegalArgumentException("host is null !");
    }
    a(paramUIElementHost);
    paramUIElementHost = a().obtainStyledAttributes(paramAttributeSet, R.styleable.ay, 0, 0);
    int j = paramUIElementHost.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramUIElementHost.getIndex(i);
      switch (k)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        k = paramUIElementHost.getDimensionPixelSize(k, 0);
        paramAttributeSet = this.jdField_b_of_type_AndroidGraphicsRect;
        Rect localRect1 = this.jdField_b_of_type_AndroidGraphicsRect;
        Rect localRect2 = this.jdField_b_of_type_AndroidGraphicsRect;
        this.jdField_b_of_type_AndroidGraphicsRect.bottom = k;
        localRect2.right = k;
        localRect1.top = k;
        paramAttributeSet.left = k;
        continue;
        this.jdField_b_of_type_AndroidGraphicsRect.left = paramUIElementHost.getDimensionPixelSize(k, 0);
        continue;
        this.jdField_b_of_type_AndroidGraphicsRect.top = paramUIElementHost.getDimensionPixelSize(k, 0);
        continue;
        this.jdField_b_of_type_AndroidGraphicsRect.right = paramUIElementHost.getDimensionPixelSize(k, 0);
        continue;
        this.jdField_b_of_type_AndroidGraphicsRect.bottom = paramUIElementHost.getDimensionPixelSize(k, 0);
        continue;
        this.jdField_a_of_type_Int = paramUIElementHost.getResourceId(k, -1);
        continue;
        this.d = paramUIElementHost.getInt(k, 0);
        continue;
        paramAttributeSet = paramUIElementHost.getDrawable(k);
        if (paramAttributeSet != null)
        {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
            this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.unscheduleDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet;
        }
      }
    }
    paramUIElementHost.recycle();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Context a()
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbstractUIElement", 2, "getContext mHost is null");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.getContext();
  }
  
  public Resources a()
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbstractUIElement", 2, "getResources mHost is null");
      }
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.getResources();
  }
  
  public ViewGroup.LayoutParams a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  }
  
  public UIElementHost a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public Object a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbstractUIElement", 2, "requestLayout mHost is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.requestLayout();
  }
  
  public void a(int paramInt)
  {
    if (this.d == paramInt) {
      return;
    }
    this.d = paramInt;
    Drawable localDrawable;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (paramInt != 0) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      localDrawable.setVisible(bool, false);
      a();
      e();
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.left = paramInt1;
    this.jdField_a_of_type_AndroidGraphicsRect.top = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsRect.right = paramInt3;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = paramInt4;
    c(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(2);
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramObject);
  }
  
  public final void a(Canvas paramCanvas)
  {
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect);
    paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top);
    b(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public void a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams == paramLayoutParams) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = paramLayoutParams;
    a();
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      e();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost != null;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return b(paramMotionEvent);
  }
  
  public boolean a(UIElementHost paramUIElementHost)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost == paramUIElementHost) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost != null) {
      c();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost = paramUIElementHost;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost != null) {
      b();
    }
    return true;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected void b() {}
  
  protected void b(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_AndroidGraphicsRect.left = paramInt1;
    this.jdField_b_of_type_AndroidGraphicsRect.top = paramInt2;
    this.jdField_b_of_type_AndroidGraphicsRect.right = paramInt3;
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = paramInt4;
    a();
  }
  
  protected abstract void b(Canvas paramCanvas);
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    AbstractUIElement.OnClickListener localOnClickListener = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost instanceof UIElementView)) {
      localOnClickListener = ((UIElementView)this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost).a;
    }
    if (localOnClickListener != null)
    {
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        a(true);
        continue;
        a(false);
        localOnClickListener.a(this);
        continue;
        a(false);
      }
    }
    return false;
  }
  
  public int c()
  {
    return this.c;
  }
  
  protected void c() {}
  
  protected abstract void c(int paramInt1, int paramInt2);
  
  protected abstract void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public int d()
  {
    return this.jdField_b_of_type_AndroidGraphicsRect.left;
  }
  
  public void d() {}
  
  public int e()
  {
    return this.jdField_b_of_type_AndroidGraphicsRect.top;
  }
  
  public void e()
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbstractUIElement", 2, "invalidate mHost is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.invalidate(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
  }
  
  public int f()
  {
    return this.jdField_b_of_type_AndroidGraphicsRect.right;
  }
  
  public abstract void f();
  
  public int g()
  {
    return this.jdField_b_of_type_AndroidGraphicsRect.bottom;
  }
  
  public int h()
  {
    return this.d;
  }
  
  public int i()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.left;
  }
  
  public int j()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.top;
  }
  
  public int k()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.right;
  }
  
  public int l()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.bottom;
  }
  
  public int m()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left;
  }
  
  public int n()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\canvas\AbstractUIElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */