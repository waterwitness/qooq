package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class InterestLabelTextView
  extends TextView
{
  ShapeDrawable jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable = null;
  RoundRectShape jdField_a_of_type_AndroidGraphicsDrawableShapesRoundRectShape = null;
  
  public InterestLabelTextView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public InterestLabelTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InterestLabelTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    RectF localRectF = new RectF(2.0F, 2.0F, 2.0F, 2.0F);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapesRoundRectShape = new RoundRectShape(new float[] { 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F, 6.0F }, localRectF, new float[] { 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F });
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableShapesRoundRectShape);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(-16777216);
    setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable);
  }
  
  public void setColorFormat(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(paramInt);
    setTextColor(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\InterestLabelTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */