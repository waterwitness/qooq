package com.tencent.upload.uinterface.action;

import FileUpload.SvcRequestHead;
import com.tencent.upload.a.d;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.MobileLogUploadResult;
import com.tencent.upload.uinterface.data.MobileLogUploadTask;
import java.io.File;

public class MobileLogUploadAction
  extends d
{
  protected static final String tag = "MobileLogUploadAction";
  private boolean a;
  private int b;
  
  public MobileLogUploadAction(MobileLogUploadTask paramMobileLogUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramMobileLogUploadTask);
    this.a = paramBoolean;
    this.mSvcRequestHead = createSvcRequestHead(paramMobileLogUploadTask);
    com.tencent.upload.a.b.b("MobileLogUploadAction", "MobileUploadAction flowId = " + paramMobileLogUploadTask.flowId + " sDescMD5 = " + this.mSvcRequestHead.i + " sFileMD5 = " + this.mSvcRequestHead.h);
  }
  
  protected byte[] getFileUploadControlReq()
  {
    return null;
  }
  
  protected com.tencent.upload.common.a getMd5$774aca96(File paramFile)
  {
    return new com.tencent.upload.common.a(1, com.tencent.upload.common.b.a(paramFile));
  }
  
  protected void hookSvcRequestHead()
  {
    this.mSvcRequestHead.r = -1;
  }
  
  protected void onDestroy(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a)) {
      com.tencent.upload.common.b.c(this.mAbstractUploadTask.uploadFilePath);
    }
  }
  
  public void onError(com.tencent.upload.network.c.a parama, int paramInt, String paramString, boolean paramBoolean)
  {
    int i;
    if (paramInt != 30500)
    {
      i = paramInt;
      if (paramInt != 30600) {}
    }
    else
    {
      i = 31600;
    }
    super.onError(parama, i, paramString, paramBoolean);
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte, int paramInt)
  {
    MobileLogUploadTask localMobileLogUploadTask = (MobileLogUploadTask)this.mAbstractUploadTask;
    MobileLogUploadResult localMobileLogUploadResult = new MobileLogUploadResult(localMobileLogUploadTask.iUin, localMobileLogUploadTask.flowId);
    if (this.mUploadTaskCallback != null)
    {
      com.tencent.upload.a.b.b("MobileLogUploadAction", "onUploadSucceed flowid = " + this.mAbstractUploadTask.flowId + " filepath = " + this.mAbstractUploadTask.uploadFilePath);
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localMobileLogUploadResult);
    }
    super.processFileUploadFinishRsp(paramArrayOfByte, localMobileLogUploadTask.flowId);
  }
  
  protected void report(int paramInt, String paramString, AbstractUploadTask paramAbstractUploadTask)
  {
    int i = paramInt;
    if (this.b == -60)
    {
      i = paramInt;
      if (paramInt == 0) {
        i = -65;
      }
    }
    com.tencent.upload.a.b.b("MobileLogUploadAction", "report() errorCode=" + i + " lastErrorCode = " + this.b + " flow:" + paramAbstractUploadTask.flowId + " errorMsg=" + paramString + " retry=" + (this.mRetryPartFileCount + this.mRetryControlCount));
    this.b = i;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\MobileLogUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */