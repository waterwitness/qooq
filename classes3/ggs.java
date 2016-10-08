import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ggs
  implements Runnable
{
  public ggs(CameraUtils paramCameraUtils)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "WL_DEBUG NoPreviewRunnable.run");
    }
    this.a.a.a().a(new Object[] { Integer.valueOf(38), Integer.valueOf(2) });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */