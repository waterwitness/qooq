import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.GridCallBack;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGridItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nbr
  implements View.OnClickListener
{
  public nbr(ActivateFriendGrid paramActivateFriendGrid)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (ActivateFriendGridItem)paramView;
    if (paramView.a)
    {
      ActivateFriendGrid.a(this.a);
      if (paramView.a) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      if (ActivateFriendGrid.a(this.a) != null) {
        ActivateFriendGrid.a(this.a).a(ActivateFriendGrid.c(this.a));
      }
      return;
      ActivateFriendGrid.b(this.a);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */