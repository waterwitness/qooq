package com.tencent.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import xum;
import xun;

public class ProgressPieView
  extends View
{
  static final float jdField_a_of_type_Float = 1.5F;
  public static final int a = 0;
  static LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(8);
  public static final float b = 4.0F;
  public static final int b = 1;
  static final float c = 14.0F;
  public static final int c = 2;
  static final float d = 40.0F;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 50;
  public static final int g = 25;
  public static final int h = 1;
  static final int jdField_i_of_type_Int = 100;
  static final int j = 0;
  static final int k = -90;
  public Paint a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  public Drawable a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  ProgressPieView.OnProgressListener jdField_a_of_type_ComTencentWidgetProgressPieView$OnProgressListener;
  public String a;
  xum jdField_a_of_type_Xum = new xum(this);
  xun jdField_a_of_type_Xun = new xun(this);
  public boolean a;
  public Paint b;
  RectF b;
  public String b;
  public boolean b;
  public Paint c;
  public boolean c;
  public Paint d;
  public boolean d;
  public float e;
  public Paint e;
  public boolean e;
  public float f;
  public boolean f;
  public float g = 14.0F;
  public boolean g;
  float jdField_h_of_type_Float;
  private boolean jdField_h_of_type_Boolean;
  float jdField_i_of_type_Float;
  public int l = 100;
  public int m = 0;
  public int n = -90;
  public int o = 1;
  public int p = 25;
  public int q = 1;
  public int r = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProgressPieView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProgressPieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProgressPieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Float = 1.5F;
    this.jdField_f_of_type_Float = 4.0F;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    a(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    return this.m;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xum.removeMessages(0);
    this.jdField_a_of_type_Xum.a(this.l);
    this.jdField_a_of_type_Xum.sendEmptyMessage(0);
    invalidate();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Xum.removeMessages(0);
    if ((paramInt > this.l) || (paramInt < 0)) {
      throw new IllegalArgumentException(String.format("Animation progress (%d) is greater than the max progress (%d) or lower than 0 ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.l) }));
    }
    this.jdField_a_of_type_Xum.a(paramInt);
    this.jdField_a_of_type_Xum.sendEmptyMessage(0);
    invalidate();
  }
  
  void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    this.jdField_e_of_type_Float *= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_f_of_type_Float *= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.g *= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
    this.jdField_h_of_type_Float = 40.0F;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Y);
    paramAttributeSet = getResources();
    this.l = paramContext.getInteger(4, this.l);
    this.m = paramContext.getInteger(3, this.m);
    this.n = paramContext.getInt(5, this.n);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(6, this.jdField_a_of_type_Boolean);
    this.jdField_b_of_type_Boolean = paramContext.getBoolean(7, this.jdField_b_of_type_Boolean);
    this.jdField_e_of_type_Float = paramContext.getDimension(8, this.jdField_e_of_type_Float);
    this.jdField_f_of_type_Float = paramContext.getDimension(9, this.jdField_f_of_type_Float);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(16);
    this.g = paramContext.getDimension(0, this.g);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2);
    this.jdField_c_of_type_Boolean = paramContext.getBoolean(14, this.jdField_c_of_type_Boolean);
    this.jdField_d_of_type_Boolean = paramContext.getBoolean(15, this.jdField_d_of_type_Boolean);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(17);
    int i1 = paramContext.getColor(10, paramAttributeSet.getColor(2131427607));
    int i2 = paramContext.getColor(11, paramAttributeSet.getColor(2131427608));
    int i3 = paramContext.getColor(12, paramAttributeSet.getColor(2131427608));
    int i4 = paramContext.getColor(13, paramAttributeSet.getColor(2131427609));
    int i5 = paramContext.getColor(1, paramAttributeSet.getColor(2131427610));
    this.o = paramContext.getInteger(18, this.o);
    paramContext.recycle();
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(i1);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(i2);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(i3);
    if (this.o == 1)
    {
      this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_f_of_type_Float);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_f_of_type_Float);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i4);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_e_of_type_Float);
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(i5);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.g);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
      return;
      this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
  }
  
  public int b()
  {
    return this.l;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Xum.removeMessages(0);
    this.jdField_a_of_type_Xum.a(this.m);
    this.jdField_a_of_type_Xun.removeMessages(0);
    invalidate();
  }
  
  public void b(int paramInt)
  {
    a(paramInt);
    this.jdField_a_of_type_Xum.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xun.a();
    this.jdField_a_of_type_Xun.sendEmptyMessageDelayed(0, 1L);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.i, this.i);
    this.jdField_a_of_type_AndroidGraphicsRectF.offset((getWidth() - this.i) / 2.0F, (getHeight() - this.i) / 2.0F);
    int i1;
    if (this.jdField_c_of_type_Boolean)
    {
      i1 = (int)(this.jdField_a_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F + 0.5F);
      this.jdField_a_of_type_AndroidGraphicsRectF.inset(i1, i1);
    }
    float f3 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
    float f4 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
    float f2;
    float f1;
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
      paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, true, this.jdField_e_of_type_AndroidGraphicsPaint);
      switch (this.o)
      {
      default: 
        throw new IllegalArgumentException("Invalid Progress Fill = " + this.o);
      case 0: 
      case 1: 
        f2 = this.m * 360 / this.l;
        f1 = f2;
        if (this.jdField_a_of_type_Boolean) {
          f1 = f2 - 360.0F;
        }
        if (this.jdField_b_of_type_Boolean) {
          f1 = -f1;
        }
        break;
      }
    }
    for (;;)
    {
      if (this.o == 0)
      {
        paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.n, f1, true, this.jdField_d_of_type_AndroidGraphicsPaint);
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_d_of_type_Boolean))
        {
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
          {
            Typeface localTypeface2 = (Typeface)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_b_of_type_JavaLangString);
            Typeface localTypeface1 = localTypeface2;
            if (localTypeface2 == null)
            {
              localTypeface1 = localTypeface2;
              if (getResources() != null)
              {
                AssetManager localAssetManager = getResources().getAssets();
                localTypeface1 = localTypeface2;
                if (localAssetManager != null)
                {
                  localTypeface1 = Typeface.createFromAsset(localAssetManager, this.jdField_b_of_type_JavaLangString);
                  jdField_a_of_type_AndroidSupportV4UtilLruCache.put(this.jdField_b_of_type_JavaLangString, localTypeface1);
                }
              }
            }
            this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(localTypeface1);
          }
          i1 = (int)f3;
          int i2 = (int)(f4 - (this.jdField_b_of_type_AndroidGraphicsPaint.descent() + this.jdField_b_of_type_AndroidGraphicsPaint.ascent()) / 2.0F);
          paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, i1, i2, this.jdField_b_of_type_AndroidGraphicsPaint);
        }
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_e_of_type_Boolean))
        {
          if (!this.jdField_h_of_type_Boolean) {
            break label722;
          }
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, getWidth(), getHeight());
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
          paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        return;
        i1 = (int)(this.jdField_d_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F + 0.5F);
        this.jdField_b_of_type_AndroidGraphicsRectF.inset(i1, i1);
        if (this.r == 1)
        {
          if (this.m >= 500)
          {
            i1 = 180000 / this.l;
            paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.n, i1, false, this.jdField_c_of_type_AndroidGraphicsPaint);
            paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.n + i1, f1 - i1, false, this.jdField_d_of_type_AndroidGraphicsPaint);
            break;
          }
          paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.n, f1, false, this.jdField_c_of_type_AndroidGraphicsPaint);
          break;
        }
        paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.n, f1, false, this.jdField_d_of_type_AndroidGraphicsPaint);
        break;
        f2 = this.i / 2.0F * (this.m / this.l);
        f1 = f2;
        if (this.jdField_c_of_type_Boolean) {
          f1 = f2 + 0.5F - this.jdField_a_of_type_AndroidGraphicsPaint.getStrokeWidth();
        }
        paramCanvas.drawCircle(f3, f4, f1, this.jdField_d_of_type_AndroidGraphicsPaint);
        break;
        label722:
        i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, i1, i1);
        this.jdField_a_of_type_AndroidGraphicsRect.offset((getWidth() - i1) / 2, (getHeight() - i1) / 2);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = resolveSize(AIOUtils.a(this.jdField_h_of_type_Float, getResources()), paramInt1);
    paramInt2 = resolveSize(AIOUtils.a(this.jdField_h_of_type_Float, getResources()), paramInt2);
    this.i = Math.min(paramInt1, paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setAnimationSpeed(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setCounterclockwise(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setDefaultViewSize(int paramInt)
  {
    if (Float.compare(this.jdField_h_of_type_Float, paramInt) != 0)
    {
      this.jdField_h_of_type_Float = paramInt;
      invalidate();
    }
  }
  
  public void setDrawImageFillView(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    invalidate();
  }
  
  public void setImageResource(int paramInt)
  {
    if (getResources() != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(paramInt);
      invalidate();
    }
  }
  
  public void setInverted(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setMax(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt < this.m)) {
      throw new IllegalArgumentException(String.format("Max (%d) must be > 0 and >= %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.m) }));
    }
    this.l = paramInt;
    invalidate();
  }
  
  public void setOnProgressListener(ProgressPieView.OnProgressListener paramOnProgressListener)
  {
    this.jdField_a_of_type_ComTencentWidgetProgressPieView$OnProgressListener = paramOnProgressListener;
  }
  
  public void setPregressPreColor(int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setProgress(int paramInt)
  {
    if ((paramInt > this.l) || (paramInt < 0)) {
      throw new IllegalArgumentException(String.format("Progress (%d) must be between %d and %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(this.l) }));
    }
    this.m = paramInt;
    invalidate();
    if (this.jdField_a_of_type_ComTencentWidgetProgressPieView$OnProgressListener != null)
    {
      if (this.m == this.l) {
        this.jdField_a_of_type_ComTencentWidgetProgressPieView$OnProgressListener.u();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetProgressPieView$OnProgressListener.b(this.m, this.l);
  }
  
  public void setProgressColor(int paramInt)
  {
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setProgressFillType(int paramInt)
  {
    this.o = paramInt;
    if (paramInt == 1)
    {
      this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_f_of_type_Float);
      return;
    }
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  public void setProgressPreType(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setProgressStrokeWidth(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidGraphicsPaint.getStyle() == Paint.Style.STROKE)
    {
      this.jdField_f_of_type_Float = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density);
      this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_f_of_type_Float);
      invalidate();
    }
  }
  
  public void setShowImage(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setShowStroke(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setShowText(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setStartAngle(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.jdField_e_of_type_Float = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_e_of_type_Float);
    invalidate();
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setTextSize(int paramInt)
  {
    this.g = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.g);
    invalidate();
  }
  
  public void setTypeface(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ProgressPieView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */