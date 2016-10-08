import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gfc
  implements MediaPlayer.OnCompletionListener
{
  public gfc(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "onCompletion request");
    }
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().g()) {
      return;
    }
    paramMediaPlayer = this.a;
    if (this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().b == 2L) {}
    for (int i = 4;; i = 1)
    {
      paramMediaPlayer.a(2131165198, i, this.a.b);
      this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().j = 6;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(14), Integer.valueOf(this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().z), this.a.jdField_a_of_type_ComTencentAvSessionMgr.a().c });
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */