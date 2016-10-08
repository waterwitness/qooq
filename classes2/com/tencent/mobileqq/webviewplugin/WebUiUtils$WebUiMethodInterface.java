package com.tencent.mobileqq.webviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;

public abstract interface WebUiUtils$WebUiMethodInterface
  extends WebUiBaseInterface
{
  public abstract String getCurrentUrl();
  
  public abstract CustomWebView getWebView();
  
  public abstract void hideQQBrowserButton();
  
  public abstract boolean isActivityResume();
  
  public abstract boolean isFullScreen();
  
  public abstract void setBottomBarVisible(boolean paramBoolean);
  
  public abstract void showActionSheet();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webviewplugin\WebUiUtils$WebUiMethodInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */