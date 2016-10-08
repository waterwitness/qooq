import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class waq
  implements BusinessObserver
{
  public waq(JumpAction paramJumpAction)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getString("StepInfoJSON");
      if (QLog.isColorLevel()) {
        QLog.i("SSOHttpUtils", 2, "JumpAction receive stepInfoJson:" + paramBundle);
      }
      ThreadManager.a(new war(this, paramBundle), 5, null, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\waq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */