import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rcw
  implements View.OnClickListener
{
  public rcw(DatingBaseActivity paramDatingBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */