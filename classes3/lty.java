import android.os.Message;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class lty
  extends MqqHandler
{
  public lty(LoginPhoneNumActivity2 paramLoginPhoneNumActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */