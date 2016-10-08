import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class shq
  implements MediaPlayer.OnVideoSizeChangedListener
{
  public shq(FileViewMusicService paramFileViewMusicService, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "invalid video width(" + paramInt1 + ") or height(" + paramInt2 + ")");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileViewMusicService<FileAssistant>", 2, "onVideoSizeChanged width:" + paramInt1 + " height:" + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewMusicService.a(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */