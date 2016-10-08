import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAdminList.ViewHolder;

public class vgc
  implements View.OnClickListener
{
  public vgc(TroopAdminList paramTroopAdminList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (TroopAdminList.ViewHolder)paramView.getTag();
    if (paramView != null)
    {
      paramView = paramView.b;
      if (!this.a.app.a().equals(paramView)) {
        break label53;
      }
      paramView = new ProfileActivity.AllInOne(paramView, 0);
    }
    for (;;)
    {
      ProfileActivity.b(this.a, paramView);
      return;
      label53:
      Friends localFriends = ((FriendsManager)this.a.app.getManager(50)).c(paramView);
      if ((localFriends == null) || (!localFriends.isFriend())) {
        break;
      }
      paramView = new ProfileActivity.AllInOne(paramView, 1);
      paramView.h = localFriends.name;
      paramView.i = localFriends.remark;
    }
    int i = this.a.getIntent().getIntExtra("t_s_f", -1);
    if (i == 1001) {
      i = 24;
    }
    for (;;)
    {
      paramView = new ProfileActivity.AllInOne(paramView, i);
      if (i == 1001) {
        paramView.k = 10000;
      }
      break;
      if (i == 1000) {
        i = 23;
      } else {
        i = 23;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */