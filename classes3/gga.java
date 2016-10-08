import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gga
  extends BroadcastReceiver
{
  public gga(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.av.EXIT_VIDEO_PROCESS".equals(paramIntent.getAction())) && (this.a.a != null))
    {
      this.a.a.a(false, 0, new int[] { this.a.a.a().D });
      this.a.a.m();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */