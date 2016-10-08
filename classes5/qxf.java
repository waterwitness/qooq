import com.tencent.mobileqq.businessCard.views.BusinessCardChildView;
import com.tencent.mobileqq.businessCard.views.BusinessCardView;
import com.tencent.mobileqq.businessCard.views.BusinessCardView.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class qxf
  implements Runnable
{
  public qxf(BusinessCardView paramBusinessCardView, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    BusinessCardChildView localBusinessCardChildView = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView$Callback.a().get(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsBusinessCardView.jdField_a_of_type_Int));
    if (localBusinessCardChildView != null) {
      localBusinessCardChildView.setFocusedTask(this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qxf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */