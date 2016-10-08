import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gyz
  implements Runnable
{
  public gyz(VideoControlUI paramVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      String str = this.a.jdField_a_of_type_ComTencentAvVideoController.b();
      if (str == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoControlUI", 2, "can not get shape info");
        }
        return;
      }
      if (this.a.m != null) {
        this.a.m.setText(str);
      }
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */