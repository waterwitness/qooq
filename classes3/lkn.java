import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;

class lkn
  implements View.OnClickListener
{
  lkn(lkk paramlkk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (lkk.a(this.a) == null) {}
    for (;;)
    {
      return;
      if ((lkk.a(this.a).a instanceof String)) {
        paramView = (String)lkk.a(this.a).a;
      }
      while (paramView != null)
      {
        this.a.a.b(paramView);
        ThreadManager.a(new lko(this), 5, null, true);
        return;
        if ((lkk.a(this.a).a instanceof ProfileActivity.CardContactInfo))
        {
          paramView = (ProfileActivity.CardContactInfo)lkk.a(this.a).a;
          if ((this.a.a.a != null) && (this.a.a.a.a != null) && (this.a.a.a.a.a == 33)) {
            paramView = paramView.c;
          } else {
            paramView = paramView.a + " " + paramView.c;
          }
        }
        else
        {
          paramView = null;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lkn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */