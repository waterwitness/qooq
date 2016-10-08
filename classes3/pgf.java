import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class pgf
  extends MqqHandler
{
  public pgf(PhoneContactTabView paramPhoneContactTabView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */