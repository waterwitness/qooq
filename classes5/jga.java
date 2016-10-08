import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import com.tencent.biz.ui.PopupWindows;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jga
  implements View.OnTouchListener
{
  public jga(PopupWindows paramPopupWindows)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */