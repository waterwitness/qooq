import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.ThreadRegulator.CpuBusyness;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class qhg
  extends MqqHandler
{
  public qhg(ThreadRegulator paramThreadRegulator, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (ThreadRegulator.CpuBusyness)paramMessage.obj;
    if (paramMessage != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadManager.Regulaotr", 2, paramMessage.jdField_a_of_type_Int + " cost " + (paramMessage.b - paramMessage.jdField_a_of_type_Long) + ", paused " + paramMessage.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
      }
      paramMessage.recycle();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */