import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class jgq
  extends AudioManager
{
  public jgq(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int requestAudioFocus(AudioManager.OnAudioFocusChangeListener paramOnAudioFocusChangeListener, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = super.requestAudioFocus(paramOnAudioFocusChangeListener, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (NullPointerException paramOnAudioFocusChangeListener)
    {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "audio_manager_npe", 0, 1, 0, "", "", "", "");
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */