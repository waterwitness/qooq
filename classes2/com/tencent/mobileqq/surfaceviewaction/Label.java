package com.tencent.mobileqq.surfaceviewaction;

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
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public Label(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 20;
    this.b = -16777216;
    a(paramInt1);
    b(paramInt2);
    a(paramString);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.b);
  }
  
  public void a(String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    int i = (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    for (this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888);; this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888))
    {
      do
      {
        paramString = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        paramString.drawColor(-16777216, PorterDuff.Mode.CLEAR);
        paramString.drawText(this.jdField_a_of_type_JavaLangString, 0.0F, this.jdField_a_of_type_Int * 0.8F, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      } while (((i == this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight())) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()));
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\Label.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */