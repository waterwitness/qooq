package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class BitmapCreatorGetter
{
  BitmapCreator a;
  
  public BitmapCreatorGetter()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BitmapCreator a()
  {
    return this.a;
  }
  
  public void a(BitmapCreator paramBitmapCreator)
  {
    this.a = paramBitmapCreator;
  }
  
  protected Bitmap b(Bitmap paramBitmap)
  {
    if (this.a == null) {
      return paramBitmap;
    }
    return this.a.a(paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\bitmapcreator\BitmapCreatorGetter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */