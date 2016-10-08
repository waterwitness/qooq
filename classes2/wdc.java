import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public final class wdc
  implements Runnable
{
  public wdc(boolean paramBoolean, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str1 = null;
    if (this.jdField_a_of_type_Boolean) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369477);
    }
    for (String str2 = "0";; str2 = "1")
    {
      if (str1 != null) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2, str1, 0).b(this.jdField_a_of_type_Int);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Fast_launch", "Fast_launch_creat", 0, 0, this.jdField_a_of_type_JavaLangString, str2, "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */