package cooperation.qzone.plugin;

import android.os.IInterface;

public abstract interface QZoneRemotePluginManager
  extends IInterface
{
  public abstract PluginRecord a(String paramString);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner);
  
  public abstract boolean b(String paramString);
  
  public abstract boolean c(String paramString);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\QZoneRemotePluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */