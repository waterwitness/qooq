import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class snq
  implements View.OnClickListener
{
  public snq(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((NetworkUtil.e(BaseApplication.getContext())) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing()))
    {
      MineFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      if ((this.a.b != null) && (this.a.b.isShowing())) {
        this.a.b.dismiss();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
    }
    do
    {
      return;
      QQToast.a(BaseApplication.getContext(), 1, this.a.getString(2131367481), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
    } while ((this.a.b == null) || (!this.a.b.isShowing()));
    this.a.b.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */