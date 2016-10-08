import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class qda
  extends TimerTask
{
  public qda(PrinterHandler paramPrinterHandler, long paramLong, Timer paramTimer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(this.jdField_a_of_type_Long)))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004021", "0X8004021", (int)this.jdField_a_of_type_Long, -1, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(Long.valueOf(this.jdField_a_of_type_Long), false);
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.Printer", 4, "printID=" + this.jdField_a_of_type_Long + ", 超时到了");
      }
    }
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */