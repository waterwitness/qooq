package com.tencent.bitapp.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.tencent.bitapp.Const;

public class ViewUtils
{
  public static final String thumbnail = "Thumbnail";
  
  public static Bitmap addTextToBitmap(Bitmap paramBitmap, String paramString)
  {
    Object localObject2 = paramBitmap.getConfig();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Bitmap.Config.RGB_565;
    }
    paramBitmap = paramBitmap.copy((Bitmap.Config)localObject1, true);
    localObject1 = new Canvas(paramBitmap);
    localObject2 = new Paint();
    ((Paint)localObject2).setDither(true);
    ((Paint)localObject2).setColor(-65281);
    ((Paint)localObject2).setTextSize(30.0F);
    Rect localRect = new Rect();
    ((Paint)localObject2).getTextBounds(paramString, 0, paramString.length(), localRect);
    ((Canvas)localObject1).drawText(paramString, 0.0F, localRect.height(), (Paint)localObject2);
    ((Paint)localObject2).setColor(-65281);
    ((Paint)localObject2).setTextSize(80.0F);
    ((Paint)localObject2).setTypeface(Typeface.create("", 3));
    ((Paint)localObject2).setStyle(Paint.Style.STROKE);
    ((Paint)localObject2).setStrokeWidth(5.0F);
    ((Canvas)localObject1).drawText("THUMBNAIL", paramBitmap.getWidth() / 2 - localRect.width() / 2, paramBitmap.getHeight() / 2 + localRect.height() / 2, (Paint)localObject2);
    return paramBitmap;
  }
  
  public static Bitmap getCropBitmap(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (!paramView.isDrawingCacheEnabled())
      {
        localObject1 = localObject2;
        paramView.setDrawingCacheEnabled(true);
      }
      localObject1 = localObject2;
      paramView.buildDrawingCache();
      localObject1 = localObject2;
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
      localObject2 = localBitmap;
      localObject1 = localBitmap;
      if (Const.isAddTextToBitmap)
      {
        localObject1 = localBitmap;
        localObject2 = addTextToBitmap(localBitmap, "Thumbnail");
      }
      localObject1 = localObject2;
      paramView.setDrawingCacheEnabled(false);
      return (Bitmap)localObject2;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return (Bitmap)localObject1;
  }
  
  public static void getCropBitmap(View paramView, final ICropBitmapListener paramICropBitmapListener)
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        Bitmap localBitmap = ViewUtils.getCropBitmap(ViewUtils.this);
        if (localBitmap != null)
        {
          paramICropBitmapListener.onCropSuccess(ViewUtils.this, localBitmap);
          return;
        }
        paramICropBitmapListener.onCropFail(ViewUtils.this);
      }
    });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\utils\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */