import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pcg
  implements Runnable
{
  public pcg(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (NewFlowCameraActivity.a(this.a)) {
      NewFlowCameraActivity.b(this.a).setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */