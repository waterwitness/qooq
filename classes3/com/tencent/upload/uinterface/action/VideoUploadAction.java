package com.tencent.upload.uinterface.action;

import FileUpload.UploadVideoInfoReq;
import FileUpload.UploadVideoInfoRsp;
import android.util.Log;
import com.tencent.upload.a.d;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.AirVideoUploadTask;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadTask;
import java.io.File;

public class VideoUploadAction
  extends d
{
  public VideoUploadAction(VideoUploadTask paramVideoUploadTask)
    throws Exception
  {
    super(paramVideoUploadTask);
    UploadVideoInfoReq localUploadVideoInfoReq = new UploadVideoInfoReq();
    localUploadVideoInfoReq.a = paramVideoUploadTask.sTitle;
    localUploadVideoInfoReq.b = paramVideoUploadTask.sDesc;
    localUploadVideoInfoReq.c = paramVideoUploadTask.iFlag;
    localUploadVideoInfoReq.i = paramVideoUploadTask.iIsNew;
    localUploadVideoInfoReq.d = paramVideoUploadTask.iUploadTime;
    localUploadVideoInfoReq.h = paramVideoUploadTask.sCoverUrl;
    localUploadVideoInfoReq.g = paramVideoUploadTask.iPlayTime;
    byte[] arrayOfByte;
    if (paramVideoUploadTask.vBusiNessData == null) {
      arrayOfByte = new byte[0];
    }
    for (;;)
    {
      localUploadVideoInfoReq.f = arrayOfByte;
      localUploadVideoInfoReq.e = paramVideoUploadTask.iBusiNessType;
      localUploadVideoInfoReq.j = paramVideoUploadTask.iIsOriginalVideo;
      localUploadVideoInfoReq.k = paramVideoUploadTask.iIsFormatF20;
      com.tencent.upload.a.b.b("FlowWrapper", "UploadVideoInfoReq [sTitle=" + localUploadVideoInfoReq.a + ", sDesc=" + localUploadVideoInfoReq.b + ", iFlag=" + localUploadVideoInfoReq.c + ", iUploadTime=" + localUploadVideoInfoReq.d + "]");
      arrayOfByte = null;
      try
      {
        this.mUploadFileInfoReqBytes = com.tencent.upload.b.a.a.a(localUploadVideoInfoReq.getClass().getSimpleName(), localUploadVideoInfoReq);
        if (this.mUploadFileInfoReqBytes == null)
        {
          paramVideoUploadTask = arrayOfByte;
          if (arrayOfByte == null) {
            paramVideoUploadTask = new Exception("ImageUploadAction() pack UploadVideoInfoReq=null. " + localUploadVideoInfoReq);
          }
          throw paramVideoUploadTask;
          arrayOfByte = paramVideoUploadTask.vBusiNessData;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.upload.a.b.a("FlowWrapper", localException);
        }
        this.mSvcRequestHead = createSvcRequestHead(paramVideoUploadTask);
      }
    }
  }
  
  protected com.tencent.upload.common.a getMd5$774aca96(File paramFile)
  {
    if ((this.mAbstractUploadTask != null) && ((this.mAbstractUploadTask instanceof AirVideoUploadTask))) {
      return new com.tencent.upload.common.a(1, com.tencent.upload.common.b.a(paramFile));
    }
    return new com.tencent.upload.common.a(2, com.tencent.upload.common.b.c(paramFile));
  }
  
  protected void onDestroy(boolean paramBoolean)
  {
    if (paramBoolean) {
      com.tencent.upload.common.b.c(this.mAbstractUploadTask.uploadFilePath);
    }
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      localUploadVideoInfoRsp = (UploadVideoInfoRsp)com.tencent.upload.b.a.a.a(UploadVideoInfoRsp.class.getSimpleName(), paramArrayOfByte);
      localObject1 = null;
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        UploadVideoInfoRsp localUploadVideoInfoRsp;
        localObject1 = Log.getStackTraceString(localException);
        com.tencent.upload.a.b.a("FlowWrapper", localException);
        localObject2 = null;
      }
      com.tencent.upload.a.b.b("FlowWrapper", "UploadVideoInfoRsp [sVid=" + ((UploadVideoInfoRsp)localObject2).sVid + "]");
      if (this.mUploadTaskCallback == null) {
        break label177;
      }
      Object localObject1 = new VideoUploadResult();
      ((VideoUploadResult)localObject1).flowId = this.mAbstractUploadTask.flowId;
      ((VideoUploadResult)localObject1).sVid = ((UploadVideoInfoRsp)localObject2).sVid;
      ((VideoUploadResult)localObject1).iBusiNessType = ((UploadVideoInfoRsp)localObject2).iBusiNessType;
      ((VideoUploadResult)localObject1).vBusiNessData = ((UploadVideoInfoRsp)localObject2).vBusiNessData;
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localObject1);
      label177:
      super.processFileUploadFinishRsp(paramArrayOfByte, this.mAbstractUploadTask.flowId);
      return;
    }
    if (localUploadVideoInfoRsp == null)
    {
      if (localObject1 != null) {
        break label190;
      }
      localObject1 = "processFileUploadFinishRsp() unpack UploadVideoInfoRsp=null. " + paramArrayOfByte;
    }
    label190:
    for (boolean bool = true;; bool = false)
    {
      cancelActionForException(500, 0, true, bool, (String)localObject1, null);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\VideoUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */