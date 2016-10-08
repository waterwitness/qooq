package com.tencent.bitapp.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hdx;

public class BitAppBitmapUtils
{
  public BitAppBitmapUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, String paramString, Bitmap paramBitmap)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {
      return;
    }
    ThreadManager.a(new hdx(paramContext, paramString, paramBitmap), 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\cache\BitAppBitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */