import android.media.MediaPlayer;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.OnTrimVDPlayCompelteListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pby
  implements FixedSizeVideoView.OnTrimVDPlayCompelteListener
{
  public pby(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(MediaPlayer paramMediaPlayer)
  {
    if (NewFlowCameraActivity.a(this.a))
    {
      QLog.e("PTV.NewFlowCameraActivity", 2, "onComplete() ---------------1   mStartTime=" + NewFlowCameraActivity.a(this.a) + " mEndTime=" + NewFlowCameraActivity.b(this.a) + "   mCurrentStartTime=" + NewFlowCameraActivity.j(this.a));
      this.a.a.pause();
      paramMediaPlayer.seekTo(NewFlowCameraActivity.j(this.a));
      this.a.i = false;
      NewFlowCameraActivity.b(this.a).setVisibility(0);
    }
  }
  
  public void a(FixedSizeVideoView paramFixedSizeVideoView, int paramInt1, int paramInt2)
  {
    if (NewFlowCameraActivity.a(this.a))
    {
      QLog.e("PTV.NewFlowCameraActivity", 2, "onArriveTrimEnd() ---------------3   mStartTime=" + NewFlowCameraActivity.a(this.a) + " mEndTime=" + NewFlowCameraActivity.b(this.a) + "   mCurrentStartTime=" + NewFlowCameraActivity.j(this.a));
      paramFixedSizeVideoView.pause();
      paramFixedSizeVideoView.seekTo(NewFlowCameraActivity.j(this.a));
      this.a.i = false;
      NewFlowCameraActivity.b(this.a).setVisibility(0);
    }
    while (NewFlowCameraActivity.b(this.a) == 0) {
      return;
    }
    QLog.e("PTV.NewFlowCameraActivity", 2, "onArriveTrimEnd() ---------------4   mStartTime=" + NewFlowCameraActivity.a(this.a) + " mEndTime=" + NewFlowCameraActivity.b(this.a) + "   mCurrentStartTime=" + NewFlowCameraActivity.j(this.a));
    paramFixedSizeVideoView.setPlayDuration(NewFlowCameraActivity.a(this.a), NewFlowCameraActivity.b(this.a) - NewFlowCameraActivity.a(this.a));
    paramFixedSizeVideoView.seekTo(NewFlowCameraActivity.a(this.a));
    paramFixedSizeVideoView.start();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */