import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CustomAlertDialog;
import com.tencent.mobileqq.widget.CustomAlertDialog.OnOptionMenuClick;
import java.util.HashMap;
import java.util.List;

class wlp
  implements View.OnClickListener
{
  wlp(wlo paramwlo, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Wlo.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.a != null) {
      this.jdField_a_of_type_Wlo.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.a.a(((Integer)((HashMap)this.jdField_a_of_type_Wlo.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).get("commandId")).intValue());
    }
    this.jdField_a_of_type_Wlo.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */