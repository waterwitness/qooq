import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.troop.activity.NearbyMemberAdapter.OnClickSayHelloListener;

public class vee
  implements NearbyMemberAdapter.OnClickSayHelloListener
{
  public vee(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    ReportController.b(this.a.app, "P_CliOper", "Grp_AIO", "", "nearby_mber", "Clk_hello", 0, 0, this.a.a.a, "", "", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("member_uin", paramString1);
    localIntent.putExtra("member_display_name", paramString2);
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */