import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CircleProgress;

public class qsx
  implements Runnable
{
  public qsx(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.a.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText("0\"");
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.d.setVisibility(4);
    this.a.c.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
    this.a.e.setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */