import android.app.Activity;
import com.tencent.mobileqq.activity.richmedia.FlowSendTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pac
  implements Runnable
{
  public pac(FlowSendTask paramFlowSendTask)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.setResult(1001);
    this.a.a.finish();
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */