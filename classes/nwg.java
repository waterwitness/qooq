import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class nwg
  extends EnterpriseQQObserver
{
  public nwg(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.b = EnterpriseQQManager.a(this.a.a).a(this.a.a, this.a.a());
      this.a.b(this.a.b);
      if ((this.a.b != null) && (!this.a.b.isEmpty())) {
        this.a.g(false);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nwg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */