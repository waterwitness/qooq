import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.dataline.activities.DLRouterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class l
  implements View.OnTouchListener
{
  public l(DLRouterActivity paramDLRouterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837560);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */