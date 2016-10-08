import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;

public class vaj
  extends MessageObserver
{
  public vaj(C2CPicUploadProcessor paramC2CPicUploadProcessor)
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
    if (paramStatictisInfo != null) {
      this.a.bl = paramStatictisInfo.e;
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */