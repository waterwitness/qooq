import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.recent.RecentCallItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oxq
  implements View.OnTouchListener
{
  public oxq(RecentCallItemBuilder paramRecentCallItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getTag() instanceof View))
    {
      paramView = (View)paramView.getTag();
      if (paramMotionEvent.getAction() != 0) {
        break label32;
      }
      paramView.setPressed(true);
    }
    label32:
    while (1 != paramMotionEvent.getAction()) {
      return false;
    }
    paramView.setPressed(false);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oxq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */