import android.media.MediaPlayer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.ptt.player.IPttPlayerListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class tyk
  implements Runnable
{
  public tyk(AmrPlayer paramAmrPlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AmrPlayer", 2, "playAmr " + AmrPlayer.a(this.a));
    }
    try
    {
      AmrPlayer.a(this.a).b();
      AmrPlayer.a(this.a).start();
      if (AmrPlayer.a(this.a, 1000) > 0) {
        AmrPlayer.a(this.a).seekTo(AmrPlayer.a(this.a));
      }
      return;
    }
    catch (Exception localException)
    {
      while (AmrPlayer.a(this.a) == null) {}
      AmrPlayer.a(this.a).sendEmptyMessage(1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tyk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */