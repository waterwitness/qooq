import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import java.util.ArrayList;

public class ocl
  implements Runnable
{
  public ocl(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (TroopUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b))
    {
      TroopHandler localTroopHandler = (TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localTroopHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, localArrayList);
      this.a.M = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ocl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */