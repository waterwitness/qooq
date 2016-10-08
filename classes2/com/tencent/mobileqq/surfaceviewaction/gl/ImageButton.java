package com.tencent.mobileqq.surfaceviewaction.gl;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import uxu;

public class ImageButton
  extends Sprite
  implements uxu
{
  private ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ImageButton(SpriteGLView paramSpriteGLView, Bitmap paramBitmap, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramBitmap);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(ImageButton.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener = paramOnClickListener;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a == null)) {}
    do
    {
      float f1;
      float f2;
      do
      {
        return false;
        paramInt1 = paramMotionEvent.getAction();
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        if (paramInt1 == 0)
        {
          if ((f1 > this.jdField_a_of_type_Float - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getWidth() * this.c / 2.0F) && (f1 < this.jdField_a_of_type_Float + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getWidth() * this.c / 2.0F) && (f2 > this.jdField_b_of_type_Float - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.c / 2.0F) && (f2 < this.jdField_b_of_type_Float + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.c / 2.0F))
          {
            this.jdField_a_of_type_Boolean = true;
            if (this.jdField_b_of_type_Boolean) {
              this.d = 128;
            }
          }
          for (;;)
          {
            return this.jdField_a_of_type_Boolean;
            this.jdField_a_of_type_Boolean = false;
            if (this.jdField_b_of_type_Boolean) {
              this.d = 255;
            }
          }
        }
      } while (paramInt1 != 1);
      if ((f1 > this.jdField_a_of_type_Float - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getWidth() * this.c / 2.0F) && (f1 < this.jdField_a_of_type_Float + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getWidth() * this.c / 2.0F) && (f2 > this.jdField_b_of_type_Float - this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.c / 2.0F) && (f2 < this.jdField_b_of_type_Float + this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.a.getHeight() * this.c / 2.0F) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener.a(this);
      }
      this.jdField_a_of_type_Boolean = false;
    } while (!this.jdField_b_of_type_Boolean);
    this.d = 255;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\gl\ImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */