import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginInstallActivity;

public class xyq
  extends BroadcastReceiver
{
  private xyq(BuscardPluginInstallActivity paramBuscardPluginInstallActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(BuscardPluginInstallActivity.a(), 4, "BuscardPluginOnResumeReceiver->onReceive, intent:" + paramIntent);
    }
    if ((paramIntent == null) || (!"bridge.plugin.onresume.broadcast".equals(paramIntent.getAction()))) {
      return;
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */