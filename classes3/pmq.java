import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pmq
  implements Runnable
{
  public pmq(VipSpecialCareHandler paramVipSpecialCareHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    VipSpecialCareHandler.a(this.a).start();
    Looper localLooper = VipSpecialCareHandler.a(this.a).getLooper();
    if (localLooper == null) {
      return;
    }
    VipSpecialCareHandler.a(this.a, new pmr(this, localLooper));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pmq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */