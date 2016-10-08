import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ngk
  implements Runnable
{
  public ngk(PressToChangeVoicePanel paramPressToChangeVoicePanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PressToChangeVoicePanel.a(this.a).sendAccessibilityEvent(128);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ngk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */