import android.media.AudioManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class vor
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public vor(TVKTroopVideoManager paramTVKTroopVideoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.h = 5;
    AudioManager localAudioManager = (AudioManager)BaseApplication.getContext().getSystemService("audio");
    if (localAudioManager != null) {
      localAudioManager.abandonAudioFocus(this.a.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new vos(this, paramTVK_IMediaPlayer));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */