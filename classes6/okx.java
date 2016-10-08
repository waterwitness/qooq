import android.app.Activity;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.SdCardChangeListener;
import java.io.PrintStream;

public class okx
  implements Runnable
{
  public okx(MainAssistObserver paramMainAssistObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SplashActivity localSplashActivity = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity;
    if (localSplashActivity == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener = new SdCardChangeListener(this.a.jdField_a_of_type_AndroidOsHandler);
    this.a.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener.a(0);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addDataScheme("file");
    try
    {
      localSplashActivity.registerReceiver(this.a.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener, localIntentFilter);
      if (Build.VERSION.RELEASE.startsWith("L"))
      {
        System.out.println("SecShell : art L");
        return;
      }
      this.a.i();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\okx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */