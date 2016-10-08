import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV;
import com.tencent.util.InputMethodUtil;

public class tjv
  implements View.OnKeyListener
{
  public tjv(ChooseInterestTagActivity paramChooseInterestTagActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0)) {
      if (ChooseInterestTagActivity.a(this.a).getText() == null)
      {
        paramView = "";
        if (TextUtils.isEmpty(paramView))
        {
          ChooseInterestTagActivity.a(this.a).fullScroll(66);
          ChooseInterestTagActivity.a(this.a, ChooseInterestTagActivity.d(this.a) + 1);
        }
      }
    }
    for (;;)
    {
      return false;
      paramView = ChooseInterestTagActivity.a(this.a).getText().toString();
      break;
      if ((paramInt == 66) && (paramKeyEvent.getAction() == 0)) {
        InputMethodUtil.b(ChooseInterestTagActivity.a(this.a));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */