package com.tencent.mobileqq.profile.view.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import txs;
import txt;

public class HeartRiseLayerDrawable
  extends LayerDrawable
{
  public HeartRiseLayerDrawable(int paramInt, Resources paramResources)
  {
    super(txt.a(paramInt, paramResources, a(paramResources)));
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Bitmap a(Resources paramResources)
  {
    Paint localPaint = new Paint();
    localPaint.setColor(paramResources.getColor(2131427553));
    Bitmap localBitmap = Bitmap.createBitmap(126, 126, Bitmap.Config.ARGB_4444);
    localBitmap.setDensity(paramResources.getDisplayMetrics().densityDpi);
    paramResources = new Canvas(localBitmap);
    paramResources.rotate(45.0F);
    paramResources.translate(0.0F, -88.0F);
    paramResources.drawRect(56, 56, 126, 126, localPaint);
    paramResources.drawCircle(56, 91, 35, localPaint);
    paramResources.drawCircle(91, 56, 35, localPaint);
    return localBitmap;
  }
  
  public void a(Handler paramHandler, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < getNumberOfLayers())
    {
      txs localtxs = new txs(this, i, paramInt1, paramInt2);
      if (i % 2 == 0) {}
      for (long l = i * 200;; l = i * 130)
      {
        paramHandler.postDelayed(localtxs, l);
        i += 1;
        break;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\profile\view\helper\HeartRiseLayerDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */