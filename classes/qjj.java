import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.automator.step.GetGeneralSettings;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qjj
  extends FriendListObserver
{
  private qjj(GetGeneralSettings paramGetGeneralSettings)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      GetGeneralSettings.a(this.a).d = 3;
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */