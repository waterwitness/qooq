package com.tencent.av.service;

import android.os.IInterface;

public abstract interface IQQServiceCallback
  extends IInterface
{
  public abstract void a(RecvMsg paramRecvMsg);
  
  public abstract void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\IQQServiceCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */