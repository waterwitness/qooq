import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ios
  implements AudioManager.OnAudioFocusChangeListener
{
  public ios(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (this.a.isResume())) {
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ios.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */