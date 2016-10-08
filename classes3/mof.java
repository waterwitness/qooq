import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class mof
  implements ActionSheet.OnButtonClickListener
{
  public mof(SubLoginActivity paramSubLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.b) {
      return;
    }
    if (paramInt == 0)
    {
      paramView = new Intent(this.a, QQBrowserActivity.class);
      paramView.putExtra("uin", SubLoginActivity.a(this.a));
      paramView.putExtra("reqType", 3);
      paramView.putExtra("url", "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756");
      this.a.startActivity(paramView);
    }
    for (;;)
    {
      this.a.b = true;
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (paramInt == 1)
      {
        paramView = new Intent(this.a, LoginPhoneNumActivity.class);
        paramView.putExtra("isSubaccount", true);
        paramView.putExtra("fromWhere", this.a.jdField_a_of_type_JavaLangString);
        this.a.startActivity(paramView);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mof.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */