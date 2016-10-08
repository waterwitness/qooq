package cooperation.qzone.plugin;

import android.os.IInterface;

public abstract interface OnQZonePluginInstallListner
  extends IInterface
{
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, float paramFloat, long paramLong);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void b(String paramString);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\OnQZonePluginInstallListner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */