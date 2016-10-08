import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletLockScreenActivity;

public class yjo
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private yjo(QWalletLockScreenActivity paramQWalletLockScreenActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity ACTION_SCREEN_ON");
      }
    }
    do
    {
      do
      {
        return;
        if (!"android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity ACTION_SCREEN_OFF");
      return;
    } while ((!"android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString)) || (!QLog.isColorLevel()));
    QLog.d("Q.qwallet.push", 2, "QWalletLockScreenActivity ACTION_USER_PRESENT");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */