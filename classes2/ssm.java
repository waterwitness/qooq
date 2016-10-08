import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ssm
  extends Handler
{
  public ssm(GamePartyManager paramGamePartyManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = "http://openmobile.qq.com/gameteam/get_team_context?uin=" + GamePartyManager.a(this.a).a();
    this.a.a(paramMessage, null);
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ssm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */