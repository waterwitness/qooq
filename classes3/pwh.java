import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class pwh
  implements Runnable
{
  public pwh(DataLineHandler paramDataLineHandler1, DataLineHandler paramDataLineHandler2, msg_comm.Msg paramMsg, C2CType0x211_SubC2CType0x9.MsgBody paramMsgBody)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.b.a.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler, this.jdField_a_of_type_MsfMsgcommMsg_comm$Msg, this.jdField_a_of_type_TencentImS2cMsgtype0x211Submsgtype0x9C2CType0x211_SubC2CType0x9$MsgBody);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */