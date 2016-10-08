package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;

public abstract class CloseableBitmap
  extends CloseableImage
{
  public abstract Bitmap getUnderlyingBitmap();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\image\CloseableBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */