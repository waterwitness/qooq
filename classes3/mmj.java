import android.os.Message;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class mmj
  extends MqqHandler
{
  public mmj(SubAccountBindActivity paramSubAccountBindActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1981: 
      this.a.finish();
      return;
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mmj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */