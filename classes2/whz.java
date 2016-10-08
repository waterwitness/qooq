import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class whz
  implements Runnable
{
  whz(why paramwhy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QQToast.a(this.a.a.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), 1, 2131364460, 1).b(this.a.a.b);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */