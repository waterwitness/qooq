package com.tencent.upload.uinterface.data;

import com.tencent.upload.a.b;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.action.VideoUploadAction;
import com.tencent.upload.uinterface.protocol.VideoUploadTaskType;

public class VideoUploadTask
  extends AbstractUploadTask
{
  public int iBusiNessType = 0;
  public int iFlag = 0;
  public int iIsFormatF20 = 0;
  public final int iIsNew;
  public int iIsOriginalVideo = 0;
  public int iPlayTime = 0;
  public String sCoverUrl = "";
  public String sDesc = "";
  public String sTitle = "";
  public byte[] vBusiNessData = null;
  
  public VideoUploadTask(int paramInt)
  {
    this.iIsNew = paramInt;
  }
  
  public IUploadTaskType getUploadTaskType()
  {
    return new VideoUploadTaskType();
  }
  
  public IUploadAction onCreateUploadAction(boolean paramBoolean)
    throws Exception
  {
    return new VideoUploadAction(this);
  }
  
  public void onProcessUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext)
  {
    b.a(paramIUploadServiceContext, this, null, 3145728);
  }
  
  public boolean onVerifyUploadFile()
  {
    return b.b(this);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\VideoUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */