import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pdj
  implements View.OnTouchListener
{
  public pdj(PtvTemplateItemView paramPtvTemplateItemView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.a.a.setAlpha(0.5F);
    }
    for (;;)
    {
      return false;
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
        this.a.a.setAlpha(1.0F);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */