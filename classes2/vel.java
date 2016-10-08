import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter.OnClickOnMemberListener;
import com.tencent.mobileqq.troop.data.NearbyMember;

public class vel
  implements View.OnClickListener
{
  public vel(NearbyMemberAdapter paramNearbyMemberAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof NearbyMember)))
    {
      paramView = (NearbyMember)paramView.getTag();
      this.a.a.a(paramView.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */