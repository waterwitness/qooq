import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.SoftInputResizeLayout;

public class xvy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public xvy(SoftInputResizeLayout paramSoftInputResizeLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    SoftInputResizeLayout.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */