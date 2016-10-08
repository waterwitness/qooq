import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.ui.GLVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gug
  implements Runnable
{
  public gug(GLVideoView paramGLVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    GLRootView localGLRootView = this.a.a();
    if (localGLRootView != null)
    {
      GLVideoView.e(this.a);
      localGLRootView.postDelayed(this.a.a, 80L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */