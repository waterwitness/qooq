package com.tencent.biz.qqstory.takevideo.doodle.ui.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ColorPicker
  extends ImageView
{
  private static final String jdField_a_of_type_JavaLangString = "ColorPicker";
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private ColorPicker.ColorSelectListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker$ColorSelectListener;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public ColorPicker(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ColorPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ColorPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130841381);
      setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.d = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      this.e = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        SLog.e("ColorPicker", "create color picker bitmap failed!");
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
    }
  }
  
  private void b()
  {
    this.h = (this.e - 1);
    int m = 0;
    int k = 0;
    if (this.h >= 0)
    {
      int n = this.jdField_a_of_type_AndroidGraphicsBitmap.getPixel(this.d / 2, this.h);
      int i1;
      if (n == -16777216)
      {
        i1 = 1;
        n = m;
      }
      label85:
      do
      {
        do
        {
          for (;;)
          {
            this.h -= 1;
            m = n;
            k = i1;
            break;
            if ((k == 0) || (n != -1)) {
              break label85;
            }
            n = 1;
            i1 = k;
          }
          n = m;
          i1 = k;
        } while (k == 0);
        n = m;
        i1 = k;
      } while (m == 0);
    }
    this.i = 0;
    if ((this.i >= this.e) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getPixel(this.d / 2, this.i) == -16777216)) {
      k = this.e - 1;
    }
    for (;;)
    {
      if (k >= 0)
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap.getPixel(this.d / 2, k) == -16777216) {
          this.j = (this.e - k);
        }
      }
      else
      {
        return;
        this.i += 1;
        break;
      }
      k -= 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = paramInt1;
    this.c = paramInt2;
    this.f = ((this.b - this.d) / 2);
    this.g = ((this.c - this.e) / 2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker$ColorSelectListener == null) {}
    while (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return false;
    }
    int k = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    k = this.b / 2;
    int m = this.f;
    n -= this.g;
    try
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getPixel(k - m, n);
      SLog.b("ColorPicker", "onColorSelect:" + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker$ColorSelectListener.a(this.jdField_a_of_type_Int);
      return true;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      for (;;)
      {
        if (n < 0) {
          this.jdField_a_of_type_Int = -65536;
        } else if (n >= this.c) {
          this.jdField_a_of_type_Int = -16777216;
        }
      }
    }
  }
  
  public void setListener(ColorPicker.ColorSelectListener paramColorSelectListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker$ColorSelectListener = paramColorSelectListener;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\control\ColorPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */