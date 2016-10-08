import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class lkf
  implements View.OnClickListener
{
  public lkf(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    FriendProfileCardActivity.d(this.a);
    this.a.finish();
    if ((this.a.a.a != null) && (this.a.a.a.a) && (this.a.app != null) && (!"0".equals(this.a.app.a()))) {
      this.a.app.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lkf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */