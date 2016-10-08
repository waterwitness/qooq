import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class uzm
  implements DialogInterface.OnDismissListener
{
  public uzm(NightModeLogic paramNightModeLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback != null)
    {
      paramDialogInterface = new Bundle();
      paramDialogInterface.putInt("start_status", 2);
      this.a.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback.c(paramDialogInterface);
    }
    this.a.jdField_a_of_type_AndroidAppDialog = null;
    try
    {
      paramDialogInterface = new HashMap();
      paramDialogInterface.put("param_FailCode", "2");
      StatisticCollector.a(this.a.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).getAccount(), "VipNightThemeDialogClick", false, 1L, 0L, paramDialogInterface, "", false);
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */