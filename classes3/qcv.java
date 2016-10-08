import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qcv
  implements Runnable
{
  public qcv(PhoneUnityManager paramPhoneUnityManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PhoneUnityManager.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */