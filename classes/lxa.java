import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lxa
  implements DialogInterface.OnClickListener
{
  public lxa(NotificationActivity paramNotificationActivity, CheckBox paramCheckBox, boolean paramBoolean, SharedPreferences paramSharedPreferences)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      if (this.jdField_a_of_type_Boolean != bool) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("MemoryAlertAutoClear", bool).commit();
      }
      MemoryManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.app);
      return;
    }
    catch (Exception paramDialogInterface) {}finally
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */