package com.sixgod.pluginsdk;

import java.io.Serializable;

public abstract interface PluginCallback
  extends Serializable
{
  public abstract void crashHappened(String paramString1, String paramString2, String paramString3, Throwable paramThrowable);
  
  public abstract void loadPluginFailed(String paramString1, String paramString2, int paramInt);
  
  public abstract void loadPluginSucc(String paramString1, String paramString2);
  
  public abstract void startActivitySucc(String paramString1, String paramString2, String paramString3);
  
  public abstract void startMainActivityFailed(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void startMainActivitySucc(String paramString1, String paramString2, String paramString3);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\PluginCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */