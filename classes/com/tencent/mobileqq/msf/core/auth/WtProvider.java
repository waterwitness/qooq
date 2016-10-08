package com.tencent.mobileqq.msf.core.auth;

import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginMsfListener;

public class WtProvider
{
  static final String tag = "MSF.C.WtloginMsfProvider";
  
  public static void cancel(int paramInt)
  {
    j.a(paramInt);
  }
  
  public static int sendData(WUserSigInfo paramWUserSigInfo, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, WtloginMsfListener paramWtloginMsfListener)
  {
    return j.a(paramWUserSigInfo, paramString1, paramString2, paramArrayOfByte, paramInt, paramBoolean, paramWtloginMsfListener);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\auth\WtProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */