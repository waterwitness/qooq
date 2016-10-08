import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class uzk
  implements View.OnClickListener
{
  public uzk(NightModeLogic paramNightModeLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback != null)
    {
      paramView = new Bundle();
      paramView.putInt("start_status", 2);
      this.a.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic$NightModeCallback.c(paramView);
    }
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_AndroidAppDialog = null;
    try
    {
      paramView = new HashMap();
      paramView.put("param_FailCode", "3");
      StatisticCollector.a(this.a.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).getAccount(), "VipNightThemeDialogClick", false, 1L, 0L, paramView, "", false);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */