package cooperation.qwallet.open.openpay;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class BaseResponse
{
  protected final int a;
  public String a;
  protected final int b;
  public String b;
  public int c;
  public int d;
  
  public BaseResponse()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -9999999;
    this.jdField_b_of_type_Int = 0;
    this.c = -9999999;
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("_mqqpay_baseresp_retcode", this.c);
    paramBundle.putString("_mqqpay_baseresp_retmsg", this.jdField_a_of_type_JavaLangString);
    paramBundle.putString("_mqqpay_baseapi_apiname", this.jdField_b_of_type_JavaLangString);
    paramBundle.putInt("_mqqpay_baseapi_apimark", this.d);
  }
  
  public boolean a()
  {
    return this.c == 0;
  }
  
  public void b(Bundle paramBundle)
  {
    this.c = paramBundle.getInt("_mqqpay_baseresp_retcode");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("_mqqpay_baseresp_retmsg");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("_mqqpay_baseapi_apiname");
    this.d = paramBundle.getInt("_mqqpay_baseapi_apimark");
  }
  
  public abstract boolean b();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\open\openpay\BaseResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */