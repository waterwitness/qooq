import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.VideoAudioManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hrb
  implements Runnable
{
  public hrb(VideoAudioManager paramVideoAudioManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (VideoAudioManager.a(this.a) == null) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          if (!VideoAudioManager.a(this.a)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.pubaccount.video.VideoAudioManager", 2, "mBreakSmooth = " + VideoAudioManager.a(this.a));
        return;
        i = VideoAudioManager.a(this.a).getStreamVolume(3);
        if (i == VideoAudioManager.a(this.a)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.pubaccount.video.VideoAudioManager", 2, "smoothAdjustVolume() currentVolume = " + i + ", mLastChangedVolume = " + VideoAudioManager.a(this.a) + ", currentVolume != mLastChangedVolume, SET mIsSmoothRaiseFinished = true, RETURN");
      return;
      VideoAudioManager.a(this.a).adjustStreamVolume(3, 1, 0);
      VideoAudioManager.a(this.a, i + 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoAudioManager", 2, "smoothAdjustVolume() currentVolume = " + (i + 1));
      }
      if (VideoAudioManager.a(this.a) < VideoAudioManager.b(this.a))
      {
        VideoAudioManager.a(this.a).postDelayed(this, VideoAudioManager.c(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.VideoAudioManager", 2, "smoothAdjustVolume() mLastChangedVolume = " + VideoAudioManager.a(this.a) + ", mTargetMusicVolume = " + VideoAudioManager.b(this.a) + ", SET mIsSmoothRaiseFinished = true, FINISHED");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */