package com.tencent.upload.uinterface.action;

import FileUpload.ShuoshuoInfoReq;
import FileUpload.ShuoshuoInfoRsp;
import FileUpload.ShuoshuoPicInfo;
import FileUpload.SvcRequestHead;
import FileUpload.SvcResponsePacket;
import android.util.Log;
import com.tencent.upload.a.b;
import com.tencent.upload.a.e;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.MoodUploadResult;
import com.tencent.upload.uinterface.data.MoodUploadTask;
import com.tencent.upload.uinterface.data.MoodUploadTask.PictureInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MoodUploadAction
  extends com.tencent.upload.a.d
{
  public MoodUploadAction(MoodUploadTask paramMoodUploadTask)
    throws Exception
  {
    super(paramMoodUploadTask);
    ShuoshuoInfoReq localShuoshuoInfoReq = new ShuoshuoInfoReq();
    localShuoshuoInfoReq.b = paramMoodUploadTask.iAlbumTypeID;
    localShuoshuoInfoReq.c = paramMoodUploadTask.iBatchID;
    localShuoshuoInfoReq.a = paramMoodUploadTask.sAlbumID;
    localShuoshuoInfoReq.e = new ArrayList();
    if (paramMoodUploadTask.pictureInfoList != null)
    {
      localIterator = paramMoodUploadTask.pictureInfoList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (MoodUploadTask.PictureInfo)localIterator.next();
        ArrayList localArrayList = localShuoshuoInfoReq.e;
        ShuoshuoPicInfo localShuoshuoPicInfo = new ShuoshuoPicInfo();
        localShuoshuoPicInfo.albumid = ((MoodUploadTask.PictureInfo)localObject).albumid;
        localShuoshuoPicInfo.pictureid = ((MoodUploadTask.PictureInfo)localObject).pictureid;
        localShuoshuoPicInfo.sloc = ((MoodUploadTask.PictureInfo)localObject).sloc;
        localShuoshuoPicInfo.pictype = ((MoodUploadTask.PictureInfo)localObject).pictype;
        if (((MoodUploadTask.PictureInfo)localObject).pictype == 2) {
          localShuoshuoPicInfo.sourceType = 2;
        }
        localShuoshuoPicInfo.picheight = ((MoodUploadTask.PictureInfo)localObject).picheight;
        localShuoshuoPicInfo.picwidth = ((MoodUploadTask.PictureInfo)localObject).picwidth;
        localShuoshuoPicInfo.ishd = ((MoodUploadTask.PictureInfo)localObject).ishd;
        localShuoshuoPicInfo.hdid = ((MoodUploadTask.PictureInfo)localObject).hdid;
        localShuoshuoPicInfo.hdheight = ((MoodUploadTask.PictureInfo)localObject).hdheight;
        localShuoshuoPicInfo.hdwidth = ((MoodUploadTask.PictureInfo)localObject).hdwidth;
        localShuoshuoPicInfo.strWaterMarkID = ((MoodUploadTask.PictureInfo)localObject).strWaterMarkID;
        localShuoshuoPicInfo.strWaterMarkMemo = ((MoodUploadTask.PictureInfo)localObject).strWaterMarkMemo;
        localShuoshuoPicInfo.mapWaterMarkParams = a(((MoodUploadTask.PictureInfo)localObject).mapWaterMarkParams);
        localShuoshuoPicInfo.pic_url = ((MoodUploadTask.PictureInfo)localObject).picUrl;
        localShuoshuoPicInfo.is_appext_pic = ((MoodUploadTask.PictureInfo)localObject).isAppExtPic;
        localShuoshuoPicInfo.richval = ((MoodUploadTask.PictureInfo)localObject).richval;
        localArrayList.add(localShuoshuoPicInfo);
      }
    }
    localShuoshuoInfoReq.d = paramMoodUploadTask.businessData;
    if (localShuoshuoInfoReq.d == null) {
      localShuoshuoInfoReq.d = new byte[0];
    }
    Object localObject = localShuoshuoInfoReq.getClass().getSimpleName();
    Iterator localIterator = null;
    try
    {
      this.mUploadFileInfoReqBytes = com.tencent.upload.b.a.a.a((String)localObject, localShuoshuoInfoReq);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramMoodUploadTask = localIterator;
        if (localIterator == null) {
          paramMoodUploadTask = new Exception("MoodUploadAction() pack " + (String)localObject + " =null. " + localShuoshuoInfoReq);
        }
        throw paramMoodUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.a("FlowWrapper", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramMoodUploadTask);
    }
  }
  
  private com.tencent.upload.network.a.d a()
  {
    int i = com.tencent.upload.b.a.a.a();
    this.mSvcRequestHead.y = com.tencent.upload.b.a.a.a(this.mAbstractUploadTask.flowId, i);
    try
    {
      arrayOfByte1 = com.tencent.upload.b.a.a.a(this.mSvcRequestHead.getClass().getSimpleName(), this.mSvcRequestHead);
      localObject = null;
    }
    catch (Exception localException)
    {
      byte[] arrayOfByte2;
      for (;;)
      {
        byte[] arrayOfByte1;
        localObject = Log.getStackTraceString(localException);
        b.a("FlowWrapper", localException);
        arrayOfByte2 = null;
      }
      Object localObject = ByteBuffer.allocate(arrayOfByte2.length + this.mUploadFileInfoReqBytes.length);
      ((ByteBuffer)localObject).put(arrayOfByte2);
      ((ByteBuffer)localObject).put(this.mUploadFileInfoReqBytes);
      return new e(((ByteBuffer)localObject).array(), null, false, 0, 0, this.mAbstractUploadTask.flowId, 6, i);
    }
    com.tencent.upload.a.d.printSvcRequestHead(this.mSvcRequestHead);
    if (arrayOfByte1 == null)
    {
      if (localObject != null) {
        break label161;
      }
      localObject = "getMoodRequest() pack SvcRequestHead=null. " + this.mSvcRequestHead;
    }
    label161:
    for (;;)
    {
      cancelActionForException(499, 0, true, true, (String)localObject, null);
      return null;
    }
  }
  
  private static Map<String, String> a(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return paramMap;
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null) {
          paramMap.put(localEntry.getKey(), "");
        }
      }
    }
  }
  
  public void onRequest(com.tencent.upload.network.c.a parama, com.tencent.upload.network.a.d paramd)
  {
    if ((10 == this.mState) && (paramd.g() == 6)) {
      this.mState = 35;
    }
  }
  
  protected void processSvcResponsePacket(com.tencent.upload.network.c.a parama, SvcResponsePacket paramSvcResponsePacket)
  {
    switch (paramSvcResponsePacket.e)
    {
    default: 
      cancelActionForException(502, 0, true, true, "svcResponsePacket.iCmdID=" + paramSvcResponsePacket.e, null);
      return;
    }
    byte[] arrayOfByte = paramSvcResponsePacket.f;
    try
    {
      paramSvcResponsePacket = (ShuoshuoInfoRsp)com.tencent.upload.b.a.a.a(ShuoshuoInfoRsp.class.getSimpleName(), arrayOfByte);
      parama = null;
    }
    catch (Exception paramSvcResponsePacket)
    {
      for (;;)
      {
        parama = Log.getStackTraceString(paramSvcResponsePacket);
        b.a("MoodUploadAction", paramSvcResponsePacket);
        paramSvcResponsePacket = null;
      }
      parama = new MoodUploadResult(paramSvcResponsePacket.a);
      if (this.mUploadTaskCallback == null) {
        break label171;
      }
      this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, parama);
      label171:
      super.processFileUploadFinishRsp(arrayOfByte, this.mAbstractUploadTask.flowId);
      return;
    }
    if (paramSvcResponsePacket == null)
    {
      if (parama != null) {
        break label184;
      }
      parama = "processMoodRsp() unpack ShuoshuoInfoRsp=null. " + arrayOfByte;
    }
    label184:
    for (boolean bool = true;; bool = false)
    {
      cancelActionForException(500, 0, true, bool, parama, null);
      return;
    }
  }
  
  protected boolean sendFirstPkg(com.tencent.upload.network.c.a parama)
  {
    this.mSvcRequestHead.g = 6;
    this.mSvcRequestHead.k = 0L;
    this.mSvcRequestHead.u = 0L;
    com.tencent.upload.network.a.d locald = a();
    if (locald == null) {
      return false;
    }
    if (parama.a(locald))
    {
      this.mState = 10;
      b.b("FlowWrapper", "sendMoodPkg() " + locald.toString() + " preupload:" + this.mSvcRequestHead.B);
      return true;
    }
    cancelActionForException(504, 0, true, true, "sendMoodPkg() session send fail", null);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\MoodUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */