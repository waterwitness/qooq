import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ldk
  extends BroadcastReceiver
{
  public ldk(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("login".equals(paramIntent.getStringExtra("status")))
    {
      this.a.a.a(8, 2);
      this.a.a.e = paramIntent.getStringExtra("loginInfo");
      this.a.a.f = paramIntent.getStringExtra("loginAppId");
      this.a.a.a(-1, null);
      return;
    }
    this.a.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */