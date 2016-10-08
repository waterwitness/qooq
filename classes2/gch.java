import android.content.Context;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.asyncHttpClient.AsyncHttpResponseHandler;
import com.rookery.translate.TranslateClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public abstract class gch
  extends TranslateClient
{
  private static final String a = "https://www.googleapis.com/language/translate/v2";
  
  gch()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, Header[] paramArrayOfHeader, List paramList, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "https://www.googleapis.com/language/translate/v2", paramArrayOfHeader, paramList, paramAsyncHttpResponseHandler);
  }
  
  public static void a(Context paramContext, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    a().a(paramContext, "https://www.googleapis.com/language/translate/v2", paramArrayOfHeader, paramHttpEntity, paramString, paramAsyncHttpResponseHandler);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */