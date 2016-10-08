package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.CPUFilter;
import com.tencent.filter.QImage;
import com.tencent.view.FilterDefault;

public class OilPaintFilter
  extends CPUFilter
{
  int type;
  
  public OilPaintFilter(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static native int nativeGetBrushSize(long paramLong);
  
  public static native long nativeInitialize(QImage paramQImage, int paramInt);
  
  public static native QImage nativeProcessOilPaintFilter(long paramLong, QImage paramQImage, int paramInt1, int paramInt2);
  
  public static native void nativeRelease(long paramLong);
  
  public static native void nativeSetBrush(long paramLong, Bitmap[] paramArrayOfBitmap);
  
  public QImage ApplyFilter(QImage paramQImage)
  {
    long l = nativeInitialize(paramQImage, this.type);
    int i = nativeGetBrushSize(l);
    Bitmap[] arrayOfBitmap = new Bitmap[4];
    if (this.type == 0)
    {
      arrayOfBitmap[0] = FilterDefault.decodeBitmap("brush/brush00.png", Bitmap.Config.ARGB_8888, i, i);
      arrayOfBitmap[1] = FilterDefault.decodeBitmap("brush/brush01.png", Bitmap.Config.ARGB_8888, i, i);
      arrayOfBitmap[2] = FilterDefault.decodeBitmap("brush/brush02.png", Bitmap.Config.ARGB_8888, i, i);
      arrayOfBitmap[3] = FilterDefault.decodeBitmap("brush/brush03.png", Bitmap.Config.ARGB_8888, i, i);
    }
    for (;;)
    {
      nativeSetBrush(l, arrayOfBitmap);
      paramQImage = nativeProcessOilPaintFilter(l, paramQImage, this.type, 5);
      nativeRelease(l);
      i = 0;
      while (i < arrayOfBitmap.length)
      {
        if (arrayOfBitmap[i] != null) {
          arrayOfBitmap[i].recycle();
        }
        i += 1;
      }
      arrayOfBitmap[0] = FilterDefault.decodeBitmap("brush/brush10.png", Bitmap.Config.ARGB_8888, i, i);
      arrayOfBitmap[1] = FilterDefault.decodeBitmap("brush/brush11.png", Bitmap.Config.ARGB_8888, i, i);
      arrayOfBitmap[2] = FilterDefault.decodeBitmap("brush/brush12.png", Bitmap.Config.ARGB_8888, i, i);
      arrayOfBitmap[3] = FilterDefault.decodeBitmap("brush/brush13.png", Bitmap.Config.ARGB_8888, i, i);
    }
    return paramQImage;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\art\OilPaintFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */