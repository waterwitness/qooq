import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

public class nph
  implements DialogInterface.OnClickListener
{
  public nph(StructingMsgItemBuilder paramStructingMsgItemBuilder, MessageForStructing paramMessageForStructing)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.source_puin != null) && (!"".equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.source_puin))) {
      localBundle.putString("source_puin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.source_puin);
    }
    localBundle.putInt("forward_type", -3);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.mCommentText = null;
    localBundle.putInt("structmsg_service_id", this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.mMsgServiceID);
    localBundle.putByteArray("stuctmsg_bytes", this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.getBytes());
    localBundle.putLong("structmsg_uniseq", this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq);
    localBundle.putInt("accostType", this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.sourceAccoutType);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.a, localIntent, 21);
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */