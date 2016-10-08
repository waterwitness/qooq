import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kmc
  implements Runnable
{
  public kmc(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kmc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */