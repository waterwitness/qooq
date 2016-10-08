import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class uzl
  implements View.OnClickListener
{
  public uzl(NightModeLogic paramNightModeLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ReportController.b((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Setting_tab", "Night_mode_dl", 0, 0, "", "", "", "");
    if ((this.a.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback != null) && (!ThemeSwitchManager.b))
    {
      paramView = new Bundle();
      paramView.putInt("start_status", 1);
      this.a.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback.c(paramView);
    }
    boolean bool = this.a.b();
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      if (bool) {}
      for (paramView = "0";; paramView = "1")
      {
        localHashMap.put("param_FailCode", paramView);
        StatisticCollector.a(this.a.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).getAccount(), "VipNightThemeDialogClick", true, 1L, 0L, localHashMap, "", false);
        return;
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */