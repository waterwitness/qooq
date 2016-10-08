import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class snp
  implements View.OnClickListener
{
  public snp(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (this.a.b.isShowing()) && (!this.a.a.isFinishing())) {
      this.a.b.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */