import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ozc
  implements View.OnTouchListener
{
  public ozc(FlowCameraActivity2 paramFlowCameraActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    if (i == 0) {
      this.a.jdField_b_of_type_AndroidWidgetButton.setText(null);
    }
    do
    {
      return false;
      if (i == 2)
      {
        if (f < this.a.jdField_b_of_type_Int * -1)
        {
          this.a.a(false, false);
          return true;
        }
        this.a.a(true, false);
        return true;
      }
      if (i == 3)
      {
        this.a.a(false, true);
        return false;
      }
    } while (i != 1);
    if (f < this.a.jdField_b_of_type_Int * -1)
    {
      this.a.l = false;
      this.a.a(false, true);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidWidgetButton.setText(2131372291);
      return false;
      this.a.l = true;
      this.a.a(true, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ozc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */