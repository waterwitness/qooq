package com.tencent.av.widget.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ShimmerViewHelper
{
  private static final int jdField_a_of_type_Int = -1;
  private float jdField_a_of_type_Float;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private View jdField_a_of_type_AndroidViewView;
  private ShimmerViewHelper.AnimationSetupCallback jdField_a_of_type_ComTencentAvWidgetShimmerShimmerViewHelper$AnimationSetupCallback;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public ShimmerViewHelper(View paramView, Paint paramPaint, AttributeSet paramAttributeSet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidGraphicsPaint = paramPaint;
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    this.c = -1;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = this.jdField_a_of_type_AndroidViewView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.al, 0, 0);
      if (paramAttributeSet == null) {}
    }
    try
    {
      this.c = paramAttributeSet.getColor(0, -1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShimmerTextView", 2, "Error while creating the view:", localException);
        }
        paramAttributeSet.recycle();
      }
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  private void c()
  {
    float f = -this.jdField_a_of_type_AndroidViewView.getWidth();
    int i = this.jdField_b_of_type_Int;
    int j = this.c;
    int k = this.jdField_b_of_type_Int;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f, 0.0F, 0.0F, 0.0F, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected void a()
  {
    c();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerViewHelper$AnimationSetupCallback != null) {
        this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerViewHelper$AnimationSetupCallback.a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      c();
    }
  }
  
  public void a(ShimmerViewHelper.AnimationSetupCallback paramAnimationSetupCallback)
  {
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerViewHelper$AnimationSetupCallback = paramAnimationSetupCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint.getShader() == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(2.0F * this.jdField_a_of_type_Float, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsLinearGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      c();
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\widget\shimmer\ShimmerViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */