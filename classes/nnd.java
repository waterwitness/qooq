import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.PokeItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PokeItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class nnd
  implements Runnable
{
  public nnd(PokeItemBuilder paramPokeItemBuilder, PokeItemBuilder.Holder paramHolder, Drawable paramDrawable, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, MessageForPoke paramMessageForPoke)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder$Holder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder$Holder.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder$Holder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder$Holder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder$Holder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder$Holder.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder.a.remove(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder.b.a().c(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
    }
    if (QLog.isColorLevel()) {
      QLog.d("poke", 2, "refreshUI isPlaying =false！！！pos=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder$Holder.jdField_b_of_type_Int);
    }
    PokeItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder$Holder.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder$Holder.jdField_a_of_type_AndroidViewView.requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */