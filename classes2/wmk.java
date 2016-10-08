import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ImageViewTouchBase;
import com.tencent.mobileqq.widget.RotateBitmap;

public class wmk
  implements Runnable
{
  public wmk(ImageViewTouchBase paramImageViewTouchBase, RotateBitmap paramRotateBitmap, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageViewTouchBase.setImageRotateBitmapResetBase(this.jdField_a_of_type_ComTencentMobileqqWidgetRotateBitmap, this.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */