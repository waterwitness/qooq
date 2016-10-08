import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class at
  implements View.OnTouchListener
{
  public at(LiteActivity paramLiteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      LiteActivity.a(this.a).x = paramMotionEvent.getRawX();
      LiteActivity.a(this.a).y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */