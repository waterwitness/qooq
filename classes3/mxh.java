import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class mxh
  implements View.OnClickListener
{
  public mxh(TroopRequestActivity paramTroopRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, AccountDetailActivity.class);
    paramView.putExtra("uin", this.a.a.req_uin.get() + "");
    paramView.putExtra("source", 112);
    this.a.startActivity(paramView);
    ReportController.b(this.a.app, "P_CliOper", "Grp_public", "", "oper", "Clk_invite", 0, 0, "", "", "", this.a.a.req_uin.get() + "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mxh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */