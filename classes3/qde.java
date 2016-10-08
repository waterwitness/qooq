import com.tencent.mobileqq.app.PrinterStatusHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class qde
  implements Runnable
{
  public qde(PrinterStatusHandler paramPrinterStatusHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPrinterStatusHandler.b(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, this.jdField_a_of_type_JavaLangObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */