import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class kpy
  implements Runnable
{
  public kpy(BaseChatPie paramBaseChatPie, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.setEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= this.jdField_a_of_type_Int;
    ((Rect)localObject).bottom += this.b;
    ((Rect)localObject).left -= this.c;
    ((Rect)localObject).right += this.d;
    if (QLog.isColorLevel()) {
      QLog.d("TouchDelegate", 2, " bounds.top=" + ((Rect)localObject).top + "bounds.bottom=" + ((Rect)localObject).bottom);
    }
    localObject = new TouchDelegate((Rect)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a);
    if (View.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getParent())) {
      ((View)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kpy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */