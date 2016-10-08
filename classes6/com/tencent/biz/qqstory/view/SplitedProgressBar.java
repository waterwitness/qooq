package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SplitedProgressBar
  extends View
{
  public static final int a = 100;
  public static final int b = 0;
  public static final int c = 50;
  public static final int d = 3;
  public static final int e = 4;
  public Paint a;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  
  public SplitedProgressBar(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SplitedProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SplitedProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new Paint();
    this.j = 872415231;
    this.k = Integer.MAX_VALUE;
    this.f = 50;
    this.n = 0;
    this.o = 1;
    this.m = 4;
    this.l = 3;
    this.g = 1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getWidth();
    if (this.g == 0) {
      return;
    }
    this.a.setStrokeWidth(this.l);
    float f1 = (i1 - (this.o - this.n - 1) * this.m) / (this.o - this.n);
    i1 = this.n;
    label69:
    float f2;
    float f3;
    if (i1 < this.o)
    {
      f2 = (i1 - this.n) * (this.m + f1);
      f3 = (i1 - this.n) * (this.m + f1) + f1;
      if (i1 >= this.h) {
        break label204;
      }
      this.a.setStrokeWidth(this.l);
      this.a.setColor(this.k);
      paramCanvas.drawLine(f2 + 1.0F, 1.0F, f3 - 1.0F, 1.0F, this.a);
      this.a.setStrokeWidth(1.0F);
      paramCanvas.drawPoint(f2, 1.0F, this.a);
      paramCanvas.drawPoint(f3 - 1.0F, 1.0F, this.a);
    }
    for (;;)
    {
      i1 += 1;
      break label69;
      break;
      label204:
      if (i1 == this.h)
      {
        this.a.setStrokeWidth(this.l);
        this.a.setColor(this.k);
        paramCanvas.drawLine(f2 + 1.0F, 1.0F, f2 + this.i * f1 / 100.0F, 1.0F, this.a);
        this.a.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(f2, 1.0F, this.a);
        this.a.setStrokeWidth(this.l);
        this.a.setColor(this.j);
        paramCanvas.drawLine(f2 + this.i * f1 / 100.0F, 1.0F, f3 - 1.0F, 1.0F, this.a);
        this.a.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(f3 - 1.0F, 1.0F, this.a);
      }
      else
      {
        this.a.setStrokeWidth(this.l);
        this.a.setColor(this.j);
        paramCanvas.drawLine(f2 + 1.0F, 1.0F, f3 - 1.0F, 1.0F, this.a);
        this.a.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(f2, 1.0F, this.a);
        paramCanvas.drawPoint(f3 - 1.0F, 1.0F, this.a);
      }
    }
  }
  
  public void setProgress(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.g)) {
      throw new IllegalArgumentException("setProgress Exception, progressIndex is < 0 or > mTotalCount, progressIndex = " + paramInt1 + ", mTotalCount = " + this.g);
    }
    if ((paramInt2 < 0) || (paramInt2 > 100)) {
      throw new IllegalArgumentException("setProgress Exception, progress is < 0 or > 100, progress = " + paramInt2);
    }
    this.h = paramInt1;
    this.i = paramInt2;
    if (this.h < this.f)
    {
      this.n = 0;
      if (this.g < this.f) {}
      for (paramInt1 = this.g;; paramInt1 = this.f)
      {
        this.o = paramInt1;
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        invalidate();
        return;
      }
    }
    for (this.n = this.f; this.n + this.f <= this.h; this.n += this.f) {}
    if (this.g < this.n + this.f) {}
    for (paramInt1 = this.g;; paramInt1 = this.n + this.f)
    {
      this.o = paramInt1;
      break;
    }
    postInvalidate();
  }
  
  public void setShowMaxCount(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("setShowMaxCount Exception, count is < 1, count = " + paramInt);
    }
    this.f = paramInt;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
  
  public void setTotalCount(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("setTotalCount Exception, count is < 0, count = " + paramInt);
    }
    this.g = paramInt;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\view\SplitedProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */