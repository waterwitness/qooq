package com.tencent.upload.uinterface.data;

import com.tencent.upload.a.b;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.AudioUploadAction;
import com.tencent.upload.uinterface.protocol.AudioUploadTaskType;

public class AudioUploadTask
  extends AbstractUploadTask
{
  public int appid = 0;
  public long client_ip = 0L;
  public int format = 0;
  public int voice_length = 0;
  
  public IUploadTaskType getUploadTaskType()
  {
    return new AudioUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new AudioUploadAction(this);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    b.b(paramIUploadServiceContext, this);
  }
  
  public boolean onVerifyUploadFile()
  {
    return b.b(this);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\AudioUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */