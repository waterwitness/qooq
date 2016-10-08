package com.tencent.mobileqq.nearby.flat.canvas;

import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class UIElementGroup
  extends AbstractUIElement
{
  AbstractUIElement a;
  public final List a;
  
  public UIElementGroup(UIElementHost paramUIElementHost)
  {
    this(paramUIElementHost, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UIElementGroup(UIElementHost paramUIElementHost, AttributeSet paramAttributeSet)
  {
    super(paramUIElementHost, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  protected static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1073741824;
    int j = 0;
    int k = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2);
    switch (k)
    {
    default: 
      paramInt2 = 0;
      paramInt1 = j;
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
      if (paramInt3 >= 0)
      {
        paramInt1 = paramInt3;
        paramInt2 = i;
      }
      else if (paramInt3 == -1)
      {
        paramInt2 = i;
      }
      else
      {
        if (paramInt3 != -2) {
          break;
        }
        paramInt2 = Integer.MIN_VALUE;
        continue;
        if (paramInt3 >= 0)
        {
          paramInt1 = paramInt3;
          paramInt2 = i;
        }
        else if (paramInt3 == -1)
        {
          paramInt2 = Integer.MIN_VALUE;
        }
        else
        {
          if (paramInt3 != -2) {
            break;
          }
          paramInt2 = Integer.MIN_VALUE;
          continue;
          if (paramInt3 >= 0)
          {
            paramInt1 = paramInt3;
            paramInt2 = i;
          }
          else if (paramInt3 == -1)
          {
            paramInt2 = 0;
            paramInt1 = j;
          }
          else
          {
            if (paramInt3 != -2) {
              break;
            }
            paramInt2 = 0;
            paramInt1 = j;
          }
        }
      }
    }
  }
  
  public ViewGroup.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(a(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null) {
      return b();
    }
    return new ViewGroup.MarginLayoutParams(paramLayoutParams.width, paramLayoutParams.height);
  }
  
  UIElement a(float paramFloat1, float paramFloat2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      UIElement localUIElement = (UIElement)localIterator.next();
      int i = localUIElement.i();
      int j = localUIElement.k();
      int k = localUIElement.j();
      int m = localUIElement.l();
      if ((i < j) && (k < m) && (paramFloat1 >= i) && (paramFloat1 < j) && (paramFloat2 >= k) && (paramFloat2 < m)) {}
      for (i = 1; i != 0; i = 0) {
        return localUIElement;
      }
    }
    return null;
  }
  
  public UIElement a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      UIElement localUIElement = (UIElement)localIterator.next();
      if (localUIElement.a() == paramInt) {
        return localUIElement;
      }
    }
    return null;
  }
  
  public void a(UIElement paramUIElement)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramUIElement.a();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = b();
    }
    a(paramUIElement, localLayoutParams1);
  }
  
  protected void a(UIElement paramUIElement, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramUIElement.a();
    paramUIElement.a(a(paramInt1, d() + f() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width), a(paramInt3, e() + g() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
  }
  
  public void a(UIElement paramUIElement, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!a(paramLayoutParams)) {
      localLayoutParams = a(paramLayoutParams);
    }
    paramUIElement.a(localLayoutParams);
    this.jdField_a_of_type_JavaUtilList.add(paramUIElement);
    a();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    UIElement localUIElement = a(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (localUIElement != null) {
      if ((localUIElement instanceof AbstractUIElement))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasAbstractUIElement == null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasAbstractUIElement = ((AbstractUIElement)localUIElement);
        }
      }
      else {
        bool = localUIElement.a(paramMotionEvent);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasAbstractUIElement == null) {
      for (;;)
      {
        return bool;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasAbstractUIElement != localUIElement)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasAbstractUIElement.a(false);
          this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasAbstractUIElement = ((AbstractUIElement)localUIElement);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasAbstractUIElement.a(false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasAbstractUIElement = null;
    return false;
  }
  
  protected boolean a(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams));
  }
  
  public boolean a(UIElementHost paramUIElementHost)
  {
    boolean bool = super.a(paramUIElementHost);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((UIElement)localIterator.next()).a(paramUIElementHost);
      }
    }
    return bool;
  }
  
  protected ViewGroup.LayoutParams b()
  {
    return new ViewGroup.MarginLayoutParams(-2, -2);
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        UIElement localUIElement = (UIElement)localIterator.next();
        if ((localUIElement instanceof AbstractUIElement)) {
          ((AbstractUIElement)localUIElement).b();
        }
      }
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      UIElement localUIElement = (UIElement)localIterator.next();
      if (localUIElement.h() == 0) {
        localUIElement.a(paramCanvas);
      }
    }
    paramCanvas.restoreToCount(i);
  }
  
  public void b(UIElement paramUIElement)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramUIElement);
    a();
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      UIElement localUIElement = (UIElement)localIterator.next();
      if ((localUIElement instanceof AbstractUIElement)) {
        ((AbstractUIElement)localUIElement).c();
      }
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((UIElement)localIterator.next()).f();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\canvas\UIElementGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */