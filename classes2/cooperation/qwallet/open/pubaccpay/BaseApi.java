package cooperation.qwallet.open.pubaccpay;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseApi
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public BaseApi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putString("_mqqpay_baseapi_apptype", this.b);
    paramBundle.putString("_mqqpay_baseapi_sdkversion", this.jdField_a_of_type_JavaLangString);
    paramBundle.putString("_mqqpay_baseapi_apiname", this.c);
    paramBundle.putInt("_mqqpay_baseapi_apimark", this.jdField_a_of_type_Int);
  }
  
  public abstract boolean a();
  
  public void b(Bundle paramBundle)
  {
    this.b = paramBundle.getString("_mqqpay_baseapi_apptype");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("_mqqpay_baseapi_sdkversion");
    this.c = paramBundle.getString("_mqqpay_baseapi_apiname");
    this.jdField_a_of_type_Int = paramBundle.getInt("_mqqpay_baseapi_apimark");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("sv=" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&at=" + this.b);
    localStringBuilder.append("&an=" + this.c);
    localStringBuilder.append("&am=" + this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\open\pubaccpay\BaseApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */