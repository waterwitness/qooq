import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.qphone.base.util.QLog;

public class mdn
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private mdn(QQLSActivity paramQQLSActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON");
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
      QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF");
      return;
    } while (!"android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder().append("ScreenBroadcastReceiver ACTION_USER_PRESENTmanager.isEnterAio");
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a;
      QLog.d("QQLSActivity", 2, QQLSRecentManager.f);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a;
    if (!QQLSRecentManager.f) {
      QQLSActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */