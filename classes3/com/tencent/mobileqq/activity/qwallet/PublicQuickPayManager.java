package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomSingleButtonDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.open.OpenPayActivity;
import mqq.manager.Manager;
import org.json.JSONObject;
import oto;

public class PublicQuickPayManager
  implements Manager
{
  public static final String a;
  public Context a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQCustomSingleButtonDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PublicQuickPayManager.class.getSimpleName();
  }
  
  public PublicQuickPayManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, "支付失败", "", "确定", new oto(this), null, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.show();
  }
  
  public boolean a(JSONObject paramJSONObject, PublicQuickPayManager.QQWalletPayCompletionImp paramQQWalletPayCompletionImp)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "jsonParams is null");
      }
      return false;
    }
    String str1 = paramJSONObject.optString("appId");
    String str2 = paramJSONObject.optString("timeStamp");
    String str3 = paramJSONObject.optString("nonceStr");
    String str4 = paramJSONObject.optString("package");
    String str5 = paramJSONObject.optString("orderId");
    String str6 = paramJSONObject.optString("signType");
    String str7 = paramJSONObject.optString("paySign");
    String str8 = paramJSONObject.optString("expireTime");
    paramJSONObject.optString("actionId");
    paramJSONObject = new Bundle();
    paramJSONObject.putInt("extra.key.pay.type", 1);
    paramJSONObject.putInt("extra.key.pay.from", 3);
    paramJSONObject.putInt("extra.key.pay.platform", 2);
    paramJSONObject.putString("appId", str1);
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str7)) && (!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str8)))
    {
      if (Long.parseLong(str8) <= NetConnInfoCenter.getServerTimeMillis() / 1000L)
      {
        paramJSONObject = new Bundle();
        paramJSONObject.putInt("retCode", -6);
        paramJSONObject.putString("retMsg", "expireTime overdue");
        a();
        if (paramQQWalletPayCompletionImp != null) {
          paramQQWalletPayCompletionImp.a(paramJSONObject);
        }
        return false;
      }
      paramJSONObject.putString("timeStampStr", str2);
      paramJSONObject.putString("nonce", str3);
      paramJSONObject.putString("packageValue", str4);
      paramJSONObject.putString("sigType", str6);
      paramJSONObject.putString("sig", str7);
      paramJSONObject.putParcelable("_qwallet_payresult_receiver", new PublicQuickPayManager.1(this, new Handler(), str5, paramQQWalletPayCompletionImp));
      paramQQWalletPayCompletionImp = new Intent(this.jdField_a_of_type_AndroidContentContext, OpenPayActivity.class);
      paramQQWalletPayCompletionImp.putExtras(paramJSONObject);
      paramQQWalletPayCompletionImp.addFlags(268435456);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramQQWalletPayCompletionImp);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "open OpenPayActivity success");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "publicQuickPay parameters parse error");
    }
    paramJSONObject = new Bundle();
    paramJSONObject.putInt("retCode", -4);
    paramJSONObject.putString("retMsg", "params parse error");
    a();
    if (paramQQWalletPayCompletionImp != null) {
      paramQQWalletPayCompletionImp.a(paramJSONObject);
    }
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\PublicQuickPayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */