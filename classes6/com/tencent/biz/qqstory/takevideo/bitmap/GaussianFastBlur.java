package com.tencent.biz.qqstory.takevideo.bitmap;

import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GaussianFastBlur
{
  public static final String a = "GaussianFastBlur";
  
  public GaussianFastBlur()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Bitmap paramBitmap, int paramInt, int[] paramArrayOfInt)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length != k * m))
    {
      a("GaussianFastBlur", "no old pixes");
      paramArrayOfInt = new int[k * m];
    }
    for (;;)
    {
      paramBitmap.getPixels(paramArrayOfInt, 0, k, 0, 0, k, m);
      while (paramInt >= 1)
      {
        int i = paramInt;
        while (i < m - paramInt)
        {
          int j = paramInt;
          while (j < k - paramInt)
          {
            int n = paramArrayOfInt[((i - paramInt) * k + j - paramInt)];
            int i1 = paramArrayOfInt[((i - paramInt) * k + j + paramInt)];
            int i2 = paramArrayOfInt[((i - paramInt) * k + j)];
            int i3 = paramArrayOfInt[((i + paramInt) * k + j - paramInt)];
            int i4 = paramArrayOfInt[((i + paramInt) * k + j + paramInt)];
            int i5 = paramArrayOfInt[((i + paramInt) * k + j)];
            int i6 = paramArrayOfInt[(i * k + j - paramInt)];
            int i7 = paramArrayOfInt[(i * k + j + paramInt)];
            paramArrayOfInt[(i * k + j)] = ((n & 0xFF0000) + (i1 & 0xFF0000) + (0xFF0000 & i2) + (0xFF0000 & i3) + (0xFF0000 & i4) + (0xFF0000 & i5) + (0xFF0000 & i6) + (0xFF0000 & i7) >> 3 & 0xFF0000 | 0xFF000000 | (n & 0xFF) + (i1 & 0xFF) + (i2 & 0xFF) + (i3 & 0xFF) + (i4 & 0xFF) + (i5 & 0xFF) + (i6 & 0xFF) + (i7 & 0xFF) >> 3 & 0xFF | (0xFF00 & n) + (0xFF00 & i1) + (0xFF00 & i2) + (0xFF00 & i3) + (0xFF00 & i4) + (0xFF00 & i5) + (0xFF00 & i6) + (0xFF00 & i7) >> 3 & 0xFF00);
            j += 1;
          }
          i += 1;
        }
        paramInt /= 2;
      }
      paramBitmap.setPixels(paramArrayOfInt, 0, k, 0, 0, k, m);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\bitmap\GaussianFastBlur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */