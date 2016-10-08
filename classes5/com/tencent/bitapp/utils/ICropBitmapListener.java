package com.tencent.bitapp.utils;

import android.graphics.Bitmap;
import android.view.View;

public abstract interface ICropBitmapListener
{
  public abstract void onCropFail(View paramView);
  
  public abstract void onCropSuccess(View paramView, Bitmap paramBitmap);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\utils\ICropBitmapListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */