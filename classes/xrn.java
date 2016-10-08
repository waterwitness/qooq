import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;

public class xrn
  implements Runnable
{
  public xrn(AbsListView paramAbsListView, View paramView, xry paramxry)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.ag = -1;
    this.jdField_a_of_type_AndroidViewView.setPressed(false);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.setPressed(false);
    if (!this.jdField_a_of_type_ComTencentWidgetAbsListView.r) {
      this.jdField_a_of_type_Xry.run();
    }
    AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xrn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */