package com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ThumbnailUtils
{
  private static final int a = 480;
  private static int b;
  private static int c;
  private static int d;
  private static int e;
  
  public ThumbnailUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    d = paramInt1;
    e = paramInt2;
    if (d > e)
    {
      d = 480;
      e = (int)(e / (paramInt1 * 1.0D / 480.0D));
    }
    for (;;)
    {
      return TrimNative.initGetFrame(paramString, d, e);
      e = 480;
      d = (int)(d / (paramInt2 * 1.0D / 480.0D));
    }
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    b = paramInt5;
    c = paramInt6;
    return TrimNative.prepare(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public static Bitmap a(long paramLong1, long paramLong2)
  {
    if ((d <= 0) || (e <= 0)) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = Bitmap.createBitmap(d, e, Bitmap.Config.ARGB_8888);
      if (TrimNative.getFrame(paramLong1, paramLong2, localBitmap) == 0) {
        break;
      }
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    localBitmap.recycle();
    return null;
    return localBitmap;
  }
  
  public static Bitmap b(long paramLong1, long paramLong2)
  {
    if ((b <= 0) || (c <= 0)) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = Bitmap.createBitmap(b, c, Bitmap.Config.ARGB_8888);
      if (TrimNative.getThumbnail(paramLong1, paramLong2, localBitmap) == 0) {
        break;
      }
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    localBitmap.recycle();
    return null;
    return localBitmap;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\trimvideo\video\utils\ThumbnailUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */