package com.tencent.mobileqq.magicface.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import tag;
import tar;

public class PngFrameDrawable
  extends Drawable
  implements IRedrawNotify
{
  private static final int jdField_a_of_type_Int = 6;
  private static final String jdField_a_of_type_JavaLangString = PngFrameDrawable.class.getSimpleName();
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private PngGifEngine jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine;
  private tag jdField_a_of_type_Tag;
  private int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PngFrameDrawable(PngPlayParam paramPngPlayParam, Resources paramResources)
  {
    this(new tag(paramPngPlayParam), paramResources);
  }
  
  private PngFrameDrawable(tag paramtag, Resources paramResources)
  {
    this.jdField_a_of_type_Tag = paramtag;
    if (paramResources != null) {}
    for (this.jdField_b_of_type_Int = paramResources.getDisplayMetrics().densityDpi;; this.jdField_b_of_type_Int = paramtag.e)
    {
      b();
      return;
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func initGifEngine");
    }
    tar localtar = new tar();
    localtar.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawableIRedrawNotify = this;
    localtar.jdField_a_of_type_Int = this.jdField_a_of_type_Tag.jdField_b_of_type_Int;
    localtar.jdField_b_of_type_Int = this.jdField_a_of_type_Tag.jdField_a_of_type_Int;
    if (!this.jdField_a_of_type_Tag.jdField_a_of_type_Boolean) {}
    for (localtar.jdField_a_of_type_ArrayOfJavaLangString = null;; localtar.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_Tag.jdField_a_of_type_ArrayOfJavaLangString)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine = new PngGifEngine();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.a(localtar);
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "PngFrameDrawable 【onDestroy】, mBitmapDrawn:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine = null;
    this.jdField_a_of_type_Tag = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine == null) {
      return;
    }
    if ((this.jdField_a_of_type_Tag.jdField_b_of_type_ArrayOfJavaLangString != null) && (paramInt < this.jdField_a_of_type_Tag.jdField_b_of_type_ArrayOfJavaLangString.length)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.a(this.jdField_a_of_type_Tag.jdField_b_of_type_ArrayOfJavaLangString[paramInt]);
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine.b();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onBitmapReady,bitmap:" + paramBitmap);
    }
    if (paramBitmap == null) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidateSelf();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func draw,bitmap:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, getBounds(), this.jdField_a_of_type_Tag.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Tag;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Tag.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_Tag.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Tag.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\drawable\PngFrameDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */