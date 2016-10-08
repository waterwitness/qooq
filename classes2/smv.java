import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.HotChatFragment.HotChatWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class smv
  extends BroadcastReceiver
{
  public smv(HotChatFragment paramHotChatFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.mobileqq.refresh_hot_chat_list".equals(paramIntent.getAction())) && (this.a.a != null) && (this.a.a.a != null)) {
      this.a.a.A();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */