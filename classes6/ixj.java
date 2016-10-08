import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ixj
  implements View.OnTouchListener
{
  private final int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public ixj(EditTextDialog paramEditTextDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 10;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    float f = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return false;
        this.b = ((int)f);
        this.jdField_a_of_type_Boolean = false;
        return false;
      } while (Math.abs(f - this.b) <= 10.0F);
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */