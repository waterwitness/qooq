import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class lxv
  implements Runnable
{
  public lxv(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ReportController", 4, "reportSettingStatusDaily run");
    }
    HashMap localHashMap = new HashMap();
    int i;
    label44:
    label70:
    label78:
    label104:
    label112:
    label138:
    label146:
    label180:
    label205:
    label252:
    label299:
    label346:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 1)
    {
      i = 1;
      if (i == 0) {
        break label491;
      }
      i = 1;
      localHashMap.put("Clk_notice_shake", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() != 1) {
        break label497;
      }
      i = 1;
      if (i == 0) {
        break label503;
      }
      i = 1;
      localHashMap.put("Clk_notice_grpshake", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d() != 1) {
        break label509;
      }
      i = 1;
      if (i == 0) {
        break label515;
      }
      i = 1;
      localHashMap.put("Clk_notice_sound", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b() != 1) {
        break label521;
      }
      i = 1;
      if (i == 0) {
        break label527;
      }
      i = 1;
      localHashMap.put("Clk_notice_gupsound", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false)) {
        break label533;
      }
      i = 1;
      localHashMap.put("Clk_night_mode", Integer.valueOf(i));
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) {
        break label539;
      }
      i = 1;
      localHashMap.put("Clk_hide_text", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368466), "qqsetting_notify_blncontrol_key", true)) {
        break label545;
      }
      i = 1;
      localHashMap.put("Led_blinking", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369617), "qqsetting_receivemsg_whenexit_key", true)) {
        break label551;
      }
      i = 1;
      localHashMap.put("Logout_msg", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368470), "qqsetting_notify_myfeedpush_key", true)) {
        break label557;
      }
      i = 1;
      localHashMap.put("Clk_about_me", Integer.valueOf(i));
      localObject = localHashMap.keySet();
      try
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "Setting_tab", str2, 0, 0, String.valueOf(localHashMap.get(str2)), "", "", "");
        }
        boolean bool;
        str1 = "1";
      }
      catch (Exception localException)
      {
        bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_pcactive_key", false);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!bool) {}
      }
    }
    for (;;)
    {
      ReportController.b((QQAppInterface)localObject, "CliStatus", "", "", "0X8004971", "0X8004971", 0, 0, str1, "", "", "");
      return;
      i = 0;
      break;
      label491:
      i = 0;
      break label44;
      label497:
      i = 0;
      break label70;
      label503:
      i = 0;
      break label78;
      label509:
      i = 0;
      break label104;
      label515:
      i = 0;
      break label112;
      label521:
      i = 0;
      break label138;
      label527:
      i = 0;
      break label146;
      label533:
      i = 0;
      break label180;
      label539:
      i = 0;
      break label205;
      label545:
      i = 0;
      break label252;
      label551:
      i = 0;
      break label299;
      label557:
      i = 0;
      break label346;
      String str1 = "0";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lxv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */