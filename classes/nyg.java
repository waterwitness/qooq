import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatRecentUserMgr;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nyg
  implements Runnable
{
  public nyg(HotChatPie paramHotChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state == 1)
    {
      this.a.ar = this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid;
      HotChatManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo);
      return;
    }
    HotChatRecentUserMgr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.state);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */