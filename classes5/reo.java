import android.os.Handler;
import com.tencent.mobileqq.data.RankEventMsg;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.dating.RankEventManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.qphone.base.util.QLog;

public class reo
  implements Runnable
{
  public reo(DatingTopListActivity paramDatingTopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DatingManager localDatingManager = (DatingManager)this.a.b.getManager(212);
    DatingTopListActivity.a(this.a, localDatingManager.c());
    DatingTopListActivity.a(this.a, localDatingManager.c());
    DatingTopListActivity.a(this.a, localDatingManager.b());
    DatingTopListActivity.b(this.a, localDatingManager.a().a(false));
    this.a.b.a().a("100510.100517");
    DatingTopListActivity.a(this.a, localDatingManager.a().b());
    if ((DatingTopListActivity.a(this.a) > 0) && (DatingTopListActivity.a(this.a) != null))
    {
      DatingTopListActivity.b(this.a, true);
      if (DatingTopListActivity.a(this.a).notifytype == 1) {
        DatingTopListActivity.c(this.a, true);
      }
    }
    DatingTopListActivity.a(this.a);
    DatingTopListActivity.b(this.a);
    if (DatingTopListActivity.a(this.a)) {
      DatingTopListActivity.a(this.a).sendEmptyMessage(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DatingTopListActivity", 2, "initData，mHideBoyGod:" + DatingTopListActivity.b(this.a) + ",mNeedShowNotify:" + DatingTopListActivity.a(this.a) + ",mTypeList:" + this.a.g + ",mCurGender:" + DatingTopListActivity.b(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\reo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */