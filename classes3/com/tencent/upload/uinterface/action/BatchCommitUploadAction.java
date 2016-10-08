package com.tencent.upload.uinterface.action;

import FileUpload.BatchCommitReq;
import FileUpload.BatchCommitRsp;
import FileUpload.PreuploadPicInfo;
import FileUpload.SvcRequestHead;
import FileUpload.SvcResponsePacket;
import FileUpload.UploadPicInfoReq;
import FileUpload.UploadPicInfoRsp;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.upload.a.e;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.BatchCommitUploadResult;
import com.tencent.upload.uinterface.data.BatchCommitUploadTask;
import com.tencent.upload.uinterface.data.ImageUploadResult;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BatchCommitUploadAction
  extends com.tencent.upload.a.d
{
  public BatchCommitUploadAction(BatchCommitUploadTask paramBatchCommitUploadTask)
    throws Exception
  {
    super(paramBatchCommitUploadTask);
    BatchCommitReq localBatchCommitReq = a(paramBatchCommitUploadTask);
    String str = localBatchCommitReq.getClass().getSimpleName();
    Object localObject = null;
    try
    {
      this.mUploadFileInfoReqBytes = com.tencent.upload.b.a.a.a(str, localBatchCommitReq);
      if (this.mUploadFileInfoReqBytes == null)
      {
        paramBatchCommitUploadTask = (BatchCommitUploadTask)localObject;
        if (localObject == null) {
          paramBatchCommitUploadTask = new Exception("BatchCommitUploadAction() pack " + str + " =null. " + localBatchCommitReq);
        }
        throw paramBatchCommitUploadTask;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.upload.a.b.a("FlowWrapper", localException);
      }
      this.mSvcRequestHead = createSvcRequestHead(paramBatchCommitUploadTask);
    }
  }
  
  private static final BatchCommitReq a(BatchCommitUploadTask paramBatchCommitUploadTask)
  {
    BatchCommitReq localBatchCommitReq = new BatchCommitReq();
    localBatchCommitReq.a = new ArrayList();
    if (paramBatchCommitUploadTask.commitImageTasks == null) {
      return localBatchCommitReq;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Flows:");
    Iterator localIterator = paramBatchCommitUploadTask.commitImageTasks.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        ImageUploadTask localImageUploadTask = (ImageUploadTask)localIterator.next();
        Object localObject3 = ImageUploadAction.createUploadPicInfoReq(localImageUploadTask);
        ImageUploadAction.printUploadPicInfoReq((UploadPicInfoReq)localObject3, localImageUploadTask.flowId);
        try
        {
          Object localObject1 = com.tencent.upload.b.a.a.a(localObject3.getClass().getSimpleName(), localObject3);
          PreuploadPicInfo localPreuploadPicInfo = new PreuploadPicInfo();
          localPreuploadPicInfo.picinfoReq = ((UploadPicInfoReq)localObject3);
          Object localObject4 = new File(localImageUploadTask.uploadFilePath);
          localObject3 = new com.tencent.upload.common.a(1, com.tencent.upload.common.b.a((File)localObject4));
          if (localObject1 == null)
          {
            i = 0;
            localPreuploadPicInfo.iDescLen = i;
            localPreuploadPicInfo.iFileLen = (((File)localObject4).length() + localPreuploadPicInfo.iDescLen);
            localPreuploadPicInfo.md5type = ((com.tencent.upload.common.a)localObject3).a();
            localPreuploadPicInfo.md5filelen = ((File)localObject4).length();
            localObject4 = ((com.tencent.upload.common.a)localObject3).b();
            localImageUploadTask.sFileMD5 = ((String)localObject4);
            localObject1 = com.tencent.upload.a.b.a(localImageUploadTask, (byte[])localObject1);
            localImageUploadTask.sDescMD5 = ((String)localObject1);
            localPreuploadPicInfo.sFileMD5 = ((String)localObject4);
            localPreuploadPicInfo.sDescMD5 = ((String)localObject1);
            localPreuploadPicInfo.seq = String.valueOf(localImageUploadTask.flowId);
            localPreuploadPicInfo.iAlbumTypeID = localImageUploadTask.iAlbumTypeID;
            localPreuploadPicInfo.sAlbumID = localImageUploadTask.sAlbumID;
            localPreuploadPicInfo.iNeedCheckAlbum = 1;
            localBatchCommitReq.a.add(localPreuploadPicInfo);
            localStringBuilder.append(localPreuploadPicInfo.seq);
            localStringBuilder.append(" ");
            com.tencent.upload.a.b.b("FlowWrapper", "BatchCommitUploadAction createSvcRequestHead flowid = " + localPreuploadPicInfo.seq + " descMd5 = " + localPreuploadPicInfo.sDescMD5 + " fileMd5 = " + localPreuploadPicInfo.sFileMD5 + " type = " + ((com.tencent.upload.common.a)localObject3).a());
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject2 = null;
            continue;
            int i = localObject2.length;
          }
        }
      }
    }
    com.tencent.upload.a.b.b("FlowWrapper", "createDescription BatchCommitReq " + paramBatchCommitUploadTask.commitImageTasks.size() + " " + localStringBuilder.toString());
    return localBatchCommitReq;
  }
  
  protected e getBatchCommitRequest()
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
        com.tencent.upload.a.b.a("FlowWrapper", localException);
        arrayOfByte2 = null;
      }
      Object localObject = ByteBuffer.allocate(arrayOfByte2.length + this.mUploadFileInfoReqBytes.length);
      ((ByteBuffer)localObject).put(arrayOfByte2);
      ((ByteBuffer)localObject).put(this.mUploadFileInfoReqBytes);
      return new e(((ByteBuffer)localObject).array(), null, false, 0, 0, this.mAbstractUploadTask.flowId, 7, i);
    }
    com.tencent.upload.a.d.printSvcRequestHead(this.mSvcRequestHead);
    if (arrayOfByte1 == null)
    {
      if (localObject != null) {
        break label161;
      }
      localObject = "getBatchCommitRequest() pack SvcRequestHead=null. " + this.mSvcRequestHead;
    }
    label161:
    for (;;)
    {
      cancelActionForException(499, 0, true, true, (String)localObject, null);
      return null;
    }
  }
  
  public void onRequest(com.tencent.upload.network.c.a parama, com.tencent.upload.network.a.d paramd)
  {
    if ((10 == this.mState) && (paramd.g() == 7)) {
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
    Object localObject1 = paramSvcResponsePacket.f;
    parama = null;
    try
    {
      paramSvcResponsePacket = (BatchCommitRsp)com.tencent.upload.b.a.a.a(BatchCommitRsp.class.getSimpleName(), (byte[])localObject1);
      if (paramSvcResponsePacket == null)
      {
        boolean bool = false;
        paramSvcResponsePacket = parama;
        if (parama == null)
        {
          paramSvcResponsePacket = "processBatchCommitRsp() unpack BatchCommitRsp=null. " + localObject1;
          bool = true;
        }
        cancelActionForException(500, 0, true, bool, paramSvcResponsePacket, null);
        return;
      }
    }
    catch (Exception paramSvcResponsePacket)
    {
      for (;;)
      {
        parama = Log.getStackTraceString(paramSvcResponsePacket);
        com.tencent.upload.a.b.a("FlowWrapper", paramSvcResponsePacket);
        paramSvcResponsePacket = null;
      }
      parama = new StringBuilder("processBatchCommitRsp commit size:");
      if (paramSvcResponsePacket.a == null) {}
      for (int i = 0;; i = paramSvcResponsePacket.a.size())
      {
        com.tencent.upload.a.b.b("FlowWrapper", i + " flowId:" + this.mAbstractUploadTask.flowId);
        localObject1 = (BatchCommitUploadTask)this.mAbstractUploadTask;
        parama = new SparseArray();
        localObject1 = ((BatchCommitUploadTask)localObject1).commitImageTasks.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ImageUploadTask localImageUploadTask = (ImageUploadTask)((Iterator)localObject1).next();
          parama.put(localImageUploadTask.flowId, localImageUploadTask);
          Object localObject2 = Integer.toString(localImageUploadTask.flowId);
          if (paramSvcResponsePacket.a != null)
          {
            localObject2 = (UploadPicInfoRsp)paramSvcResponsePacket.a.get(localObject2);
            if (localObject2 != null)
            {
              report(-55555, null, localImageUploadTask);
              IUploadTaskCallback localIUploadTaskCallback = localImageUploadTask.uploadTaskCallback;
              if (localIUploadTaskCallback != null) {
                localIUploadTaskCallback.onUploadSucceed(localImageUploadTask, new ImageUploadResult(localImageUploadTask.iUin, localImageUploadTask.flowId, localImageUploadTask.iBatchID, (UploadPicInfoRsp)localObject2));
              }
              com.tencent.upload.a.b.b("FlowWrapper", "processBatchCommitRsp commit flow:" + localImageUploadTask.flowId);
              com.tencent.upload.a.b.g(localImageUploadTask);
              IUploadService.UploadServiceCreator.getInstance().commit(localImageUploadTask);
            }
          }
        }
      }
      if (this.mUploadTaskCallback != null)
      {
        parama = new BatchCommitUploadResult();
        parama.flowId = this.mAbstractUploadTask.flowId;
        parama.mapPicInfoRsp = paramSvcResponsePacket.a;
        this.mUploadTaskCallback.onUploadSucceed(this.mAbstractUploadTask, parama);
      }
      com.tencent.upload.a.b.b("FlowWrapper", "processBatchCommitRsp cancel self");
      this.mState = 40;
      report(0, null, this.mAbstractUploadTask);
      IUploadService.UploadServiceCreator.getInstance().commit(this.mAbstractUploadTask);
    }
  }
  
  protected boolean sendFirstPkg(com.tencent.upload.network.c.a parama)
  {
    this.mSvcRequestHead.g = 7;
    this.mSvcRequestHead.k = 0L;
    this.mSvcRequestHead.u = 0L;
    e locale = getBatchCommitRequest();
    if (locale == null) {
      return false;
    }
    if (parama.a(locale))
    {
      this.mState = 10;
      com.tencent.upload.a.b.b("FlowWrapper", "sendBatchCommitPkg() " + locale.toString() + " preupload:" + this.mSvcRequestHead.B);
      return true;
    }
    cancelActionForException(504, 0, true, true, "sendBatchCommitPkg() session send fail", null);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\action\BatchCommitUploadAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */