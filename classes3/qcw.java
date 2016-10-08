import com.tencent.mobileqq.app.PhoneUnityBannerData;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qcw
  implements Runnable
{
  public qcw(PhoneUnityManager paramPhoneUnityManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PhoneUnityBannerData localPhoneUnityBannerData = this.a.a();
    ((SecSvcHandler)this.a.a.a(34)).a(9, true, localPhoneUnityBannerData);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */