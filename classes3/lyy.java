import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lyy
  implements Runnable
{
  public lyy(PermisionPrivacyActivity paramPermisionPrivacyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = this.a.app.o();
    this.a.runOnUiThread(new lyz(this, bool));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */