import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity.AccountDetailAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hnj
  implements View.OnClickListener
{
  public hnj(AccountDetailActivity.AccountDetailAdapter paramAccountDetailAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.b();
    ReportController.b(this.a.a.a, "dc00899", "Pb_account_lifeservice", this.a.a.p, "0X8006983", "0X8006983", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hnj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */