import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class hpr
  implements Runnable
{
  public hpr(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = PublicAccountJavascriptInterface.a();
    try
    {
      PublicAccountJavascriptInterface.a(l);
      if (PublicAccountJavascriptInterface.b() > 52428800L)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{ret:-12, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.a(this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */