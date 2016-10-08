import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class mps
  extends TransProcessorHandler
{
  public mps(TroopAssistantActivity paramTroopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.e();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */