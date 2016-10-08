import android.os.IBinder.DeathRecipient;
import com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import com.tencent.biz.qqstory.takevideo.rmw.RMWMessengerObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iyr
  implements IBinder.DeathRecipient
{
  public iyr(RMWMessengerObserver paramRMWMessengerObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void binderDied()
  {
    RMWLog.c(RMWMessengerObserver.a(this.a), "binderDied");
    RMWMessengerObserver.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iyr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */