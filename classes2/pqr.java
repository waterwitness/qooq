import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.apollo.GLTextureView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pqr
  implements View.OnLayoutChangeListener
{
  public pqr(GLTextureView paramGLTextureView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.a(this.a.getSurfaceTexture(), 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pqr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */