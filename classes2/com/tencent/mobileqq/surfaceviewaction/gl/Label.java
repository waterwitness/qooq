package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Label
  extends Sprite
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private String jdField_a_of_type_JavaLangString;
  private int e;
  
  public Label(SpriteGLView paramSpriteGLView, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 20;
    this.e = -1;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    a(paramInt1);
    b(paramInt2);
    a(paramSpriteGLView, paramString);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
  }
  
  public void a(SpriteGLView paramSpriteGLView, String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = Bitmap.createBitmap((int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString), this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramString);
    localCanvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
    localCanvas.drawText(this.jdField_a_of_type_JavaLangString, 0.0F, this.jdField_a_of_type_Int * 0.8F, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(paramSpriteGLView, paramString);
    c();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\gl\Label.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */