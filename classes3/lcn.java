import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lcn
  extends BizTroopObserver
{
  public lcn(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      this.a.a(8, paramString1, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */