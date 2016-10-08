import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qvg
  implements View.OnClickListener
{
  public qvg(BusinessCardEditActivity paramBusinessCardEditActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.a = null;
    }
    BusinessCardServlet.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.b("删除名片...");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */