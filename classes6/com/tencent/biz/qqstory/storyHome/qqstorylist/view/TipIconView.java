package com.tencent.biz.qqstory.storyHome.qqstorylist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TipIconView
  extends View
{
  public float a;
  public int a;
  public Paint a;
  public int b;
  public Paint b;
  
  public TipIconView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -2039584;
    this.jdField_b_of_type_Int = 10;
    a();
  }
  
  public TipIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -2039584;
    this.jdField_b_of_type_Int = 10;
    a();
  }
  
  public TipIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -2039584;
    this.jdField_b_of_type_Int = 10;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (getHeight() < getWidth()) {}
    for (int i = getHeight() / 2;; i = getWidth() / 2)
    {
      this.jdField_b_of_type_Int = i;
      float f1 = this.jdField_b_of_type_Int / 4;
      float f2 = this.jdField_b_of_type_Int * 2 - this.jdField_b_of_type_Int / 4;
      RectF localRectF = new RectF(f1, f1, f2, f2);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Int / 5);
      f1 = this.jdField_a_of_type_Float;
      f2 = this.jdField_a_of_type_Float;
      Path localPath = new Path();
      localPath.addArc(localRectF, 0.0F, 360.0F);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      paramCanvas.drawPath(localPath, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      paramCanvas.drawArc(localRectF, 0.0F - (90.0F - f1), 360.0F - f2, true, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public void setColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setCountdown(float paramFloat)
  {
    paramFloat = 360.0F * (paramFloat / 24.0F);
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      super.invalidate();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\view\TipIconView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */