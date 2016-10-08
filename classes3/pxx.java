import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pxx
  extends Thread
{
  public pxx(FriendListHandler paramFriendListHandler, String paramString1, String paramString2)
  {
    super(paramString1);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b.getManager(50);
    Friends localFriends = localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b.a());
    localFriends.signature = this.jdField_a_of_type_JavaLangString;
    localFriendsManager.a(localFriends);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */