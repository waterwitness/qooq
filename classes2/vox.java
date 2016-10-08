import android.media.AudioManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class vox
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public vox(TVKTroopVideoManager paramTVKTroopVideoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.h = 2;
    int i = this.a.j;
    Object localObject = (AudioManager)BaseApplication.getContext().getSystemService("audio");
    StringBuilder localStringBuilder;
    if (localObject != null)
    {
      int j = ((AudioManager)localObject).requestAudioFocus(this.a.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1);
      if (QLog.isColorLevel())
      {
        localObject = TVKTroopVideoManager.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("requestAudioFocus,result:");
        if (j != 1) {
          break label123;
        }
      }
    }
    label123:
    for (boolean bool = true;; bool = false)
    {
      QLog.d((String)localObject, 2, bool);
      this.a.d();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new voy(this, paramTVK_IMediaPlayer, i));
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */