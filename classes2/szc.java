import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

public final class szc
  implements IHttpCommunicatorListener
{
  public szc()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    ReportLog.a().sendEmptyMessage(10000001);
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    ReportLog.a = false;
    ReportLog.a().sendEmptyMessage(10000001);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\szc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */