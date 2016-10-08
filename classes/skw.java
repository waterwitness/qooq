import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class skw
  implements Runnable
{
  public skw(ForwardBaseOption paramForwardBaseOption, Drawable paramDrawable, boolean paramBoolean, int paramInt)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a.setPreviewImage(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.m();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\skw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */