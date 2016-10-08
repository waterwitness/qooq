import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class pbz
  implements MediaPlayer.OnErrorListener
{
  public pbz(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private String[] a()
  {
    String str = QzoneConfig.a().a("VideoEdit", "VideoLoadErrorReturnCode");
    if (str == null) {
      return null;
    }
    return str.split(",");
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("PTV.NewFlowCameraActivity", 2, "VideoView onError, what:" + paramInt1 + ", extra:" + paramInt2);
    for (;;)
    {
      try
      {
        Toast.makeText(this.a.getApplicationContext(), "加载视频失败", 1).show();
        paramMediaPlayer = a();
        if (paramMediaPlayer == null)
        {
          NewFlowCameraActivity.a(this.a, "play_local_video", "play_local_video_success", "4", "what: " + paramInt1 + ",   extra: " + paramInt2 + ",   " + Build.MODEL);
          this.a.setResult(0);
          return true;
        }
        int k = paramMediaPlayer.length;
        int i = 0;
        int j = 1;
        if (i < k)
        {
          if (TextUtils.equals(paramMediaPlayer[i], paramInt1 + "-" + paramInt2)) {
            j = 0;
          }
        }
        else
        {
          if (j == 0) {
            continue;
          }
          NewFlowCameraActivity.a(this.a, "play_local_video", "play_local_video_success", "4", "what: " + paramInt1 + ",   extra: " + paramInt2 + ",   " + Build.MODEL);
          continue;
        }
        i += 1;
      }
      catch (Exception paramMediaPlayer)
      {
        QLog.e("PTV.NewFlowCameraActivity", 2, "VideoView onError", paramMediaPlayer);
        return true;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */