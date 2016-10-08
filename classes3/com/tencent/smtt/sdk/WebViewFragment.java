package com.tencent.smtt.sdk;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WebViewFragment
  extends Fragment
{
  private boolean mIsWebViewAvailable;
  private WebView mWebView;
  
  public WebView getWebView()
  {
    if (this.mIsWebViewAvailable) {
      return this.mWebView;
    }
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.mWebView != null) {
      this.mWebView.destroy();
    }
    this.mWebView = new WebView(getActivity());
    this.mIsWebViewAvailable = true;
    return this.mWebView;
  }
  
  public void onDestroy()
  {
    if (this.mWebView != null)
    {
      this.mWebView.destroy();
      this.mWebView = null;
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.mIsWebViewAvailable = false;
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mWebView.onPause();
  }
  
  public void onResume()
  {
    this.mWebView.onResume();
    super.onResume();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\WebViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */