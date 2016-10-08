import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class tmg
  implements View.OnClickListener
{
  public tmg(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (!this.a.isFinishing()))
    {
      this.a.b.dismiss();
      this.a.b = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */