import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class bd
  implements View.OnTouchListener
{
  public bd(LiteActivity paramLiteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LiteActivity.jdField_a_of_type_JavaLangString, 2, "ontouch--fcc----: " + paramMotionEvent.getAction());
    }
    this.a.o();
    LiteActivity.a(this.a, false);
    this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.postDelayed(new be(this), 200L);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */