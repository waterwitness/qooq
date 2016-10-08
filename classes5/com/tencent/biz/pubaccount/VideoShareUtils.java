package com.tencent.biz.pubaccount;

import android.graphics.Bitmap;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import hsp;

public class VideoShareUtils
{
  public static final String a = "VideoShareUtils";
  
  public VideoShareUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      localBitmap = paramBitmap;
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), (int)(j * d), true);
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        System.gc();
        paramBitmap.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("VideoShareUtils", 2, "scaleBitmapForWeChat ERROR OutOfMemoryError");
        }
        localBitmap = null;
      }
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoShareUtils", 2, "scaleBitmapForWeChat ERROR e=" + paramBitmap.getMessage());
        }
        Bitmap localBitmap = null;
      }
    }
    return localBitmap;
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt)
  {
    int j = 0;
    if (paramString1 == null) {}
    for (paramBaseActivity = "";; paramBaseActivity = paramString1)
    {
      if (paramString2 == null) {}
      for (paramString1 = "";; paramString1 = paramString2)
      {
        int i;
        if (!WXShareHelper.a().a()) {
          i = 2131369529;
        }
        for (;;)
        {
          if (i != -1)
          {
            QRUtils.a(0, i);
            if (QLog.isColorLevel()) {
              QLog.d("VideoShareUtils", 2, "title=" + paramBaseActivity + ", description=" + paramString1 + ", shareUrl=" + paramString3 + ", action=" + paramInt);
            }
            return;
            if (!WXShareHelper.a().b()) {
              i = 2131369530;
            }
          }
          else
          {
            paramString2 = String.valueOf(System.currentTimeMillis());
            Object localObject = new hsp(paramString2);
            WXShareHelper.a().a((WXShareHelper.WXShareListener)localObject);
            localObject = WXShareHelper.a();
            paramBitmap = a(paramBitmap);
            if (paramInt == 9) {}
            for (i = j;; i = 1)
            {
              ((WXShareHelper)localObject).a(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, i);
              break;
            }
          }
          i = -1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\VideoShareUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */