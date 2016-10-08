package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;

public class SimpleBitmapReleaser
  implements ResourceReleaser<Bitmap>
{
  private static SimpleBitmapReleaser sInstance;
  
  public static SimpleBitmapReleaser getInstance()
  {
    if (sInstance == null) {
      sInstance = new SimpleBitmapReleaser();
    }
    return sInstance;
  }
  
  public void release(Bitmap paramBitmap)
  {
    paramBitmap.recycle();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\bitmaps\SimpleBitmapReleaser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */