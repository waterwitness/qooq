import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class leq
  implements View.OnFocusChangeListener
{
  public leq(DetailProfileActivity paramDetailProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramView != DetailProfileActivity.a(this.a)) {
        break label68;
      }
      paramView = DetailProfileActivity.a(this.a).getText().toString();
      if ((TextUtils.isEmpty(paramView)) || (!TextUtils.isEmpty(paramView.trim()))) {}
    }
    label68:
    do
    {
      QQToast.a(this.a, "昵称不可以为空", 0).b(this.a.getTitleBarHeight());
      do
      {
        return;
      } while (paramView != DetailProfileActivity.d(this.a));
      paramView = DetailProfileActivity.d(this.a).getText().toString();
    } while ((TextUtils.isEmpty(paramView)) || (SearchBaseActivity.a.matcher(paramView).matches()));
    QQToast.a(this.a, "邮箱格式不正确", 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\leq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */