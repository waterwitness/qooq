import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ThreadFactory;

public final class qhe
  implements ThreadFactory
{
  public qhe()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TM.global", 2, "new NetExcutor5Thread");
    }
    paramRunnable = new Thread(paramRunnable, "NetExcutor5Thread");
    if (ThreadOptimizer.a().c()) {
      paramRunnable.setPriority(1);
    }
    return paramRunnable;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qhe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */