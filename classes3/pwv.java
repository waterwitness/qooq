import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;

public class pwv
  extends MessageObserver
{
  public pwv(DataLineHandler paramDataLineHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.a()))
    {
      this.a.a(true);
      DataLineHandler.a(this.a, MessageCache.a());
      this.a.b.a().a(0).b();
    }
    this.a.a.a(this.a);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.b()))
    {
      this.a.b(true);
      DataLineHandler.b(this.a, MessageCache.a());
      this.a.b.a().a(1).b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pwv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */