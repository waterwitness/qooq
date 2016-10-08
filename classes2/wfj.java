import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vashealth.StepServiceAsync;
import mqq.observer.BusinessObserver;

public class wfj
  implements BusinessObserver
{
  public wfj(StepServiceAsync paramStepServiceAsync)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      ThreadManager.a(new wfk(this, paramBundle.getString("StepInfoJSON")), 5, null, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */