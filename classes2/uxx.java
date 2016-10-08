import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.gl.Label;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class uxx
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Label jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel;
  
  private uxx(SpriteGLView paramSpriteGLView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    synchronized (SpriteGLView.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView))
    {
      if (!SpriteGLView.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).isEmpty()) {
        ((Runnable)SpriteGLView.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).remove(0)).run();
      }
    }
    paramGL10.glViewport(0, 0, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getHeight());
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    paramGL10.glClear(16384);
    paramGL10.glMatrixMode(5889);
    paramGL10.glEnable(3042);
    paramGL10.glDisable(2929);
    paramGL10.glBlendFunc(1, 771);
    int i = 0;
    while (i < SpriteGLView.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).size())
    {
      ((Sprite)SpriteGLView.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).get(i)).a(paramGL10, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getHeight());
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.a)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int >= 5)
      {
        i = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        ??? = String.format("fps: %.1f", new Object[] { Float.valueOf(this.jdField_a_of_type_Int * 1000.0F / i) });
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, (String)???);
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.a(paramGL10, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getHeight());
    }
    paramGL10.glDisable(3042);
    paramGL10.glFinish();
    paramGL10.glFlush();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.jdField_a_of_type_Float = ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.jdField_b_of_type_Int - paramInt1) / 2 + 50);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.jdField_b_of_type_Float = ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.c - paramInt2) / 2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel = new Label(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "fps:", -1, 40);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */