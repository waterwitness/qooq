import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;

class uvc
  implements Runnable
{
  uvc(uvb paramuvb, StructMsgForAudioShare paramStructMsgForAudioShare, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.uin, "0X80055C7", "0X80055C7", 0, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.msgId), this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForAudioShare.mMsgAction, Integer.toString(i));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */