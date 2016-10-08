import android.os.Message;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class mog
  extends MqqHandler
{
  public mog(SubLoginActivity paramSubLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1982: 
      this.a.finish();
      return;
    }
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */