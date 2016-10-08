import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.net.URL;
import org.json.JSONObject;

public class hpq
  implements Runnable
{
  public hpq(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PublicAccountJavascriptInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, this.jdField_a_of_type_JavaNetURL, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */