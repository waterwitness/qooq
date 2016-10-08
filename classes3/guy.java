import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class guy
  implements Runnable
{
  public guy(MultiIncomingCallsActivity paramMultiIncomingCallsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = this.a.b;
    String str1 = Long.toString(this.a.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.e(MultiIncomingCallsActivity.jdField_a_of_type_JavaLangString, 2, "GetDiscussFaceRunnable");
    }
    Bitmap localBitmap = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, String.valueOf(l), null, true, false);
    String str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, str1, String.valueOf(this.a.b));
    if ((localBitmap != null) && (!str2.equals(str1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(MultiIncomingCallsActivity.jdField_a_of_type_JavaLangString, 2, "GetDiscussFaceRunnable bitmap OK");
      }
      if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      }
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1500L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\guy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */