import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.QavPanelSoundWaveView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gyl
  extends BroadcastReceiver
{
  public gyl(QavPanel paramQavPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      do
      {
        return;
        if (!"android.intent.action.SCREEN_ON".equals(paramIntent.getAction())) {
          break;
        }
      } while ((this.a.a == null) || (!this.a.c));
      this.a.a.f();
      return;
    } while ((!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) || (this.a.a == null));
    this.a.a.g();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */