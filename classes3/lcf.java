import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalManager;

public class lcf
  implements View.OnClickListener
{
  public lcf(Conversation paramConversation, PortalManager paramPortalManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation).removeView(Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation));
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), true);
    }
    Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */