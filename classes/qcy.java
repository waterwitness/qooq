import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qcy
  extends pyi
{
  public qcy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    super.a();
    if (this.b >= pyg.a().a / 12000L)
    {
      CoreService.d();
      this.a.f();
      this.b = 0L;
    }
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
  
  protected void b(String paramString)
  {
    super.b(paramString);
    this.a.e();
    CoreService.c();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qcy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */