package com.tencent.mobileqq.intervideo.now.runtime;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.IToolProcEventListener;

public class NowRunTime
  extends AppInterface
  implements IToolProcEventListener
{
  public static final String a = "NowRunTime";
  public static final String b = "Now";
  
  public NowRunTime(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return AppSetting.a;
  }
  
  public EntityManagerFactory a(String paramString)
  {
    return null;
  }
  
  public BaseApplication a()
  {
    return this.a;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public String getModuleId()
  {
    return "Now";
  }
  
  public void onBeforeExitProc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowRunTime", 2, "onBeforeExitProc");
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowRunTime", 2, "onReceiveAccountAction");
    }
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NowRunTime", 2, "onReceiveLegalExitProcAction");
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\now\runtime\NowRunTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */