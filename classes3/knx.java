import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class knx
  implements Runnable
{
  public knx(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.a, PeakService.class);
    try
    {
      this.a.a.startService(localIntent);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.aio.BaseChatPie", 2, "onShow_otherThings, e = " + localSecurityException.getStackTrace());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\knx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */