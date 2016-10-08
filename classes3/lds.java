import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lds
  implements DrawerFrame.IDrawerCallbacks
{
  public lds(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).d();
    }
  }
  
  public void a(int paramInt, float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.a != null) {
      this.a.a.B();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    Conversation.c(this.a);
    if (this.a.a != null) {
      this.a.a.A();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */