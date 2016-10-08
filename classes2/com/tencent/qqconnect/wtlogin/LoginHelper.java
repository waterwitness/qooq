package com.tencent.qqconnect.wtlogin;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;
import xhi;

public class LoginHelper
{
  protected static final String a = "LoginHelper";
  public LoginHelper.Callback a;
  private SSOAccountObserver a;
  
  public LoginHelper(Context paramContext, AppInterface paramAppInterface, LoginHelper.Callback paramCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new xhi(this);
    this.jdField_a_of_type_ComTencentQqconnectWtloginLoginHelper$Callback = paramCallback;
    paramAppInterface.ssoGetTicketNoPasswd(paramAppInterface.getAccount(), 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qqconnect\wtlogin\LoginHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */