import android.graphics.SurfaceTexture;
import com.hiar.sdk.HSARToolkit;
import com.hiar.sdk.renderer.CameraRenderer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ahg
  implements Runnable
{
  public ahg(CameraRenderer paramCameraRenderer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (CameraRenderer.a(this.a) != null) {
        while (HSARToolkit.a().c > HSARToolkit.a().b)
        {
          HSARToolkit localHSARToolkit = HSARToolkit.a();
          localHSARToolkit.b += 1L;
          CameraRenderer.a(this.a).updateTexImage();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ahg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */