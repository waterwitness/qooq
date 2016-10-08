import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

class lcu
  implements Runnable
{
  lcu(lcs paramlcs, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Conversation.a(this.jdField_a_of_type_Lcs.a, 800L);
    PullRefreshHeader localPullRefreshHeader = Conversation.a(this.jdField_a_of_type_Lcs.a);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ConversationTab[onRefleshRecentListFinished_ui]");
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */