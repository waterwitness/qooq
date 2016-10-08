package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqprotect.singleupdate.QPSingleUpdTimerTask;
import java.util.Timer;

public class StartSecurityUpdate
  extends AsyncStep
{
  public StartSecurityUpdate()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    ThreadManager.a().schedule(new QPSingleUpdTimerTask(this.a.b.a()), 300000L, 86400000L);
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\StartSecurityUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */