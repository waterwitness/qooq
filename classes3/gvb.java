import android.content.Context;
import android.widget.RadioButton;
import com.tencent.av.ui.MultiMembersAudioIndicator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gvb
  extends RadioButton
{
  public gvb(MultiMembersAudioIndicator paramMultiMembersAudioIndicator, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean performClick()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */