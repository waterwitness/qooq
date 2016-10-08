package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.highway.utils.EndPoint;

public abstract interface IConnectionListener
{
  public abstract void onConnect(boolean paramBoolean, int paramInt1, IConnection paramIConnection, EndPoint paramEndPoint, int paramInt2, ConnReportInfo paramConnReportInfo);
  
  public abstract void onConnectionIdle(int paramInt, boolean paramBoolean);
  
  public abstract void onDisConnect(int paramInt, IConnection paramIConnection);
  
  public abstract void onRecvInvalidData(EndPoint paramEndPoint);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\conn\IConnectionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */