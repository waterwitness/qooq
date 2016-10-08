import android.text.TextUtils;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kly
  implements Runnable
{
  public kly(AutoRemarkActivity paramAutoRemarkActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.f)) {}
    while (((FriendsManager)this.a.app.getManager(50)).a(this.a.f) != null) {
      return;
    }
    ((FriendListHandler)this.a.app.a(1)).b(this.a.f);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */