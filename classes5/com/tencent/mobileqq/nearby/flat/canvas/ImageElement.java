package com.tencent.mobileqq.nearby.flat.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.MeasureSpec;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ImageElement
  extends AbstractUIElement
  implements Drawable.Callback
{
  private static final Matrix.ScaleToFit[] jdField_a_of_type_ArrayOfAndroidGraphicsMatrix$ScaleToFit = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  static final ImageView.ScaleType[] jdField_a_of_type_ArrayOfAndroidWidgetImageView$ScaleType;
  static final String jdField_b_of_type_JavaLangString = "ImageElement";
  final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  PorterDuffColorFilter jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.FIT_CENTER;
  Matrix jdField_b_of_type_AndroidGraphicsMatrix;
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  boolean jdField_b_of_type_Boolean;
  boolean c = false;
  int e;
  int f;
  int g;
  int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfAndroidWidgetImageView$ScaleType = new ImageView.ScaleType[] { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
  }
  
  public ImageElement(UIElementHost paramUIElementHost)
  {
    this(paramUIElementHost, null);
  }
  
  public ImageElement(UIElementHost paramUIElementHost, AttributeSet paramAttributeSet)
  {
    super(paramUIElementHost, paramAttributeSet);
    if (!a()) {
      throw new IllegalStateException("Construct ImageElement error,mHost is null!");
    }
    paramUIElementHost = a().obtainStyledAttributes(paramAttributeSet, R.styleable.M, 0, 0);
    int j = paramUIElementHost.getIndexCount();
    if (i < j)
    {
      int k = paramUIElementHost.getIndex(i);
      switch (k)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        paramAttributeSet = paramUIElementHost.getDrawable(k);
        if (paramAttributeSet != null)
        {
          b(paramAttributeSet);
          continue;
          k = paramUIElementHost.getInt(k, -1);
          if (k >= 0) {
            a(jdField_a_of_type_ArrayOfAndroidWidgetImageView$ScaleType[k]);
          }
        }
      }
    }
    paramUIElementHost.recycle();
  }
  
  private static Matrix.ScaleToFit a(ImageView.ScaleType paramScaleType)
  {
    return jdField_a_of_type_ArrayOfAndroidGraphicsMatrix$ScaleToFit[(paramScaleType.ordinal() - 1)];
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    b(new BitmapDrawable(a(), paramBitmap));
  }
  
  void a(Drawable paramDrawable)
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.unscheduleDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.getDrawableState());
      }
      paramDrawable.setLevel(this.h);
      if (h() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramDrawable.setVisible(bool, true);
        this.f = paramDrawable.getIntrinsicWidth();
        this.g = paramDrawable.getIntrinsicHeight();
        g();
        return;
      }
    }
    this.g = -1;
    this.f = -1;
  }
  
  public void a(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      throw new NullPointerException();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == paramScaleType) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
    a();
    e();
  }
  
  public void b()
  {
    super.b();
    if (h() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    this.h = paramInt;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setLevel(paramInt);
      h();
    }
  }
  
  protected void b(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {}
    while ((this.f == 0) || (this.g == 0)) {
      return;
    }
    int i = d();
    int j = e();
    if (this.jdField_a_of_type_Boolean) {
      if (!this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter == null) {
          this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter = new PorterDuffColorFilter(1711276032, PorterDuff.Mode.SRC_ATOP);
        }
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter);
        this.jdField_b_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      if (this.c)
      {
        this.c = false;
        g();
      }
      if ((this.jdField_b_of_type_AndroidGraphicsMatrix != null) || (i != 0) || (j != 0)) {
        break;
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.clearColorFilter();
        this.jdField_b_of_type_Boolean = false;
      }
    }
    int k = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.translate(i, j);
    if (this.jdField_b_of_type_AndroidGraphicsMatrix != null) {
      paramCanvas.concat(this.jdField_b_of_type_AndroidGraphicsMatrix);
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(k);
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == paramDrawable) {
      return;
    }
    this.e = 0;
    int i = this.f;
    int j = this.g;
    a(paramDrawable);
    if ((i != this.f) || (j != this.g)) {
      a();
    }
    e();
  }
  
  void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setVisible(paramBoolean, false);
    }
  }
  
  public void c()
  {
    super.c();
    b(false);
  }
  
  public void c(int paramInt)
  {
    if (this.e == paramInt) {
      return;
    }
    a(null);
    this.e = paramInt;
    paramInt = this.f;
    int i = this.g;
    i();
    if ((paramInt != this.f) || (i != this.g)) {
      a();
    }
    e();
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    int i = 0;
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    i();
    if (n == 1073741824) {
      paramInt1 = k;
    }
    label167:
    label170:
    for (;;)
    {
      if (m == 1073741824) {
        paramInt2 = j;
      }
      for (;;)
      {
        b(paramInt1, paramInt2);
        return;
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.f = -1;
        }
        for (paramInt1 = 0;; paramInt1 = Math.max(1, this.f) + d() + f())
        {
          if (n != Integer.MIN_VALUE) {
            break label170;
          }
          paramInt1 = Math.min(k, paramInt1);
          break;
        }
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.g = -1;
        }
        for (paramInt2 = i;; paramInt2 = Math.max(1, this.g) + e() + g())
        {
          if (m != Integer.MIN_VALUE) {
            break label167;
          }
          paramInt2 = Math.min(j, paramInt2);
          break;
        }
      }
    }
  }
  
  protected void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    g();
  }
  
  public void f()
  {
    if ((a()) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.getDrawableState());
    }
  }
  
  void g()
  {
    float f1 = 0.0F;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
      return;
    }
    int j = this.f;
    int k = this.g;
    int m = m() - d() - f();
    int n = n() - e() - g();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1; (j <= 0) || (k <= 0) || (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.FIT_XY); i = 0)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, m, n);
      this.jdField_b_of_type_AndroidGraphicsMatrix = null;
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, j, k);
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.MATRIX)
    {
      if (this.jdField_a_of_type_AndroidGraphicsMatrix.isIdentity())
      {
        this.jdField_b_of_type_AndroidGraphicsMatrix = null;
        return;
      }
      this.jdField_b_of_type_AndroidGraphicsMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
      return;
    }
    if (i != 0)
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix = null;
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER)
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
      this.jdField_b_of_type_AndroidGraphicsMatrix.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
      return;
    }
    float f3;
    float f2;
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_CROP)
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
      if (j * n > m * k)
      {
        f3 = n / k;
        f2 = (m - j * f3) * 0.5F;
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidGraphicsMatrix.setScale(f3, f3);
        this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate((int)(f2 + 0.5F), (int)(f1 + 0.5F));
        return;
        f3 = m / j;
        f1 = n;
        float f4 = k;
        f2 = 0.0F;
        f1 = (f1 - f4 * f3) * 0.5F;
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_INSIDE)
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
      if ((j <= m) && (k <= n)) {}
      for (f1 = 1.0F;; f1 = Math.min(m / j, n / k))
      {
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.jdField_b_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(f2, f3);
        return;
      }
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, j, k);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, m, n);
    this.jdField_b_of_type_AndroidGraphicsMatrix = this.jdField_a_of_type_AndroidGraphicsMatrix;
    this.jdField_b_of_type_AndroidGraphicsMatrix.setRectToRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF, a(this.jdField_a_of_type_AndroidWidgetImageView$ScaleType));
  }
  
  void h()
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {}
    int j;
    int i;
    do
    {
      return;
      j = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      i = j;
      if (j < 0) {
        i = this.f;
      }
      int k = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.g;
      }
    } while ((i == this.f) && (j == this.g));
    this.f = i;
    this.g = j;
    a();
  }
  
  void i()
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {}
    for (;;)
    {
      return;
      Object localObject1 = null;
      if (this.e != 0) {}
      try
      {
        Object localObject2 = a();
        if (localObject2 != null)
        {
          localObject2 = ((Resources)localObject2).getDrawable(this.e);
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("ImageElement", "Unable to find resource: " + this.e, localException);
        }
      }
    }
    a((Drawable)localObject1);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (!a()) {
      return;
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == paramDrawable)
    {
      if ((this.f != paramDrawable.getIntrinsicWidth()) || (this.g != paramDrawable.getIntrinsicHeight()))
      {
        h();
        this.c = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.invalidate();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.invalidateDrawable(paramDrawable);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.unscheduleDrawable(paramDrawable, paramRunnable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\canvas\ImageElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */