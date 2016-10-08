import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.step.GetTbsSwitchInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.sdk.QbSdk;

public class qjp
  implements Runnable
{
  public qjp(GetTbsSwitchInfo paramGetTbsSwitchInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QbSdk.isX5DisabledSync(BaseApplicationImpl.getContext());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qjp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */