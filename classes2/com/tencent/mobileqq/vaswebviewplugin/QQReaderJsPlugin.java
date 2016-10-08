package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class QQReaderJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BROADCAST_ADD_BOOKSHELF = "com.tencent.mobileqq.jsPlugin.AddToBookShelf";
  public static final String NAMESPACE = "qqreader";
  private static final String TAG = "QQReaderJsPlugin";
  private BroadcastReceiver mReceiver;
  
  public QQReaderJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "qqreader";
  }
  
  private void addBookShelfReceiver()
  {
    registerReceiver();
  }
  
  private void registerReceiver()
  {
    if (this.mReceiver == null)
    {
      this.mReceiver = new QQReaderJsPlugin.1(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.jsPlugin.AddToBookShelf");
      this.mRuntime.a().registerReceiver(this.mReceiver, localIntentFilter);
    }
  }
  
  private void unregisterReceiver()
  {
    if (this.mReceiver != null) {
      this.mRuntime.a().unregisterReceiver(this.mReceiver);
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQReaderJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"qqreader".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {}
    while (!"addBookShelfReceiver".equals(paramString3)) {
      return false;
    }
    addBookShelfReceiver();
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\QQReaderJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */