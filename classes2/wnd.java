import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PagingScrollView;
import com.tencent.qphone.base.util.QLog;

public class wnd
  implements View.OnTouchListener
{
  public wnd(PagingScrollView paramPagingScrollView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.c)
    {
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 3))
      {
        this.a.c = false;
        this.a.getParent().requestDisallowInterceptTouchEvent(false);
        if (QLog.isDevelopLevel()) {
          QLog.i("PageScrollView", 4, "C.TE ACT_UP or CANCEL");
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */