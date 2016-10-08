import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class pzw
  implements Runnable
{
  public pzw(MessageHandler paramMessageHandler, MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MsgSend", 4, "delay notify: " + MessageHandler.ci);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(8022, true, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */