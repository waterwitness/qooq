import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ofl
  implements MediaPlayer.OnErrorListener
{
  public ofl(BlessActivity paramBlessActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.a), 2, "videoview onError what=" + paramInt1 + ", extra=" + paramInt2);
    }
    BlessActivity.a(this.a, true);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */