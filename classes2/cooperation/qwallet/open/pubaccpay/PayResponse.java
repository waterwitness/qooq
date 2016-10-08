package cooperation.qwallet.open.pubaccpay;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PayResponse
  extends BaseResponse
{
  protected final int b;
  public String b;
  protected final int c;
  public String c;
  protected final int d;
  public int e;
  
  public PayResponse()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = -9999999;
    this.jdField_c_of_type_Int = 0;
    this.d = -1;
    this.e = -9999999;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putInt("_mqqpay_payresp_retcode", this.e);
    paramBundle.putString("_mqqpay_payresp_retmsg", this.jdField_b_of_type_JavaLangString);
    paramBundle.putString("_mqqpay_payresp_extData", this.jdField_c_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    if (this.e == -9999999) {}
    while (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return false;
    }
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.e = paramBundle.getInt("_mqqpay_payresp_retcode");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("_mqqpay_payresp_retmsg");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("_mqqpay_payresp_extData");
  }
  
  public boolean b()
  {
    return this.e == 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\open\pubaccpay\PayResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */