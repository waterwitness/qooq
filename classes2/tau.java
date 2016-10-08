import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.ActionCountdownOver;
import java.util.TimerTask;

public class tau
  extends TimerTask
{
  public tau(ActionGlobalData paramActionGlobalData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ActionGlobalData.a(this.a);
    ActionGlobalData localActionGlobalData = this.a;
    localActionGlobalData.a -= 0.1F;
    if (ActionGlobalData.a(this.a) != null) {
      ActionGlobalData.a(this.a).b();
    }
    if (ActionGlobalData.b(this.a) * 100 == this.a.c * 1000)
    {
      this.a.a = 0.0F;
      if (ActionGlobalData.a(this.a) != null) {
        ActionGlobalData.a(this.a).a();
      }
      cancel();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */