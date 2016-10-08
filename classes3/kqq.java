import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.BlessPTVActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kqq
  implements MediaPlayer.OnCompletionListener
{
  public kqq(BlessPTVActivity paramBlessPTVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, "onCompletion");
    }
    if (BlessPTVActivity.a(this.a)) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */