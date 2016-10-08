import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import mqq.os.MqqHandler;

class odf
  implements Runnable
{
  odf(ode paramode)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopNotificationHelper.c(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    TroopNotificationHelper.c(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    Message localMessage = TroopChatPie.h(this.a.a).obtainMessage(29);
    localMessage.arg1 = 2;
    TroopChatPie.i(this.a.a).sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */