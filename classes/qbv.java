import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qbv
  implements Runnable
{
  public qbv(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PhoneContactManagerImp.a(this.a, 8);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */