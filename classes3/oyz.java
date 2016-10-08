import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class oyz
  implements Runnable
{
  public oyz(FlowCameraActivity2 paramFlowCameraActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.b != null) && (!this.a.b.isEnabled()))
    {
      this.a.b.setEnabled(true);
      this.a.b.setText(2131372290);
      this.a.b.setTextColor(-15550475);
    }
    int i = 0;
    if (this.a.a != null) {
      i = this.a.a.c();
    }
    if ((!this.a.i.isEnabled()) && (i > 0)) {
      this.a.i.setEnabled(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */