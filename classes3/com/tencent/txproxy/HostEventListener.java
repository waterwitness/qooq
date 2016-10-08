package com.tencent.txproxy;

public abstract interface HostEventListener
{
  public abstract void onDownloadProgress(long paramLong1, long paramLong2);
  
  public abstract void onDownloadResult(int paramInt1, int paramInt2, String paramString);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\txproxy\HostEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */