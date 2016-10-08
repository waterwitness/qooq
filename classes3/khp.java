import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountInfoListActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;

public class khp
  implements View.OnClickListener
{
  public khp(AccountManageActivity paramAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131296832: 
      do
      {
        return;
        localObject = null;
        if ((paramView.getTag() instanceof String)) {
          localObject = String.valueOf(paramView.getTag());
        }
        if ("0X8004001".equals(localObject))
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004002", "0X8004002", 0, 0, "", "", "", "");
          paramView = new Intent(this.a, SubAccountUgActivity.class);
          paramView.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
          this.a.startActivity(paramView);
          return;
        }
      } while (!"0X8004456".equals(localObject));
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004457", "0X8004457", 0, 0, "", "", "", "");
      paramView = new Intent(this.a, SubAccountBindActivity.class);
      paramView.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
      this.a.startActivity(paramView);
      DBUtils.a().a(this.a.app.a(), true);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClass(paramView.getContext(), SubAccountInfoListActivity.class);
    ((Intent)localObject).putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    paramView.getContext().startActivity((Intent)localObject);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004039", "0X8004039", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */