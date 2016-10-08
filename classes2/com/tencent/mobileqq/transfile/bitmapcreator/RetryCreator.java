package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RetryCreator
  implements BitmapCreator
{
  int a;
  
  public RetryCreator(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramInt;
    if (this.a <= 0) {}
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    while (this.a < 0) {}
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\bitmapcreator\RetryCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */