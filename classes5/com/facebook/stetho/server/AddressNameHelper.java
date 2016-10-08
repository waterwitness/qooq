package com.facebook.stetho.server;

import com.facebook.stetho.common.ProcessUtil;

public class AddressNameHelper
{
  private static final String PREFIX = "stetho_";
  
  public static String createCustomAddress(String paramString)
  {
    return "stetho_" + ProcessUtil.getProcessName() + paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\AddressNameHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */