import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import java.util.List;

public class uxw
  implements Runnable
{
  public uxw(SpriteGLView paramSpriteGLView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Texture.d();
    int i = 0;
    while (i < SpriteGLView.a(this.a).size())
    {
      ((Sprite)SpriteGLView.a(this.a).get(i)).b();
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */