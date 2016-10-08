import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lva
  implements Runnable
{
  public lva(ModifyFriendInfoActivity paramModifyFriendInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (FriendsManager)this.a.app.getManager(50);
    Friends localFriends = ((FriendsManager)localObject).c(this.a.jdField_a_of_type_JavaLangString);
    if (localFriends != null)
    {
      this.a.jdField_a_of_type_Int = localFriends.groupid;
      localObject = ((FriendsManager)localObject).a(this.a.jdField_a_of_type_Int + "");
      if (localObject != null) {
        this.a.d = ((Groups)localObject).group_name;
      }
    }
    if (this.a.jdField_a_of_type_Int == -1)
    {
      this.a.runOnUiThread(new lvb(this));
      return;
    }
    localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    ((Message)localObject).what = 2;
    ((Message)localObject).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lva.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */