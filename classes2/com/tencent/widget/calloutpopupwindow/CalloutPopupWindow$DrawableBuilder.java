package com.tencent.widget.calloutpopupwindow;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class CalloutPopupWindow$DrawableBuilder
{
  private int jdField_a_of_type_Int;
  private CalloutPopupWindow.Builder jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder;
  private int b;
  private int c;
  private int d;
  
  public CalloutPopupWindow$DrawableBuilder(CalloutPopupWindow.Builder paramBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 12;
    this.d = 8;
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder = paramBuilder;
  }
  
  private int a(float paramFloat)
  {
    return DisplayUtil.a(CalloutPopupWindow.Builder.a(this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder), paramFloat);
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 32;
    }
    return 33;
  }
  
  private static Drawable a(float paramFloat, int paramInt)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt);
    return localShapeDrawable;
  }
  
  private static Drawable a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new TriangleShape(a(paramInt3));
    ((TriangleShape)localObject).resize(paramInt1, paramInt2);
    localObject = new ShapeDrawable((Shape)localObject);
    ((ShapeDrawable)localObject).setIntrinsicWidth(paramInt1);
    ((ShapeDrawable)localObject).setIntrinsicHeight(paramInt2);
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt4);
    return (Drawable)localObject;
  }
  
  public CalloutPopupWindow.Builder a()
  {
    Drawable localDrawable = a(a(this.jdField_a_of_type_Int), this.b);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder.b(localDrawable);
    localDrawable = a(a(this.c), a(this.d), 49, this.b);
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder.a(localDrawable);
    return this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow$Builder;
  }
  
  public DrawableBuilder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public DrawableBuilder b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\calloutpopupwindow\CalloutPopupWindow$DrawableBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */