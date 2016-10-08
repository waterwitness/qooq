import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mvn
  implements View.OnClickListener
{
  public mvn(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.d != null)
    {
      this.a.d.setVisibility(8);
      this.a.f = false;
      this.a.d = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mvn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */