import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class imw
  implements View.OnTouchListener
{
  public imw(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (ViewPager)this.a.getParent();
    int i = paramMotionEvent.getAction();
    if ((i == 3) || (i == 1))
    {
      paramView.requestDisallowInterceptTouchEvent(false);
      return true;
    }
    paramView.requestDisallowInterceptTouchEvent(true);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */