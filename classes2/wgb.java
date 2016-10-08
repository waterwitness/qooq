import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipav.VipFunCallMediaListener;

public final class wgb
  implements MediaPlayer.OnPreparedListener
{
  public wgb(VipFunCallMediaListener paramVipFunCallMediaListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
    paramMediaPlayer.setLooping(true);
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */