import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class leo
  implements View.OnClickListener
{
  public leo(DetailProfileActivity paramDetailProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (this.a.a.getWindow() != null)) {
      this.a.a.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\leo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */