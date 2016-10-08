import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class qcz
  extends TimerTask
{
  public qcz(PrinterHandler paramPrinterHandler, DataLineHandler paramDataLineHandler, Timer paramTimer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a.size() > 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.Printer", 4, " pc下线了");
      }
      while (this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a.size() > 0)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a.keySet().iterator();
        if (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(0, l, true);
          this.jdField_a_of_type_ComTencentMobileqqAppPrinterHandler.a(Long.valueOf(l), false);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */