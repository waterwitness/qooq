import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class gkc
  implements Comparator
{
  public gkc(GLViewGroup paramGLViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(GLView paramGLView1, GLView paramGLView2)
  {
    if (paramGLView1.i() >= paramGLView2.i()) {
      return 1;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */