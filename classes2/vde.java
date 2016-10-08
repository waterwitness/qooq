import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;

public class vde
  implements InputFilter
{
  public vde(AbsPublishActivity paramAbsPublishActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if (TroopBarUtils.a(paramCharSequence, '\n') + TroopBarUtils.a(paramSpanned.toString(), '\n') > 100) {
        return paramCharSequence.replaceAll("\n", "");
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vde.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */