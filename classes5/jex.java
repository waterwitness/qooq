import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.PrintStream;

public class jex
  implements InputFilter
{
  protected int a;
  
  public jex(TroopGiftPanel paramTroopGiftPanel, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    System.out.println("filter() source = " + paramCharSequence + ", dest = " + paramSpanned + ", start = " + paramInt1 + ", dstart = " + paramInt3 + ", dend = " + paramInt4);
    if (paramCharSequence.length() != 1) {
      return "";
    }
    paramInt1 = paramCharSequence.charAt(0);
    if ((paramInt1 < 48) || (paramInt1 > 57)) {
      return "";
    }
    if ((paramInt3 == 0) && (paramInt1 == 48)) {
      return "";
    }
    if ((this.jdField_a_of_type_Int > 0) && (paramSpanned.length() >= this.jdField_a_of_type_Int)) {
      return "";
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */