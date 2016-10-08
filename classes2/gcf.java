import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.TranslateClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gcf
  extends TranslateClient
{
  private static final String a = "http://passport.imqq.com/App/MobileQQ/ChangeTrans.html";
  
  gcf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "http://passport.imqq.com/App/MobileQQ/ChangeTrans.html", null, null, new gcg(paramAsyncHttpResponseHandler));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */