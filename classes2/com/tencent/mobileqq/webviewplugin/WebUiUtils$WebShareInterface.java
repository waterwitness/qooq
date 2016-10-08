package com.tencent.mobileqq.webviewplugin;

import android.os.Bundle;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;

public abstract interface WebUiUtils$WebShareInterface
  extends WebUiBaseInterface
{
  public abstract Share getShare();
  
  public abstract boolean setShareUrl(String paramString);
  
  public abstract boolean setSummary(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webviewplugin\WebUiUtils$WebShareInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */