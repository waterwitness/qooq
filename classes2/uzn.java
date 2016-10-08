import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.NightModeLogic;

public class uzn
  implements Runnable
{
  public uzn(NightModeLogic paramNightModeLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NightModeLogic.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */