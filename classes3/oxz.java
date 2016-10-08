import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oxz
  implements View.OnTouchListener
{
  public oxz(RecentT9SearchActivity paramRecentT9SearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (EditText)paramView;
    int i = paramView.getInputType();
    paramView.setInputType(0);
    paramView.onTouchEvent(paramMotionEvent);
    paramView.setInputType(i);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */