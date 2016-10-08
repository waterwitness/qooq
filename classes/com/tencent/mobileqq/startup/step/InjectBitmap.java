package com.tencent.mobileqq.startup.step;

import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class InjectBitmap
  extends Step
{
  private static final String a = "InjectBitmap";
  
  protected boolean a()
  {
    try
    {
      SafeBitmapFactory.injectBitmapHotPatch();
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("InjectBitmap", 1, "", localThrowable);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\InjectBitmap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */