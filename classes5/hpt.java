import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountManageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class hpt
  implements ActionSheet.OnButtonClickListener
{
  public hpt(PublicAccountManageActivity paramPublicAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      PublicAccountManageActivity.a(this.a).dismiss();
      return;
      PublicAccountManageActivity.a(this.a, true);
      ReportController.b(this.a.app, "dc00899", "Pb_account_lifeservice", "", "0X8006DEB", "0X8006DEB", 0, 0, "", "", "", "");
      continue;
      PublicAccountManageActivity.a(this.a, false);
      ReportController.b(this.a.app, "dc00899", "Pb_account_lifeservice", "", "0X8006DEA", "0X8006DEA", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */