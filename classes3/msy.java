import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

class msy
  implements Runnable
{
  msy(msx parammsx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.a.a.app, this.a.a.t, this.a.a.v);
    if (localTroopMemberCardInfo != null)
    {
      if (localTroopMemberCardInfo.tel != null) {
        this.a.a.p = localTroopMemberCardInfo.tel;
      }
      if (localTroopMemberCardInfo.email != null) {
        this.a.a.q = localTroopMemberCardInfo.email;
      }
      if (localTroopMemberCardInfo.job != null) {
        this.a.a.r = localTroopMemberCardInfo.job;
      }
      if (TextUtils.getTrimmedLength(this.a.a.p) <= 0) {
        this.a.a.p = "";
      }
      if (TextUtils.getTrimmedLength(this.a.a.q) <= 0) {
        this.a.a.q = "";
      }
      if (TextUtils.getTrimmedLength(this.a.a.r) <= 0) {
        this.a.a.r = "";
      }
      this.a.a.a.sendEmptyMessage(3);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "updateParams: cardInfo==null, ");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */