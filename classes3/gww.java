import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gww
  implements Runnable
{
  public gww(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = "QQ电话";
    if (this.a.jdField_c_of_type_Int == 2) {
      localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, String.valueOf(this.a.jdField_a_of_type_Long), null);
    }
    for (;;)
    {
      this.a.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = this.a;
      ((MultiVideoEnterPageActivity)localObject).g += 1;
      if (this.a.d != null)
      {
        if (this.a.g >= 3) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.d, 1000L);
      }
      return;
      if (this.a.jdField_c_of_type_Int == 1) {
        localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, String.valueOf(this.a.jdField_a_of_type_Long), null);
      }
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.d);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */