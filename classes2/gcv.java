import android.widget.Button;
import android.widget.ImageView;
import com.tencent.arrange.ui.AVMeetingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gcv
  implements Runnable
{
  public gcv(AVMeetingActivity paramAVMeetingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838983);
      if (this.a.jdField_a_of_type_AndroidWidgetButton != null) {
        this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */