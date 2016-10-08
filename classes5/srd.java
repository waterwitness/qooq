import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.freshnews.MyFreshNewsFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.flat.async.AsyncFlatElementFactory;
import com.tencent.mobileqq.nearby.flat.async.UIElementCache;

public class srd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public srd(MyFreshNewsFragment paramMyFreshNewsFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    AsyncFlatElementFactory.a(MyFreshNewsFragment.a(this.a).getContext(), MyFreshNewsFragment.a(this.a).getWidth() - MyFreshNewsFragment.a(this.a).getPaddingLeft() + MyFreshNewsFragment.a(this.a).getPaddingRight());
    NearbyAppInterface.a.evictAll();
    MyFreshNewsFragment.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\srd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */