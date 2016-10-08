package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.highway.utils.EndPoint;

public abstract interface IConnection
{
  public abstract void connect();
  
  public abstract void disConnect();
  
  public abstract int getConnId();
  
  public abstract EndPoint getEndPoint();
  
  public abstract int getProtoType();
  
  public abstract boolean isWritable();
  
  public abstract void setConnectListener(IConnectionListener paramIConnectionListener);
  
  public abstract void setUrgentFlag(boolean paramBoolean);
  
  public abstract void wakeupChannel();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\conn\IConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */