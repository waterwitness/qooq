import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.SwitchAccountActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class wrw
  implements View.OnTouchListener
{
  protected GestureDetector.SimpleOnGestureListener a;
  protected GestureDetector a;
  View jdField_a_of_type_AndroidViewView;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public wrw(SwitchAccountActivity paramSwitchAccountActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new wrx(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("AccountManage", 2, "action = " + i);
    }
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      if (this.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.a == true) {
        this.jdField_a_of_type_ComTencentOpenAgentSwitchAccountActivity.a = false;
      }
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wrw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */