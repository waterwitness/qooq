import android.app.Dialog;
import com.tencent.mobileqq.activity.RegisterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mht
  implements Runnable
{
  public mht(RegisterActivity paramRegisterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (!this.a.isFinishing())) {
      this.a.a.dismiss();
    }
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */