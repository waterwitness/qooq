import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.GetConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qjh
  extends ResourcePluginListener
{
  private qjh(GetConfig paramGetConfig)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(byte paramByte)
  {
    if (GetConfig.a(this.a) == 41)
    {
      if ((paramByte != 2) && (paramByte == 3)) {}
      GetConfig.a(this.a).b.c(GetConfig.a(this.a));
      this.a.a(7);
    }
  }
  
  public void b(byte paramByte)
  {
    if ((paramByte != 2) && (paramByte == 3)) {}
    GetConfig.b(this.a).b.d(this);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qjh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */