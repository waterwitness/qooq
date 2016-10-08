import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class mvp
  implements OverScrollViewListener
{
  public mvp(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.i)
    {
      this.a.a.a();
      return;
    }
    this.a.a.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X80058F5", "0X80058F5", 0, 0, "", "", "", "");
    if (this.a.i) {
      return true;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.a.a.a(1);
      TroopMemberListActivity.a(this.a, 800L);
      return true;
    }
    this.a.i = true;
    this.a.a.a(0L);
    paramView = (TroopHandler)this.a.app.a(20);
    if (paramView != null)
    {
      this.a.d = true;
      this.a.c = System.currentTimeMillis();
      paramView.a(true, this.a.k, this.a.j, true, TroopMemberListActivity.d(this.a));
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "TroopContacts Reflesh memberlist, TroopHandler.getTroopMemberList(), troopUin: " + this.a.j + " troopCode: " + this.a.k);
      }
    }
    try
    {
      paramView.a(Long.parseLong(this.a.k), 0L, 1, null, 0, 0);
      return true;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopMemberListActivityget_troop_member", 2, paramView.toString());
        }
      }
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.i) {
      return;
    }
    this.a.a.b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */