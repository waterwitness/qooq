import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;

public final class qhf
  extends Timer
{
  public qhf(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void cancel()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TM.global", 2, "Can't cancel Global Timer");
    }
  }
  
  public void schedule(TimerTask paramTimerTask, long paramLong)
  {
    try
    {
      super.schedule(paramTimerTask, paramLong);
      return;
    }
    catch (Exception paramTimerTask)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TM.global", 2, "timer schedule err", paramTimerTask);
    }
  }
  
  public void schedule(TimerTask paramTimerTask, long paramLong1, long paramLong2)
  {
    try
    {
      super.schedule(paramTimerTask, paramLong1, paramLong2);
      return;
    }
    catch (Exception paramTimerTask)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TM.global", 2, "timer schedule2 err", paramTimerTask);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */