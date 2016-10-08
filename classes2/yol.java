import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.patch.QZonePatchRequest;
import cooperation.qzone.plugin.PluginIntent.OnResultListner;
import cooperation.qzone.plugin.QZonePluginUpdater;
import cooperation.qzone.plugin.QZonePluginUpdater.OnUpdateListner;

public class yol
  implements PluginIntent.OnResultListner
{
  public yol(QZonePluginUpdater paramQZonePluginUpdater)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = QZonePatchRequest.a(paramFromServiceMsg.getWupBuffer());
      QZonePluginUpdater.a(this.a, paramIntent);
      QZonePluginUpdater.a(this.a, paramIntent, null);
      if (this.a.a != null) {
        this.a.a.a(true);
      }
    }
    do
    {
      return;
      QZonePluginUpdater.a(this.a, null, null);
    } while (this.a.a == null);
    this.a.a.a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */