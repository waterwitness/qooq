import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pbd
  implements Runnable
{
  public pbd(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a != null) && (!this.a.a.isEnabled())) {
      this.a.a.setEnabled(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */