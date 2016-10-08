import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PAVideoView;

public class wmy
  implements Runnable
{
  View jdField_a_of_type_AndroidViewView;
  PAVideoView jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView;
  
  public wmy(PAVideoView paramPAVideoView, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView = paramPAVideoView;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a(false);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */