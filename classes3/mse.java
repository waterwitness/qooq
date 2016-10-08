import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class mse
  implements Runnable
{
  public mse(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (!this.a.b())
    {
      this.a.a.post(new msf(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "TroopMemberCardActivity checkIntentParams() time = " + (System.currentTimeMillis() - l));
    }
    this.a.a.post(new msg(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */