package com.tencent.litetransfersdk;

public abstract interface LiteTransferListenerCallback
{
  public abstract void OnGroupComplete(int paramInt1, int paramInt2);
  
  public abstract void OnGroupStart(int paramInt);
  
  public abstract void OnSessionComplete(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo);
  
  public abstract void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void OnSessionStart(long paramLong);
  
  public abstract void OnSessionUpdate(int paramInt, long paramLong, String paramString);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\litetransfersdk\LiteTransferListenerCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */