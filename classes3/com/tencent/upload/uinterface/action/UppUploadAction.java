package com.tencent.upload.uinterface.action;

import FileUpload.UploadUppInfoReq;
import FileUpload.UploadUppInfoRsp;
import android.util.Log;
import com.tencent.upload.a.d;
import com.tencent.upload.b.a.a;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.UppUploadResult;
import com.tencent.upload.uinterface.data.UppUploadTask;

public class UppUploadAction
  extends d
{
  private boolean a;
  
  public UppUploadAction(UppUploadTask paramUppUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramUppUploadTask);
    this.a = paramBoolean;
    UploadUppInfoReq localUploadUppInfoReq = new UploadUppInfoReq();
    localUploadUppInfoReq.a = "diy";
    com.tencent.upload.a.b.b("FlowWrapper", "UploadUppInfoReq [appid=" + localUploadUppInfoReq.a + "]");
    Object localObject = null;
    try
    {
      this.mUploadFileInfoReqBytes = a.a(localUploadUppInfoReq.getClass().getSimpleName(), localUploadUppInfoReq);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramUppUploadTask = (UppUploadTask)localObject;
        if (localObject == null) {
          paramUppUploadTask = new Exception("ImageUploadAction() pack UploadUppInfoReq=null. " + localUploadUppInfoReq);
        }
        throw paramUppUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.upload.a.b.a("FlowWrapper", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramUppUploadTask);
    }
  }
  
  protected void onDestroy(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a)) {
      com.tencent.upload.common.b.c(this.mAbstractUploadTask.uploadFilePath);
    }
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      localUploadUppInfoRsp = (UploadUppInfoRsp)a.a(UploadUppInfoRsp.class.getSimpleName(), paramArrayOfByte);
      localObject1 = null;
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        UploadUppInfoRsp localUploadUppInfoRsp;
        localObject1 = Log.getStackTraceString(localException);
        com.tencent.upload.a.b.a("FlowWrapper", localException);
        localObject2 = null;
      }
      com.tencent.upload.a.b.a("FlowWrapper", "UploadUppInfoRsp [sUrl=" + ((UploadUppInfoRsp)localObject2).a + "]");
      if (this.mUploadTaskCallback == null) {
        break label159;
      }
      Object localObject1 = new UppUploadResult();
      ((UppUploadResult)localObject1).flowId = this.mAbstractUploadTask.flowId;
      ((UppUploadResult)localObject1).sUrl = ((UploadUppInfoRsp)localObject2).a;
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localObject1);
      label159:
      super.processFileUploadFinishRsp(paramArrayOfByte, this.mAbstractUploadTask.flowId);
      return;
    }
    if (localUploadUppInfoRsp == null)
    {
      if (localObject1 != null) {
        break label172;
      }
      localObject1 = "processFileUploadFinishRsp() unpack UploadUppInfoRsp=null. " + paramArrayOfByte;
    }
    label172:
    for (boolean bool = true;; bool = false)
    {
      cancelActionForException(500, 0, true, bool, (String)localObject1, null);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\UppUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */