import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.C2CMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qld
  implements Runnable
{
  public qld(C2CMessageManager paramC2CMessageManager, MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest " + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getLogColorContent());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageC2CMessageManager.a.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 15000L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */