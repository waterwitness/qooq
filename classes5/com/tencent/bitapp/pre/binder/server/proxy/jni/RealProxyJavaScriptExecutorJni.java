package com.tencent.bitapp.pre.binder.server.proxy.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.soloader.SoLoader;
import javax.annotation.Nullable;

@DoNotStrip
public class RealProxyJavaScriptExecutorJni
  extends JavaScriptExecutor
{
  @Nullable
  private JavaJSExecutor mJavaJSExecutor;
  
  static
  {
    SoLoader.loadLibrary("reactnativejni");
  }
  
  public RealProxyJavaScriptExecutorJni(JavaJSExecutor paramJavaJSExecutor)
  {
    this.mJavaJSExecutor = paramJavaJSExecutor;
    initialize(paramJavaJSExecutor);
  }
  
  private native void initialize(JavaJSExecutor paramJavaJSExecutor);
  
  public void close()
  {
    if (this.mJavaJSExecutor != null)
    {
      this.mJavaJSExecutor.close();
      this.mJavaJSExecutor = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\RealProxyJavaScriptExecutorJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */