import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class wic
  implements Runnable
{
  public wic(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 2, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.jdField_a_of_type_AndroidAppActivity.getString(2131364459, new Object[] { this.jdField_a_of_type_JavaLangString }), 1).b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserLongClickHandler.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */