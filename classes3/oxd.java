import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.LightTalkTipsData;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class oxd
  implements View.OnClickListener
{
  public oxd(RecentCallHelper paramRecentCallHelper, BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.h();
    paramView = "";
    if (LightTalkTipsData.a() != null) {
      paramView = LightTalkTipsData.a().f;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "gotoLightalkWeb() url = " + paramView);
    }
    if (StringUtil.b(paramView)) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a.a()).edit().putInt("show_tab_lightalk_tips", 4).commit();
    if (paramView.startsWith("mqqapi://avtipsbanner/"))
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AssistantSettingActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentCallHelper.a, "CliOper", "", "", "0X800510D", "0X800510D", 0, 0, "", "", "", "");
      return;
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, 524288L, localIntent, false, -1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */