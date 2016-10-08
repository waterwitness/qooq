import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gfx
  extends BroadcastReceiver
{
  public gfx(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.process.exit".equals(paramIntent.getAction())))
    {
      paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
      paramIntent = paramIntent.getExtras().getString("verify");
      if ((this.a.a(paramIntent, paramContext)) && (this.a.a(paramContext)) && ((this.a.a == null) || (this.a.a.a().a()))) {
        this.a.c();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */