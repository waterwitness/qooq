package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;

public abstract interface AnimatedDrawableCachingBackend
  extends AnimatedDrawableBackend
{
  public abstract void appendDebugOptionString(StringBuilder paramStringBuilder);
  
  public abstract AnimatedDrawableCachingBackend forNewBounds(Rect paramRect);
  
  public abstract CloseableReference<Bitmap> getBitmapForFrame(int paramInt);
  
  public abstract CloseableReference<Bitmap> getPreviewBitmap();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\animated\base\AnimatedDrawableCachingBackend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */