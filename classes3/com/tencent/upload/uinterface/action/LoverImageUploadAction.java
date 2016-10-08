package com.tencent.upload.uinterface.action;

import FileUpload.SvcResponsePacket;
import com.tencent.upload.a.d;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.LoverImageUploadResult;
import com.tencent.upload.uinterface.data.LoverImageUploadTask;

public class LoverImageUploadAction
  extends d
{
  private boolean a;
  private int b = 0;
  
  public LoverImageUploadAction(AbstractUploadTask paramAbstractUploadTask, boolean paramBoolean)
    throws Exception
  {
    super(paramAbstractUploadTask);
    this.a = paramBoolean;
    LoverImageUploadTask localLoverImageUploadTask = (LoverImageUploadTask)paramAbstractUploadTask;
    a.a locala = new a.a();
    locala.a = localLoverImageUploadTask.mPicTitle;
    locala.b = localLoverImageUploadTask.mPicDesc;
    locala.c = 3;
    locala.d = localLoverImageUploadTask.mAlbumID;
    locala.e = localLoverImageUploadTask.mBatchID;
    locala.f = localLoverImageUploadTask.mPictureType;
    locala.g = paramAbstractUploadTask.uploadFilePath;
    locala.h = localLoverImageUploadTask.mPicWidth;
    locala.i = localLoverImageUploadTask.mPicHight;
    locala.j = localLoverImageUploadTask.mClientip;
    locala.k = localLoverImageUploadTask.mIsShareFeeds;
    locala.l = localLoverImageUploadTask.mUserAgent;
    locala.m = localLoverImageUploadTask.mAddress;
    locala.n = localLoverImageUploadTask.mPictotalNum;
    locala.o = localLoverImageUploadTask.mCurPicNum;
    locala.p = localLoverImageUploadTask.mFromQZone;
    locala.q = localLoverImageUploadTask.mPicUrl;
    locala.w = 64;
    locala.x = localLoverImageUploadTask.vLoginData;
    locala.r = localLoverImageUploadTask.mLocalid;
    locala.s = localLoverImageUploadTask.mOs;
    locala.t = localLoverImageUploadTask.mDeviceID;
    locala.u = localLoverImageUploadTask.mOsVersion;
    locala.v = localLoverImageUploadTask.mAppVersion;
    locala.y = "0.0";
    locala.z = "0";
    locala.A = "0";
    com.tencent.upload.a.b.b("FlowWrapper", "SWUploadPicReq [sPicTitle=" + locala.a + ", sPicDesc=" + locala.b + ", sPicPath=" + locala.g + "]");
    localLoverImageUploadTask = null;
    try
    {
      this.mUploadFileInfoReqBytes = com.tencent.upload.b.a.a.a(locala.getClass().getSimpleName(), locala);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramAbstractUploadTask = localLoverImageUploadTask;
        if (localLoverImageUploadTask == null) {
          paramAbstractUploadTask = new Exception("LoverImageUploadAction() pack SWUploadPicReq=null. " + locala);
        }
        throw paramAbstractUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.upload.a.b.a("FlowWrapper", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramAbstractUploadTask);
      this.mSvcRequestHead.a = 15;
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
    a.b localb = new a.b();
    localb.a = this.b;
    com.tencent.upload.a.b.b("FlowWrapper", "SWUploadPicRsp [iCode=" + localb.a + "]");
    if (this.b != 0)
    {
      cancelActionForException(500, 0, true, true, "LoverImageUploadAction mIsUploadSuccess = false", null);
      return;
    }
    if (this.mUploadTaskCallback != null)
    {
      LoverImageUploadResult localLoverImageUploadResult = new LoverImageUploadResult();
      localLoverImageUploadResult.code = localb.a;
      localLoverImageUploadResult.albumId = localb.c;
      localLoverImageUploadResult.flowId = this.mAbstractUploadTask.flowId;
      localLoverImageUploadResult.height = localb.f;
      localLoverImageUploadResult.width = localb.e;
      localLoverImageUploadResult.name = localb.g;
      localLoverImageUploadResult.photoId = localb.d;
      localLoverImageUploadResult.picType = localb.i;
      localLoverImageUploadResult.uploadTs = localb.h;
      localLoverImageUploadResult.url = localb.b;
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, localLoverImageUploadResult);
    }
    super.processFileUploadFinishRsp(paramArrayOfByte, this.mAbstractUploadTask.flowId);
  }
  
  protected void processSvcResponsePacket(com.tencent.upload.network.c.a parama, SvcResponsePacket paramSvcResponsePacket)
  {
    this.b = paramSvcResponsePacket.a;
    super.processSvcResponsePacket(parama, paramSvcResponsePacket);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\LoverImageUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */