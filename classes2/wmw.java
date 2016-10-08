import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PAVideoView;

public class wmw
  implements Runnable
{
  public wmw(PAVideoView paramPAVideoView, ImageView paramImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839555);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */