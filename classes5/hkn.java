import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hkn
  implements View.OnClickListener
{
  public hkn(EqqAccountDetailActivity paramEqqAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      paramView = new Intent(this.a, ChatHistory.class);
      paramView.putExtra("uin", EqqAccountDetailActivity.i(this.a));
      paramView.putExtra("uintype", 1024);
      this.a.startActivity(paramView);
      ReportController.b(EqqAccountDetailActivity.i(this.a), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.j(this.a), "0X8005A29", "0X8005A29", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hkn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */