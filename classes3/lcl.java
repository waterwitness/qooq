import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lcl
  implements Runnable
{
  lcl(lch paramlch)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (Conversation.a(this.a.a) != null) {
      Conversation.a(this.a.a).b(this.a.a.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lcl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */