package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;

public class AirVideoUploadTask
  extends VideoUploadTask
{
  public AirVideoUploadTask()
  {
    super(109);
  }
  
  public IUploadTaskType getUploadTaskType()
  {
    return new AirVideoUploadTask.1(this);
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return super.onCreateUploadAction(paramBoolean);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    super.onProcessUploadTask(paramIUploadServiceContext);
  }
  
  public boolean onVerifyUploadFile()
  {
    return super.onVerifyUploadFile();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\AirVideoUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */