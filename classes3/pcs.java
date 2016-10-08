import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.PTVOperatingGuideActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class pcs
  extends BroadcastReceiver
{
  public pcs(PTVOperatingGuideActivity paramPTVOperatingGuideActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("PTVOperatingGuide", 2, "onReceive ===>" + paramContext);
    }
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("tencent.av.v2q.StartVideoChat".equals(paramContext)))
    {
      if ((PTVOperatingGuideActivity.a(this.a) != null) && (PTVOperatingGuideActivity.a(this.a).isPlaying())) {
        this.a.b = true;
      }
      this.a.d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */