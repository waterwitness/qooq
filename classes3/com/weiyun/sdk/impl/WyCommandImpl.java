package com.weiyun.sdk.impl;

import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyCommand;

public class WyCommandImpl<T>
  implements IWyFileSystem.WyCommand
{
  protected volatile IWyFileSystem.IWyCallback<T> mCallback;
  protected volatile boolean mCanceled = false;
  
  public WyCommandImpl(IWyFileSystem.IWyCallback<T> paramIWyCallback)
  {
    this.mCallback = paramIWyCallback;
  }
  
  public void cancel()
  {
    this.mCanceled = true;
    try
    {
      this.mCallback = null;
      return;
    }
    finally {}
  }
  
  public IWyFileSystem.IWyCallback<T> getCallback()
  {
    try
    {
      IWyFileSystem.IWyCallback localIWyCallback = this.mCallback;
      return localIWyCallback;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\impl\WyCommandImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */