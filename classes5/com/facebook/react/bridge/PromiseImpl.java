package com.facebook.react.bridge;

import com.tencent.bitapp.pre.binder.server.proxy.jni.WritableNativeMap;
import javax.annotation.Nullable;

public class PromiseImpl
  implements Promise
{
  @Nullable
  private Callback mReject;
  @Nullable
  private Callback mResolve;
  
  public PromiseImpl(@Nullable Callback paramCallback1, @Nullable Callback paramCallback2)
  {
    this.mResolve = paramCallback1;
    this.mReject = paramCallback2;
  }
  
  public void reject(String paramString)
  {
    if (this.mReject != null)
    {
      WritableNativeMap localWritableNativeMap = new WritableNativeMap();
      localWritableNativeMap.putString("message", paramString);
      this.mReject.invoke(new Object[] { localWritableNativeMap });
    }
  }
  
  public void reject(Throwable paramThrowable)
  {
    reject(paramThrowable.getMessage());
  }
  
  public void resolve(Object paramObject)
  {
    if (this.mResolve != null) {
      this.mResolve.invoke(new Object[] { paramObject });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\PromiseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */