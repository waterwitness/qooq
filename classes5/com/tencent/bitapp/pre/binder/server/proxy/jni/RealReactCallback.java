package com.tencent.bitapp.pre.binder.server.proxy.jni;

import com.tencent.bitapp.pre.binder.ReactCallback;
import com.tencent.bitapp.pre.binder.server.Java2JniImpl;

public class RealReactCallback
  implements ReactCallback
{
  public static final String TAG = "RealReactCallback";
  
  public void call(int paramInt1, int paramInt2, ReadableNativeArray paramReadableNativeArray)
  {
    Java2JniImpl localJava2JniImpl = Java2JniImpl.instance;
    if (localJava2JniImpl != null) {
      localJava2JniImpl.reactCallbackCall(paramInt1, paramInt2, paramReadableNativeArray);
    }
  }
  
  public void onBatchComplete()
  {
    Java2JniImpl localJava2JniImpl = Java2JniImpl.instance;
    if (localJava2JniImpl != null) {
      localJava2JniImpl.reactCallbackonBatchComplete();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\RealReactCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */