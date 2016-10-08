package com.tencent.mobileqq.intervideo;

import android.app.Activity;
import android.os.Bundle;

public abstract interface IVPluginEvtListener
{
  public abstract void a(Activity paramActivity);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString1, int paramInt, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void b(String paramString);
  
  public abstract void c(String paramString);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\intervideo\IVPluginEvtListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */