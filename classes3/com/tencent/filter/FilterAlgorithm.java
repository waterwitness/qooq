package com.tencent.filter;

import android.graphics.Bitmap;

public class FilterAlgorithm
{
  public static native void nativeDrawBitmapWithBlendmode(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeFastBlur(QImage paramQImage, float paramFloat);
  
  public static native float[] nativeGetMaxAndMin(QImage paramQImage);
  
  public static native void nativeImageAutoContrast(QImage paramQImage, float paramFloat);
  
  public static native void nativeImageAutoTone(QImage paramQImage);
  
  public static native void nativeImageHistogramStretch(QImage paramQImage, float paramFloat);
  
  public static native void nativeUpdateLookupBitmap(QImage paramQImage, float paramFloat);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\FilterAlgorithm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */