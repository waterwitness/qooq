import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

public class lwf
  implements Runnable
{
  public lwf(NearbyActivity paramNearbyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = this.a.a();
    this.a.a.obtainMessage(3, 3, 0, localAppInfo).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lwf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */