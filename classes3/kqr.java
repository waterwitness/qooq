import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.BlessPTVActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kqr
  implements MediaPlayer.OnPreparedListener
{
  public kqr(BlessPTVActivity paramBlessPTVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.a.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    this.a.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.e("BlessPTVActivity", 2, "start: mMediaStartTimeStamp=" + this.a.jdField_a_of_type_Long);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */