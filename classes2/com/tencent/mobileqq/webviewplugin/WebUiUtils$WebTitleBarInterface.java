package com.tencent.mobileqq.webviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.widget.immersive.SystemBarCompact;
import org.json.JSONObject;

public abstract interface WebUiUtils$WebTitleBarInterface
  extends WebUiBaseInterface
{
  public abstract int a();
  
  public abstract SystemBarCompact a();
  
  public abstract void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener);
  
  public abstract void a(JSONObject paramJSONObject);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract long b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(long paramLong);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract boolean d();
  
  public abstract void e();
  
  public abstract int getTitleBarHeight();
  
  public abstract View getTitleBarView();
  
  public abstract void setImmersiveStatus();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webviewplugin\WebUiUtils$WebTitleBarInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */