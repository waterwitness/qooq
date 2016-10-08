package com.tencent.bitapp.pre.binder.server.proxy.jni;

import com.facebook.soloader.SoLoader;

public class RealJSCJavaScriptExecutorJni
  extends JavaScriptExecutor
{
  static
  {
    SoLoader.loadLibrary("reactnativejni");
  }
  
  public native void initialize();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\RealJSCJavaScriptExecutorJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */