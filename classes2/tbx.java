import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;

public class tbx
  implements Runnable
{
  public tbx(ShieldMsgManger paramShieldMsgManger)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ShieldMsgManger.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */