import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class kvj
  extends MessageObserver
{
  public kvj(ChatHistory paramChatHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean)
  {
    this.a.j();
    if (!paramBoolean)
    {
      Message localMessage = this.a.a.obtainMessage(5);
      this.a.a(localMessage);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localMessage = this.a.a.obtainMessage(3);
      this.a.a(localMessage);
      return;
    }
    Message localMessage = this.a.a.obtainMessage(2);
    this.a.a(localMessage);
  }
  
  protected void e_(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localMessage = this.a.a.obtainMessage(1);
      this.a.a(localMessage);
      return;
    }
    this.a.app.a().c();
    Message localMessage = this.a.a.obtainMessage(0);
    this.a.a(localMessage);
  }
  
  protected void f_(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localMessage = this.a.a.obtainMessage(1);
      this.a.a(localMessage);
      return;
    }
    this.a.app.a().c();
    Message localMessage = this.a.a.obtainMessage(0);
    this.a.a(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */