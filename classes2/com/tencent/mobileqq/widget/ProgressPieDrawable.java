package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import wns;

public class ProgressPieDrawable
  extends Drawable
{
  static final float jdField_a_of_type_Float = 1.5F;
  public static final int a = 0;
  static LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(8);
  static final float jdField_b_of_type_Float = 4.0F;
  public static final int b = 1;
  static final float c = 14.0F;
  public static final int c = 2;
  static final float d = 40.0F;
  public static final int d = 50;
  public static final int e = 25;
  public static final int f = 1;
  static final int g = 100;
  static final int jdField_h_of_type_Int = 0;
  static final int i = -90;
  public static final int o = 5;
  public static final int p = 2;
  public static final int q = 1;
  public Paint a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  public Drawable a;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  ProgressPieDrawable.OnProgressListener jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$OnProgressListener;
  public String a;
  public WeakReference a;
  public wns a;
  public boolean a;
  public Paint b;
  RectF jdField_b_of_type_AndroidGraphicsRectF;
  public String b;
  public boolean b;
  public Paint c;
  public boolean c;
  public Paint d;
  public boolean d;
  public float e;
  public boolean e;
  public float f;
  public boolean f;
  public float g = 14.0F;
  public boolean g;
  float jdField_h_of_type_Float;
  private boolean jdField_h_of_type_Boolean;
  public int j = 100;
  public int k = 0;
  public int l = -90;
  public int m = 1;
  public int n = 25;
  public int r = 2;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProgressPieDrawable(Context paramContext)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Float = 1.5F;
    this.jdField_f_of_type_Float = 4.0F;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Wns = new wns(this);
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    a(paramContext);
  }
  
  public int a()
  {
    return this.k;
  }
  
  public int a(int paramInt)
  {
    int i1;
    if (paramInt < 0) {
      i1 = 0;
    }
    do
    {
      return i1;
      i1 = paramInt;
    } while (paramInt <= this.j);
    return this.j;
  }
  
  public Resources a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      return null;
    }
    return ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources();
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wns.removeMessages(0);
    this.jdField_a_of_type_Wns.a(this.j);
    this.jdField_a_of_type_Wns.sendEmptyMessage(0);
    invalidateSelf();
  }
  
  public void a(float paramFloat)
  {
    float f1;
    if (paramFloat >= 0.0F)
    {
      f1 = paramFloat;
      if (paramFloat <= 1.0F) {}
    }
    else
    {
      f1 = 1.0F;
    }
    d((int)(this.j * f1));
  }
  
  public void a(int paramInt)
  {
    this.jdField_h_of_type_Float = paramInt;
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    this.jdField_e_of_type_Float *= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.jdField_f_of_type_Float *= this.jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    this.g *= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(16777215);
    if (this.m == 1)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_f_of_type_Float);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(16777215);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_e_of_type_Float);
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(3355443);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.g);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
      return;
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    invalidateSelf();
  }
  
  public void a(ProgressPieDrawable.OnProgressListener paramOnProgressListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$OnProgressListener = paramOnProgressListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= this.j);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Wns.removeMessages(0);
    this.jdField_a_of_type_Wns.a(this.k);
    invalidateSelf();
  }
  
  public void b(float paramFloat)
  {
    float f1;
    if (paramFloat >= 0.0F)
    {
      f1 = paramFloat;
      if (paramFloat <= 1.0F) {}
    }
    else
    {
      f1 = 1.0F;
    }
    e((int)(this.j * f1));
  }
  
  public void b(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt < this.k)) {
      throw new IllegalArgumentException(String.format("Max (%d) must be > 0 and >= %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.k) }));
    }
    this.j = paramInt;
    invalidateSelf();
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    invalidateSelf();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_Wns.removeMessages(0);
    if (!a(paramInt)) {
      throw new IllegalArgumentException(String.format("Animation progress (%d) is greater than the max progress (%d) or lower than 0 ", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.j) }));
    }
    this.jdField_a_of_type_Wns.a(paramInt);
    this.jdField_a_of_type_Wns.sendEmptyMessage(0);
    invalidateSelf();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!isVisible()) {
      return;
    }
    Rect localRect = getBounds();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_h_of_type_Float, this.jdField_h_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsRectF.offset((localRect.width() - this.jdField_h_of_type_Float) / 2.0F, (localRect.height() - this.jdField_h_of_type_Float) / 2.0F);
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
      paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, true, this.jdField_d_of_type_AndroidGraphicsPaint);
      switch (this.m)
      {
      default: 
        throw new IllegalArgumentException("Invalid Progress Fill = " + this.m);
      case 0: 
      case 1: 
        f2 = this.k * 360 / this.j;
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
      if (this.m == 0)
      {
        paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.l, f1, true, this.jdField_c_of_type_AndroidGraphicsPaint);
        label281:
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_d_of_type_Boolean))
        {
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
          {
            Typeface localTypeface2 = (Typeface)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_b_of_type_JavaLangString);
            Typeface localTypeface1 = localTypeface2;
            if (localTypeface2 == null)
            {
              localTypeface1 = localTypeface2;
              if (a() != null)
              {
                AssetManager localAssetManager = a().getAssets();
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
            break label636;
          }
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localRect.width(), localRect.height());
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_f_of_type_Boolean)) {
          break;
        }
        paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
        i1 = (int)(this.jdField_c_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F + 0.5F);
        this.jdField_b_of_type_AndroidGraphicsRectF.inset(i1, i1);
        paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.l, f1, false, this.jdField_c_of_type_AndroidGraphicsPaint);
        break label281;
        f2 = this.jdField_h_of_type_Float / 2.0F * (this.k / this.j);
        f1 = f2;
        if (this.jdField_c_of_type_Boolean) {
          f1 = f2 + 0.5F - this.jdField_a_of_type_AndroidGraphicsPaint.getStrokeWidth();
        }
        paramCanvas.drawCircle(f3, f4, f1, this.jdField_c_of_type_AndroidGraphicsPaint);
        break label281;
        label636:
        i1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, i1, i1);
        this.jdField_a_of_type_AndroidGraphicsRect.offset((localRect.width() - i1) / 2, (localRect.height() - i1) / 2);
      }
    }
  }
  
  public void e(int paramInt)
  {
    if (!a(paramInt)) {
      throw new IllegalArgumentException(String.format("Progress (%d) must be between %d and %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0), Integer.valueOf(this.j) }));
    }
    this.k = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$OnProgressListener != null)
    {
      if (this.k != this.j) {
        break label88;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$OnProgressListener.a(this);
    }
    for (;;)
    {
      invalidateSelf();
      return;
      label88:
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable$OnProgressListener.a(this, this.k, this.j);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void f(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    invalidateSelf();
  }
  
  public void g(int paramInt)
  {
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.jdField_h_of_type_Float;
  }
  
  public int getIntrinsicWidth()
  {
    return (int)this.jdField_h_of_type_Float;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void h(int paramInt)
  {
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public void i(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public void j(int paramInt)
  {
    this.g = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.g);
    invalidateSelf();
  }
  
  public void k(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidateSelf();
  }
  
  public void l(int paramInt)
  {
    this.jdField_e_of_type_Float = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_e_of_type_Float);
    invalidateSelf();
  }
  
  public void m(int paramInt)
  {
    this.m = paramInt;
    if (paramInt == 1)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_f_of_type_Float);
      return;
    }
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  public void n(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidGraphicsPaint.getStyle() == Paint.Style.STROKE)
    {
      this.jdField_f_of_type_Float = (paramInt * this.jdField_a_of_type_AndroidUtilDisplayMetrics.density);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_f_of_type_Float);
      invalidateSelf();
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    return super.onLevelChange(paramInt);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBounds(Rect paramRect)
  {
    super.setBounds(paramRect);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ProgressPieDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */