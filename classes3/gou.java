import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gou
  implements Runnable
{
  public gou(SmallScreenVideoControlUI paramSmallScreenVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.b))
    {
      this.a.d = UITools.a(this.a.jdField_a_of_type_ComTencentAvVideoController.b());
      if ((this.a.jdField_a_of_type_AndroidWidgetTextView != null) && (!this.a.c))
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(UITools.a(this.a.d));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.d);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */