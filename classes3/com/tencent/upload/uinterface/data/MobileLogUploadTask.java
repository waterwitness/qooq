package com.tencent.upload.uinterface.data;

import com.tencent.upload.a.b;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.MobileLogUploadAction;
import com.tencent.upload.uinterface.protocol.HeadUploadTaskType;
import com.tencent.upload.uinterface.protocol.MobileLogUploadTaskType;

public class MobileLogUploadTask
  extends AbstractUploadTask
{
  public String clientFakeKey;
  public int iUploadType = 3;
  public final boolean isHead;
  public final String originalPath;
  
  public MobileLogUploadTask(boolean paramBoolean, String paramString)
  {
    this.isHead = paramBoolean;
    this.originalPath = paramString;
    this.uploadFilePath = paramString;
  }
  
  public final String getOriginalUploadFilePath()
  {
    return this.originalPath;
  }
  
  public IUploadTaskType getUploadTaskType()
  {
    if (this.isHead) {
      return new HeadUploadTaskType();
    }
    return new MobileLogUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new MobileLogUploadAction(this, paramBoolean);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    b.b("ServiceImpl", " onProcessUploadTask, iUploadType:" + this.iUploadType + " flowId:" + this.flowId);
    b.a(paramIUploadServiceContext, this, "", 104857600);
  }
  
  public boolean onVerifyUploadFile()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\MobileLogUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */