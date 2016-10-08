import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;

public class vlb
  implements View.OnClickListener
{
  public vlb(TroopWebviewPlugin paramTroopWebviewPlugin, String paramString, IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopBrowserTroopWebviewPlugin.a(this.jdField_a_of_type_JavaLangString, "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vlb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */