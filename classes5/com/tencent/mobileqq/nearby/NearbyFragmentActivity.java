package com.tencent.mobileqq.nearby;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class NearbyFragmentActivity
  extends FragmentActivity
{
  public static final String h = NearbyFragmentActivity.class.getSimpleName();
  NearbyAppInterface b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected String getModuleId()
  {
    return "module_nearby";
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof NearbyAppInterface)) {
      this.b = ((NearbyAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i(h, 4, "NearbyFragmentActivity updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyFragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */