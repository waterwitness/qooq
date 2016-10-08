import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class snk
  implements View.OnClickListener
{
  public snk(MineFragment paramMineFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((NetworkUtil.e(BaseApplication.getContext())) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
    {
      MineFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
    }
    do
    {
      return;
      QQToast.a(BaseApplication.getContext(), 1, this.a.getString(2131367481), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
    } while ((this.a.jdField_a_of_type_AndroidAppDialog == null) || (!this.a.jdField_a_of_type_AndroidAppDialog.isShowing()));
    this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */