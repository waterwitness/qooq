import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class nzj
  implements Runnable
{
  public nzj(NearbyChatPie paramNearbyChatPie, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildNearbyChatPie.al, 4, "0X80052C5, " + this.jdField_a_of_type_JavaLangString);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildNearbyChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052C5", "0X80052C5", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildNearbyChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", this.jdField_a_of_type_JavaLangString, "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */