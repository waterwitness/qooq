import com.rookery.asyncHttpClient.JsonHttpResponseHandler;
import com.rookery.translate.microsoft.MicrosoftTranslator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.apache.http.Header;
import org.json.JSONObject;

public class gcm
  extends JsonHttpResponseHandler
{
  public gcm(MicrosoftTranslator paramMicrosoftTranslator, JsonHttpResponseHandler paramJsonHttpResponseHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComRookeryAsyncHttpClientJsonHttpResponseHandler.a(paramInt, paramArrayOfHeader, paramJSONObject);
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    this.jdField_a_of_type_ComRookeryAsyncHttpClientJsonHttpResponseHandler.a(paramThrowable, paramString);
    super.a(paramThrowable, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gcm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */