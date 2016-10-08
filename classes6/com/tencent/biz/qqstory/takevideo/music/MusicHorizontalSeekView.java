package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class MusicHorizontalSeekView
  extends View
  implements View.OnTouchListener
{
  protected static final int a;
  protected static final int[] a;
  protected static final int b = 21;
  protected static int[] b;
  protected static final int c = 10;
  protected static final int d = 2;
  protected static final int e = 2;
  protected static final int f = 1;
  protected static int g;
  protected static int h;
  float a;
  protected Paint a;
  protected Rect a;
  protected MusicHorizontalSeekView.SeekListener a;
  protected boolean a;
  protected Paint b;
  protected Paint c;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 6, 8, 10, 12, 12, 10, 8, 6 };
    jdField_a_of_type_Int = jdField_a_of_type_ArrayOfInt.length;
    jdField_b_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
  }
  
  public MusicHorizontalSeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 0.0F;
    this.r = ((int)DisplayUtils.a(paramContext, 2.0F));
    this.s = ((int)DisplayUtils.a(paramContext, 1.0F));
    g = (int)DisplayUtils.a(paramContext, 10.0F);
    h = (int)DisplayUtils.a(paramContext, 21.0F);
    int i1 = 0;
    while (i1 < jdField_a_of_type_Int)
    {
      jdField_b_of_type_ArrayOfInt[i1] = ((int)DisplayUtils.a(paramContext, jdField_a_of_type_ArrayOfInt[i1]));
      i1 += 1;
    }
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131427645));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131427982));
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.c.setColor(paramContext.getColor(2131427983));
    this.c.setStrokeWidth(this.s);
    setOnTouchListener(this);
  }
  
  public void a(int paramInt)
  {
    this.m = (g * paramInt / 1000);
    setPlayedPosition(-1);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint)
  {
    paramCanvas.drawLine(paramInt1, paramInt2, paramInt1, paramInt3, paramPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.s);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.s);
    int i2 = 0;
    int i1 = -1;
    int i3;
    int i4;
    if (i2 < this.j)
    {
      i3 = this.o;
      i4 = this.m;
      i3 = (i2 + 1) * g + (i3 - i4);
      if ((i3 <= this.o + this.k) || (this.m != this.l)) {
        break label223;
      }
    }
    label223:
    label228:
    Paint localPaint;
    for (;;)
    {
      if ((this.jdField_a_of_type_Boolean) || (this.n >= this.i))
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.r);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "MusicHorizontalSeekView onDraw() time : " + (System.currentTimeMillis() - l1));
        }
        return;
        if (i3 < 0)
        {
          i2 += 1;
          break;
        }
        if (i3 <= this.p)
        {
          localPaint = this.c;
          if ((this.jdField_a_of_type_Boolean) || (i3 <= this.jdField_a_of_type_AndroidGraphicsRect.left) || (i3 >= this.jdField_a_of_type_AndroidGraphicsRect.right)) {
            break label534;
          }
          if (i1 != -1) {
            break label531;
          }
          i1 = i2;
          label290:
          if ((i2 >= i1) && (i2 < this.n + i1)) {
            localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
          }
        }
      }
    }
    label531:
    label534:
    for (;;)
    {
      i4 = jdField_b_of_type_ArrayOfInt[(i2 % jdField_a_of_type_Int)];
      int i5 = (this.q - i4) / 2;
      a(paramCanvas, i3, i5, i5 + i4, localPaint);
      break label228;
      localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      continue;
      if (this.n == -1)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.r);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
        break;
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.r);
      a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.r);
      a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      break;
      break label290;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.p = getMeasuredWidth();
    this.q = (h + getPaddingTop() + getPaddingBottom());
    setMeasuredDimension(this.p, this.q);
    this.o = ((this.p - this.k) / 2);
    paramInt1 = (this.q - h) / 2;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.o, paramInt1, this.o + this.i * g, h + paramInt1);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.a(this.o, this.k);
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onMeasure() mViewWidth: " + this.p + ", mViewHeight = " + this.q + ", mVideoViewOffsetX = " + this.o + ", mMusicMaxWidth = " + this.l);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = false;
      float f1;
      do
      {
        return bool;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.a(this.l, this.k, this.m);
        break;
        f1 = paramMotionEvent.getX();
      } while (Math.abs(f1 - this.jdField_a_of_type_Float) < 2.0F);
      this.jdField_a_of_type_Boolean = true;
      this.m = ((int)(this.m + (this.jdField_a_of_type_Float - f1) / 2.0F));
      if (f1 > this.jdField_a_of_type_Float)
      {
        if (this.m <= g)
        {
          this.m = 0;
          invalidate();
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.b(this.l, this.k, this.m);
          }
          this.jdField_a_of_type_Float = f1;
          return false;
        }
      }
      else if (this.m >= this.l - this.k)
      {
        this.m = (this.l - this.k);
        invalidate();
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.b(this.l, this.k, this.m);
        }
        this.jdField_a_of_type_Float = f1;
        return false;
      }
      invalidate();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.b(this.l, this.k, this.m);
      }
      this.jdField_a_of_type_Float = f1;
      continue;
      this.jdField_a_of_type_Boolean = false;
      invalidate();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.c(this.l, this.k, this.m);
      }
    }
  }
  
  public void setDurations(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = (g * this.i);
    this.l = (g * this.j);
  }
  
  public void setOnSeekListener(MusicHorizontalSeekView.SeekListener paramSeekListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener = paramSeekListener;
  }
  
  public void setPlayedPosition(int paramInt)
  {
    this.n = paramInt;
    invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\music\MusicHorizontalSeekView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */