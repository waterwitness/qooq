import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.smallscreen.PstnSmallScreenService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class goa
  implements Runnable
{
  public goa(PstnSmallScreenService paramPstnSmallScreenService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131364012);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b = 2;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\goa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */