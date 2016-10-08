import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qvo
  implements View.OnClickListener
{
  public qvo(BusinessCardEditActivity paramBusinessCardEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (qvv)paramView.getTag();
    if (!((FriendsManager)this.a.app.getManager(50)).b(paramView.a)) {}
    for (int i = 35;; i = 1)
    {
      paramView = new ProfileActivity.AllInOne(paramView.a, i);
      ProfileActivity.a(this.a, paramView, 1016);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */