import android.widget.Button;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.GridCallBack;
import com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nbu
  implements ActivateFriendGrid.GridCallBack
{
  public nbu(BirthdayActivatePage paramBirthdayActivatePage)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a.a.setEnabled(true);
      return;
    }
    this.a.a.setEnabled(false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */