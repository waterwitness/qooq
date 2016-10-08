import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicObserver;
import com.tencent.mobileqq.olympic.activity.OlympicSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;

public class trs
  extends OlympicObserver
{
  public trs(OlympicSettingActivity paramOlympicSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onSetOlympicShowSwitch, isSuc:" + paramBoolean1 + " switchOn:" + paramBoolean2);
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity.jdField_b_of_type_Boolean = paramBoolean2;
    }
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityOlympicSettingActivity.jdField_b_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\trs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */