import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.widget.HorizontalScrollLayout;

public class vey
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public vey(NearbyTroopsView paramNearbyTroopsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    if (this.a.G == -1) {
      return;
    }
    View localView = this.a.a.getChildAt(this.a.G + 2);
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      this.a.a.a(this.a.G, 2);
      return;
    }
    this.a.a.a(this.a.G, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */