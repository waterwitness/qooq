package com.tencent.securemodule.service;

import com.tencent.securemodule.impl.AppInfo;
import java.util.List;

public abstract interface CloudScanListener
{
  public abstract void onFinish(int paramInt);
  
  public abstract void onRiskFoud(List<AppInfo> paramList);
  
  public abstract void onRiskFound();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\securemodule\service\CloudScanListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */