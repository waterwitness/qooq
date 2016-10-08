import android.content.IntentFilter;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mct
  implements Runnable
{
  public mct(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      if (QQLSActivity.a(this.a) == 0)
      {
        BaseApplicationImpl.getContext().registerReceiver(this.a.a, localIntentFilter);
        QQLSActivity.a(this.a, 1);
      }
      QQLSActivity.a(this.a, AnimationUtils.loadAnimation(this.a, 2130968743));
      QQLSActivity.a(this.a).setFillAfter(true);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "registerScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("QQLSActivity", 2, "registerScreenListener:" + localException.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */