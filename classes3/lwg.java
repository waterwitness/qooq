import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class lwg
  extends NearbyObserver
{
  public lwg(NearbyActivity paramNearbyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyActivity", 2, "onMyTabConfigChanged");
    }
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lwg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */