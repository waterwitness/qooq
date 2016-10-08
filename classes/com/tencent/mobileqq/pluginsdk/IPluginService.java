package com.tencent.mobileqq.pluginsdk;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;

public abstract interface IPluginService
{
  public abstract void IInit(String paramString1, String paramString2, Service paramService, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, int paramInt);
  
  public abstract IBinder IOnBind(Intent paramIntent);
  
  public abstract void IOnCreate();
  
  public abstract void IOnDestroy();
  
  public abstract void IOnStart(Intent paramIntent, int paramInt);
  
  public abstract int IOnStartCommand(Intent paramIntent, int paramInt1, int paramInt2);
  
  public abstract boolean IOnUnbind(Intent paramIntent);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\IPluginService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */