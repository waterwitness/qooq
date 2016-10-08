package cooperation.qwallet.open.pubaccpay;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseResponse
{
  public int a;
  public String a;
  
  public BaseResponse()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putString("_mqqpay_baseapi_apiname", this.jdField_a_of_type_JavaLangString);
    paramBundle.putInt("_mqqpay_baseapi_apimark", this.jdField_a_of_type_Int);
  }
  
  public abstract boolean a();
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("_mqqpay_baseapi_apiname");
    this.jdField_a_of_type_Int = paramBundle.getInt("_mqqpay_baseapi_apimark");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\open\pubaccpay\BaseResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */