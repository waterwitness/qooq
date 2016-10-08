import android.os.Handler;
import android.os.Message;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PaFlashLightView;
import java.lang.ref.WeakReference;

public class wnc
  extends Handler
{
  private WeakReference a;
  
  public wnc(PaFlashLightView paramPaFlashLightView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramPaFlashLightView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (PaFlashLightView)this.a.get();
    if (paramMessage == null) {
      return;
    }
    switch (paramMessage.jdField_c_of_type_Int)
    {
    default: 
      return;
    case 0: 
      paramMessage.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (paramMessage.jdField_a_of_type_Boolean)
      {
        paramMessage.startAnimation(paramMessage.jdField_a_of_type_AndroidViewAnimationAnimation);
        return;
      }
      paramMessage.startAnimation(paramMessage.jdField_c_of_type_AndroidViewAnimationAnimation);
      return;
    case 1: 
      paramMessage.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (paramMessage.jdField_a_of_type_Boolean)
      {
        paramMessage.jdField_b_of_type_ComTencentImageURLImageView.startAnimation(paramMessage.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
      }
      paramMessage.jdField_b_of_type_ComTencentImageURLImageView.startAnimation(paramMessage.jdField_c_of_type_AndroidViewAnimationAnimation);
      return;
    }
    paramMessage.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (paramMessage.jdField_a_of_type_Boolean)
    {
      paramMessage.jdField_c_of_type_ComTencentImageURLImageView.startAnimation(paramMessage.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
    }
    paramMessage.jdField_c_of_type_ComTencentImageURLImageView.startAnimation(paramMessage.jdField_c_of_type_AndroidViewAnimationAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wnc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */