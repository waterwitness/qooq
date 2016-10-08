import com.tencent.mobileqq.activity.ConversationHotChatCtrl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import mqq.os.MqqHandler;

class lej
  extends HotChatObserver
{
  lej(lei paramlei)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this);
    if (paramBoolean) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.isShowing()) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.a("已退出热聊房间。");
        this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.c(2130838452);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.b(false);
        this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new lek(this), 1500L);
      }
    }
    while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.isShowing()) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.a("退出失败，请稍后重试。");
    this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.c(2130838442);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.b(false);
    this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new lel(this), 1500L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */