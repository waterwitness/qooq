import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class hpk
  implements Runnable
{
  public hpk(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, AppInterface paramAppInterface, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = PublicAccountUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("follow", bool);
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.b, new String[] { "{ret:0, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
      return;
    }
    catch (JSONException localJSONException)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.b, new String[] { "{ret:-2, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */