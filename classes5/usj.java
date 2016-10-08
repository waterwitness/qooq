import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface;

public class usj
  implements Runnable
{
  public usj(OffScreenGLSurface paramOffScreenGLSurface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    OffScreenGLSurface.a(this.a).sendFirstFrameMsg();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */