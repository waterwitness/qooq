import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import mqq.os.MqqHandler;

class ocs
  implements Runnable
{
  ocs(ocq paramocq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (TroopUtils.b(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b)) {
      TroopChatPie.c(this.a.a).post(new oct(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ocs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */