import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQMapView;

public class her
  implements ViewTreeObserver.OnPreDrawListener
{
  public her(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onPreDraw()
  {
    this.a.r = PoiMapActivity.e(this.a).getMeasuredHeight();
    PoiMapActivity.a(this.a, PoiMapActivity.a(this.a).getMeasuredHeight());
    if ((this.a.r > 0) && (PoiMapActivity.a(this.a) > 0))
    {
      PoiMapActivity.a(this.a, (this.a.r - PoiMapActivity.b(this.a)) / 2 + this.a.w, false);
      PoiMapActivity.f(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
      PoiMapActivity.b(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\her.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */