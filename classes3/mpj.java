import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class mpj
  extends MqqHandler
{
  public mpj(TroopAssistantActivity paramTroopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.app.isLogin()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.e();
      return;
    }
    this.a.e();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */