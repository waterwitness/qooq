import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BlessPTVActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.qphone.base.util.QLog;

public class kqp
  extends BroadcastReceiver
{
  public kqp(BlessPTVActivity paramBlessPTVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("tencent.av.v2q.StartVideoChat".equals(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessPTVActivity", 2, "receive ACTION_START_VIDEO_CHAT.");
      }
      this.a.finish();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!"android.intent.action.HEADSET_PLUG".equals(paramContext)) {
              break;
            }
          } while ((!paramIntent.hasExtra("state")) || (paramIntent.getIntExtra("state", 1) != 0));
          if ((BlessPTVActivity.a(this.a) == 0) && (BlessPTVActivity.a(this.a)))
          {
            this.a.s();
            return;
          }
          if (BlessPTVActivity.a(this.a) != 0) {
            break;
          }
          BlessPTVActivity.a(this.a);
        } while (BlessPTVActivity.a(this.a) == null);
        BlessPTVActivity.a(this.a).c();
        return;
      } while (BlessPTVActivity.a(this.a) != 1);
      BlessPTVActivity.b(this.a);
      return;
    } while (!"android.intent.action.PHONE_STATE".equals(paramContext));
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */