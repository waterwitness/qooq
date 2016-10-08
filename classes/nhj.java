import android.content.Context;
import android.widget.RadioButton;
import com.tencent.mobileqq.activity.aio.audiopanel.ViewPagerRadioGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nhj
  extends RadioButton
{
  public nhj(ViewPagerRadioGroup paramViewPagerRadioGroup, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean performClick()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */