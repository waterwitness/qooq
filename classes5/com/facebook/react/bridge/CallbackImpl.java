package com.facebook.react.bridge;

public final class CallbackImpl
  implements Callback
{
  private final int mCallbackId;
  private final CatalystInstance mCatalystInstance;
  
  public CallbackImpl(CatalystInstance paramCatalystInstance, int paramInt)
  {
    this.mCatalystInstance = paramCatalystInstance;
    this.mCallbackId = paramInt;
  }
  
  public void invoke(Object... paramVarArgs)
  {
    this.mCatalystInstance.invokeCallback(this.mCallbackId, paramVarArgs);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\CallbackImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */