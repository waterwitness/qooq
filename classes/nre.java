import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nre
  implements View.OnTouchListener
{
  public nre(TroopGiftMsgItemBuilder paramTroopGiftMsgItemBuilder, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener.onTouch(paramView, paramMotionEvent);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */