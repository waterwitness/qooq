import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gfe
  implements MediaPlayer.OnCompletionListener
{
  public gfe(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "onCompletion onClose");
    }
    if (this.a.a().A)
    {
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      l = this.a.a().e;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), String.valueOf(l), Boolean.valueOf(true) });
      this.a.a(3, l, 0, new int[0]);
      this.a.a();
      this.a.a().A = false;
      this.a.a().z = false;
    }
    while (!QLog.isColorLevel())
    {
      long l;
      return;
    }
    QLog.e(VideoController.jdField_a_of_type_JavaLangString, 2, "mOnCloseDoubleVideoMeetingListener-->Is not in doubleMeetingRoom");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gfe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */