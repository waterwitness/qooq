package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import hxh;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadInJoyDisplayUtils
{
  private static Drawable a;
  public static final String a = "…";
  private static final String b = ReadInJoyDisplayUtils.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Pair a()
  {
    Resources localResources = BaseApplicationImpl.a().getResources();
    return new Pair(Integer.valueOf((localResources.getDisplayMetrics().widthPixels - AIOUtils.a(3.0F, localResources)) / 3), Integer.valueOf(localResources.getDimensionPixelSize(2131493822)));
  }
  
  public static String a(String paramString)
  {
    String str;
    if (android.text.TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!com.tencent.mobileqq.text.TextUtils.a(paramString));
    paramString = new StringBuilder(paramString);
    int j;
    for (int i = 0; i < paramString.length(); i = j + 1)
    {
      j = i;
      if (paramString.codePointAt(i) == 20)
      {
        j = i;
        if (i < paramString.length() - 1)
        {
          int k = paramString.charAt(i + 1);
          j = i;
          if (k < EmotcationConstants.b)
          {
            str = EmotcationConstants.a[k];
            paramString.replace(i + 1, i + 2, str);
            j = i + (str.length() - 1);
          }
        }
      }
    }
    return paramString.toString();
  }
  
  public static void a() {}
  
  public static void a(Context paramContext, URLImageView paramURLImageView)
  {
    paramContext = b();
    int i = ((Integer)paramContext.first).intValue();
    int j = ((Integer)paramContext.second).intValue();
    paramContext = new LinearLayout.LayoutParams(i, j);
    paramContext.width = i;
    paramContext.height = j;
    paramContext.setMargins(0, 0, 0, 0);
    paramURLImageView.setLayoutParams(paramContext);
    paramURLImageView.setPadding(0, 0, 0, 0);
    paramURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public static void a(Context paramContext, URLImageView paramURLImageView, boolean paramBoolean)
  {
    paramContext = a();
    int i = ((Integer)paramContext.first).intValue();
    int j = ((Integer)paramContext.second).intValue();
    ViewGroup.LayoutParams localLayoutParams = paramURLImageView.getLayoutParams();
    paramContext = localLayoutParams;
    if (localLayoutParams == null) {
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (paramContext = new LinearLayout.LayoutParams(i, j);; paramContext = new RelativeLayout.LayoutParams(i, j))
    {
      paramContext.width = i;
      paramContext.height = j;
      paramURLImageView.setLayoutParams(paramContext);
      paramURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
  }
  
  public static void a(URLImageView paramURLImageView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramURLImageView == null) {}
    for (;;)
    {
      return;
      Object localObject = paramDrawable1;
      if (paramDrawable1 == null) {
        localObject = BaseApplicationImpl.a().getResources().getDrawable(2130837566);
      }
      paramDrawable1 = paramDrawable2;
      if (paramDrawable2 == null) {
        paramDrawable1 = BaseApplicationImpl.a().getResources().getDrawable(2130837566);
      }
      try
      {
        new URL(paramString);
        paramDrawable2 = URLDrawable.URLDrawableOptions.obtain();
        paramDrawable2.mRequestWidth = paramInt1;
        paramDrawable2.mRequestHeight = paramInt2;
        paramDrawable2.mPlayGifImage = true;
        paramDrawable2 = URLDrawable.getDrawable(paramString, paramDrawable2);
        paramDrawable2.setURLDrawableListener(new hxh(paramURLImageView, paramDrawable1, (Drawable)localObject));
        paramDrawable2.startDownload();
        paramURLImageView.setImageDrawable((Drawable)localObject);
        if (paramDrawable2.getStatus() != 1) {
          break label200;
        }
        paramDrawable2 = ImageUtil.a(paramDrawable2);
        if (paramDrawable2 != null)
        {
          localObject = b(paramDrawable2, paramDrawable2.getWidth());
          if (!paramDrawable2.isRecycled()) {
            paramDrawable2.recycle();
          }
          paramURLImageView.setImageBitmap((Bitmap)localObject);
          return;
        }
      }
      catch (Exception paramDrawable2)
      {
        if (!(paramDrawable2 instanceof MalformedURLException)) {
          break label207;
        }
      }
    }
    QLog.d(b, 4, paramDrawable2.getMessage());
    for (;;)
    {
      paramURLImageView.setImageDrawable(paramDrawable1);
      return;
      label200:
      paramURLImageView.setImageDrawable(paramDrawable1);
      return;
      label207:
      QLog.d(b, 4, paramDrawable2.getMessage() + "error configImage URL: " + paramString);
    }
  }
  
  public static void a(URLImageView paramURLImageView, URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2, Context paramContext)
  {
    Object localObject2 = null;
    if ((paramURLImageView == null) || (paramContext == null)) {
      return;
    }
    Object localObject1;
    if (paramDrawable1 == null)
    {
      paramDrawable1 = a;
      localObject1 = paramDrawable1;
      if (paramDrawable1 == null)
      {
        a = paramContext.getResources().getDrawable(2130838862);
        localObject1 = a;
      }
      paramDrawable1 = paramDrawable2;
      if (paramDrawable2 == null) {
        paramDrawable1 = a;
      }
    }
    for (;;)
    {
      try
      {
        paramDrawable2 = URLDrawable.URLDrawableOptions.obtain();
        paramDrawable2.mRequestWidth = paramURLImageView.getWidth();
        paramDrawable2.mRequestHeight = paramURLImageView.getHeight();
        paramDrawable2.mPlayGifImage = true;
        paramDrawable2.mLoadingDrawable = ((Drawable)localObject1);
        paramDrawable2.mFailedDrawable = paramDrawable1;
        localObject1 = URLDrawable.getDrawable(paramURL, paramDrawable2);
        paramDrawable2 = (Drawable)localObject2;
        if ((paramContext instanceof BaseActivity)) {
          paramDrawable2 = (BaseActivity)paramContext;
        }
        if (paramDrawable2 == null) {
          break label246;
        }
        bool = SettingCloneUtil.readValue(paramDrawable2, paramDrawable2.app.a(), null, "qqsetting_kandian_download_pic_flag", false);
        if ((NetworkUtil.i(paramContext)) || (!bool) || (((URLDrawable)localObject1).getStatus() == 1)) {
          break label202;
        }
        paramURLImageView.setImageResource(2130838862);
        ((URLDrawable)localObject1).cancelDownload();
        return;
      }
      catch (Exception paramDrawable2)
      {
        if (!(paramDrawable2 instanceof MalformedURLException)) {
          break label209;
        }
      }
      QLog.d(b, 4, paramDrawable2.getMessage());
      for (;;)
      {
        paramURLImageView.setImageDrawable(paramDrawable1);
        return;
        break;
        label202:
        paramURLImageView.setImageDrawable((Drawable)localObject1);
        return;
        label209:
        QLog.d(b, 4, paramDrawable2.getMessage() + "error configImage URL: " + paramURL);
      }
      label246:
      boolean bool = false;
    }
  }
  
  public static void a(String paramString)
  {
    URLDrawable.removeMemoryCacheByUrl(paramString);
  }
  
  private static Bitmap b(Bitmap paramBitmap, float paramFloat)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public static Pair b()
  {
    int i = BaseApplicationImpl.a().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.5533D)));
  }
  
  public static String b(String paramString)
  {
    String str;
    if (android.text.TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!com.tencent.mobileqq.text.TextUtils.a(paramString));
    paramString = new StringBuilder(paramString);
    int i = 0;
    while (i < EmotcationConstants.a.length)
    {
      str = EmotcationConstants.a[i];
      int j = -1;
      for (;;)
      {
        int k = paramString.indexOf(str, j + 1);
        if (k == -1) {
          break;
        }
        j = k;
        if (k != 0)
        {
          j = k;
          if (paramString.codePointAt(k - 1) == 20)
          {
            char c = (char)i;
            paramString.replace(k, str.length() + k, String.valueOf(c));
            j = k;
          }
        }
      }
      i += 1;
    }
    return paramString.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\common\ReadInJoyDisplayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */