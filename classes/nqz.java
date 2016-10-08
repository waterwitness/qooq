import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.troop.TroopFileProxyActivity;
import cooperation.troop.TroopProxyActivity;

public class nqz
  implements View.OnClickListener
{
  public nqz(TroopFileItemBuilder paramTroopFileItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    paramView = (Activity)paramView.getContext();
    Intent localIntent = new Intent();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra(TroopProxyActivity.a, localChatMessage.frienduin);
    TroopFileProxyActivity.a(paramView, localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nqz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */