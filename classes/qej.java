import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class qej
  implements Runnable
{
  public qej(QQAppInterface paramQQAppInterface, StringBuilder paramStringBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QQAppInterface.a, 2, "isCallTabShow needupdate,result=" + this.jdField_a_of_type_JavaLangStringBuilder);
    }
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_calltab_show_key", this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */