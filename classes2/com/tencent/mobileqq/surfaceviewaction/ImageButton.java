package com.tencent.mobileqq.surfaceviewaction;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import uxq;

public class ImageButton
  extends Sprite
  implements uxq
{
  private ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ImageButton(Bitmap paramBitmap, boolean paramBoolean)
  {
    super(paramBitmap);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramBoolean;
  }
  
  public void a(ImageButton.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton$OnClickListener = paramOnClickListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    do
    {
      int i;
      float f1;
      float f2;
      do
      {
        return false;
        i = paramMotionEvent.getAction();
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        if (i == 0)
        {
          if ((f1 > this.jdField_e_of_type_Int - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_e_of_type_Float / 2.0F) && (f1 < this.jdField_e_of_type_Int + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_e_of_type_Float / 2.0F) && (f2 > this.f - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_e_of_type_Float / 2.0F) && (f2 < this.f + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_e_of_type_Float / 2.0F))
          {
            this.jdField_a_of_type_Boolean = true;
            if (this.b) {
              this.g = 128;
            }
          }
          for (;;)
          {
            return this.jdField_a_of_type_Boolean;
            this.jdField_a_of_type_Boolean = false;
            if (this.b) {
              this.g = 255;
            }
          }
        }
      } while (i != 1);
      if ((f1 > this.jdField_e_of_type_Int - this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_e_of_type_Float / 2.0F) && (f1 < this.jdField_e_of_type_Int + this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.jdField_e_of_type_Float / 2.0F) && (f2 > this.f - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_e_of_type_Float / 2.0F) && (f2 < this.f + this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.jdField_e_of_type_Float / 2.0F) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton$OnClickListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionImageButton$OnClickListener.a(this);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (!this.b);
    this.g = 255;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\ImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */