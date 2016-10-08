import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.device.qfind.QFindBLEScanMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class kch
  extends BroadcastReceiver
{
  private kch(QFindBLEScanMgr paramQFindBLEScanMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLE", 2, "QFindBLEScanMgr alarm is coming " + paramIntent.getAction());
    }
    if ((this.a.a == null) || (System.currentTimeMillis() - QFindBLEScanMgr.a(this.a) < this.a.h)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLE", 2, "QFindBLEScanMgr startScan");
    }
    this.a.a.post(new kci(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\kch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */