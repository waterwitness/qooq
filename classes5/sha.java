import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class sha
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public sha(TroopLocalVideoFileView paramTroopLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    TroopLocalVideoFileView.b(this.a).runOnUiThread(new shb(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */