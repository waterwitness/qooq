import android.app.Activity;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.SubscribeRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import mqq.app.NewIntent;

public class npp
  implements PopupMenuDialog.OnClickActionListener
{
  public npp(StructingMsgItemBuilder paramStructingMsgItemBuilder, ChatMessage paramChatMessage, Activity paramActivity, AbsStructMsg paramAbsStructMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    if (StructingMsgItemBuilder.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder)) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("msg_template_id");
    int i = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "PubAccountFollowSvc.subscribe");
    mobileqq_mp.SubscribeRequest localSubscribeRequest = new mobileqq_mp.SubscribeRequest();
    localSubscribeRequest.msg_id.set(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId);
    localSubscribeRequest.index.set(paramMenuItem.a);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin);
      l1 = l2;
    }
    catch (Exception paramMenuItem)
    {
      for (;;) {}
    }
    localSubscribeRequest.template_id.set(str);
    localSubscribeRequest.puin.set(l1);
    localNewIntent.setObserver(new npq(this, str));
    localNewIntent.putExtra("data", localSubscribeRequest.toByteArray());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.a.startServlet(localNewIntent);
    StructingMsgItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\npp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */