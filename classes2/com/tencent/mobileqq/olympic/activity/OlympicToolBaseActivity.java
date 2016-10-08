package com.tencent.mobileqq.olympic.activity;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class OlympicToolBaseActivity
  extends FragmentActivity
{
  public OlympicToolAppInterface a;
  
  public OlympicToolBaseActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void updateAppRuntime()
  {
    super.updateAppRuntime();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof OlympicToolAppInterface)) {
      this.a = ((OlympicToolAppInterface)localAppRuntime);
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 4, "OlympicToolBaseActivity updateAppRuntime, " + localAppRuntime);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\activity\OlympicToolBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */