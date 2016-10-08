import android.widget.Button;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper.CameraHelperCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class qwl
  implements CameraHelper.CameraHelperCallback
{
  public qwl(FlowCameraPhotoActivity paramFlowCameraPhotoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    this.a.e = paramString;
    if (this.a.e != null)
    {
      paramString = new File(this.a.e);
      this.a.d = false;
      this.a.a(paramString, true);
      return;
    }
    this.a.a.setClickable(true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */