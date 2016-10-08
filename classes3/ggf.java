import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.IQQServiceCallback.Stub;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ggf
  extends IQQServiceCallback.Stub
{
  public ggf(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(RecvMsg paramRecvMsg)
  {
    if (paramRecvMsg != null) {
      this.a.a(new Object[] { Integer.valueOf(12), paramRecvMsg });
    }
  }
  
  public void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo)
  {
    if ((paramArrayOfRecvGVideoLevelInfo != null) && (paramArrayOfRecvGVideoLevelInfo.length > 0)) {
      this.a.a(new Object[] { Integer.valueOf(501), paramArrayOfRecvGVideoLevelInfo });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */