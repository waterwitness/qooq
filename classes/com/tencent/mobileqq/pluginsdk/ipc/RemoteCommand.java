package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;

public abstract class RemoteCommand
{
  public static final String RESULT_KEY = "result_key";
  private String a;
  
  public RemoteCommand(String paramString)
  {
    this.a = paramString;
  }
  
  public String getCmd()
  {
    return this.a;
  }
  
  public abstract Bundle invoke(Bundle paramBundle, OnInvokeFinishLinstener paramOnInvokeFinishLinstener);
  
  public boolean isSynchronized()
  {
    return true;
  }
  
  public String toString()
  {
    return "[cmd:" + this.a + ", sync:" + isSynchronized() + "]";
  }
  
  public static abstract interface OnInvokeFinishLinstener
  {
    public abstract void onInvokeFinish(Bundle paramBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\ipc\RemoteCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */