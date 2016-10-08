import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ThreadFactory;

public final class qhd
  implements ThreadFactory
{
  public qhd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TM.global", 2, "serialExecutor_thread");
    }
    paramRunnable = new Thread(paramRunnable, "serialExecutor_thread");
    if (ThreadOptimizer.a().c()) {
      paramRunnable.setPriority(1);
    }
    return paramRunnable;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */