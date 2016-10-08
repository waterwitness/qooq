import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class lps
  extends FriendListObserver
{
  public lps(JoinDiscussionActivity paramJoinDiscussionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramString = ((FriendsManager)this.a.app.getManager(50)).c(this.a.a + "");
      if (paramString != null)
      {
        this.a.e = paramString.name;
        JoinDiscussionActivity.a(this.a);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("IphoneTitleBarActivity", 2, "get owner name failed");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */