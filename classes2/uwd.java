import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.qphone.base.util.QLog;

public class uwd
  implements View.OnTouchListener
{
  public uwd(StructMsgItemLayout12 paramStructMsgItemLayout12, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout12.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout12.b = true;
        ObjectAnimator localObjectAnimator = (ObjectAnimator)paramView.getTag(2131296552);
        paramMotionEvent = localObjectAnimator;
        if (localObjectAnimator == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("StructMsgItemLayout12", 2, "animator is null");
          }
          paramMotionEvent = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scaleX", new float[] { 0.9F }), PropertyValuesHolder.ofFloat("scaleY", new float[] { 0.95F }) });
          paramMotionEvent.setInterpolator(new DecelerateInterpolator(2.0F));
          paramMotionEvent.setDuration(100L);
          paramView.setTag(2131296552, paramMotionEvent);
        }
        paramMotionEvent.start();
      }
      return true;
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout12.a.onClick(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout12.b = false;
      paramView = (ObjectAnimator)paramView.getTag(2131296552);
      if (paramView != null) {
        paramView.reverse();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uwd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */