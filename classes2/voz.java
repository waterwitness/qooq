import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;

public class voz
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  public voz(TVKTroopVideoManager paramTVKTroopVideoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.h = 5;
    this.a.a.runOnUiThread(new vpa(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\voz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */