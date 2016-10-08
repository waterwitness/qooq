import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class meg
  implements View.OnClickListener
{
  public meg(QQMapActivity paramQQMapActivity, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.l) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQMapActivity.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\meg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */