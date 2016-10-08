import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CustomedTabWidget;

public class wlv
  implements View.OnTouchListener
{
  public wlv(CustomedTabWidget paramCustomedTabWidget)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      i = 0;
      if (i < this.a.getChildCount())
      {
        if (this.a.getChildAt(i) != paramView) {
          break label57;
        }
        this.a.jdField_a_of_type_Int = i;
        this.a.jdField_a_of_type_Boolean = true;
        this.a.invalidate();
      }
    }
    label57:
    while (paramMotionEvent.getAction() != 1) {
      for (;;)
      {
        int i;
        return false;
        i += 1;
      }
    }
    this.a.jdField_a_of_type_Boolean = false;
    this.a.invalidate();
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wlv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */