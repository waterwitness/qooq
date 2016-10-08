import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;

public class miz
  implements Runnable
{
  public miz(RegisterQQNumberActivity paramRegisterQQNumberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((PhoneContactManager)this.a.app.getManager(10)).i();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\miz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */