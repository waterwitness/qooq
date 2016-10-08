import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper.AppInfo;
import com.tencent.mobileqq.ark.DispatchTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nib
  extends GestureDetector.SimpleOnGestureListener
{
  public nib(ArkContainerWrapper paramArkContainerWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentArkArk$Container == null) {
      return false;
    }
    int i = (int)(paramMotionEvent.getX() / this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.a);
    int j = (int)(paramMotionEvent.getY() / this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkContainerWrapper$AppInfo.a);
    this.a.jdField_a_of_type_ComTencentMobileqqArkDispatchTask.a(new nic(this, i, j));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */