import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class shg
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public shg(TroopLocalVideoFileView paramTroopLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocalVideoFileView", 2, "video player prepared");
    }
    TroopLocalVideoFileView.c(this.a).runOnUiThread(new shh(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */