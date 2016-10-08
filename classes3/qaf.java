import android.app.NotificationManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qaf
  implements Runnable
{
  public qaf(MessageHandler paramMessageHandler, NotificationManager paramNotificationManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "IPADonline time expired cancel now");
      }
      this.jdField_a_of_type_AndroidAppNotificationManager.cancel(MessageHandler.cp);
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.MessageHandler", 2, "IPADonline thread Interrupt");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */