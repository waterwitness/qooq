import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kim
  implements View.OnClickListener
{
  public kim(AddFriendVerifyActivity paramAddFriendVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, BusinessCardEditActivity.class);
    paramView.putExtra("mode_type", 3);
    paramView.putExtra("cur_card_id", this.a.a.cardId);
    this.a.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */