package com.tencent.mobileqq.filemanager.discoperation;

import com.tencent.mobileqq.transfile.NetResp;

public abstract interface IFileHttpUploderSink
{
  public abstract long a(NetResp paramNetResp, FileReportData paramFileReportData);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(FileReportData paramFileReportData);
  
  public abstract void a(boolean paramBoolean, FileReportData paramFileReportData);
  
  public abstract byte[] a(byte[] paramArrayOfByte, long paramLong, FileReportData paramFileReportData);
  
  public abstract void b(FileReportData paramFileReportData);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\discoperation\IFileHttpUploderSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */