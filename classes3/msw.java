import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DBUtils;

class msw
  implements Runnable
{
  msw(msv parammsv)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.a.a.app, this.a.a.t, this.a.a.v);
    if (localTroopMemberCardInfo != null)
    {
      this.a.a.J = localTroopMemberCardInfo.charm;
      this.a.a.a.sendEmptyMessage(4);
      ReportController.b(this.a.a.app, "dc00899", "Grp_flower", "", "charm", "exp_grpname", 0, 0, String.valueOf(this.a.a.J), "", "", "");
      if (localTroopMemberCardInfo.torchFlag != 0) {
        this.a.a.a.sendEmptyMessage(6);
      }
      return;
    }
    this.a.a.a.sendEmptyMessage(5);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */