package com.tencent.bitapp.pre.binder;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class NativeRunnable
  extends Countable
  implements Runnable
{
  public native void run();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\NativeRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */