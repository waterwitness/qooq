import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.qphone.base.util.QLog;

public class jin
  extends BroadcastReceiver
{
  public jin(SosoPlugin paramSosoPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      return;
      i = paramIntent.getIntExtra("com.tencent.receiver.soso.type", SosoSrvAddrProvider.a);
      if (i == SosoSrvAddrProvider.a)
      {
        if (QLog.isColorLevel()) {
          QLog.d(SosoPlugin.a(this.a), 2, "soso receiver ACTION_SOSO_TYPE_UPDATE");
        }
        SosoSrvAddrProvider.a().c();
        return;
      }
    } while (i != SosoSrvAddrProvider.b);
    if (QLog.isColorLevel()) {
      QLog.d(SosoPlugin.b(this.a), 2, "soso receiver ACTION_SOSO_TYPE_CLEAR");
    }
    SosoSrvAddrProvider.a().a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */