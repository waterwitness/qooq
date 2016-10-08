package com.tencent.imageservice;

import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.upload.common.f;
import com.tencent.upload.uinterface.IUploadConfig;
import java.lang.reflect.Field;

public final class BitmapUtils
{
  public static BitmapFactory.Options getOptions()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if ((Build.VERSION.SDK_INT < 11) && (f.b() != null) && (f.b().enableBitmapNativeAlloc())) {
      setBitmapOptionInNativeAlloc(localOptions);
    }
    return localOptions;
  }
  
  public static void setBitmapOptionInNativeAlloc(Object paramObject)
  {
    try
    {
      Field localField = paramObject.getClass().getDeclaredField("inNativeAlloc");
      localField.setAccessible(true);
      localField.setBoolean(paramObject, true);
      return;
    }
    catch (Throwable paramObject) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\imageservice\BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */