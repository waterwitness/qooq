import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.hotspotnode.ShowNodeTaskManager;

public class yhv
  extends BroadcastReceiver
{
  public yhv(ShowNodeTaskManager paramShowNodeTaskManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) {}
    switch (paramIntent.getIntExtra("wifi_state", 4))
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShowNodeTaskManager", 2, "networkChangedReceiver: WIFI_STATE_CHANGED_ACTION enabled");
    }
    this.a.a(ShowNodeTaskManager.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */