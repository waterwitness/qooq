package com.tencent.av.opengl.widgets;

import android.content.Context;
import android.view.Surface;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.texture.GLSurfaceTexture;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GLSurfaceTextureView
  extends GLView
{
  public GLSurfaceTextureView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    super.a(new GLSurfaceTexture());
  }
  
  public Surface a()
  {
    return ((GLSurfaceTexture)this.d).a();
  }
  
  protected void b(GLCanvas paramGLCanvas)
  {
    super.b(paramGLCanvas);
  }
  
  public void d(GLCanvas paramGLCanvas)
  {
    ((GLSurfaceTexture)this.d).a(paramGLCanvas);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\opengl\widgets\GLSurfaceTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */