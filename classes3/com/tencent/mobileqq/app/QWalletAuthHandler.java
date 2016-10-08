package com.tencent.mobileqq.app;

import QQWalletPay.ReqCheckChangePwdAuth;
import Wallet.AdvRequest;
import Wallet.AuthCodeReq;
import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;

public class QWalletAuthHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "QQWalletPayAuthServer.checkChangePwdAuth";
  public static final int b = 2;
  public static final String b = "AdvRuleSvrCmd.getAdList";
  public static final int c = 3;
  public static final String c = "WalletGestureSvc.GetPassword";
  public static final int d = 4;
  public static final String d = "VacThirdCodeSvc.fetchCodes";
  private static final String e = "Q.qwallet.auth.AuthHandler";
  private boolean a;
  
  protected QWalletAuthHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null) {}
    while (((Bundle)paramObject).getByteArray("resp") != null) {
      return;
    }
  }
  
  protected Class a()
  {
    return QWalletAuthObserver.class;
  }
  
  public void a(ReqCheckChangePwdAuth paramReqCheckChangePwdAuth)
  {
    if (paramReqCheckChangePwdAuth == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), "QQWalletPayAuthServer.checkChangePwdAuth");
      localToServiceMsg.extraData.putSerializable("ReqCheckChangePwdAuth", paramReqCheckChangePwdAuth);
      super.a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendCheckModifyPassReq: on send--cmd=QQWalletPayAuthServer.checkChangePwdAuth");
  }
  
  public void a(AdvRequest paramAdvRequest)
  {
    if (paramAdvRequest == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), "AdvRuleSvrCmd.getAdList");
      localToServiceMsg.extraData.putSerializable("AdvRequest", paramAdvRequest);
      super.a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetAdsReq: on send--cmd=AdvRuleSvrCmd.getAdList");
  }
  
  public void a(AuthCodeReq paramAuthCodeReq)
  {
    if (paramAuthCodeReq == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), "VacThirdCodeSvc.fetchCodes");
      localToServiceMsg.extraData.putSerializable("AuthCodeReq", paramAuthCodeReq);
      super.a(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetAuthCode: on send--cmd=VacThirdCodeSvc.fetchCodes");
  }
  
  public void a(GetPasswordReq paramGetPasswordReq)
  {
    if (paramGetPasswordReq == null) {}
    do
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), "WalletGestureSvc.GetPassword");
      localToServiceMsg.extraData.putSerializable("GetPasswordReq", paramGetPasswordReq);
      super.a(localToServiceMsg);
      this.a = true;
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    boolean bool;
    do
    {
      do
      {
        return;
        bool = paramFromServiceMsg.isSuccess();
        paramToServiceMsg = paramToServiceMsg.getServiceCmd();
      } while (TextUtils.isEmpty(paramToServiceMsg));
      if (paramToServiceMsg.compareTo("QQWalletPayAuthServer.checkChangePwdAuth") == 0)
      {
        super.a(1, bool, paramObject);
        return;
      }
      if (paramToServiceMsg.compareTo("AdvRuleSvrCmd.getAdList") != 0) {
        break;
      }
      if (bool) {
        a(paramObject);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetAdsReq: onReceive isSuccess:" + bool);
    return;
    if (paramToServiceMsg.compareTo("WalletGestureSvc.GetPassword") == 0) {
      if ((paramObject == null) || (!(paramObject instanceof GetPasswordRsp))) {
        break label408;
      }
    }
    label408:
    for (paramToServiceMsg = (GetPasswordRsp)paramObject;; paramToServiceMsg = null)
    {
      if ((bool) && (paramToServiceMsg != null) && (paramToServiceMsg.ret == 0))
      {
        PatternLockUtils.c(this.b.a(), this.b.a(), false);
        paramFromServiceMsg = "";
        if (!TextUtils.isEmpty(paramToServiceMsg.password))
        {
          paramFromServiceMsg = Utils.b(this.b.a());
          paramFromServiceMsg = MD5.toMD5(paramFromServiceMsg + paramToServiceMsg.password);
        }
        PatternLockUtils.a(this.b.a(), this.b.a(), paramFromServiceMsg);
        PatternLockUtils.a(this.b.a(), this.b.a(), paramToServiceMsg.checkInterval);
        PatternLockUtils.b(this.b.a(), this.b.a(), paramToServiceMsg.passInterval);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("Q.qwallet.auth.AuthHandler", 2, "sendGetPasswordReq: onReceive isSuccess:" + bool);
        return;
        if ((this.a) && (NetworkUtil.e(this.b.a())))
        {
          this.a = false;
          paramToServiceMsg = new GetPasswordReq();
          paramToServiceMsg.MQOS = "Android";
          paramFromServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), "WalletGestureSvc.GetPassword");
          paramFromServiceMsg.extraData.putSerializable("GetPasswordReq", paramToServiceMsg);
          super.a(paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.auth.AuthHandler", 2, "RetrySendGetPasswordReq: on send--cmd=WalletGestureSvc.GetPassword");
          }
        }
      }
      break;
      if (paramToServiceMsg.compareTo("VacThirdCodeSvc.fetchCodes") != 0) {
        break;
      }
      super.a(4, bool, paramObject);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QWalletAuthHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */