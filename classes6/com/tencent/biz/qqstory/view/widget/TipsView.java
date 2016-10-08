package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import jad;

public class TipsView
  extends View
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 1;
  public static final int e = 2;
  protected float a;
  protected Paint a;
  protected Path a;
  protected RectF a;
  protected String a;
  protected float b;
  protected Paint b;
  protected int f;
  protected int g;
  protected int h;
  
  public TipsView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.f = 1;
    this.g = 3;
    a();
  }
  
  public TipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.f = 1;
    this.g = 3;
    a();
  }
  
  public static void a(Context paramContext, View paramView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramContext, paramView, paramString, paramInt1, paramInt2, paramInt3, Color.argb(178, 0, 0, 0));
  }
  
  public static void a(Context paramContext, View paramView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TipsView localTipsView = new TipsView(paramContext);
    localTipsView.setText(paramString);
    localTipsView.setBgColor(paramInt4);
    localTipsView.setArrowPosition(paramInt1, paramInt2, paramView.getWidth() / 2 - paramInt3);
    paramString = new PopupWindow(localTipsView, -2, -2);
    paramString.setTouchable(true);
    paramString.setOutsideTouchable(true);
    paramString.setBackgroundDrawable(new BitmapDrawable(paramContext.getResources(), (Bitmap)null));
    paramInt4 = (int)((paramView.getWidth() - localTipsView.a()) / 2.0F);
    if (paramInt2 == 1) {}
    for (;;)
    {
      if (paramInt1 == 1) {}
      for (float f1 = DisplayUtil.a(paramContext, 5.0F);; f1 = -paramView.getHeight() - localTipsView.b() - DisplayUtil.a(paramContext, 5.0F))
      {
        paramString.showAsDropDown(paramView, paramInt3, (int)f1);
        localTipsView.postDelayed(new jad(paramString), 3000L);
        return;
        if (paramInt2 != 2) {
          break label195;
        }
        paramInt3 = (int)(paramView.getWidth() - localTipsView.a());
        break;
      }
      label195:
      paramInt3 = paramInt4;
    }
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_Float == 0.0F) {
      return this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString) + (getPaddingLeft() + getPaddingRight());
    }
    return this.jdField_a_of_type_Float;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(DisplayUtil.a(getContext(), 14.0F));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.argb(178, 0, 0, 0));
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    int i = DisplayUtil.a(getContext(), 10.0F);
    setPadding(i, i, i, i);
  }
  
  public float b()
  {
    if (this.jdField_b_of_type_Float == 0.0F)
    {
      Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
      return localFontMetrics.bottom - localFontMetrics.top + (getPaddingTop() + getPaddingBottom()) + DisplayUtil.a(getContext(), 6.5F);
    }
    return this.jdField_b_of_type_Float;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    float f1 = ((Paint.FontMetrics)localObject).bottom;
    float f2 = ((Paint.FontMetrics)localObject).top;
    float f3 = ((Paint.FontMetrics)localObject).bottom;
    float f4 = getPaddingTop();
    int j;
    if (this.f == 1)
    {
      i = DisplayUtil.a(getContext(), 6.5F);
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      float f5 = i;
      float f6 = this.jdField_a_of_type_Float;
      float f7 = this.jdField_b_of_type_Float;
      if (this.f != 1) {
        break label289;
      }
      j = 0;
      label91:
      ((RectF)localObject).set(0.0F, f5, f6, f7 - j);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, DisplayUtil.a(getContext(), 4.0F), DisplayUtil.a(getContext(), 4.0F), this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, getPaddingLeft(), f4 + (f1 - f2 - f3) + i, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      f1 = this.jdField_a_of_type_Float / 2.0F;
      if (this.g != 1) {
        break label303;
      }
      f1 = this.h;
    }
    for (;;)
    {
      if (this.f != 1) {
        break label325;
      }
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 - DisplayUtil.a(getContext(), 6.5F), i);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1 + DisplayUtil.a(getContext(), 6.5F), i);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
      super.onDraw(paramCanvas);
      return;
      i = 0;
      break;
      label289:
      j = DisplayUtil.a(getContext(), 6.5F);
      break label91;
      label303:
      if (this.g == 2) {
        f1 = this.jdField_a_of_type_Float - this.h;
      }
    }
    label325:
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, this.jdField_b_of_type_Float);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    f2 = DisplayUtil.a(getContext(), 6.5F);
    f3 = this.jdField_b_of_type_Float;
    if (this.f == 1)
    {
      i = 0;
      label371:
      ((Path)localObject).lineTo(f1 - f2, f3 - i);
      localObject = this.jdField_a_of_type_AndroidGraphicsPath;
      f2 = DisplayUtil.a(getContext(), 6.5F);
      f3 = this.jdField_b_of_type_Float;
      if (this.f != 1) {
        break label470;
      }
    }
    label470:
    for (int i = k;; i = DisplayUtil.a(getContext(), 6.5F))
    {
      ((Path)localObject).lineTo(f1 + f2, f3 - i);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
      break;
      i = DisplayUtil.a(getContext(), 6.5F);
      break label371;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString) + (getPaddingLeft() + getPaddingRight()));
    Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    this.jdField_b_of_type_Float = (localFontMetrics.bottom - localFontMetrics.top + (getPaddingTop() + getPaddingBottom()) + DisplayUtil.a(getContext(), 6.5F));
    setMeasuredDimension((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
  }
  
  public void setArrowPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\widget\TipsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */