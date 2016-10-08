package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.AbstractImageDownloader;
import com.tencent.mobileqq.utils.ImageUtil;

public class RoundBitmapCreator
  implements BitmapCreator
{
  boolean a;
  
  public RoundBitmapCreator(boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBoolean;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    int i = Math.max(0, Math.max(paramBitmap.getHeight(), paramBitmap.getWidth()));
    if (this.a) {}
    for (float f = 0.0F;; f = AbstractImageDownloader.a(BaseApplicationImpl.a(), i))
    {
      Bitmap localBitmap = ImageUtil.a(paramBitmap, f);
      paramBitmap.recycle();
      return localBitmap;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\bitmapcreator\RoundBitmapCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */