import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class wfu
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public wfu(VipVideoPlayActivity paramVipVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video player prepared");
    }
    this.a.runOnUiThread(new wfv(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */