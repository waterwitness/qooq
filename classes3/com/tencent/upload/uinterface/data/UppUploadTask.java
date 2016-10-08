package com.tencent.upload.uinterface.data;

import com.tencent.upload.a.b;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.UppUploadAction;
import com.tencent.upload.uinterface.protocol.UppUploadTaskType;

public class UppUploadTask
  extends AbstractUploadTask
{
  public static final String sfUppAppId = "diy";
  
  public IUploadTaskType getUploadTaskType()
  {
    return new UppUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new UppUploadAction(this, paramBoolean);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    b.a(paramIUploadServiceContext, this, 0, false);
  }
  
  public boolean onVerifyUploadFile()
  {
    return b.a(this);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\UppUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */