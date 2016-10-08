import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class par
  implements Runnable
{
  public par(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.removeCallbacks(this.a.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\par.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */