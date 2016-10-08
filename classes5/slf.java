import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.forward.ForwardMarketFaceOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class slf
  implements Runnable
{
  public slf(ForwardMarketFaceOption paramForwardMarketFaceOption, QQCustomDialog paramQQCustomDialog, URLDrawable paramURLDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage(this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new slg(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\slf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */