import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lnh
  extends CardObserver
{
  public lnh(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, Card paramCard)
  {
    this.a.a();
    if ((!paramBoolean) || (paramInt != 0))
    {
      this.a.a(2131367913, 1);
      return;
    }
    this.a.a(2131367912, 2);
    paramCard = new Intent();
    paramCard.putExtra("param_joined_group_switch", FriendProfileMoreInfoActivity.a(this.a));
    if (FriendProfileMoreInfoActivity.a(this.a)) {
      paramCard.putExtra("param_switches_changed", true);
    }
    this.a.setResult(-1, paramCard);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lnh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */