package com.facebook.react.bridge;

import android.content.Context;
import com.tencent.bitapp.pre.binder.client.IJava2jniClient;
import com.tencent.bitapp.pre.binder.client.Java2jniClientFactory;

public abstract class JSBundleLoader
{
  public static JSBundleLoader createCachedBundleFromNetworkLoader(final String paramString, String[] paramArrayOfString)
  {
    new JSBundleLoader()
    {
      public String getSourceUrl()
      {
        return paramString;
      }
      
      public void loadScript()
      {
        IJava2jniClient localIJava2jniClient = Java2jniClientFactory.getJava2jniClient();
        if (localIJava2jniClient != null) {
          localIJava2jniClient.reactBridgeLoadScriptFromFile(this.val$cachedFileLocation, paramString);
        }
      }
    };
  }
  
  public static JSBundleLoader createFileLoader(final Context paramContext, String paramString)
  {
    new JSBundleLoader()
    {
      public String getSourceUrl()
      {
        return this.val$fileName;
      }
      
      public void loadScript()
      {
        IJava2jniClient localIJava2jniClient = Java2jniClientFactory.getJava2jniClient();
        if (localIJava2jniClient != null)
        {
          if (this.val$fileName.startsWith("assets://")) {
            localIJava2jniClient.reactBridgeLoadScriptFromAssets(paramContext.getAssets(), this.val$fileName.replaceFirst("assets://", ""));
          }
        }
        else {
          return;
        }
        String str1 = this.val$fileName;
        String str2 = this.val$fileName;
        localIJava2jniClient.reactBridgeLoadScriptFromFile(new String[] { str1 }, str2);
      }
    };
  }
  
  public static JSBundleLoader createRemoteDebuggerBundleLoader(String paramString)
  {
    new JSBundleLoader()
    {
      public String getSourceUrl()
      {
        return this.val$sourceURL;
      }
      
      public void loadScript()
      {
        IJava2jniClient localIJava2jniClient = Java2jniClientFactory.getJava2jniClient();
        if (localIJava2jniClient != null) {
          localIJava2jniClient.reactBridgeLoadScriptFromFile(null, this.val$sourceURL);
        }
      }
    };
  }
  
  public abstract String getSourceUrl();
  
  public abstract void loadScript();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\JSBundleLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */