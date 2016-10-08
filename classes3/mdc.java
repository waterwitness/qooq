import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class mdc
  implements Runnable
{
  public mdc(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("moveTaskToBack", 2, "moveTaskToBackInSubThread");
    }
    try
    {
      this.a.moveTaskToBack(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("moveTaskToBack", 2, "moveTaskToBack e=" + localThrowable.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */