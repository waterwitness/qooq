import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class lcp
  implements Runnable
{
  public lcp(Conversation paramConversation, int paramInt, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = NetworkUtil.f(BaseApplication.getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b(new lcq(this, bool));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */