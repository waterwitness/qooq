import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.NightModeLogic;

public class uzp
  implements Handler.Callback
{
  public uzp(NightModeLogic paramNightModeLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 4097)
    {
      if ((NightModeLogic.a(this.a, true)) && (NightModeLogic.a(this.a) != null))
      {
        this.a.b(NightModeLogic.a(this.a));
        NightModeLogic.a(this.a, null);
      }
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */