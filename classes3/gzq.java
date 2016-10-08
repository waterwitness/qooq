import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gzq
  extends BroadcastReceiver
{
  public gzq(VideoInviteActivity paramVideoInviteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteActivity", 2, "WL_DEBUG onReceive action = " + paramContext);
    }
    if (paramContext.equals("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO")) {
      this.a.i();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */