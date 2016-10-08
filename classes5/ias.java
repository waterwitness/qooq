import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ias
  extends BroadcastReceiver
{
  private ias(VideoVolumeControl paramVideoVolumeControl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (VideoVolumeControl.a(this.a)) {
      VideoVolumeControl.a(this.a, false);
    }
    int i;
    label156:
    do
    {
      do
      {
        do
        {
          return;
          if (VideoVolumeControl.a(this.a) != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "VolumeReceiver onReceive null");
        return;
        try
        {
          if (!paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
            break label156;
          }
          i = VideoVolumeControl.a(this.a).getStreamVolume(3);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change:" + i);
          }
          if (VideoVolumeControl.b(this.a))
          {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change shield ");
            return;
          }
        }
        catch (Exception paramContext)
        {
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "VolumeReceiver", paramContext);
          return;
        }
        if (i == 0)
        {
          this.a.a(true, "system volume 0");
          return;
        }
        this.a.a(false, "system volume change");
        return;
        if (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"))
        {
          boolean bool = VideoVolumeControl.a(this.a).isWiredHeadsetOn();
          if (VideoVolumeControl.c(this.a))
          {
            VideoVolumeControl.b(this.a, false);
            return;
          }
          VideoVolumeControl.c(this.a, true);
          if (bool) {
            this.a.a(false, "headset on");
          }
          for (;;)
          {
            VideoVolumeControl.a(this.a).postDelayed(new iat(this), 200L);
            return;
            this.a.a(true, "headset off");
          }
        }
        if (paramIntent.getAction().equals("android.media.AUDIO_BECOMING_NOISY"))
        {
          this.a.a(true, "headset off from noisy");
          return;
        }
      } while (!paramIntent.getAction().equals("android.media.RINGER_MODE_CHANGED"));
      i = VideoVolumeControl.a(this.a).getRingerMode();
      if ((i == 0) || (i == 1))
      {
        this.a.a(true, "ringset off");
        return;
      }
    } while (i != 2);
    this.a.a(false, "ringset on");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ias.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */