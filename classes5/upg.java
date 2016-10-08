import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.MsgBody;

public final class upg
  implements Runnable
{
  public upg(QQAppInterface paramQQAppInterface, submsgtype0xb1.MsgBody paramMsgBody, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0xb1Submsgtype0xb1$MsgBody.invite_info, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\upg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */