import android.media.AudioManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class vot
  implements TVK_IMediaPlayer.OnErrorListener
{
  public vot(TVKTroopVideoManager paramTVKTroopVideoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.a.h = -1;
    Object localObject = (AudioManager)BaseApplication.getContext().getSystemService("audio");
    if (localObject != null) {
      ((AudioManager)localObject).abandonAudioFocus(this.a.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("video player error model=" + paramInt1);
      ((StringBuilder)localObject).append(",what=" + paramInt2);
      ((StringBuilder)localObject).append(",extra=" + paramInt3);
      ((StringBuilder)localObject).append(",detailInfo=" + paramString);
      QLog.e(TVKTroopVideoManager.jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject).toString());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new vou(this, paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */