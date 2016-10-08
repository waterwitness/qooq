package com.tencent.upload.uinterface.action;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.upload.a.d;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.PhotoWallUploadResult;
import com.tencent.upload.uinterface.data.PhotoWallUploadTask;
import org.json.JSONObject;

public class PhotoWallUploadAction
  extends d
{
  private boolean a;
  
  public PhotoWallUploadAction(PhotoWallUploadTask paramPhotoWallUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramPhotoWallUploadTask);
    this.a = paramBoolean;
    Object localObject = null;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("op", paramPhotoWallUploadTask.op);
      localJSONObject.put("source", paramPhotoWallUploadTask.source);
      if (!TextUtils.isEmpty(paramPhotoWallUploadTask.clientIp)) {
        localJSONObject.put("ip", paramPhotoWallUploadTask.clientIp);
      }
      if (!TextUtils.isEmpty(paramPhotoWallUploadTask.title)) {
        localJSONObject.put("title", paramPhotoWallUploadTask.title);
      }
      this.mUploadFileInfoReqBytes = localJSONObject.toString().getBytes();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.upload.a.b.b("FlowWrapper", "create photowallUpload DescInfor err", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramPhotoWallUploadTask);
    }
    if (this.mUploadFileInfoReqBytes == null)
    {
      paramPhotoWallUploadTask = (PhotoWallUploadTask)localObject;
      if (localObject == null) {
        paramPhotoWallUploadTask = new Exception("create photowallUpload DescInfor err,but exeception is null");
      }
      throw paramPhotoWallUploadTask;
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
    if (paramArrayOfByte == null)
    {
      cancelActionForException(500, 0, true, false, "photowall upload task response is null", null);
      return;
    }
    Object localObject1 = new String(paramArrayOfByte);
    try
    {
      localPhotoWallUploadResult = new PhotoWallUploadResult();
      localPhotoWallUploadResult.flowId = this.mAbstractUploadTask.flowId;
      localObject1 = new JSONObject((String)localObject1);
      localPhotoWallUploadResult.burl = ((JSONObject)localObject1).getString("burl");
      localPhotoWallUploadResult.ctime = ((JSONObject)localObject1).getInt("ctime");
      localPhotoWallUploadResult.filekey = ((JSONObject)localObject1).getString("filekey");
      localPhotoWallUploadResult.publish_code = ((JSONObject)localObject1).getInt("publish_code");
      localPhotoWallUploadResult.surl = ((JSONObject)localObject1).getString("surl");
      localPhotoWallUploadResult.murl = ((JSONObject)localObject1).getString("murl");
      localPhotoWallUploadResult.url = ((JSONObject)localObject1).getString("url");
      localObject1 = null;
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        PhotoWallUploadResult localPhotoWallUploadResult;
        localObject1 = Log.getStackTraceString(localException);
        com.tencent.upload.a.b.b("FlowWrapper", "decode photowallUpload result err", localException);
        localObject2 = null;
      }
      if (this.mUploadTaskCallback == null) {
        break label227;
      }
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localObject2);
      label227:
      super.processFileUploadFinishRsp(paramArrayOfByte, this.mAbstractUploadTask.flowId);
      return;
    }
    if (localPhotoWallUploadResult == null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label240;
      }
      localObject1 = "processFileUploadFinishRsp() unpack UploadPicInfoRsp=null. " + paramArrayOfByte;
    }
    label240:
    for (boolean bool = true;; bool = false)
    {
      cancelActionForException(500, 0, true, bool, (String)localObject1, null);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\PhotoWallUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */