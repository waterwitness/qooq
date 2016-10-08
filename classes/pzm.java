import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.AppRuntime;

public class pzm
  extends pyi
{
  public pzm()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString)
  {
    GuardManager localGuardManager = this.a;
    if ("com.tencent.mobileqq".equals(paramString)) {}
    for (int i = 2;; i = 3)
    {
      localGuardManager.a(i, paramString);
      return;
    }
  }
  
  protected void b()
  {
    this.a.a(6, "fake_p_msg");
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    this.a.f();
    this.a.b(true);
    BaseApplicationImpl.a.a().onGuardEvent(4, pyg.a().a, 0L);
    CoreService.b();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */