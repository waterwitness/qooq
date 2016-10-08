import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class olu
  implements MsgTabUnreadListener
{
  public olu(MainAssistObserver paramMainAssistObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if ((this.a.a == null) || (this.a.a.app == null)) {}
    do
    {
      return;
      QQAppInterface localQQAppInterface = this.a.a.app;
      this.a.a(32, 16, Integer.valueOf(paramInt));
      Intent localIntent = new Intent("com.tencent.qq.syncQQMessage");
      localQQAppInterface.a().sendBroadcast(localIntent);
    } while (!QLog.isDevelopLevel());
    QLog.d("SplashActivity", 4, "msg fresh callback.msgNum.." + paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("SplashActivity", "msg fresh callback...", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    }
    if ((!paramBoolean) && (paramInt >= 0))
    {
      a(paramInt);
      return;
    }
    ThreadManager.b(new olv(this));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\olu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */