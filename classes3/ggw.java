import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.av.camera.VcCamera;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ggw
  implements Camera.AutoFocusCallback
{
  public ggw(VcCamera paramVcCamera)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AndroidCamera", 2, "camera focus success ? " + paramBoolean);
    }
    GraphicRenderMgr.getInstance().setIsFocusing(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */