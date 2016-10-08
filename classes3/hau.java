import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.AvAddFriendHelper;
import com.tencent.av.utils.AvAddFriendHelper.IAvAddFriendCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hau
  extends BroadcastReceiver
{
  public hau(AvAddFriendHelper paramAvAddFriendHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("tencent.video.q2v.AddfrindMsg"))
    {
      paramContext = paramIntent.getStringExtra("peerUin");
      if (this.a.a != null) {
        this.a.a.a(paramContext);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */