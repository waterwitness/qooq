import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class xti
  implements Runnable
{
  public xti(GestureSelectGridView paramGestureSelectGridView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if ((!this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.a.jdField_b_of_type_Int != -1))
    {
      if (this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener != null) {
        this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$OnSelectListener.b(this.a.jdField_b_of_type_Int);
      }
      this.a.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */