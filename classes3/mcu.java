import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mcu
  implements Runnable
{
  public mcu(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (QQLSActivity.a(this.a) == 1)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.a.a);
        QQLSActivity.a(this.a, 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "unRegisterScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("QQLSActivity", 2, "unRegisterScreenListener:" + localException.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */