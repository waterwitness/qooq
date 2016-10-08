import android.widget.TextView;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class nbq
  implements Runnable
{
  public nbq(ActivateFriendActivity paramActivateFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.a.app.a().e();
    Object localObject2 = this.a.app.a().getString(2131367566);
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject2 = new StringBuilder().append((String)localObject2).append("(");
      if (i <= 99) {
        break label88;
      }
    }
    label88:
    for (localObject1 = "99+";; localObject1 = Integer.valueOf(i))
    {
      localObject1 = localObject1 + ")";
      ActivateFriendActivity.a(this.a).setText((CharSequence)localObject1);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */