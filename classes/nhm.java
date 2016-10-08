import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.item.AnimationTopGestureLayout;
import com.tencent.mobileqq.activity.aio.item.BitmapAnimTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nhm
  implements Runnable
{
  public nhm(AnimationTopGestureLayout paramAnimationTopGestureLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask == null) {
      return;
    }
    int i = (int)(SystemClock.uptimeMillis() - AnimationTopGestureLayout.a(this.a));
    if (i > this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask.jdField_a_of_type_Float) {
      if (AnimationTopGestureLayout.a(this.a))
      {
        AnimationTopGestureLayout.a(this.a);
        if (AnimationTopGestureLayout.b(this.a) > 0)
        {
          AnimationTopGestureLayout.a(this.a, SystemClock.uptimeMillis() + AnimationTopGestureLayout.c(this.a) - 1L);
          AnimationTopGestureLayout.a(this.a, true);
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, AnimationTopGestureLayout.c(this.a));
        }
      }
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask != null)
    {
      this.a.invalidate(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask.jdField_a_of_type_AndroidGraphicsRect);
      return;
      this.a.a(false);
      continue;
      this.a.a(false);
      continue;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemBitmapAnimTask.a(i);
      AnimationTopGestureLayout.a(this.a, false);
      if (AnimationTopGestureLayout.a(this.a)) {
        this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 8L);
      }
    }
    this.a.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nhm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */