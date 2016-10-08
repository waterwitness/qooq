package cooperation.qwallet.open.openpay;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class PayResponse
  extends BaseResponse
{
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public PayResponse()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("name", "pay");
      localJSONObject1.put("identifier", this.i);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("code", this.jdField_c_of_type_Int);
      localJSONObject2.put("message", this.a);
      ((JSONObject)localObject).put("action", localJSONObject1);
      ((JSONObject)localObject).put("params", localJSONObject2);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("_mqqpay_payresp_paychanneltype", this.jdField_c_of_type_JavaLangString);
    paramBundle.putString("_mqqpay_payresp_transactionid", this.d);
    paramBundle.putString("_mqqpay_payresp_paytime", this.e);
    paramBundle.putString("_mqqpay_payresp_totalfee", this.f);
    paramBundle.putString("_mqqpay_payresp_callbackurl", this.g);
    paramBundle.putString("_mqqpay_payresp_spdata", this.h);
    paramBundle.putString("_mqqpay_payapi_serialnumber", this.i);
    paramBundle.putString("_mqqpay_payapi_openid", this.j);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("_mqqpay_payresp_paychanneltype");
    this.d = paramBundle.getString("_mqqpay_payresp_transactionid");
    this.e = paramBundle.getString("_mqqpay_payresp_paytime");
    this.f = paramBundle.getString("_mqqpay_payresp_totalfee");
    this.g = paramBundle.getString("_mqqpay_payresp_callbackurl");
    this.h = paramBundle.getString("_mqqpay_payresp_spdata");
    this.i = paramBundle.getString("_mqqpay_payapi_serialnumber");
    this.j = paramBundle.getString("_mqqpay_payapi_openid");
  }
  
  public boolean b()
  {
    if (this.jdField_c_of_type_Int == -9999999) {}
    while ((a()) && (!c()) && ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.f)))) {
      return false;
    }
    return true;
  }
  
  public boolean c()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    while (this.jdField_c_of_type_JavaLangString.compareTo("1") != 0) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\open\openpay\PayResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */