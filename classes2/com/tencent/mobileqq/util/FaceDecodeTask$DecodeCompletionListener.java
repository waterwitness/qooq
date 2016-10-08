package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;

public abstract interface FaceDecodeTask$DecodeCompletionListener
{
  public abstract void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo);
  
  public abstract void a(FaceInfo paramFaceInfo, Bitmap paramBitmap);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\FaceDecodeTask$DecodeCompletionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */