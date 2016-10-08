import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class klw
  implements View.OnClickListener
{
  public klw(AutoRemarkActivity paramAutoRemarkActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (this.a.a.getWindow() != null)) {}
    try
    {
      this.a.a.dismiss();
      this.a.a = null;
      return;
    }
    catch (Throwable paramView)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\klw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */