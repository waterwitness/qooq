import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;

public class kip
  extends CardObserver
{
  public kip(AddFriendVerifyActivity paramAddFriendVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      String str1;
      String str2;
      TextView localTextView;
      if ((paramBoolean) && (paramObject != null) && (((Card)paramObject).uin != null) && (((Card)paramObject).uin.equals(AddFriendVerifyActivity.a(this.a))))
      {
        str1 = ((FriendsManager)this.a.app.getManager(50)).a(((Card)paramObject).uin);
        str2 = ContactUtils.j(this.a.app, ((Card)paramObject).uin);
        localTextView = AddFriendVerifyActivity.b(this.a);
        if (!AddFriendVerifyActivity.b(this.a)) {
          break label122;
        }
        if (!str2.equals(((Card)paramObject).uin)) {
          localTextView.setText(str2);
        }
      }
      return;
      label122:
      localTextView.setText(String.format("%s(%s)", new Object[] { str2, str1 }));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */