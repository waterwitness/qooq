import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lco
  extends ConfigObserver
{
  public lco(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if (paramBoolean) {
      this.a.a(0L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */