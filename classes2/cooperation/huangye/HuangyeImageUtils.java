package cooperation.huangye;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class HuangyeImageUtils
{
  private static final String a = "HuangyeImageUtils";
  public static final int[] a = { 48, 2, 20, 217, 4, 15, 349, 81, 84, 349, 90, 66, 340, 69, 94, 315, 73, 74, 267, 86, 81, 271, 81, 54, 208, 87, 92, 225, 69, 82, 182, 79, 82, 204, 85, 91, 165, 87, 81, 165, 95, 63, 146, 78, 78, 145, 78, 68, 89, 78, 78, 68, 92, 73, 38, 75, 99, 38, 92, 88, 28, 86, 99, 20, 85, 94, 6, 78, 96, 4, 77, 85 };
  private static final int[] b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = new int[] { Color.parseColor("#55c8c8"), Color.parseColor("#fc7867"), Color.parseColor("#8bc03c"), Color.parseColor("#ffbe34"), Color.parseColor("#ffbe34"), Color.parseColor("#649deb"), Color.parseColor("#fe8d3a"), Color.parseColor("#55c8c8"), Color.parseColor("#53bae2"), Color.parseColor("#fe8d3a"), Color.parseColor("#53bae2"), Color.parseColor("#fc7867") };
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    int[] arrayOfInt = a(paramInt1, paramInt2, paramInt3);
    int n = arrayOfInt[0];
    int i1 = arrayOfInt[1];
    int i2 = arrayOfInt[2];
    if ((i1 < 50) && (i2 > 75)) {
      i = -1;
    }
    int i3;
    int j;
    do
    {
      return i;
      paramInt3 = 1000000;
      i3 = a.length / 3;
      j = 0;
      paramInt1 = 0;
      paramInt2 = i;
      i = paramInt1;
    } while (paramInt2 >= i3);
    i = a[(j + 1)];
    int k = a[(j + 1)];
    k = (i2 - a[(j + 2)]) * (i2 - a[(j + 2)]) + (i1 - i) * (i1 - k);
    int m;
    if (i1 > 35)
    {
      m = n - a[j];
      if (m > 180) {
        i = 360 - m;
      }
    }
    label164:
    for (i = i * i + k;; i = k)
    {
      if (i < paramInt3)
      {
        paramInt3 = paramInt2;
        paramInt1 = i;
      }
      for (;;)
      {
        paramInt2 += 1;
        j += 3;
        i = paramInt3;
        paramInt3 = paramInt1;
        paramInt1 = i;
        break;
        i = m;
        if (m >= 65356) {
          break label164;
        }
        i = m + 360;
        break label164;
        i = paramInt1;
        paramInt1 = paramInt3;
        paramInt3 = i;
      }
    }
  }
  
  public static final BitmapDrawable a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject2 = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
      if (localBitmap != null)
      {
        localObject2 = new Canvas(localBitmap);
        Paint localPaint = new Paint(1);
        RectF localRectF = new RectF(new Rect(0, 0, paramInt2, paramInt3));
        float f1 = paramInt2 / 2;
        float f2 = paramInt2 / 2 + paramInt2 / 20;
        localPaint.setAntiAlias(true);
        localPaint.setTextAlign(Paint.Align.CENTER);
        localPaint.setTextSize(f2);
        localPaint.setColor(paramInt1);
        ((Canvas)localObject2).drawRoundRect(localRectF, f1, f1, localPaint);
        localPaint.setColor(-1);
        Paint.FontMetricsInt localFontMetricsInt = localPaint.getFontMetricsInt();
        f1 = localRectF.top;
        f2 = (localRectF.bottom - localRectF.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2.0F;
        float f3 = localFontMetricsInt.top;
        ((Canvas)localObject2).drawText(paramString, localRectF.centerX(), f1 + f2 - f3, localPaint);
        localObject2 = new BitmapDrawable(localBitmap);
      }
      return (BitmapDrawable)localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HuangyeImageUtils", 2, "OOM occurred in ImageUtil.round" + localOutOfMemoryError.getMessage());
        }
        Object localObject1 = null;
      }
    }
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      str = "huangyeroundimage";
      paramString = paramString + "|" + paramBoolean1 + "|" + paramBoolean2;
    }
    for (;;)
    {
      try
      {
        paramString = new URL(str, "", paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label163;
        }
        QLog.d("HuangyeImageUtils", 2, paramString.getMessage(), paramString);
      }
      if (FileManagerUtil.a(paramString) == 2)
      {
        str = "videothumb";
      }
      else
      {
        str = "datalineimage";
        paramString = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + "0" + "|" + paramBoolean1;
      }
    }
    label163:
    return null;
  }
  
  private static void a(ImageView paramImageView, Drawable paramDrawable, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = a(paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (paramString == null) {}
    do
    {
      URLDrawable localURLDrawable;
      do
      {
        return;
        if (!(paramImageView.getDrawable() instanceof URLDrawable)) {
          break;
        }
        localURLDrawable = (URLDrawable)paramImageView.getDrawable();
      } while ((localURLDrawable.getURL().toString().equals(paramString.toString())) && (localURLDrawable.getStatus() == 1));
      paramDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, paramDrawable, paramDrawable, false);
      paramImageView.setImageDrawable(paramDrawable);
    } while ((paramDrawable.getStatus() == 1) || (paramDrawable.getStatus() == 0));
    paramDrawable.restartDownload();
  }
  
  public static void a(ImageView paramImageView, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    int j = 100;
    int m = paramImageView.getWidth();
    int k = paramImageView.getHeight();
    int i = m;
    if (m == 0) {
      i = 100;
    }
    if (k == 0) {}
    for (;;)
    {
      a(paramImageView, paramString1, paramBoolean1, paramBoolean2, paramString2, i, j);
      return;
      j = k;
    }
  }
  
  public static void a(ImageView paramImageView, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i;
    if (paramString2 != null)
    {
      i = 0;
      while (j < paramString2.length())
      {
        i = (char)(i ^ paramString2.charAt(j));
        j += 1;
      }
    }
    for (paramString2 = ContactUtils.b(paramString2);; paramString2 = "a")
    {
      j = b.length;
      a(paramImageView, a(b[(i % j)], paramString2, paramInt1, paramInt2), paramString1, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
      i = 0;
    }
  }
  
  static int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.max(Math.max(paramInt1, paramInt2), paramInt3);
    int j = Math.min(Math.min(paramInt1, paramInt2), paramInt3);
    float f4 = i / 255.0F;
    float f2;
    float f1;
    if (i == 0)
    {
      f2 = 0.0F;
      if (i != j) {
        break label113;
      }
      f1 = 0.0F;
    }
    for (;;)
    {
      float f3;
      if (f1 >= 0.0F)
      {
        f3 = f1;
        if (f1 <= 360.0F) {}
      }
      else
      {
        f3 = 0.0F;
      }
      return new int[] { (int)f3, (int)(f2 * 100.0F), (int)(f4 * 100.0F) };
      f2 = (i - j) / i;
      break;
      label113:
      if ((i == paramInt1) && (paramInt2 >= paramInt3)) {
        f1 = (paramInt2 - paramInt3) * 60.0F / (i - j) + 0.0F;
      } else if ((i == paramInt1) && (paramInt2 < paramInt3)) {
        f1 = (paramInt2 - paramInt3) * 60.0F / (i - j) + 360.0F;
      } else if (i == paramInt2) {
        f1 = (paramInt3 - paramInt1) * 60.0F / (i - j) + 120.0F;
      } else if (i == paramInt3) {
        f1 = (paramInt1 - paramInt2) * 60.0F / (i - j) + 240.0F;
      } else {
        f1 = 0.0F;
      }
    }
  }
  
  public static int[] a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int m = paramBitmap.getWidth();
    int n = paramBitmap.getHeight();
    int[] arrayOfInt = new int[m * n];
    paramBitmap.getPixels(arrayOfInt, 0, m, 0, 0, m, n);
    paramBitmap = new int[a.length / 3];
    int i = 0;
    while (i < paramBitmap.length)
    {
      paramBitmap[i] = 0;
      i += 1;
    }
    i = 0;
    int j = 0;
    while (i < n)
    {
      k = 0;
      if (k < m)
      {
        int i3 = arrayOfInt[(j + k)];
        int i1 = (0xFF0000 & i3) >> 16;
        int i2 = (0xFF00 & i3) >> 8;
        i3 &= 0xFF;
        if ((i1 >= 245) && (i2 >= 245) && (i3 >= 245)) {}
        for (;;)
        {
          k += 1;
          break;
          i1 = a(i1, i2, i3);
          if (i1 != -1) {
            paramBitmap[i1] += 1;
          }
        }
      }
      j += m;
      i += 1;
    }
    i = 0;
    j = 0;
    int k = 0;
    while (i < paramBitmap.length)
    {
      m = j;
      if (paramBitmap[i] > j)
      {
        m = paramBitmap[i];
        k = i;
      }
      i += 1;
      j = m;
    }
    i = k * 3;
    return a(new float[] { a[i], a[(i + 1)] / 100.0F, a[(i + 2)] / 100.0F });
  }
  
  static int[] a(float[] paramArrayOfFloat)
  {
    float f2 = paramArrayOfFloat[0];
    float f1 = paramArrayOfFloat[1];
    float f4 = paramArrayOfFloat[2];
    int i = (int)(f2 / 60.0F) % 6;
    f2 = f2 / 60.0F - i;
    float f5 = (1.0F - f1) * f4;
    float f6 = (1.0F - f2 * f1) * f4;
    float f7 = (1.0F - f1 * (1.0F - f2)) * f4;
    f2 = f5;
    float f3 = f4;
    f1 = f6;
    switch (i)
    {
    default: 
      f2 = 0.0F;
      f3 = 0.0F;
      f1 = 0.0F;
    }
    for (;;)
    {
      return new int[] { (int)(f1 * 255.0D), (int)(f3 * 255.0D), (int)(f2 * 255.0D) };
      f1 = f4;
      f3 = f7;
      f2 = f5;
      continue;
      f1 = f5;
      f2 = f7;
      f3 = f4;
      continue;
      f3 = f6;
      f1 = f5;
      f2 = f4;
      continue;
      f1 = f7;
      f2 = f4;
      f3 = f5;
      continue;
      f1 = f4;
      f3 = f5;
      f2 = f6;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HuangyeImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */