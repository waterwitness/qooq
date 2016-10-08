import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.IphoneTreeView;

public class wmm
  implements View.OnTouchListener
{
  public wmm(IphoneTreeView paramIphoneTreeView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      bool = false;
    }
    do
    {
      return bool;
      paramView.setPressed(true);
      this.a.invalidate();
      return true;
      paramView.setPressed(false);
      this.a.invalidate();
      break;
    } while (!paramView.isPressed());
    paramView.setPressed(false);
    this.a.collapseGroup(this.a.jdField_a_of_type_Int);
    this.a.setSelectedGroup(this.a.jdField_a_of_type_Int);
    this.a.jdField_a_of_type_AndroidViewView = null;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */