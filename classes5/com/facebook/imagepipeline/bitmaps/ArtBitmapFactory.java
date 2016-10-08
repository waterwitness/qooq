package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class ArtBitmapFactory
  extends PlatformBitmapFactory
{
  private final BitmapPool mBitmapPool;
  
  public ArtBitmapFactory(BitmapPool paramBitmapPool)
  {
    this.mBitmapPool = paramBitmapPool;
  }
  
  public CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = BitmapUtil.getSizeInByteForBitmap(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap = (Bitmap)this.mBitmapPool.get(i);
    Bitmaps.reconfigureBitmap(localBitmap, paramInt1, paramInt2, paramConfig);
    return CloseableReference.of(localBitmap, this.mBitmapPool);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\bitmaps\ArtBitmapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */