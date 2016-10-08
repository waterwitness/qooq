import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.widget.ActionSheet;

public class wij
  implements View.OnClickListener
{
  public wij(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (SwiftBrowserShareMenuHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler).isShowing()) {
        SwiftBrowserShareMenuHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler).dismiss();
      }
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler.a.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler.a.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wij.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */