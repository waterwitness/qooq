package com.tencent.mobileqq.app;

import VIP.ReqCheckPayAuth;
import Wallet.PrePayRqt;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QWalletOpenHandler
  extends BusinessHandler
{
  public static final int a = 3;
  public static final String a = "OpenPayServer.checkPayAuth";
  public static final int b = 4;
  public static final String b = "QPaySvc.prePay";
  private static final String c = "Q.qwallet.open.OpenPayHandler";
  
  public QWalletOpenHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Class a()
  {
    return QWalletOpenObserver.class;
  }
  
  public void a(ReqCheckPayAuth paramReqCheckPayAuth)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), "OpenPayServer.checkPayAuth");
    localToServiceMsg.extraData.putSerializable("reqCheckPayAuth", paramReqCheckPayAuth);
    super.a(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.open.OpenPayHandler", 2, "sendCheckSignatureReq: on send--cmd=OpenPayServer.checkPayAuth");
    }
  }
  
  public void a(PrePayRqt paramPrePayRqt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.a(), "QPaySvc.prePay");
    localToServiceMsg.extraData.putSerializable("rqt", paramPrePayRqt);
    super.a(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.open.OpenPayHandler", 2, "sendQpayAuthReq: on send--cmd=QPaySvc.prePay");
    }
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
      if (paramToServiceMsg.compareTo("OpenPayServer.checkPayAuth") == 0)
      {
        super.a(3, bool, paramObject);
        return;
      }
    } while (paramToServiceMsg.compareTo("QPaySvc.prePay") != 0);
    super.a(4, bool, paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QWalletOpenHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */