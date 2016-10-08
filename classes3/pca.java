import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;

public class pca
  implements MediaPlayer.OnPreparedListener
{
  public pca(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onPrepared, duration:" + paramMediaPlayer.getDuration());
    }
    paramMediaPlayer.setLooping(true);
    NewFlowCameraActivity.a(this.a).removeMessages(9999);
    if (!NewFlowCameraActivity.a(this.a).a())
    {
      NewFlowCameraActivity.i(this.a, paramMediaPlayer.getDuration());
      if (NewFlowCameraActivity.e(this.a) >= 2000) {
        break label165;
      }
      Toast.makeText(this.a.getApplicationContext(), "裁剪不支持小于2秒的视频，请重新选择视频", 1).show();
      if (this.a.j)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c();
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(0);
        }
        NewFlowCameraActivity.b(this.a, 8);
        this.a.j = false;
      }
    }
    return;
    label165:
    if ((FileUtils.a(NewFlowCameraActivity.c(this.a)) / this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getDuration() * 15000L > this.a.a(NewFlowCameraActivity.b())) && (QLog.isColorLevel())) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "prepared, there is not enough space on sdcard");
    }
    int i = paramMediaPlayer.getVideoWidth();
    int j = paramMediaPlayer.getVideoHeight();
    if ((i <= 0) || (j <= 0))
    {
      Toast.makeText(this.a.getApplicationContext(), "获取视频尺寸失败", 1).show();
      return;
    }
    NewFlowCameraActivity.j(this.a, i);
    NewFlowCameraActivity.k(this.a, j);
    NewFlowCameraActivity.a(this.a, i, j);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */