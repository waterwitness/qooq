import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qlj
  implements Runnable
{
  public qlj(ConversationFacade paramConversationFacade)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b(AppConstants.ar, 1001);
    this.a.b(AppConstants.ag, 1009);
    this.a.b(AppConstants.aH, 1010);
    ConversationFacade.a(this.a).a().a(8023, true, null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qlj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */