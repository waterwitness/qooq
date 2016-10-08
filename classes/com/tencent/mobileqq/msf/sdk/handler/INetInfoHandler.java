package com.tencent.mobileqq.msf.sdk.handler;

public abstract interface INetInfoHandler
  extends IMsfHandler
{
  public abstract void onNetMobile2None();
  
  public abstract void onNetMobile2Wifi(String paramString);
  
  public abstract void onNetNone2Mobile(String paramString);
  
  public abstract void onNetNone2Wifi(String paramString);
  
  public abstract void onNetWifi2Mobile(String paramString);
  
  public abstract void onNetWifi2None();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\handler\INetInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */