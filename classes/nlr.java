import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nlr
  implements DialogInterface.OnClickListener
{
  public nlr(LongMsgItemBuilder paramLongMsgItemBuilder, MessageForLongMsg paramMessageForLongMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLongMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nlr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */