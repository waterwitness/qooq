import android.os.Looper;
import android.os.Message;
import com.tencent.device.ble.QFindGattManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class jvz
  extends MqqHandler
{
  public jvz(QFindGattManager paramQFindGattManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE2", 2, "QFindGattManager write data timeout bleSN " + (String)paramMessage.obj);
      }
      QFindGattManager.a(this.a, paramMessage.arg1);
      this.a.a((String)paramMessage.obj);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jvz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */