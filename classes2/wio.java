import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.qphone.base.util.QLog;

public class wio
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public wio(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    int i = this.jdField_a_of_type_AndroidViewView.getRootView().getHeight() - localRect.height();
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "heightDiff:" + i);
    }
    if (i > 150)
    {
      SwiftBrowserShareMenuHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler, true);
      SwiftBrowserShareMenuHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler, false, 0);
    }
    while (!SwiftBrowserShareMenuHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler)) {
      return;
    }
    SwiftBrowserShareMenuHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserShareMenuHandler, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */