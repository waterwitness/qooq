import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;

public class vbu
  extends MessageObserver
{
  public vbu(ShortVideoForwardProcessor paramShortVideoForwardProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    this.a.a("sendMsgFinish", "success:" + paramBoolean);
    this.a.a(this.a.c, false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.a.c();
      return;
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */