import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import java.util.List;

public class wdh
  implements Runnable
{
  public wdh(SendMessageHandler paramSendMessageHandler, long paramLong, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SendMessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler) >= SendMessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler).size()) {
      return;
    }
    int i = SendMessageHandler.b(this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler);
    SendMessageHandler.SendMessageRunnable localSendMessageRunnable = (SendMessageHandler.SendMessageRunnable)SendMessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqUtilsSendMessageHandler).get(i);
    localSendMessageRunnable.jdField_a_of_type_Int = i;
    localSendMessageRunnable.g = System.currentTimeMillis();
    localSendMessageRunnable.c = this.jdField_a_of_type_Long;
    localSendMessageRunnable.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localSendMessageRunnable.run();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */