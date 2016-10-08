import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ColorRingPlayer;

public class wef
  implements MediaPlayer.OnCompletionListener
{
  public wef(ColorRingPlayer paramColorRingPlayer, AudioManager paramAudioManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer arg1)
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.jdField_a_of_type_JavaLangObject)
    {
      ???.release();
      this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.c.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841668));
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.jdField_a_of_type_Weo)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.jdField_a_of_type_Weo.h = 6;
      return;
      ??? = finally;
      throw ???;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */