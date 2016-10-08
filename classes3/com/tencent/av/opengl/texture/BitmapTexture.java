package com.tencent.av.opengl.texture;

import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import junit.framework.Assert;

public class BitmapTexture
  extends UploadedTexture
{
  protected Bitmap a;
  
  public BitmapTexture(Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {}
    for (bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.a = paramBitmap;
      return;
    }
  }
  
  protected Bitmap a()
  {
    return this.a;
  }
  
  protected void a(Bitmap paramBitmap) {}
  
  public Bitmap b()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\texture\BitmapTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */