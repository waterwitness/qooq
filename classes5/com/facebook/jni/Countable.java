package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class Countable
{
  @DoNotStrip
  private long mInstance = 0L;
  
  public Countable()
  {
    Prerequisites.ensure();
  }
  
  public native void dispose();
  
  protected void finalize()
    throws Throwable
  {
    dispose();
    super.finalize();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\jni\Countable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */