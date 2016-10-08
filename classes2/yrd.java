import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;

public class yrd
  extends BroadcastReceiver
{
  public yrd(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d(QzoneDynamicAlbumPlugin.a(), 2, paramContext);
    }
    paramIntent = paramIntent.getStringExtra("runningProcessName");
    if ((("com.tencent.process.stopping".equals(paramContext)) && (!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq:web"))) || ("tencent.av.v2q.StartVideoChat".equals(paramContext)))
    {
      QzoneDynamicAlbumPlugin.a(this.a, true);
      this.a.b();
    }
    while (((!"com.tencent.process.starting".equals(paramContext)) || (TextUtils.isEmpty(paramIntent)) || (!paramIntent.equals("com.tencent.mobileqq:web")) || (!QzoneDynamicAlbumPlugin.a(this.a))) && (!"tencent.av.v2q.StopVideoChat".equals(paramContext))) {
      return;
    }
    QzoneDynamicAlbumPlugin.a(this.a, false);
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */