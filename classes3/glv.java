import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class glv
  implements Runnable
{
  public glv(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.c))
    {
      this.a.b = UITools.a(this.a.jdField_a_of_type_ComTencentAvVideoController.b());
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(UITools.a(this.a.b));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b);
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 2) {
          this.a.f.setText(this.a.b);
        }
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */