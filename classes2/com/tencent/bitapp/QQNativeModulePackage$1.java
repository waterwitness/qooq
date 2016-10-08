package com.tencent.bitapp;

import android.graphics.Bitmap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.tencent.bitapp.cache.BitAppBitmapUtils;
import com.tencent.bitapp.nativemodule.BitApp.OnSaveBitmapListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class QQNativeModulePackage$1
  implements BitApp.OnSaveBitmapListener
{
  QQNativeModulePackage$1(QQNativeModulePackage paramQQNativeModulePackage, ReactApplicationContext paramReactApplicationContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onSaveBitmap(String paramString, Bitmap paramBitmap)
  {
    BitAppBitmapUtils.a(this.val$reactContext, paramString, paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\QQNativeModulePackage$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */