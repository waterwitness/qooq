package com.tencent.bitapp.pre.binder.server.proxy.jni;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public abstract class NativeMap
  extends Countable
{
  static
  {
    SoLoader.loadLibrary("reactnativejni");
  }
  
  public NativeMap()
  {
    initialize();
  }
  
  private native void initialize();
  
  public native String toString();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\NativeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */