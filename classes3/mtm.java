import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DBUtils;

public class mtm
  implements Runnable
{
  public mtm(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.app != null)
    {
      if (this.a.a != null) {
        this.a.a.card = this.a.b(this.a.t, this.a.v);
      }
      TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.a.app, this.a.t, this.a.v);
      if (localTroopMemberCardInfo != null)
      {
        if (localTroopMemberCardInfo.tel != null) {
          this.a.p = localTroopMemberCardInfo.tel;
        }
        if (localTroopMemberCardInfo.email != null) {
          this.a.q = localTroopMemberCardInfo.email;
        }
        if (localTroopMemberCardInfo.job != null) {
          this.a.r = localTroopMemberCardInfo.job;
        }
        if (TextUtils.getTrimmedLength(this.a.p) <= 0) {
          this.a.p = "";
        }
        if (TextUtils.getTrimmedLength(this.a.q) <= 0) {
          this.a.q = "";
        }
        if (TextUtils.getTrimmedLength(this.a.r) <= 0) {
          this.a.r = "";
        }
        this.a.J = localTroopMemberCardInfo.charm;
        this.a.app.runOnUiThread(new mtn(this));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */