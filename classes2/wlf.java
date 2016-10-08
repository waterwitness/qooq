import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ContainerView;

public class wlf
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public wlf(ContainerView paramContainerView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    if (!ContainerView.a(this.a))
    {
      ContainerView.a(this.a, ContainerView.a);
      ContainerView.a(this.a, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */