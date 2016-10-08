import android.widget.TextView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CircleProgress;

public class qsz
  implements Runnable
{
  public qsz(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int / 1000;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("\"");
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(this.jdField_a_of_type_Int / 80);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */