package com.tencent.litetransfersdk;

public abstract interface LiteTransferOperatorCallback
{
  public abstract void GetThumbFilePath(int paramInt, Session paramSession);
  
  public abstract void HandleSession(int paramInt1, long paramLong, int paramInt2, MsgHeader paramMsgHeader);
  
  public abstract void InvokeReport(ReportItem paramReportItem);
  
  public abstract boolean OnQueryAutoDownload(long paramLong, byte paramByte);
  
  public abstract void SendPbMsg(int paramInt, MsgCSBody paramMsgCSBody);
  
  public abstract boolean getAutoDownload();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\LiteTransferOperatorCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */