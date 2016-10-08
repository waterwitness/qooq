import android.view.View;
import com.tencent.mobileqq.activity.aio.item.FrameAnimationActor;
import com.tencent.mobileqq.activity.aio.item.FrameAnimationActor.Listener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class njv
  implements Runnable
{
  public njv(FrameAnimationActor paramFrameAnimationActor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if ((this.a.jdField_a_of_type_Int == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener.a();
      }
      if (this.a.jdField_a_of_type_Int < this.a.jdField_a_of_type_ArrayOfInt.length) {
        break;
      }
      this.a.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.a.jdField_a_of_type_ArrayOfInt[this.a.b]);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener == null);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener.b();
    return;
    this.a.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.a.jdField_a_of_type_ArrayOfInt[this.a.jdField_a_of_type_Int]);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemFrameAnimationActor$Listener.a(this.a.jdField_a_of_type_Int);
    }
    this.a.jdField_a_of_type_AndroidViewView.postDelayed(FrameAnimationActor.a(this.a), this.a.c);
    FrameAnimationActor localFrameAnimationActor = this.a;
    localFrameAnimationActor.jdField_a_of_type_Int += 1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\njv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */