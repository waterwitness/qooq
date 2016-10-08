import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;

class lrl
  implements Runnable
{
  lrl(lrk paramlrk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.a.a.getManager(12);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.a(-1, new lrm(this));
    }
    this.a.a.m();
    this.a.a.a(1);
    if (NearbyUtils.b()) {
      NearbyUtils.a("Q.lebatab.", new Object[] { "preload nearby process/tool process" });
    }
    NearbyProcessMonitor.a(this.a.a.a.getAccount(), 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */