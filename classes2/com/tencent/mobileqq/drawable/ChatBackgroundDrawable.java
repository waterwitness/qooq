package com.tencent.mobileqq.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ChatBackgroundDrawable
  extends BitmapDrawable
{
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  
  public ChatBackgroundDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(2);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  protected Rect a(Rect paramRect)
  {
    if (getBitmap() == null) {
      return this.jdField_a_of_type_AndroidGraphicsRect;
    }
    int i = getBitmap().getHeight();
    int j = getBitmap().getWidth();
    if (paramRect == null) {
      return new Rect(0, 0, j, i);
    }
    if (this.jdField_a_of_type_Int < paramRect.height()) {
      this.jdField_a_of_type_Int = paramRect.height();
    }
    if (this.jdField_a_of_type_Int / paramRect.width() >= i / j)
    {
      k = paramRect.width() * i / this.jdField_a_of_type_Int;
      j = (int)((j - k) * 0.5D);
      return new Rect(j, 0, k + j, i);
    }
    int k = paramRect.height() * j / paramRect.width();
    i = (int)((i - this.jdField_a_of_type_Int * j / paramRect.width()) * 0.5D);
    return new Rect(0, i, j, k + i);
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = a(getBounds());
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\drawable\ChatBackgroundDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */