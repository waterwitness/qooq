package com.microrapid.opencv;

import android.graphics.Bitmap;

public class SwitchFaceHandle
{
  private static native void nativeSwitchFace(Bitmap paramBitmap1, int[][] paramArrayOfInt1, Bitmap paramBitmap2, int[][] paramArrayOfInt2, Bitmap paramBitmap3);
  
  public static void switchFace(Bitmap paramBitmap1, int[][] paramArrayOfInt1, Bitmap paramBitmap2, int[][] paramArrayOfInt2, Bitmap paramBitmap3)
  {
    nativeSwitchFace(paramBitmap1, paramArrayOfInt1, paramBitmap2, paramArrayOfInt2, paramBitmap3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\microrapid\opencv\SwitchFaceHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */