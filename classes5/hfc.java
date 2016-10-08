import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hfc
  implements View.OnTouchListener
{
  public hfc(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null) {
      this.a.a.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */