package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class HybridData
{
  @DoNotStrip
  private long mNativePointer = 0L;
  
  public HybridData()
  {
    Prerequisites.ensure();
  }
  
  protected void finalize()
    throws Throwable
  {
    resetNative();
    super.finalize();
  }
  
  public native void resetNative();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\jni\HybridData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */