package com.tencent.upload.uinterface.action;

import FileUpload.UploadUpsInfoReq;
import FileUpload.UploadUpsInfoRsp;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.tencent.imageservice.BitmapUtils;
import com.tencent.upload.a.d;
import com.tencent.upload.b.a.a;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.upload.uinterface.data.UpsImageUploadTask;

public class UpsImageUploadAction
  extends d
{
  private boolean a;
  
  public UpsImageUploadAction(UpsImageUploadTask paramUpsImageUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramUpsImageUploadTask);
    this.a = paramBoolean;
    int i = this.mConfig.getAppId();
    UploadUpsInfoReq localUploadUpsInfoReq = new UploadUpsInfoReq();
    localUploadUpsInfoReq.e = paramUpsImageUploadTask.keepRaw;
    localUploadUpsInfoReq.f = i;
    localUploadUpsInfoReq.c = paramUpsImageUploadTask.dataType;
    localUploadUpsInfoReq.b = paramUpsImageUploadTask.fileId;
    localUploadUpsInfoReq.a = paramUpsImageUploadTask.sBusinessId;
    localUploadUpsInfoReq.d = paramUpsImageUploadTask.vBusiNessData;
    if (paramUpsImageUploadTask.iBusiNessType != 0) {
      i = 1;
    }
    for (;;)
    {
      localUploadUpsInfoReq.g = ((byte)i);
      localUploadUpsInfoReq.j = paramUpsImageUploadTask.iBatchID;
      localUploadUpsInfoReq.h = paramUpsImageUploadTask.iBatchUploadCount;
      localUploadUpsInfoReq.i = paramUpsImageUploadTask.iCurrentUploadOrder;
      localUploadUpsInfoReq.k = paramUpsImageUploadTask.sCommand;
      BitmapFactory.Options localOptions = BitmapUtils.getOptions();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramUpsImageUploadTask.uploadFilePath, localOptions);
      localUploadUpsInfoReq.m = localOptions.outHeight;
      localUploadUpsInfoReq.l = localOptions.outWidth;
      localUploadUpsInfoReq.n = paramUpsImageUploadTask.mapExt;
      com.tencent.upload.a.b.b("FlowWrapper", "UploadUpsInfoReq [sBusinessId=" + localUploadUpsInfoReq.a + ", iType=" + localUploadUpsInfoReq.c + ", sFileId=" + localUploadUpsInfoReq.b + "]");
      localOptions = null;
      try
      {
        this.mUploadFileInfoReqBytes = a.a(localUploadUpsInfoReq.getClass().getSimpleName(), localUploadUpsInfoReq);
        if (this.mUploadFileInfoReqBytes == null)
        {
          paramUpsImageUploadTask = localOptions;
          if (localOptions == null) {
            paramUpsImageUploadTask = new Exception("UpsImageUploadAction() pack UploadUpsInfoReq=null. " + localUploadUpsInfoReq);
          }
          throw paramUpsImageUploadTask;
          i = 0;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.upload.a.b.a("FlowWrapper", localException);
        }
        this.mSvcRequestHead = createSvcRequestHead(paramUpsImageUploadTask);
      }
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
      localUploadUpsInfoRsp = (UploadUpsInfoRsp)a.a(UploadUpsInfoRsp.class.getSimpleName(), paramArrayOfByte);
      localObject1 = null;
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        UploadUpsInfoRsp localUploadUpsInfoRsp;
        localObject1 = Log.getStackTraceString(localException);
        com.tencent.upload.a.b.a("FlowWrapper", localException);
        localObject2 = null;
      }
      com.tencent.upload.a.b.b("FlowWrapper", "UploadUpsInfoReq [iType=" + ((UploadUpsInfoRsp)localObject2).iType + "]");
      if (this.mUploadTaskCallback == null) {
        break label204;
      }
      Object localObject1 = new UpsImageUploadResult();
      ((UpsImageUploadResult)localObject1).flowId = this.mAbstractUploadTask.flowId;
      ((UpsImageUploadResult)localObject1).dataType = ((UploadUpsInfoRsp)localObject2).iType;
      ((UpsImageUploadResult)localObject1).vBusiNessData = ((UploadUpsInfoRsp)localObject2).vBusiNessData;
      ((UpsImageUploadResult)localObject1).url = ((UploadUpsInfoRsp)localObject2).sUrl;
      ((UpsImageUploadResult)localObject1).rawWidth = ((UploadUpsInfoRsp)localObject2).iWidth;
      ((UpsImageUploadResult)localObject1).rawHeight = ((UploadUpsInfoRsp)localObject2).iHight;
      ((UpsImageUploadResult)localObject1).photoType = ((UploadUpsInfoRsp)localObject2).iPhotoType;
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localObject1);
      label204:
      super.processFileUploadFinishRsp(paramArrayOfByte, this.mAbstractUploadTask.flowId);
      return;
    }
    if (localUploadUpsInfoRsp == null)
    {
      if (localObject1 != null) {
        break label217;
      }
      localObject1 = "processFileUploadFinishRsp() unpack UploadUpsInfoRsp=null. " + paramArrayOfByte;
    }
    label217:
    for (boolean bool = true;; bool = false)
    {
      cancelActionForException(500, 0, true, bool, (String)localObject1, null);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\UpsImageUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */