package com.tencent.mobileqq.nearby;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MyDrawable
  extends Drawable
{
  public Drawable a;
  
  public MyDrawable()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.a != null)
    {
      this.a.setCallback(getCallback());
      this.a.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\MyDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */