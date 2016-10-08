import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class uvn
  implements Runnable
{
  public uvn(StructMsgForGeneralShare paramStructMsgForGeneralShare, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.frienduin, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.msgtype, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.extStr);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */