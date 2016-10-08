import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mir
  implements Runnable
{
  public mir(RegisterPhoneNumActivity paramRegisterPhoneNumActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RegisterPhoneNumActivity.a(this.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */