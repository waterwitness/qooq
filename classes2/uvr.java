import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

class uvr
  implements Runnable
{
  uvr(uvq paramuvq, StructMsgForImageShare paramStructMsgForImageShare, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.uin, "0X80055C7", "0X80055C7", 0, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.msgId), this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mMsgAction, Integer.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.mPromotionType));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */