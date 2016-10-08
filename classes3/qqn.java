import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qqn
  extends BroadcastReceiver
{
  public qqn(ArkAppCenter paramArkAppCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.PROXY_CHANGE"))
    {
      ArkAppCenter.c("ArkApp", "receive broadcast proxy change.");
      if (1 == NetworkUtil.a(paramContext)) {
        ArkAppCenter.c();
      }
    }
    else
    {
      return;
    }
    ArkAppCenter.d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */