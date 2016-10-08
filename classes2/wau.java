import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.JumpAction;

public class wau
  implements View.OnClickListener
{
  public wau(JumpAction paramJumpAction)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((JumpAction.a(this.a) != null) && (JumpAction.a(this.a).isShowing())) {
      JumpAction.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */