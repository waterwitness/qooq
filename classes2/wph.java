import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqpsdk.secsrv.MQPAPPScanService;

public class wph
  extends Thread
{
  public wph(MQPAPPScanService paramMQPAPPScanService, byte[] paramArrayOfByte)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      MQPAPPScanService.h += 1;
      MQPAPPScanService.a(this.jdField_a_of_type_ComTencentMqpsdkSecsrvMQPAPPScanService, this.jdField_a_of_type_ArrayOfByte);
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */