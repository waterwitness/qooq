import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;

public class lcg
  implements Runnable
{
  public lcg(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PullRefreshHeader localPullRefreshHeader;
    if (this.a.f)
    {
      Conversation.a(this.a, 800L);
      localPullRefreshHeader = Conversation.a(this.a);
      if (!NetworkUtil.e(BaseApplication.getContext())) {
        break label45;
      }
    }
    label45:
    for (int i = 0;; i = 2)
    {
      localPullRefreshHeader.a(i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */