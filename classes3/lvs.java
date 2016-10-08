import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.ModifyTroopMemberCardActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lvs
  implements View.OnFocusChangeListener
{
  public lvs(ModifyTroopMemberCardActivity paramModifyTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramView == this.a.d))
    {
      paramView = this.a.d.getText().toString();
      if ((!TextUtils.isEmpty(paramView)) && (!SearchBaseActivity.a.matcher(paramView).matches())) {
        QQToast.a(this.a, this.a.getString(2131367948), 0).b(this.a.getTitleBarHeight());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */