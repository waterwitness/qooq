package com.tencent.upload.uinterface;

public abstract interface IUploadReport
{
  public abstract void batchComplete();
  
  public abstract void onUploadReport(Report paramReport);
  
  public abstract void openSessionReport(int paramInt1, String paramString1, String paramString2, int paramInt2);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\IUploadReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */