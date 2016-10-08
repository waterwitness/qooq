import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nqd
  implements Runnable
{
  public nqd(StructingMsgItemBuilder paramStructingMsgItemBuilder, StructingMsgItemBuilder.StructingMsgViewHolder paramStructingMsgViewHolder, Animation paramAnimation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder.a.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$StructingMsgViewHolder.a.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */