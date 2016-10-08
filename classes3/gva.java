import android.os.Handler;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

public class gva
  extends TimerTask
{
  public gva(MultiIncomingCallsActivity paramMultiIncomingCallsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.sendEmptyMessage(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gva.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */