import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQToast;

public class wim
  implements TroopMemberApiClient.Callback
{
  public wim(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler, QQBrowserActivity paramQQBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    boolean bool;
    if (paramBundle.getInt("type") == 73)
    {
      bool = paramBundle.getBoolean("isSuccess");
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isFinishing()) || (!this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.i)) {}
    }
    else
    {
      return;
    }
    if (Boolean.valueOf(bool).booleanValue())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), 2, 2131367457, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), 1, 2131367458, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */