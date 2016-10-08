import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ToastUtil;

public class wuc
  implements Runnable
{
  public wuc(ToastUtil paramToastUtil, View paramView, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b == null)
    {
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b = new Toast(CommonDataAdapter.a().a());
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setDuration(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.show();
      return;
    }
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.setDuration(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentOpenBaseToastUtil.b.show();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */