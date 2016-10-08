import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.OvalProgress;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.QfavMicroPhoneDialog;

public class ygz
  extends Handler
{
  public ygz(QfavMicroPhoneDialog paramQfavMicroPhoneDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 8: 
    case 10: 
    default: 
      return;
    case 7: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetOvalProgress.setProgressParams(0L, 0L);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841076);
      return;
    case 9: 
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841076);
      return;
    case 11: 
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(Integer.toString((int)Math.round(this.a.f * 1.0D / 1000.0D)) + "\"");
      return;
    }
    QfavUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 2131365967, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ygz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */