package com.sixgod.pluginsdk;

import android.content.Context;

public final class b
{
  protected PluginLoadParams a;
  Context b;
  
  public b(Context paramContext, PluginLoadParams paramPluginLoadParams)
  {
    this.a = paramPluginLoadParams;
    this.b = paramContext;
  }
  
  public final void a()
  {
    if (this.a.pluginLoadCallBack != null) {
      this.a.pluginLoadCallBack.loadPluginSucc(this.a.pkgName, this.a.pluginName);
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.a.pluginLoadCallBack != null) {
      this.a.pluginLoadCallBack.loadPluginFailed(this.a.pkgName, this.a.pluginName, paramInt);
    }
  }
  
  public final void a(String paramString)
  {
    if (this.a.pluginLoadCallBack != null) {
      this.a.pluginLoadCallBack.startMainActivitySucc(this.a.pkgName, this.a.pluginName, paramString);
    }
  }
  
  public final void a(String paramString, Throwable paramThrowable)
  {
    if (this.a.pluginLoadCallBack != null) {
      this.a.pluginLoadCallBack.crashHappened(paramString, this.a.pkgName, this.a.pluginName, paramThrowable);
    }
  }
  
  public final void b(String paramString)
  {
    if (this.a.pluginLoadCallBack != null) {
      this.a.pluginLoadCallBack.startActivitySucc(this.a.pkgName, this.a.pluginName, paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */