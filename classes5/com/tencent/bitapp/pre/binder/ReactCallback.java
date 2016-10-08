package com.tencent.bitapp.pre.binder;

import com.facebook.proguard.annotations.DoNotStrip;
import com.tencent.bitapp.pre.binder.server.proxy.jni.ReadableNativeArray;

@DoNotStrip
public abstract interface ReactCallback
{
  @DoNotStrip
  public abstract void call(int paramInt1, int paramInt2, ReadableNativeArray paramReadableNativeArray);
  
  @DoNotStrip
  public abstract void onBatchComplete();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\ReactCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */