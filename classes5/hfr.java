import android.os.Bundle;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class hfr
  implements BusinessObserver
{
  public hfr(TroopRedTouchHandler paramTroopRedTouchHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRedTouchHandler", 2, "getRedPointInfo onReceive :" + paramBoolean);
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label73;
      }
      TroopRedTouchHandler.a(this.a.b, paramBundle);
      this.a.a(105, true, null);
    }
    label73:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("TroopRedTouchHandler", 2, "getRedPointInfo success data is null");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */