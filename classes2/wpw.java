import android.content.res.Resources;
import android.widget.Button;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.AuthorityActivity;

public class wpw
  implements Runnable
{
  public wpw(AuthorityActivity paramAuthorityActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.a.jdField_v_of_type_Int == 0) {
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131369833);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.a.a(this.a.getResources().getString(2131369830), new wpx(this));
      return;
      if (this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse == null) {
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.w);
      } else {
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.jdField_v_of_type_JavaLangString);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */