import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gfd
  implements MediaPlayer.OnCompletionListener
{
  public gfd(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "onCompletion onClose");
    }
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().h())
    {
      if (QLog.isColorLevel()) {
        QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "onCompletion onClose is not Closing2");
      }
      return;
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, 0);
    this.a.c(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c, this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().z);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */