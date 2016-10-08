import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hfd
  implements View.OnTouchListener
{
  public hfd(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.a.b();
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */