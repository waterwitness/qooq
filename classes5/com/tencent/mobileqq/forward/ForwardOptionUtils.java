package com.tencent.mobileqq.forward;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.ImageUtil;

public class ForwardOptionUtils
{
  public ForwardOptionUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt, double paramDouble)
  {
    float f = 1.0F;
    if (paramInt > 150) {
      f = paramInt / 100;
    }
    if (paramDouble <= 1.5D) {
      return (int)(f * 9.0F);
    }
    if (paramDouble <= 2.0D) {
      return (int)(f * 9.0F);
    }
    return (int)(f * 4.0F);
  }
  
  public static Drawable a(Bitmap paramBitmap)
  {
    Object localObject = null;
    Bitmap localBitmap = ImageUtil.a(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    paramBitmap = (Bitmap)localObject;
    if (localBitmap != null) {
      paramBitmap = new BitmapDrawable(BaseApplicationImpl.a().getResources(), localBitmap);
    }
    return paramBitmap;
  }
  
  public static Drawable a(Bitmap paramBitmap, double paramDouble)
  {
    Object localObject = null;
    Bitmap localBitmap = ImageUtil.a(paramBitmap, a(0, paramDouble));
    paramBitmap = (Bitmap)localObject;
    if (localBitmap != null) {
      paramBitmap = new BitmapDrawable(BaseApplicationImpl.a().getResources(), localBitmap);
    }
    return paramBitmap;
  }
  
  public static Drawable a(Drawable paramDrawable, double paramDouble)
  {
    return a(SkinUtils.a(paramDrawable), paramDouble);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardOptionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */