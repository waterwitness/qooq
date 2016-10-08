import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class pej
  implements Runnable
{
  public pej(CameraGLSurfaceView paramCameraGLSurfaceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    CameraGLSurfaceView.a(this.a).sendFirstFrameMsg();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */