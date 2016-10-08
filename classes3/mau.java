import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mau
  implements Runnable
{
  public mau(ProfileCardMoreActivity paramProfileCardMoreActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      i = ProfileCardMoreActivity.a(this.a, this.a.a.a);
      ProfileCardMoreActivity.a(this.a, false);
      this.a.app.runOnUiThread(new mav(this, i));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */