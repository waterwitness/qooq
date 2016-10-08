package cooperation.qzone.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import yon;

public class QZonePatchService
  extends Service
{
  private static final String a = "patch";
  
  public QZonePatchService()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "QZonePatchService onBind");
    }
    return yon.a().a();
  }
  
  public void onCreate()
  {
    super.onCreate();
    MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "QZonePatchService onCreate");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "QZonePatchService onDestroy");
    }
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "QZonePatchService onRebind");
    }
    super.onRebind(paramIntent);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("patch", 2, "QZonePatchService onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\QZonePatchService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */