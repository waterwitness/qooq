import android.app.Dialog;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.qidian.controller.QidianBusinessObserver;
import java.util.HashMap;

public class obu
  extends QidianBusinessObserver
{
  public obu(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null))
    {
      this.a.v(2);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    if (((Integer)paramHashMap.get("result")).intValue() == 0)
    {
      this.a.v(1);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    this.a.ag = true;
    this.a.aR();
    if ((PublicAccountChatPie.a(this.a) != null) && (PublicAccountChatPie.a(this.a).isShowing())) {
      PublicAccountChatPie.a(this.a).dismiss();
    }
    paramHashMap = StructMsgFactory.a(((String)paramHashMap.get("welcome")).getBytes(), 0);
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = ((MessageForStructing)MessageRecordFactory.a(63525));
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.msgtype = 63525;
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.istroop = 1008;
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.issend = 0;
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.isread = true;
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.selfuin = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.senderuin = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.frienduin = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.mIsParsed = true;
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg = paramHashMap;
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.msgData = paramHashMap.getBytes();
    this.a.aS();
  }
  
  protected void c(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null)) {
      return;
    }
    this.a.aj = true;
    this.a.ai = ((Boolean)paramHashMap.get("result")).booleanValue();
    this.a.aQ();
    this.a.aS();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\obu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */