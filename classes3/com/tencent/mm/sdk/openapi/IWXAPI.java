package com.tencent.mm.sdk.openapi;

import android.content.Intent;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public abstract interface IWXAPI
{
  public abstract void detach();
  
  public abstract int getWXAppSupportAPI();
  
  public abstract boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler);
  
  public abstract boolean isWXAppInstalled();
  
  public abstract boolean isWXAppSupportAPI();
  
  public abstract boolean openWXApp();
  
  public abstract boolean registerApp(String paramString);
  
  public abstract boolean sendReq(BaseReq paramBaseReq);
  
  public abstract boolean sendResp(BaseResp paramBaseResp);
  
  public abstract void unregisterApp();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mm\sdk\openapi\IWXAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */