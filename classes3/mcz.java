import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.qphone.base.util.QLog;

public class mcz
  implements Runnable
{
  public mcz(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSSensor", 2, "====shutSensor===" + Thread.currentThread().getId());
    }
    if (this.a.a != null)
    {
      this.a.a.b();
      this.a.a = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */