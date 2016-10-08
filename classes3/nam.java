import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;

public class nam
  implements Runnable
{
  public nam(VerifyPhoneNumActivity paramVerifyPhoneNumActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((PhoneContactManager)this.a.app.getManager(10)).i();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */