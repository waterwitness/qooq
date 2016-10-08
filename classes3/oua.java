import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oua
  implements TextWatcher
{
  public oua(CommonHbFragment paramCommonHbFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = CommonHbFragment.a(this.a).getText().toString();
    String str;
    if ((CommonHbFragment.a(this.a)) && (CommonHbFragment.b(this.a)) && ((CommonHbFragment.a(this.a).getCurrentItem() != 2) || (!TextUtils.isEmpty(paramEditable))) && (((!"1".equals(CommonHbFragment.a(this.a))) && (!"7".equals(CommonHbFragment.a(this.a)))) || (CommonHbFragment.a(this.a).getCurrentItem() != 1) || (!TextUtils.isEmpty(paramEditable))))
    {
      if (!CommonHbFragment.a(this.a).isEnabled())
      {
        CommonHbFragment.a(this.a).setEnabled(true);
        CommonHbFragment.a(this.a).setClickable(true);
        CommonHbFragment.a(this.a, "hongbao.wrap.enable", "");
      }
      paramEditable = new StringBuffer();
      paramEditable.append("塞钱");
      if ("2".equals(CommonHbFragment.b(this.a)))
      {
        str = CommonHbFragment.b(this.a).getText().toString();
        CommonHbFragment.a(this.a, CommonHbFragment.a(this.a, str, "1"));
        paramEditable.append(CommonHbFragment.d(this.a));
        paramEditable.append("元");
        CommonHbFragment.a(this.a).setText(paramEditable.toString());
        label247:
        if (!TextUtils.isEmpty(CommonHbFragment.b(this.a).getText().toString())) {
          break label497;
        }
        CommonHbFragment.b(this.a).setGravity(19);
      }
    }
    for (;;)
    {
      if (CommonHbFragment.c(this.a) != null)
      {
        if (!TextUtils.isEmpty(CommonHbFragment.c(this.a).getText().toString())) {
          break label512;
        }
        CommonHbFragment.c(this.a).setGravity(19);
      }
      return;
      if (CommonHbFragment.c(this.a) == null)
      {
        str = CommonHbFragment.b(this.a).getText().toString();
        CommonHbFragment.a(this.a, CommonHbFragment.a(this.a, str, "1"));
        break;
      }
      CommonHbFragment.a(this.a, CommonHbFragment.a(this.a, CommonHbFragment.c(this.a), "1"));
      break;
      if (CommonHbFragment.a(this.a).isEnabled())
      {
        CommonHbFragment.a(this.a).setClickable(false);
        CommonHbFragment.a(this.a).setEnabled(false);
        CommonHbFragment.a(this.a, "hongbao.wrap.disable", "");
      }
      if ((CommonHbFragment.b(this.a) != null) && (CommonHbFragment.b(this.a).getText() != null)) {
        CommonHbFragment.a(this.a, CommonHbFragment.b(this.a).getText().toString());
      }
      CommonHbFragment.a(this.a).setText(2131365696);
      break label247;
      label497:
      CommonHbFragment.b(this.a).setGravity(21);
    }
    label512:
    CommonHbFragment.c(this.a).setGravity(21);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */