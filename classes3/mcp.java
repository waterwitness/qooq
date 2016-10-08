import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.qphone.base.util.QLog;

public class mcp
  implements Runnable
{
  public mcp(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSSensor", 2, "====openSensor===" + Thread.currentThread().getId());
      }
      this.a.a = new QQLSSensor(this.a.getApplicationContext(), this.a);
      this.a.a.a();
      if (QQLSActivity.a(this.a).hasMessages(8)) {
        QQLSActivity.a(this.a).removeMessages(8);
      }
      Message localMessage = QQLSActivity.a(this.a).obtainMessage(8);
      QQLSActivity.a(this.a).sendMessageDelayed(localMessage, 1500L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */