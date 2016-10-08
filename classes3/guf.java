import com.tencent.av.opengl.texture.YUVTexture.GLRenderListener;
import com.tencent.av.ui.GLVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class guf
  implements YUVTexture.GLRenderListener
{
  public guf(GLVideoView paramGLVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    GLVideoView.a(this.a);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoView", 2, "onRenderInfoNotify width: " + paramInt1 + ", height: " + paramInt2 + ", angle: " + paramInt3);
    }
    GLVideoView.d(this.a);
  }
  
  public void b()
  {
    GLVideoView.b(this.a);
  }
  
  public void c()
  {
    GLVideoView.c(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\guf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */