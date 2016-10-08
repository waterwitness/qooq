package com.tencent.mobileqq.transfile.filebrowser;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FastBitmapDrawable
  extends Drawable
{
  private Bitmap a;
  
  public FastBitmapDrawable(Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBitmap;
  }
  
  public Bitmap a()
  {
    return this.a;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.a != null) && (!this.a.isRecycled())) {
      paramCanvas.drawBitmap(this.a, 0.0F, 0.0F, null);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.a.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.a.getWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.a.getHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.a.getWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\filebrowser\FastBitmapDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */