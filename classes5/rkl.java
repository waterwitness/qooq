import android.content.Context;
import android.widget.RadioButton;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rkl
  extends RadioButton
{
  public rkl(EmoticonPagerRadioGroup paramEmoticonPagerRadioGroup, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean performClick()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rkl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */