import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;

public class olp
  extends QZoneObserver
{
  public olp(MainAssistObserver paramMainAssistObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "inform onGetQZoneFeedCountFin");
      }
      if ((this.a.a != null) && (this.a.a.app != null)) {}
    }
    else
    {
      return;
    }
    QQAppInterface localQQAppInterface = this.a.a.app;
    if (!GuardManager.a.a()) {
      ThreadManager.a(new olq(this, localQQAppInterface), 8, null, false);
    }
    this.a.g();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\olp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */