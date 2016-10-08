import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class geq
  implements AudioManager.OnAudioFocusChangeListener
{
  public geq(VideoController paramVideoController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt == -1) {}
    while ((paramInt == -2) || (paramInt == -3) || (paramInt != 1)) {
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\geq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */