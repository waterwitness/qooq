import com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.ContactMatchMessage;
import mqq.os.MqqHandler;

public class ois
  implements Runnable
{
  public ois(ContactMatchBuilder paramContactMatchBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((PhoneContactManagerImp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(((ContactMatchMessage)this.a.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a);
    ThreadManager.c().post(new oit(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ois.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */