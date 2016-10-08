package com.tencent.util;

import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BitmapUtil
{
  public BitmapUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int m = paramInt1 / j;
    int n = paramInt2 / k;
    if (n > m)
    {
      paramInt1 = (paramInt2 - k * paramInt1 / j) / 2;
      paramInt2 = paramInt1 / k;
      paramInt2 = i;
    }
    for (;;)
    {
      if (paramInt1 > 0) {}
      while (paramInt2 <= 0)
      {
        return null;
        if (n >= m) {
          break label93;
        }
        paramInt2 = (paramInt1 - j * paramInt2 / k) / 2;
        paramInt1 = paramInt2 / j;
        paramInt1 = 0;
        break;
      }
      return null;
      label93:
      paramInt1 = 0;
      paramInt2 = i;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\BitmapUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */