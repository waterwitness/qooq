package com.tencent.upload.uinterface.action;

import FileUpload.UploadUppInfoV2Req;
import FileUpload.UploadUppInfoV2Rsp;
import FileUpload.stPhotoSepcInfo;
import android.util.Log;
import com.tencent.imageservice.ImageProcessUtil;
import com.tencent.upload.a.b;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.QunUppUploadResult;
import com.tencent.upload.uinterface.data.QunUppUploadTask;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class QunUppUploadAction
  extends com.tencent.upload.a.d
{
  public QunUppUploadAction(QunUppUploadTask paramQunUppUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramQunUppUploadTask);
    UploadUppInfoV2Req localUploadUppInfoV2Req = new UploadUppInfoV2Req();
    localUploadUppInfoV2Req.a = "qun";
    localUploadUppInfoV2Req.b = paramQunUppUploadTask.userId;
    localUploadUppInfoV2Req.c = paramQunUppUploadTask.albumId;
    localUploadUppInfoV2Req.d = paramQunUppUploadTask.title;
    localUploadUppInfoV2Req.e = paramQunUppUploadTask.desc;
    localUploadUppInfoV2Req.j = paramQunUppUploadTask.uploadFilePath;
    localUploadUppInfoV2Req.f = 0;
    localUploadUppInfoV2Req.g = 1L;
    localUploadUppInfoV2Req.k = paramQunUppUploadTask.batchId;
    Object localObject = new stPhotoSepcInfo();
    File localFile = new File(paramQunUppUploadTask.uploadFilePath);
    ((stPhotoSepcInfo)localObject).iPhotoSize = localFile.length();
    IUploadConfig.UploadImageSize localUploadImageSize = ImageProcessUtil.decodeBitmapSize(paramQunUppUploadTask.uploadFilePath);
    ((stPhotoSepcInfo)localObject).iPhotoWidth = localUploadImageSize.width;
    ((stPhotoSepcInfo)localObject).iPhotoHeight = localUploadImageSize.height;
    ((stPhotoSepcInfo)localObject).iPhotoType = paramQunUppUploadTask.photoType;
    localUploadUppInfoV2Req.h = ((stPhotoSepcInfo)localObject);
    localUploadUppInfoV2Req.l = paramQunUppUploadTask.mutipic;
    localObject = new HashMap();
    ((Map)localObject).put("sFileMD5", getMd5$774aca96(localFile).b());
    ((Map)localObject).put("sFirm", paramQunUppUploadTask.deviceInfo);
    ((Map)localObject).put("dLongitude", paramQunUppUploadTask.poiX);
    ((Map)localObject).put("dLatitude", paramQunUppUploadTask.poiY);
    ((Map)localObject).put("sPOIName", paramQunUppUploadTask.poiName);
    ((Map)localObject).put("sPOIType", Integer.toString(paramQunUppUploadTask.poiType));
    ((Map)localObject).put("mobile_fakefeeds_clientkey", com.tencent.upload.common.d.a(paramQunUppUploadTask.clientFakeKey));
    ((Map)localObject).put("a2", com.tencent.upload.common.d.a(paramQunUppUploadTask.A2));
    localUploadUppInfoV2Req.i = ((Map)localObject);
    localFile = null;
    try
    {
      this.mUploadFileInfoReqBytes = com.tencent.upload.b.a.a.a(localUploadUppInfoV2Req.getClass().getSimpleName(), localUploadUppInfoV2Req);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramQunUppUploadTask = localFile;
        if (localFile == null) {
          paramQunUppUploadTask = new Exception("ImageUploadAction() pack mUploadUppInfoReq=null. " + localUploadUppInfoV2Req);
        }
        throw paramQunUppUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.a("FlowWrapper", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramQunUppUploadTask);
    }
  }
  
  protected byte[] getControlRequestData()
  {
    try
    {
      Object localObject = (QunUppUploadTask)this.mAbstractUploadTask;
      localObject = com.tencent.upload.b.a.a.a(localObject.getClass().getSimpleName(), localObject);
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      b.a("FlowWrapper", localException);
    }
    return super.getControlRequestData();
  }
  
  protected void processFileUploadFinishRsp(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      UploadUppInfoV2Rsp localUploadUppInfoV2Rsp = (UploadUppInfoV2Rsp)com.tencent.upload.b.a.a.a(UploadUppInfoV2Rsp.class.getSimpleName(), paramArrayOfByte);
      if ((this.mUploadTaskCallback != null) && (localUploadUppInfoV2Rsp != null))
      {
        QunUppUploadResult localQunUppUploadResult = new QunUppUploadResult();
        localQunUppUploadResult.flowId = this.mAbstractUploadTask.flowId;
        localQunUppUploadResult.url = localUploadUppInfoV2Rsp.a;
        localQunUppUploadResult.photoId = localUploadUppInfoV2Rsp.b;
        localQunUppUploadResult.mapSpecInfo = localUploadUppInfoV2Rsp.c;
        this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localQunUppUploadResult);
        super.processFileUploadFinishRsp(paramArrayOfByte, this.mAbstractUploadTask.flowId);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.getStackTraceString(localException);
        b.a("FlowWrapper", localException);
        Object localObject = null;
        continue;
        if (this.mUploadTaskCallback != null) {
          this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, null);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\QunUppUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */