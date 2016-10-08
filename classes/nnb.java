import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.PokeItemBuilder;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nnb
  implements DialogInterface.OnClickListener
{
  public nnb(PokeItemBuilder paramPokeItemBuilder, MessageForPoke paramMessageForPoke)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.uniseq);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */