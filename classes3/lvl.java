import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ModifyTroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lvl
  implements View.OnClickListener
{
  public lvl(ModifyTroopMemberCardActivity paramModifyTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (this.a.a.getWindow() != null)) {
      this.a.a.dismiss();
    }
    this.a.finish();
    this.a.overridePendingTransition(0, 2130968584);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */