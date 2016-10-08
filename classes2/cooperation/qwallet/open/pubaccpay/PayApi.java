package cooperation.qwallet.open.pubaccpay;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

public class PayApi
  extends BaseApi
{
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public PayApi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("_mqqpay_payapi_extData", this.d);
    paramBundle.putString("_mqqpay_payapi_callbackscheme", this.e);
    paramBundle.putString("_mqqpay_payapi_appId", this.f);
    paramBundle.putString("_mqqpay_payapi_timeStamp", this.g);
    paramBundle.putString("_mqqpay_payapi_nonceStr", this.h);
    paramBundle.putString("_mqqpay_payapi_packageValue", this.i);
    paramBundle.putString("_mqqpay_payapi_signType", this.j);
    paramBundle.putString("_mqqpay_payapi_paySign", this.k);
    paramBundle.putString("_mqqpay_payapi_packageName", this.l);
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.f)) {}
    while ((TextUtils.isEmpty(this.b)) || (this.b.compareTo("native") != 0) || (TextUtils.isEmpty(this.l)) || (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.g)) || (TextUtils.isEmpty(this.h)) || (TextUtils.isEmpty(this.i)) || (TextUtils.isEmpty(this.j)) || (TextUtils.isEmpty(this.k)) || (TextUtils.isEmpty(this.d))) {
      return false;
    }
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.d = paramBundle.getString("_mqqpay_payapi_extData");
    this.e = paramBundle.getString("_mqqpay_payapi_callbackscheme");
    this.f = paramBundle.getString("_mqqpay_payapi_appId");
    this.g = paramBundle.getString("_mqqpay_payapi_timeStamp");
    this.h = paramBundle.getString("_mqqpay_payapi_nonceStr");
    this.i = paramBundle.getString("_mqqpay_payapi_packageValue");
    this.j = paramBundle.getString("_mqqpay_payapi_signType");
    this.k = paramBundle.getString("_mqqpay_payapi_paySign");
    this.l = paramBundle.getString("_mqqpay_payapi_packageName");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(super.toString());
    localStringBuilder.append("&ex=" + this.d);
    localStringBuilder.append("&cs=" + this.e);
    localStringBuilder.append("&ai=" + this.f);
    localStringBuilder.append("&ts=" + this.g);
    localStringBuilder.append("&ns=" + this.h);
    try
    {
      if (!TextUtils.isEmpty(this.i)) {
        localStringBuilder.append("&pv=" + URLEncoder.encode(this.i, "utf-8"));
      }
      localStringBuilder.append("&st=" + this.j);
      localStringBuilder.append("&ps=" + this.k);
      localStringBuilder.append("&pn=" + this.l);
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\open\pubaccpay\PayApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */