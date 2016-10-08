import android.os.Message;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class kgn
  extends MqqHandler
{
  public kgn(AccountManageActivity paramAccountManageActivity)
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
    this.a.e();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */