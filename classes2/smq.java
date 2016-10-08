import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.fragment.FreshNewsFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.flat.async.AsyncFlatElementFactory;
import com.tencent.mobileqq.nearby.flat.async.UIElementCache;
import com.tencent.mobileqq.nearby.smooth.AsyncListView;

public class smq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public smq(FreshNewsFragment paramFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    AsyncFlatElementFactory.a(this.a.a.getContext(), this.a.a.getWidth() - this.a.a.getPaddingLeft() + this.a.a.getPaddingRight());
    NearbyAppInterface.a.evictAll();
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\smq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */