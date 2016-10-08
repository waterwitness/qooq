import com.tencent.mobileqq.app.message.ConversationProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.qphone.base.util.QLog;

public class qlk
  implements NoColumnErrorHandler
{
  public qlk(ConversationProxy paramConversationProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(NoColumnError paramNoColumnError)
  {
    if ((paramNoColumnError != null) && (("unreadGiftCount".equals(paramNoColumnError.mColumnName)) || ("unreadMark".equals(paramNoColumnError.mColumnName))))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.unread.Proxy", 2, paramNoColumnError.getMessage(), paramNoColumnError);
      }
      ConversationProxy.a(this.a, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qlk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */