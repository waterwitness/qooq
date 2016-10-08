import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;

public class kju
  implements View.OnClickListener
{
  public kju(AddRequestActivity paramAddRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    ReportController.b(this.a.app, "CliOper", "", "", "Verification_msg", "Vfc_answ_clk", 0, 0, "", "", "", "");
    paramView = this.a;
    int i;
    if (AddRequestActivity.a(this.a) == 10004)
    {
      i = 3041;
      AddRequestActivity.a(paramView, i);
      Object localObject = (FriendsManager)this.a.app.getManager(50);
      boolean bool = ((FriendsManager)localObject).b(AddRequestActivity.a(this.a));
      paramView = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
      paramView.putExtra("uin", AddRequestActivity.a(this.a));
      paramView.putExtra("add_friend_source_id", AddRequestActivity.a(this.a));
      if (!bool) {
        break label215;
      }
      localObject = ((FriendsManager)localObject).c(AddRequestActivity.a(this.a));
      if (localObject != null)
      {
        paramView.putExtra("cSpecialFlag", ((Friends)localObject).cSpecialFlag);
        paramView.putExtra("uinname", ContactUtils.a((Friends)localObject));
      }
      label179:
      if (!bool) {
        break label232;
      }
      i = j;
    }
    for (;;)
    {
      paramView.putExtra("uintype", i);
      this.a.startActivity(paramView);
      return;
      i = AddRequestActivity.a(this.a);
      break;
      label215:
      paramView.putExtra("uinname", this.a.q);
      break label179;
      label232:
      if ((AddRequestActivity.a(this.a) == 2007) || (AddRequestActivity.a(this.a) == 3007) || (AddRequestActivity.a(this.a) == 4007)) {
        i = 1001;
      } else if ((AddRequestActivity.a(this.a) == 2019) || (AddRequestActivity.a(this.a) == 3019)) {
        i = 1010;
      } else {
        i = 1022;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */