package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.QImage;

public class OpencvAlgorithm
{
  public static native void nativeDehazeProcess(QImage paramQImage, float paramFloat);
  
  public static native void nativeDetailEnhanceFilter(QImage paramQImage, float paramFloat);
  
  public static native int nativeGlowFilterDropShadow(QImage paramQImage, int paramInt1, int paramInt2, int paramInt3, float paramFloat);
  
  public static native int nativeGlowFilterGlow(QImage paramQImage, int paramInt1, int paramInt2, float paramFloat);
  
  public static native int nativeGlowFilterPolyFit(QImage paramQImage, Bitmap paramBitmap, int paramInt, float paramFloat);
  
  public static native void nativeImageHdrContrastEnhance(QImage paramQImage);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\microrapid\opencv\OpencvAlgorithm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */