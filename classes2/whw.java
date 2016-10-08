import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class whw
  implements ActionSheet.OnButtonClickListener
{
  public whw(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.a.jdField_a_of_type_AndroidAppActivity, this.a.b);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369682);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    if (paramInt == 0) {
      if (TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)) {
        this.a.jdField_c_of_type_Int = 0;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.a.b(this.a.jdField_c_of_type_JavaLangString);
      continue;
      if (paramInt == 1)
      {
        if (TextUtils.isEmpty(this.a.jdField_c_of_type_JavaLangString)) {
          this.a.jdField_c_of_type_Int = 1;
        } else {
          this.a.a(this.a.jdField_c_of_type_JavaLangString);
        }
      }
      else if (paramInt == 2)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        this.a.c(this.a.jdField_c_of_type_JavaLangString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */