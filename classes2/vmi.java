import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class vmi
  extends Handler
{
  public vmi(TroopFeedsDataManager paramTroopFeedsDataManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          return;
          this.a.a = ((List)paramMessage.obj);
          this.a.a(1000);
          return;
          this.a.a = ((List)paramMessage.obj);
          TroopFeedsDataManager.a(this.a);
          this.a.notifyObservers(Integer.valueOf(101));
        } while (!QLog.isColorLevel());
        QLog.d("TroopFeedsDataManager", 2, "end load feed: " + System.currentTimeMillis());
        return;
        this.a.a = ((List)paramMessage.obj);
        TroopFeedsDataManager.b(this.a);
        this.a.notifyObservers(Integer.valueOf(105));
      } while (!QLog.isColorLevel());
      QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "end auto pull down feed");
      return;
    case 5: 
      TroopFeedsDataManager.c(this.a);
      this.a.notifyObservers(Integer.valueOf(1010));
      return;
    }
    TroopFeedsDataManager.d(this.a);
    this.a.notifyObservers(Integer.valueOf(103));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */