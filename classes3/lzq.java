import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lzq
  implements Runnable
{
  public lzq(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PhoneUnityBindInfoActivity.a(this.a).i();
    PhoneUnityBindInfoActivity.b(this.a).e = true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */