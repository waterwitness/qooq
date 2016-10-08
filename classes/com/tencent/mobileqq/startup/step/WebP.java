package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class WebP
  extends Step
{
  private static final String a = "WEBP";
  
  protected boolean a()
  {
    if ((!WebpSoLoader.a()) && (QLog.isColorLevel())) {
      QLog.d("WEBP", 2, String.format("Can't load libwebp support library when start %s process!", new Object[] { BaseApplicationImpl.getMobileQQ().getProcessName() }));
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\WebP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */