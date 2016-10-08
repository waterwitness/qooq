import android.os.Handler;
import android.os.Message;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gbz
  extends Handler
{
  public gbz(AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\gbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */