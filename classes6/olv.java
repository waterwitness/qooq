import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class olv
  implements Runnable
{
  olv(olu paramolu)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SplashActivity localSplashActivity = this.a.a.a;
    if ((localSplashActivity == null) || (localSplashActivity.app == null)) {}
    QQAppInterface localQQAppInterface;
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQAppInterface = localSplashActivity.app;
      localQQMessageFacade = localQQAppInterface.a();
    } while (localQQMessageFacade == null);
    ServiceAccountFolderManager.a().a(localQQAppInterface);
    localSplashActivity.runOnUiThread(new olw(this, localQQMessageFacade.e()));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\olv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */