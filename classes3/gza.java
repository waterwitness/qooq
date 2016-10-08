import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gza
  implements Runnable
{
  public gza(VideoControlUI paramVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.l))
    {
      this.a.w = UITools.a(this.a.jdField_a_of_type_ComTencentAvVideoController.b());
      Object localObject = this.a;
      ((VideoControlUI)localObject).t += 1;
      if ((this.a.h != null) && (!this.a.n))
      {
        localObject = UITools.a(this.a.w);
        this.a.h.setContentDescription((CharSequence)localObject);
        this.a.e((String)localObject);
        this.a.w = this.a.a(this.a.w);
        if (!this.a.o)
        {
          this.a.h.setText(this.a.w);
          this.a.d(this.a.w);
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar != null) {
            this.a.jdField_a_of_type_ComTencentAvUiVideoNetStateBar.a(this.a.w);
          }
        }
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */