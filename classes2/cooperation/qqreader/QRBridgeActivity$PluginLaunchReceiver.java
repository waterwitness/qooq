package cooperation.qqreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import yja;

public class QRBridgeActivity$PluginLaunchReceiver
  extends BroadcastReceiver
{
  public QRBridgeActivity$PluginLaunchReceiver(QRBridgeActivity paramQRBridgeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("QRBridgeActivity", 2, "PluginLaunchReceiver onReceive action:" + paramContext);
    }
    if (paramContext.equals("com.tencent.mobileqq.closeQRBridgeActivity")) {
      if ((this.a.d) || (!this.a.e)) {
        this.a.a.postDelayed(new yja(this), 1200L);
      }
    }
    do
    {
      do
      {
        return;
        this.a.finish();
        return;
      } while (!paramContext.equals("com.tencent.mobileqq.middlePagePreloadProcess"));
      if (!this.a.g)
      {
        this.a.a.removeMessages(1004);
        this.a.g = true;
        this.a.f();
      }
    } while (!QLog.isColorLevel());
    QLog.d("QRBridgeActivity", 2, "reader process has launched");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRBridgeActivity$PluginLaunchReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */