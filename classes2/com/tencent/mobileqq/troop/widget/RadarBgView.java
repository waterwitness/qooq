package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class RadarBgView
  extends View
{
  public static final int a = 15;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  protected Scroller a;
  private RadarBgView.OnBackgroundReadyListener jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView$OnBackgroundReadyListener;
  protected int b;
  int c;
  int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public RadarBgView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.d = 0;
    a(paramContext);
  }
  
  public RadarBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.d = 0;
    a(paramContext);
  }
  
  public RadarBgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.d = 0;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.e = DisplayUtil.a(getContext(), 15.0F);
    this.b = DisplayUtil.a(getContext(), 20.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(16777215);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
      this.d = paramInt2;
      return;
      paramInt1 = (paramInt2 - this.d) / 5 % this.g;
      this.c += paramInt1;
      if (paramInt1 > 0) {
        if (this.c >= this.i + this.g) {
          this.c = this.i;
        }
      }
      for (;;)
      {
        this.d = paramInt2;
        invalidate();
        return;
        if (this.c <= this.i - this.g) {
          this.c = this.i;
        }
      }
    } while (this.c == this.i);
    this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    if (this.c > this.i) {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.c, 0, this.i + this.g - this.c, 0, 500);
    }
    for (;;)
    {
      invalidate();
      return;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.c, 0, this.i - this.g - this.c, 0, 500);
    }
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.c = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      if (this.c < this.i + this.g) {
        break label50;
      }
      this.c = this.i;
    }
    for (;;)
    {
      invalidate();
      return;
      label50:
      if (this.c <= this.i - this.g) {
        this.c = this.i;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = getWidth() - this.e * 2;
    int k = j / 2 + this.e;
    int m = j / 2 + this.e;
    if (this.f != j)
    {
      this.f = j;
      this.i = (this.f / 2);
      this.g = ((this.i - this.b) / 5);
      this.h = (this.i - this.g * 4);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView$OnBackgroundReadyListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView$OnBackgroundReadyListener.a(this.e, this.b * 2, this.h, this.i, this.i - this.g, this.g);
      }
      this.c = this.i;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(7);
    if (this.c <= this.i) {
      paramCanvas.drawCircle(k, m, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(12);
    paramCanvas.drawCircle(k, m, this.c - this.g, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(25);
    paramCanvas.drawCircle(k, m, this.c - this.g * 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(38);
    paramCanvas.drawCircle(k, m, this.c - this.g * 3, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawCircle(k, m, this.c - this.g * 4, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawCircle(k, m, this.c - this.g * 5, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt1);
  }
  
  public void setOnBackgroundReadyListenerr(RadarBgView.OnBackgroundReadyListener paramOnBackgroundReadyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRadarBgView$OnBackgroundReadyListener = paramOnBackgroundReadyListener;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\RadarBgView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */