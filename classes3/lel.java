import com.tencent.mobileqq.activity.ConversationHotChatCtrl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

class lel
  implements Runnable
{
  lel(lej paramlej)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a != null) && (this.a.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.isShowing()) && (!this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */