import android.app.Dialog;
import com.tencent.mobileqq.activity.RegisterBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mik
  implements Runnable
{
  public mik(RegisterBaseActivity paramRegisterBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((this.a.a != null) && (this.a.a.isShowing())) {
        this.a.a.dismiss();
      }
      this.a.a = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */