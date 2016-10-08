import android.hardware.Camera;
import com.hiar.sdk.camera.CameraPreviewHandler;
import com.tencent.mobileqq.ar.ARFragment;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qop
  implements Runnable
{
  public qop(ARFragment paramARFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.a)
    {
      if (ARFragment.a(this.a) != null) {
        if (ARFragment.a(this.a) != null) {
          ARFragment.a(this.a).a();
        }
      }
      try
      {
        ARFragment.b(this.a);
        ARFragment.a(this.a).release();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          ARFragment.a(this.a, null);
        }
        localObject1 = finally;
        throw ((Throwable)localObject1);
      }
      finally
      {
        ARFragment.a(this.a, null);
      }
      if (this.a.a != null) {
        this.a.a.requestRender();
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */