import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicInteger;

public class ozz
  implements Runnable
{
  static final int jdField_a_of_type_Int = 32;
  static final int b = 4;
  boolean jdField_a_of_type_Boolean;
  final int[] jdField_a_of_type_ArrayOfInt;
  int c;
  
  public ozz(FlowCameraActivity2 paramFlowCameraActivity2, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 255, 191, 127, 63, 0, 63, 127, 191 };
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.c = paramFlowCameraActivity2.a.a;
    this.c %= 32;
  }
  
  public void run()
  {
    Drawable[] arrayOfDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.b.getCompoundDrawables();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.x();
    }
    if (arrayOfDrawable[0] != null) {
      arrayOfDrawable[0].setAlpha(this.jdField_a_of_type_ArrayOfInt[(this.c / 4)]);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a.b.get() == 2) && (arrayOfDrawable[0] != null))
    {
      arrayOfDrawable[0].setAlpha(255);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.a(arrayOfDrawable[0], -1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ozz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */