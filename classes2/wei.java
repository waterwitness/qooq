import android.media.MediaPlayer;
import android.widget.ProgressBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ColorRingPlayer;

class wei
  implements Runnable
{
  wei(weh paramweh, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_Weh.a.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        bool1 = this.jdField_a_of_type_Weh.a.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
      }
      if ((this.jdField_a_of_type_Weh.a.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (bool1)) {
        this.jdField_a_of_type_Weh.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(this.jdField_a_of_type_Int * 100 / this.b);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Weh.a.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        this.jdField_a_of_type_Weh.a.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        bool1 = bool2;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */