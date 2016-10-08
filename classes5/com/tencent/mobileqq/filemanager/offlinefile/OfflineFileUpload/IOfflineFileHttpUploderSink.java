package com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload;

import com.tencent.mobileqq.transfile.NetResp;

public abstract interface IOfflineFileHttpUploderSink
{
  public abstract long a(NetResp paramNetResp);
  
  public abstract void a();
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract byte[] a(byte[] paramArrayOfByte, long paramLong);
  
  public abstract void b();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\offlinefile\OfflineFileUpload\IOfflineFileHttpUploderSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */