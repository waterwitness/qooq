package com.tencent.mobileqq.urldrawable;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import vxb;
import vxc;
import vxd;
import vxe;
import vxf;
import vxg;
import vxh;
import vxi;

public abstract class URLDrawableDecodeHandler
  implements DownloadParams.DecodeHandler
{
  public static final DownloadParams.DecodeHandler a;
  private static String a;
  public static final DownloadParams.DecodeHandler b = new vxc();
  public static final DownloadParams.DecodeHandler c = new vxd();
  public static final DownloadParams.DecodeHandler d = new vxe();
  public static final DownloadParams.DecodeHandler e = new vxf();
  public static final DownloadParams.DecodeHandler f = new vxg();
  public static final DownloadParams.DecodeHandler g = new vxh();
  public static final DownloadParams.DecodeHandler h = new vxi();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "URLDrawableDecodeHandler";
    jdField_a_of_type_ComTencentImageDownloadParams$DecodeHandler = new vxb();
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    Object localObject = new int[k * m];
    paramBitmap.getPixels((int[])localObject, 0, k, 0, 0, k, m);
    int n = (int)Math.ceil(m / paramInt);
    int i1 = (int)Math.ceil(k / paramInt);
    int i = 0;
    while (i < n)
    {
      int j = 0;
      while (j < i1)
      {
        a((int[])localObject, j * paramInt + 1, i * paramInt + 1, paramInt, k, m);
        j += 1;
      }
      i += 1;
    }
    paramBitmap.recycle();
    paramBitmap = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
    paramBitmap.setPixels((int[])localObject, 0, k, 0, 0, k, m);
    localObject = new Canvas();
    ((Canvas)localObject).setBitmap(paramBitmap);
    ((Canvas)localObject).drawARGB(89, 0, 0, 0);
    return paramBitmap;
  }
  
  public static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramInt1 + paramInt3 - 1;
    int j = paramInt2 + paramInt3 - 1;
    paramInt3 = i;
    if (i > paramInt4) {
      paramInt3 = paramInt4;
    }
    if (j > paramInt5) {}
    for (;;)
    {
      j = paramArrayOfInt[((paramInt3 - paramInt1 + 1) / 2 + paramInt1 + ((paramInt5 - paramInt2 + 1) / 2 + paramInt2 - 1) * paramInt4 - 1)];
      while (paramInt2 <= paramInt5)
      {
        i = paramInt1;
        while (i <= paramInt3)
        {
          paramArrayOfInt[((paramInt2 - 1) * paramInt4 + i - 1)] = j;
          i += 1;
        }
        paramInt2 += 1;
      }
      return;
      paramInt5 = j;
    }
  }
  
  public static final int[] a(int paramInt1, int paramInt2)
  {
    return new int[] { paramInt1, paramInt2 };
  }
  
  public static final int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new int[] { paramInt1, paramInt2, paramInt3 };
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\urldrawable\URLDrawableDecodeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */