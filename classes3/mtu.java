import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ProfileCardUtil;

public class mtu
  implements View.OnClickListener
{
  public mtu(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ProfileCardUtil.a(this.a, this.a.b, this.a.v, 0);
    this.a.d("Clk_mberhead", "P_CliOper");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */