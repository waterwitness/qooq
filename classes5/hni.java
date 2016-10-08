import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity.AccountDetailAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class hni
  implements View.OnClickListener
{
  public hni(AccountDetailActivity.AccountDetailAdapter paramAccountDetailAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.a();
    ReportController.b(this.a.a.a, "dc00899", "Pb_account_lifeservice", this.a.a.p, "0X8006982", "0X8006982", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */