package cooperation.qwallet.open.openpay;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseApi
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public BaseApi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putString("_mqqpay_baseapi_appid", this.jdField_a_of_type_JavaLangString);
    paramBundle.putString("_mqqpay_baseapi_apptype", this.c);
    paramBundle.putString("_mqqpay_baseapi_sdkversion", this.b);
    paramBundle.putString("_mqqpay_baseapi_apiname", this.d);
    paramBundle.putInt("_mqqpay_baseapi_apimark", this.jdField_a_of_type_Int);
  }
  
  public abstract boolean a();
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("_mqqpay_baseapi_appid");
    this.c = paramBundle.getString("_mqqpay_baseapi_apptype");
    this.b = paramBundle.getString("_mqqpay_baseapi_sdkversion");
    this.d = paramBundle.getString("_mqqpay_baseapi_apiname");
    this.jdField_a_of_type_Int = paramBundle.getInt("_mqqpay_baseapi_apimark");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("ai=" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&sv=" + this.b);
    localStringBuilder.append("&at=" + this.c);
    localStringBuilder.append("&an=" + this.d);
    localStringBuilder.append("&am=" + this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\open\openpay\BaseApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */