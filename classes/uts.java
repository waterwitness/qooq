import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qphone.base.util.QLog;

public class uts
  implements Runnable
{
  public uts(InitSkin paramInitSkin) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(InitSkin.a(), 2, "start asynInitSkin");
    }
    InitSkin.initSkin(BaseApplicationImpl.a);
    InitSkin.c = true;
    synchronized (InitSkin.a)
    {
      InitSkin.a.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.i(InitSkin.a(), 2, "end asynInitSkin");
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */