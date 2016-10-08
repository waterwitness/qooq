package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;
import wkr;
import wks;

public class ArcImageView
  extends ImageView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  
  public ArcImageView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 3;
    a();
  }
  
  public ArcImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 3;
    a();
  }
  
  public ArcImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 3;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    try
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131427733));
      this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 1.5F));
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface != null) && (!TextUtils.isEmpty(paramString))) {
      ThreadManager.a().post(new wkr(this, paramAppInterface, paramString));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843321);
      }
      postInvalidate();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(AppInterface paramAppInterface, String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      a(false);
      ThreadManager.a().post(new wks(this, paramAppInterface, paramString));
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF = new RectF();
    localRectF.left = this.jdField_a_of_type_Int;
    localRectF.top = this.jdField_a_of_type_Int;
    localRectF.right = (getWidth() - this.jdField_a_of_type_Int);
    localRectF.bottom = (getHeight() - this.jdField_a_of_type_Int);
    paramCanvas.drawArc(localRectF, 270.0F, this.jdField_a_of_type_Float, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
      int i = getWidth();
      int j = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      int k = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i - j, 0, getWidth(), k);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  public void setProgress(float paramFloat)
  {
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      paramFloat = 360.0F * f;
      if (this.jdField_a_of_type_Float != paramFloat)
      {
        this.jdField_a_of_type_Float = paramFloat;
        postInvalidate();
      }
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ArcImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */