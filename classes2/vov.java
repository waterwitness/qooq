import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

public class vov
  implements TVK_IMediaPlayer.OnInfoListener
{
  public vov(TVKTroopVideoManager paramTVKTroopVideoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    this.a.a.runOnUiThread(new vow(this, paramTVK_IMediaPlayer, paramInt, paramObject));
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */