import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicObserver;
import com.tencent.mobileqq.olympic.activity.OlympicSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;

public class trt
  extends OlympicObserver
{
  public trt(OlympicSettingActivity paramOlympicSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGetOlympicShowSwitch, isSuc:" + paramBoolean1 + " switchOn:" + paramBoolean2);
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity.jdField_b_of_type_Boolean = paramBoolean2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity.jdField_b_of_type_Boolean);
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity.isFinishing())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity.a == null) {
          this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity.a = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity);
        }
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity.a.a(2, "我的火炬标识开关拉取失败", 1000);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */