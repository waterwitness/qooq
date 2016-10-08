import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;

public class ysd
  extends BroadcastReceiver
{
  public ysd(QZoneCoverStoreJsPlugin paramQZoneCoverStoreJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QZoneCoverStoreJsPlugin.a(this.a, paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */