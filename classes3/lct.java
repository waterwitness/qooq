import android.os.SystemClock;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.widget.PullRefreshHeader;

class lct
  implements Runnable
{
  lct(lcs paramlcs, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Lcs.a.d(true);
    PullRefreshHeader localPullRefreshHeader;
    if (this.jdField_a_of_type_Lcs.a.f)
    {
      Conversation.a(this.jdField_a_of_type_Lcs.a, 800L);
      localPullRefreshHeader = Conversation.a(this.jdField_a_of_type_Lcs.a);
      if (!this.jdField_a_of_type_Boolean) {
        break label97;
      }
    }
    label97:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      if (Conversation.a(this.jdField_a_of_type_Lcs.a) > 0L) {
        StartupTracker.a("Conversation_PullToRefresh_cbSwitchToUI", SystemClock.uptimeMillis() - Conversation.a(this.jdField_a_of_type_Lcs.a));
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */