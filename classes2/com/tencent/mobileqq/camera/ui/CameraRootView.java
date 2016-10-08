package com.tencent.mobileqq.camera.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class CameraRootView
  extends FrameLayout
{
  private static final String jdField_a_of_type_JavaLangString = "Q.camera.ui.CameraRootView";
  private int jdField_a_of_type_Int;
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  private CameraRootView.MyDisplayListener jdField_a_of_type_ComTencentMobileqqCameraUiCameraRootView$MyDisplayListener;
  private Object jdField_a_of_type_JavaLangObject;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public CameraRootView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect.equals(paramRect)) {
      return false;
    }
    if (this.e == 0)
    {
      if (paramRect.bottom <= 0) {
        break label86;
      }
      this.e = paramRect.bottom;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
      QLog.d("Q.camera.ui.CameraRootView", 4, "[fitSystemWindow] offset=" + this.e + " insets=" + paramRect);
      requestLayout();
      return false;
      label86:
      if (paramRect.right > 0) {
        this.e = paramRect.right;
      }
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 -= paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    paramInt1 = 0;
    if (paramInt1 < getChildCount())
    {
      View localView = getChildAt(paramInt1);
      if ((localView instanceof SurfaceView)) {
        localView.layout(this.c + 0, this.jdField_a_of_type_Int + 0, paramInt3 - this.d, paramInt2 - this.b);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if ((localView instanceof QCameraFocusUI))
        {
          Rect localRect = ((QCameraFocusUI)localView).a();
          localView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
        }
        else
        {
          localView.layout(this.c + 0, this.jdField_a_of_type_Int + 0, paramInt3 - this.d, paramInt2 - this.b);
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1 - this.c - this.d, paramInt2 - this.jdField_a_of_type_Int - this.b);
    setMeasuredDimension(paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\ui\CameraRootView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */