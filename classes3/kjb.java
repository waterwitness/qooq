import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class kjb
  implements Runnable
{
  public kjb(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.app.getManager(50)).a(AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity));
    ThreadManager.c().post(new kjc(this, str));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */