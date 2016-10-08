import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pxn
  extends pyi
{
  private String b;
  
  public pxn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString)
  {
    this.b = paramString;
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    this.b = paramString;
    CoreService.a();
    this.a.f();
  }
  
  protected void d(String paramString)
  {
    this.a.a(4, this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pxn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */