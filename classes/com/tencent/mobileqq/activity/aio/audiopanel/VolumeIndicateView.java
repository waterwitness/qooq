package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VolumeIndicateView
  extends ImageView
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private int e;
  private int f;
  
  public VolumeIndicateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = 0;
    int k;
    int j;
    int i;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      k = getWidth();
      j = getHeight();
      if (this.f != 3) {
        break label79;
      }
      i = k - this.e * k / 10000 - 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(i, m, k, j);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      super.onDraw(paramCanvas);
      return;
      label79:
      if (this.f == 4)
      {
        k = k * this.e / 10000 + 1;
        i = 0;
      }
      else if (this.f == 1)
      {
        m = this.e * j / 10000;
        i = 0;
        m = j - m - 1;
      }
      else if (this.f == 2)
      {
        j = j * this.e / 10000 + 1;
        i = 0;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void setIndicateVolumeBitmap(Bitmap paramBitmap, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.f = paramInt;
  }
  
  public void setLevel(int paramInt)
  {
    this.e = paramInt;
    invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\audiopanel\VolumeIndicateView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */