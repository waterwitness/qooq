import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public final class igh
  implements BusinessObserver
{
  public igh(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    ThreadManager.b().postDelayed(new igi(this, paramBoolean, paramBundle), 10L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\igh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */