import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;

public class tgb
  extends BroadcastReceiver
{
  public tgb(QQPlayerService paramQQPlayerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "QQPlayerBroadcastReceiverReceiver onReceive,action:" + paramIntent.getAction());
    }
    if (("com.tencent.mobileqq.intent.logout".equals(paramIntent.getAction())) || ("qqplayer_exit_action".equals(paramIntent.getAction())))
    {
      if ((paramIntent.getBooleanExtra("musicplayer.isDelFileOnDonwloadThreadOver", false)) && (this.a.a != null)) {
        this.a.a.b = true;
      }
      QQPlayerService.c(this.a.getApplicationContext());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */