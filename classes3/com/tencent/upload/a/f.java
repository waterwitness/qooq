package com.tencent.upload.a;

import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.Report;

public final class f
  implements IUploadReport
{
  public final void batchComplete()
  {
    b.c("ConsoleReport", "batchComplate");
  }
  
  public final void onUploadReport(Report paramReport)
  {
    b.c("ConsoleReport", paramReport.toString());
  }
  
  public final void openSessionReport(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    b.c("ConsoleReport", "wnsSessionReport() " + paramInt1 + " " + paramString1 + " " + paramString2 + " " + paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */