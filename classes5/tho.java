import android.os.Bundle;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class tho
  extends NearbyObserver
{
  public tho(NearbyFakeActivity paramNearbyFakeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("requestId");
    if (NearbyFakeActivity.a(this.a) != l) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(NearbyFakeActivity.a, 2, "onGetEncounterPkgRaw");
    }
    NearbyFakeActivity.a(this.a, System.currentTimeMillis() - NearbyFakeActivity.b(this.a));
    ThreadManager.a(new thp(this, paramFromServiceMsg, paramToServiceMsg, paramObject), null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */